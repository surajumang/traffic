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

import java.util.Objects;

/**
 * Created 11/21/2019
 *
 * @author sjkumar
 */
public class ResponseContainerSmall implements Comparable<ResponseContainerSmall> {
    private Vehicle chosenVehicle;
    private Double timeTaken;
    private Orbit orbit;

    public ResponseContainerSmall(Vehicle chosenVehicle, Double timeTaken, Orbit orbit) {
        this.chosenVehicle = chosenVehicle;
        this.timeTaken = timeTaken;
        this.orbit = orbit;
    }

    public ResponseContainerSmall(Vehicle chosenVehicle, Double timeTaken) {
        this(chosenVehicle, timeTaken, null);
    }

    public Vehicle getChosenVehicle() {
        return chosenVehicle;
    }

    public Double getTimeTaken() {
        return timeTaken;
    }

    public Orbit getOrbit() {
        return orbit;
    }

    public void setChosenVehicle(Vehicle chosenVehicle) {
        this.chosenVehicle = chosenVehicle;
    }

    public void setTimeTaken(Double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setOrbit(Orbit orbit) {
        this.orbit = orbit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseContainerSmall)) return false;
        ResponseContainerSmall that = (ResponseContainerSmall) o;
        return chosenVehicle.equals(that.chosenVehicle) &&
                Objects.equals(timeTaken, that.timeTaken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chosenVehicle, timeTaken);
    }

    @Override
    public String toString() {
        return "ResponseContainerSmall{" +
                "chosenVehicle=" + chosenVehicle +
                ", timeTaken=" + timeTaken +
                ", orbit=" + orbit +
                '}';
    }

    @Override
    public int compareTo(ResponseContainerSmall o) {
        return this.timeTaken.compareTo(o.timeTaken);
    }
}
