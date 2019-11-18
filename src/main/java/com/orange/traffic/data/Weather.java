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
public enum  Weather {
    SUNNY(-10), RAINY(20), WINDY(0);
    private final int percentCraterChange;

    Weather(int percentCraterChange) {
        this.percentCraterChange = percentCraterChange;
    }

    public int getAdaptedCraterNumber(int craterCount){
        return craterCount + (int)(craterCount * toFraction(percentCraterChange));
    }

    private static Double toFraction(int percentChange){
        return (percentChange * 1.0) / 100;
    }
}
