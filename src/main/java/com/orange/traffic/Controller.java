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

import com.orange.traffic.data.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */

/*
* Adapt the vehicles based on the max speed of Orbit, where the Orbit itself has to be adapted to Weather
* Input is a Weather followed by Max speed of two Orbits
* Step 1- Adapt the two orbits to the weather
* Step 2- Adapt three vehicles to the orbits
* It will give us six different objects, we just need to find the minimum among them*/
public class Controller {
    private final Weather weather;
    private final int orbitOneMaxSpeed;
    private final int orbitTwoMaxSpeed;
    private OrbitMaxSpeed orbitMaxSpeed;

    public Controller(Weather weather, int orbitOneMaxSpeed, int orbitTwoMaxSpeed) {
        this.weather = weather;
        this.orbitOneMaxSpeed = orbitOneMaxSpeed;
        this.orbitTwoMaxSpeed = orbitTwoMaxSpeed;
    }

    public ResponseContainer process(){
        OrbitMaxSpeed orbit1Adapted = new OrbitMaxSpeedAdapter(this.orbitOneMaxSpeed,
                new WeatherOrbitWrapper(weather, Orbit.Orbits.ORBIT_1));
        OrbitMaxSpeed orbit2Adapted = new OrbitMaxSpeedAdapter(this.orbitTwoMaxSpeed,
                new WeatherOrbitWrapper(this.weather, Orbit.Orbits.ORBIT_2));
        return minTimeVehicleForOrbits(Arrays.asList(orbit1Adapted, orbit2Adapted));
    }
    /*
    * This will use Weather instance and given list of Orbits to determine the Vehicle which takes
    * minimum time to cover any of the Orbits.
    * */
    public ResponseContainer minTimeVehicleForOrbits(List<OrbitMaxSpeed> orbits){
        ResponseContainerSmall result = orbits.stream().map(orb -> minTimeVehicle(weather, orb))
                .min(ResponseContainerSmall::compareTo)
                .orElseThrow(RuntimeException::new);
        return new ResponseContainer(result.getChosenVehicle(), result.getTimeTaken(), result.getOrbit(), weather);
    }

    public static ResponseContainerSmall minTimeVehicle(Weather weather, OrbitMaxSpeed orbitMaxSpeed){
        //find the vehicle which will take the least time on this orbit.
        double minTime = Integer.MAX_VALUE;
        Vehicle minTimeVehicle = null;
        for (Vehicle vehicle : Vehicle.Vehicles.values()){
            //adapt the vehicle with the orbit and them fin time taken
            if (!vehicle.canTravelIn(weather)) continue;
            double time = timeToTravel(orbitMaxSpeed, new VehicleOrbitMaxSpeedAdapter(orbitMaxSpeed, vehicle));
            System.err.println("Time for " + vehicle + " is " + time);
            if(time < minTime){
                minTime = time;
                minTimeVehicle = vehicle;
            }
        }
        return new ResponseContainerSmall(minTimeVehicle, minTime, orbitMaxSpeed);
    }

    public static double timeToTravel(Orbit orbit, Vehicle vehicle){
        return (orbit.getDistance() / vehicle.getSpeed()) * 60 +
                orbit.getNumberOfCraters() * vehicle.timeToCrossACrater();
    }

}
