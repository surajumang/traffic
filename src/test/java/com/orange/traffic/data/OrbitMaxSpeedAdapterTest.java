package com.orange.traffic.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/22/2019
 *
 * @author sjkumar
 */
public class OrbitMaxSpeedAdapterTest {

    @Test
    public void maxSpeed() {
        Orbit orbitAdapted = new OrbitMaxSpeedAdapter(14, Orbit.Orbits.ORBIT_1);
        assertEquals(orbitAdapted.maxSpeed(), 14);
    }
}