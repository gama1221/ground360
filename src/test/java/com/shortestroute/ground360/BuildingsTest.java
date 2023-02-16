package com.shortestroute.ground360;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class BuildingsTest {
    /**
     * Method under test: {@link Buildings#addBuilding(Building)}
     */
    @Test
    void testAddBuilding() {
        Buildings buildings = new Buildings();
        buildings.addBuilding(new Building("Name"));
        assertEquals(1, buildings.getBuildingSet().size());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Buildings}
     *   <li>{@link Buildings#setBuildingSet(Set)}
     *   <li>{@link Buildings#getBuildingSet()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Buildings actualBuildings = new Buildings();
        HashSet<Building> buildingSet = new HashSet<>();
        actualBuildings.setBuildingSet(buildingSet);
        assertSame(buildingSet, actualBuildings.getBuildingSet());
    }
}