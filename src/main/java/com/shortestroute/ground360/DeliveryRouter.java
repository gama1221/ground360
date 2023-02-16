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

    /**
     * Based on the sample diagram I mentioned here is the method to check
     * the shortest possible route for delivery to each building
     */
    public static void deliveryRouteOptimizationDemo(){
        Building block12 = new Building("Block12");
        Building block2 = new Building("Block2");
        Building block3 = new Building("Block3");
        Building block6 = new Building("Block6");
        Building block7 = new Building("Block7");
        Building block9 = new Building("Block9");

        block12.addDestination(block2, 10);
        block12.addDestination(block3, 15);

        block2.addDestination(block6, 12);
        block2.addDestination(block9, 15);

        block3.addDestination(block7, 10);

        block6.addDestination(block7, 2);
        block6.addDestination(block9, 1);

        block9.addDestination(block7, 5);

        Buildings graph = new Buildings();

        graph.addBuilding(block12);
        graph.addBuilding(block2);
        graph.addBuilding(block3);
        graph.addBuilding(block6);
        graph.addBuilding(block7);
        graph.addBuilding(block9);

        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(graph, block12)
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