package com.orange.traffic.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class VehicleOrbitAdapterTest {

    @Test
    public void getSpeed() {
        Orbit orbit = new OrbitMaxSpeedAdapter(11, Orbit.Orbits.ORBIT_1);
        VehicleOrbitAdapter vehicle = new VehicleOrbitAdapter(orbit, Vehicle.Vehicles.SUPER_CAR);
        assertEquals(vehicle.getSpeed(), 11);
        vehicle = new VehicleOrbitAdapter(orbit, Vehicle.Vehicles.BIKE);
        assertEquals(vehicle.getSpeed(), 10);

        vehicle = new VehicleOrbitAdapter(orbit, Vehicle.Vehicles.TUKTUK);
        assertEquals(vehicle.getSpeed(), 11);
    }
}