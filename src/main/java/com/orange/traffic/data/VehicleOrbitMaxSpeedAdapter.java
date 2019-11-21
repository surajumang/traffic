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
* Changing the behaviour of Vehicle class based on what orbit it is going to travel*/
public class VehicleOrbitMaxSpeedAdapter implements Vehicle {
    private final OrbitMaxSpeed orbit;
    private final Vehicle vehicle;

    public VehicleOrbitMaxSpeedAdapter(OrbitMaxSpeed orbit, Vehicle vehicle) {
        this.orbit = orbit;
        this.vehicle = vehicle;
    }

    public static VehicleOrbitMaxSpeedAdapter create(OrbitMaxSpeed orbit, Vehicle vehicle){
        return new VehicleOrbitMaxSpeedAdapter(orbit, vehicle);
    }

    @Override
    public int getSpeed() {
        return Math.min(orbit.maxSpeed(), vehicle.getSpeed());
    }

    @Override
    public boolean canTravelIn(Weather weather) {
        return vehicle.canTravelIn(weather);
    }

    @Override
    public String getName() {
        return vehicle.getName();
    }

    @Override
    public int timeToCrossACrater() {
        return vehicle.timeToCrossACrater();
    }
}
