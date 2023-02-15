package com.shortestroute.ground360;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    @Disabled("TODO: Complete this test")
    void testComputesShortestPossibleRoutesToTravelFromSourceBuilding2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.shortestroute.ground360.Building.setDistance(java.lang.Integer)" because "sourceBuilding" is null
        //       at com.shortestroute.ground360.DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(DeliveryRouter.java:17)
        //   In order to prevent computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building).
        //   See https://diff.blue/R013 to resolve this issue.

        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(new Buildings(), null);
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

    /**
     * Method under test: {@link DeliveryRouter#computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testComputesShortestPossibleRoutesToTravelFromSourceBuilding5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.shortestroute.ground360.Building.getAdjacentBuilding()" because "currentBuilding" is null
        //       at com.shortestroute.ground360.DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(DeliveryRouter.java:25)
        //   In order to prevent computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building).
        //   See https://diff.blue/R013 to resolve this issue.

        Buildings buildings = new Buildings();

        Building building = new Building("Name");
        building.addDestination(new Building("Name"), Integer.MAX_VALUE);
        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(buildings, building);
    }

    /**
     * Method under test: {@link DeliveryRouter#computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testComputesShortestPossibleRoutesToTravelFromSourceBuilding6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.shortestroute.ground360.Building.getDistance()" because "computeBuilding" is null
        //       at com.shortestroute.ground360.DeliveryRouter.computesShortestDistance(DeliveryRouter.java:47)
        //       at com.shortestroute.ground360.DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(DeliveryRouter.java:29)
        //   In order to prevent computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   computesShortestPossibleRoutesToTravelFromSourceBuilding(Buildings, Building).
        //   See https://diff.blue/R013 to resolve this issue.

        Buildings buildings = new Buildings();

        Building building = new Building("Name");
        building.addDestination(null, 2);
        DeliveryRouter.computesShortestPossibleRoutesToTravelFromSourceBuilding(buildings, building);
    }
}

