package com.orange.traffic.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class WeatherTest {

    @Test
    public void getAdaptedCraterNumber() {
        assertEquals(Weather.SUNNY.getAdaptedCraterNumber(100), 90, 0.7);
        assertEquals(Weather.RAINY.getAdaptedCraterNumber(100), 120, 0.7);
        assertEquals(Weather.WINDY.getAdaptedCraterNumber(90), 90, 0.7);

    }
}