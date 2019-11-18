package com.orange.traffic.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class VehicleTest {

    @Test
    public void canTravel() {
        assertTrue(Vehicle.Vehicles.SUPER_CAR.canTravelIn(Weather.RAINY));
        assertFalse(Vehicle.Vehicles.BIKE.canTravelIn(Weather.RAINY));
        assertFalse(Vehicle.Vehicles.TUKTUK.canTravelIn(Weather.WINDY));
    }
}