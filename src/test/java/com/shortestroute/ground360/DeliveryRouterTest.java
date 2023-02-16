package com.shortestroute.ground360;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryRouterTest {
    /**
     * Method under test: {@link DeliveryRouter#computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)}
     */
    @Test
    void testComputesShortestPossibleRoutesToTravelFromSourceBuilding() {
        Buildings buildings = new Buildings();
        Building building = new Building("Name");
        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(buildings, building);
        assertEquals(0, building.getDistance().intValue());
    }
    /**
     * Method under test: {@link DeliveryRouter#computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)}
     */
    @Test
    void testComputesShortestPossibleRoutesToTravelFromSourceBuilding3() {
        Buildings buildings = new Buildings();

        Building building = new Building("Name");
        building.addDestination(new Building("Name"), 2);
        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(buildings, building);
        assertEquals(0, building.getDistance().intValue());
    }

    /**
     * Method under test: {@link DeliveryRouter#computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)}
     */
    @Test
    void testComputesShortestPossibleRoutesToTravelFromSourceBuilding4() {
        Buildings buildings = new Buildings();

        Building building = new Building("Name");
        building.addDestination(new Building("Name"), 2);
        building.addDestination(new Building("Name"), 2);
        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(buildings, building);
        assertEquals(0, building.getDistance().intValue());
    }
}