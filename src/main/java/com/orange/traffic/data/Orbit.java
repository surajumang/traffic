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
public interface Orbit {
    City from();
    City to();
    double getDistance();
    double getNumberOfCraters();

    enum Orbits implements Orbit{
        ORBIT_1(City.SILK_DORB, City.HALLITHARAM, 18.0, 20),
        ORBIT_2(City.SILK_DORB, City.HALLITHARAM,20, 10),
        ORBIT_3(City.SILK_DORB, City.RK_PURAM,30, 15),
        ORBIT_4(City.HALLITHARAM, City.RK_PURAM,15, 18);

        private final City fromCity;
        private final City toCity;
        private final double distance;
        private final double craters;

        Orbits(City fromCity, City toCity, double distance, double craters) {
            this.fromCity = fromCity;
            this.toCity = toCity;
            this.distance = distance;
            this.craters = craters;
        }

        @Override
        public City from() {
            return fromCity;
        }

        @Override
        public City to() {
            return toCity;
        }

        @Override
        public double getDistance() {
            return distance;
        }

        @Override
        public double getNumberOfCraters() {
            return craters;
        }
    }
}
