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

import java.util.Arrays;
import java.util.List;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public interface Vehicle {
    enum Vehicles implements Vehicle {
        BIKE(10, 2, Weather.SUNNY, Weather.WINDY),
        TUKTUK(12, 1, Weather.SUNNY, Weather.RAINY),
        SUPER_CAR(20, 3, Weather.values());

        private final int speed;
        private final int timeToCrossACrater;
        private final List<Weather> canTravelIn;

        Vehicles(int speed, int timeToCrossACrater, Weather... canTravelIn) {
            this.speed = speed;
            this.timeToCrossACrater = timeToCrossACrater;
            this.canTravelIn = Arrays.asList(canTravelIn);
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public boolean canTravelIn(Weather weather) {
            return canTravelIn.contains(weather);
        }

        @Override
        public String getName() {
            return name();
        }

        @Override
        public int timeToCrossACrater() {
            return timeToCrossACrater;
        }
    }

    int getSpeed();
    boolean canTravelIn(Weather weather);
    String getName();
    int timeToCrossACrater();
}
