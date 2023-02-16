package com.shortestroute.ground360;

import java.util.*;
import java.util.stream.Collectors;

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
        Set<Building> shortestPossibleRouteBuildings = new HashSet<>();
        Set<Building> allOtherBuildings = new HashSet<>();
        allOtherBuildings.add(sourceBuilding);

        while (allOtherBuildings.size() != 0) {
            Building currentBuilding = getShortestDistanceBuilding(allOtherBuildings);
            allOtherBuildings.remove(currentBuilding);
            for (Map.Entry<Building, Integer> adjacencyPair : currentBuilding.getAdjacentBuilding().entrySet()) {
                Building adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();
                if (!shortestPossibleRouteBuildings.contains(adjacentNode)) {
                    computesShortestDistance(adjacentNode, edgeWeigh, currentBuilding);
                    allOtherBuildings.add(adjacentNode);
                }
            }
            shortestPossibleRouteBuildings.add(currentBuilding);
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

    /**
     * Based on the sample diagram I mentioned here is the method to check
     * the shortest possible route for delivery to each building
     */
    public static void deliveryRouteOptimizationDemo(){
        Building block1 = new Building("Building 1");
        Building block2 = new Building("Building 2");
        Building block3 = new Building("Building 3");
        Building block4 = new Building("Building 4");
        Building block5 = new Building("Building 5");
        Building block6 = new Building("Building 6");

        block1.addDestination(block2, 11);
        block1.addDestination(block3, 16);
        block2.addDestination(block4, 13);
        block2.addDestination(block5, 16);
        block3.addDestination(block6, 11);
        block6.addDestination(block4, 3);
        block6.addDestination(block5, 6);
        block5.addDestination(block6, 6);
        block1.addDestination(block2, 11);
        block1.addDestination(block3, 16);
        block2.addDestination(block4, 13);
        block2.addDestination(block5, 16);
        block3.addDestination(block6, 11);
        block4.addDestination(block5, 2);
        block4.addDestination(block6, 3);
        block6.addDestination(block6, 6);

        Buildings buildings = new Buildings();

        buildings.addBuilding(block1);
        buildings.addBuilding(block2);
        buildings.addBuilding(block3);
        buildings.addBuilding(block4);
        buildings.addBuilding(block5);
        buildings.addBuilding(block6);

        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(buildings, block1)
                .getBuildingSet().forEach(building -> {
                    String path = building.getShortestPath().stream()
                            .map(Building::getName).map(Objects::toString)
                            .collect(Collectors.joining(" => "));
                    System.out.println((path.isBlank()
                            ? "%s : %s".formatted(building.getName(), building.getDistance())
                            : "%s => %s : %s".formatted(path, building.getName(), building.getDistance()))
                    );
                });
    }
}