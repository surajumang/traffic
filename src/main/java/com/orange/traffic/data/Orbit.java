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
    int getDistance();
    int getNumberOfCraters();

    enum Orbits implements Orbit{
        ORBIT_1(City.SILK_DORB, City.HALLITHARAM, 18, 20),
        ORBIT_2(City.SILK_DORB, City.HALLITHARAM,20, 10),
        ORBIT_3(City.SILK_DORB, City.RK_PURAM,30, 15),
        ORBIT_4(City.HALLITHARAM, City.RK_PURAM,15, 18);

        private final City fromCity;
        private final City toCity;
        private final int distance;
        private final int craters;

        Orbits(City fromCity, City toCity, int distance, int craters) {
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
        public int getDistance() {
            return distance;
        }

        @Override
        public int getNumberOfCraters() {
            return craters;
        }
    }
}
