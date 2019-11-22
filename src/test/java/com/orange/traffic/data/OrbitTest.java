package com.orange.traffic.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class OrbitTest {

    @Test
    public void maxSpeed() {
        Orbit orbit = Orbit.Orbits.ORBIT_1;
        assertEquals(orbit.maxSpeed(), Integer.MAX_VALUE);
    }
}