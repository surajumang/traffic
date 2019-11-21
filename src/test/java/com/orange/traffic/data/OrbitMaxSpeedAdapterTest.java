package com.orange.traffic.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class OrbitMaxSpeedAdapterTest {

    @Test
    public void maxSpeed() {
        OrbitMaxSpeed orbit = new OrbitMaxSpeedAdapter(12, Orbit.Orbits.ORBIT_1);
        assertEquals(orbit.maxSpeed(), 12);
    }
}