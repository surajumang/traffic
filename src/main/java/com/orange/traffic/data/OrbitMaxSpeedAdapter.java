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
public class OrbitMaxSpeedAdapter implements OrbitMaxSpeed {
    private final int maxSpeed;
    private final Orbit orbit;

    public OrbitMaxSpeedAdapter(int maxSpeed, Orbit orbit) {
        this.maxSpeed = maxSpeed;
        this.orbit = orbit;
    }

    public static OrbitMaxSpeedAdapter create(int maxSpeed, Orbit orbit){
        return new OrbitMaxSpeedAdapter(maxSpeed, orbit);
    }

    @Override
    public int maxSpeed() {
        return maxSpeed;
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
    public double getDistance() {
        return orbit.getDistance();
    }

    @Override
    public double getNumberOfCraters() {
        return orbit.getNumberOfCraters();
    }

    @Override
    public String name() {
        return orbit.name();
    }
}
