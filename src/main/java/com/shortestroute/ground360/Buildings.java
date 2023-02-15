package com.shortestroute.ground360;

import java.util.HashSet;
import java.util.Set;

public class Buildings {
    /**
     * Contains Building properties as well as add building method to buildingSet collection object
     * Buildings are the collection of building i.e. one or more building can make Buildings properties
     * Setter and Getter methods
     * Used to access private fields by other classes
     */
    private Set<Building> buildingSet = new HashSet<>();

    /**
     * Add a building to set of buildings object
     * @param building - an individual building to be added to set of buildings
     */
    public void addBuilding(Building building){
        buildingSet.add(building);
    }

    public Set<Building> getBuildingSet() {
        return buildingSet;
    }

    public void setBuildingSet(Set<Building> buildingSet) {
        this.buildingSet = buildingSet;
    }
}
