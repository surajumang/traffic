package com.orange.traffic;

import com.orange.traffic.data.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class ControllerTest {

    @Test
    public void start() {
    }

    @Test
    public void minTimeVehicle() {
        Vehicle vehicle = new Controller(Weather.WINDY, 10,5).minTimeVehicle();
        assertEquals(vehicle, Vehicle.Vehicles.BIKE);
    }

    @Test
    public void timeToTravel() {
        double val = Controller.timeToTravel(Orbit.Orbits.ORBIT_1, Vehicle.Vehicles.BIKE);
        assertEquals(val, (18.0/10)*60 + 20*2, 0.7);
        OrbitMaxSpeed temp = OrbitMaxSpeedAdapter.create(5, Orbit.Orbits.ORBIT_1);
        Orbit sunnyOrbit1 = new WeatherOrbitWrapper(Weather.SUNNY, temp);

        val = Controller.timeToTravel(sunnyOrbit1, VehicleOrbitMaxSpeedAdapter.create(temp, Vehicle.Vehicles.BIKE));
        assertEquals(val, (18.0/5)*60 + 2*18, 0.7);
    }
}