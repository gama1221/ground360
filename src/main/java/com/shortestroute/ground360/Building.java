package com.shortestroute.ground360;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Building {
    /**
     * Building properties
     * Setter and Getter methods
     * Used to access private fields by other classes
     */
    private String name;
    private LinkedList<Building> shortestRoute = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;// considers as infinity value except to the starting building
    private Map<Building, Integer> adjacentBuilding = new HashMap<>();

    /**
     * A constructor for creating Building object
     * @param name - the param used to create Building object via name parameter
     */
    public Building(String name){
        this.name = name;
    }
    /**
     * Attach and map the building with distance
     */
    public void addDestination(Building destination, int distance){
        adjacentBuilding.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Building> getShortestPath() {
        return shortestRoute;
    }

    public void setShortestPath(LinkedList<Building> shortestPath) {
        this.shortestRoute = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Building, Integer> getAdjacentBuilding() {
        return adjacentBuilding;
    }

    public void setAdjacentBuilding(Map<Building, Integer> adjacentBuilding) {
        this.adjacentBuilding = adjacentBuilding;
    }
}