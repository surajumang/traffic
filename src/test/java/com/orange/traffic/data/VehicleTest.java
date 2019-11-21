package com.orange.traffic.data;

import com.orange.traffic.data.Vehicle.Vehicles;
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
        assertTrue(Vehicles.SUPER_CAR.canTravelIn(Weather.RAINY));
        assertFalse(Vehicles.BIKE.canTravelIn(Weather.RAINY));
        assertFalse(Vehicles.TUKTUK.canTravelIn(Weather.WINDY));
    }

    @Test
    public void orderTest() {
        assertArrayEquals(new Vehicles[]{Vehicles.BIKE, Vehicles.TUKTUK, Vehicles.SUPER_CAR}, Vehicles.values());
    }
}