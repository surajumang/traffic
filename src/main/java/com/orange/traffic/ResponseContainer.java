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
package com.orange.traffic;

import com.orange.traffic.data.Orbit;
import com.orange.traffic.data.Vehicle;
import com.orange.traffic.data.Weather;

/**
 * Created 11/21/2019
 *
 * @author sjkumar
 */
public class ResponseContainer extends ResponseContainerSmall {
    private Weather weather;

    public ResponseContainer(Vehicle chosenVehicle, Double timeTaken, Orbit orbit, Weather weather) {
        super(chosenVehicle, timeTaken, orbit);
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "ResponseContainer{" +
                "weather=" + weather +
                "} " + super.toString();
    }
}
