package com.shortestroute.ground360;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuildingTest {
    @Test
    void contextLoads() {
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Building#Building(String)}
     *   <li>{@link Building#setAdjacentBuilding(Map)}
     *   <li>{@link Building#setDistance(Integer)}
     *   <li>{@link Building#setName(String)}
     *   <li>{@link Building#setShortestPath(LinkedList)}
     *   <li>{@link Building#getAdjacentBuilding()}
     *   <li>{@link Building#getDistance()}
     *   <li>{@link Building#getName()}
     *   <li>{@link Building#getShortestPath()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Building actualBuilding = new Building("Name");
        HashMap<Building, Integer> buildingIntegerMap = new HashMap<>();
        actualBuilding.setAdjacentBuilding(buildingIntegerMap);
        actualBuilding.setDistance(1);
        actualBuilding.setName("Name");
        LinkedList<Building> buildingList = new LinkedList<>();
        actualBuilding.setShortestPath(buildingList);
        assertSame(buildingIntegerMap, actualBuilding.getAdjacentBuilding());
        assertEquals(1, actualBuilding.getDistance().intValue());
        assertEquals("Name", actualBuilding.getName());
        assertSame(buildingList, actualBuilding.getShortestPath());
    }

    /**
     * Method under test: {@link Building#addDestination(Building, int)}
     */
    @Test
    void testAddDestination() {
        Building building = new Building("Name");
        building.addDestination(new Building("Name"), 2);
        assertEquals(1, building.getAdjacentBuilding().size());
    }
}