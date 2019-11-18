/*
 * Copyright 2006-2019 (c) Care.com, Inc.
 * 1400 Main Street, Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */
package com.orange.traffic.data;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
/*
* As vehicle characteristics are changing based on the Weather
* */
public class WeatherOrbitWrapper implements Orbit {
    private final Weather weather;
    private final Orbit orbit;

    public WeatherOrbitWrapper(Weather weather, Orbit orbit) {
        this.weather = weather;
        this.orbit = orbit;
    }

    @Override
    public City from() {
        return orbit.from();
    }

    @Override
    public City to() {
        return orbit.to();
    }

    @Override
    public int getDistance() {
        return orbit.getDistance();
    }

    @Override
    public int getNumberOfCraters() {
//        int craters = orbit.getNumberOfCraters();
//        if(weather == Weather.SUNNY){
//            craters = (int)(0.9 * craters);
//        }else if (weather == Weather.RAINY){
//            craters = (int)(1.2 * craters);
//        }
        return weather.getAdaptedCraterNumber(orbit.getNumberOfCraters());
    }
}
