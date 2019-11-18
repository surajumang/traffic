package com.orange.traffic.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class WeatherOrbitWrapperTest {

    @Test
    public void getNumberOfCraters() {
        Orbit orbit = new WeatherOrbitWrapper(Weather.SUNNY, Orbit.Orbits.ORBIT_1);
        assertEquals(orbit.getNumberOfCraters(), 18);
        orbit = new WeatherOrbitWrapper(Weather.WINDY, Orbit.Orbits.ORBIT_1);
        assertEquals(orbit.getNumberOfCraters(), 20);
        orbit = new WeatherOrbitWrapper(Weather.RAINY, Orbit.Orbits.ORBIT_1);
        assertEquals(orbit.getNumberOfCraters(), 24);
    }
}