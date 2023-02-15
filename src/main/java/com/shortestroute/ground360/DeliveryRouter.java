package delivery_route_optimization;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DeliveryRouter {
    /**
     * It computes the all shortest possible routes to travel from the source building
     * @param buildings - List of buildings to go for delivery
     * @param sourceBuilding - The delivery person starts building
     * @return - It returns all possible shortest routes to travel from source to all buildings
     */
    public static Buildings computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings buildings,
                                                                            Building sourceBuilding){
        sourceBuilding.setDistance(0);
        Set<Building> shortestPossiblePathBuildings = new HashSet<>();
        Set<Building> allOtherBuildings = new HashSet<>();
        allOtherBuildings.add(sourceBuilding);

        while (allOtherBuildings.size() != 0) {
            Building currentBuilding = getShortestDistanceBuilding(allOtherBuildings);
            allOtherBuildings.remove(currentBuilding);
            for (Map.Entry<Building, Integer> adjacencyPair : currentBuilding.getAdjacentBuilding().entrySet()) {
                Building adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();
                if (!shortestPossiblePathBuildings.contains(adjacentNode)) {
                    computesShortestDistance(adjacentNode, edgeWeigh, currentBuilding);
                    allOtherBuildings.add(adjacentNode);
                }
            }
            shortestPossiblePathBuildings.add(currentBuilding);
        }
        return buildings;
    }
    /**
     * It calculates or computes the shortest distance
     * @param computeBuilding - The building to be evaluated or computed
     * @param betweenWeigh - The distance between each Building
     * @param sourceBuilding - The Source building
     */
    private static void computesShortestDistance(Building computeBuilding,
                                                 Integer betweenWeigh,
                                                 Building sourceBuilding) {
        Integer sourceDistance = sourceBuilding.getDistance();
        if (sourceDistance + betweenWeigh < computeBuilding.getDistance()) {
            computeBuilding.setDistance(sourceDistance + betweenWeigh);
            LinkedList<Building> shortestPath = new LinkedList<>(sourceBuilding.getShortestPath());
            shortestPath.add(sourceBuilding);
            computeBuilding.setShortestPath(shortestPath);
        }
    }
    /**
     *  Which computes the shortest distance building
     * @param allBuildings - takes set of buildings
     * @return - the shortest distance building object
     */
    private static Building getShortestDistanceBuilding(Set<Building> allBuildings) {
        Building shortestDistanceBuilding = null;
        int shortestDistance = Integer.MAX_VALUE;
        for (Building building : allBuildings) {
            int buildingDistance = building.getDistance();
            if (buildingDistance < shortestDistance) {
                shortestDistance = buildingDistance;
                shortestDistanceBuilding = building;
            }
        }
        return shortestDistanceBuilding;
    }
}