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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private final List<Integer> maxSpeeds = new ArrayList<>();

    public Controller(Weather weather, Integer... maxSpeeds) {
        this.weather = weather;
        this.maxSpeeds.addAll(Arrays.asList(maxSpeeds));
    }

    public ResponseContainer process(){
        assert maxSpeeds.size() == 2;
        Orbit orbit1Adapted = new OrbitMaxSpeedAdapter(maxSpeeds.get(0),
                new WeatherOrbitWrapper(weather, Orbit.Orbits.ORBIT_1));
        Orbit orbit2Adapted = new OrbitMaxSpeedAdapter(this.maxSpeeds.get(1),
                new WeatherOrbitWrapper(this.weather, Orbit.Orbits.ORBIT_2));
        return minTimeVehicleForOrbits(Arrays.asList(orbit1Adapted, orbit2Adapted),
                Arrays.asList(Vehicle.Vehicles.values()));
    }

    public ResponseContainerSmall processV2(){
        assert maxSpeeds.size() == 4;
        Orbit orbit1Adapted = new OrbitMaxSpeedAdapter(maxSpeeds.get(0),
                new WeatherOrbitWrapper(weather, Orbit.Orbits.ORBIT_1));
        Orbit orbit2Adapted = new OrbitMaxSpeedAdapter(this.maxSpeeds.get(1),
                new WeatherOrbitWrapper(this.weather, Orbit.Orbits.ORBIT_2));
        Orbit orbit3Adapted = new OrbitMaxSpeedAdapter(maxSpeeds.get(2),
                new WeatherOrbitWrapper(weather, Orbit.Orbits.ORBIT_3));
        Orbit orbit4Adapted = new OrbitMaxSpeedAdapter(this.maxSpeeds.get(3),
                new WeatherOrbitWrapper(this.weather, Orbit.Orbits.ORBIT_4));

        return minTimeVehicleAndOrbit(Arrays.asList(Vehicle.Vehicles.values()),
                Arrays.asList(orbit1Adapted, orbit2Adapted, orbit3Adapted),
                Collections.singletonList(orbit4Adapted));
    }
    /*
    * This will use Weather instance and given list of Orbits to determine the Vehicle which takes
    * minimum time to cover any of the Orbits.
    * */
    public ResponseContainer minTimeVehicleForOrbits(List<Orbit> orbits, List<Vehicle> vehicles){
        ResponseContainerSmall result = orbits.stream()
                .map(orb -> minTimeVehicle(weather, orb, vehicles))
                .min(ResponseContainerSmall::compareTo)
                .orElseThrow(RuntimeException::new);
        return new ResponseContainer(result.getChosenVehicle(), result.getTimeTaken(), result.getOrbit(), weather);
    }

    public static ResponseContainerSmall minTimeVehicle(Weather weather, Orbit orbit, List<Vehicle> vehicles){
        //find the vehicle which will take the least time on this orbit.
        double minTime = Integer.MAX_VALUE;
        Vehicle minTimeVehicle = null;
        for (Vehicle vehicle : vehicles){
            //adapt the vehicle with the orbit and them fin time taken
            if (!vehicle.canTravelIn(weather)) continue;
            double time = timeToTravel(orbit, new VehicleOrbitAdapter(orbit, vehicle));
            System.err.println("Time for " + vehicle + " on " + orbit.name() + " is : " + time);
            if(time < minTime){
                minTime = time;
                minTimeVehicle = vehicle;
            }
        }
        return new ResponseContainerSmall(minTimeVehicle, minTime, orbit);
    }

    /*
    A method to find the Vehicle and Orbit with the least travel time from a given List<Vehicles>
    and List<Orbit>*/
    public ResponseContainerSmall minTimeVehicleAndOrbit(List<Vehicle> vehicles,
                                                                List<Orbit> first,
                                                                List<Orbit> second){
        // for each vehicle find out the min time taken to travel one Orbit from the each List.
        ResponseContainerSmall result = new ResponseContainerSmall(null, Double.MAX_VALUE);
        for(Vehicle vehicle : vehicles){
            System.out.println("Processing Vehicle " + vehicle);
            List<Vehicle> singleVehicle = Collections.singletonList(vehicle);
            Double temp = minTimeVehicleForOrbits(first, singleVehicle).getTimeTaken()
                    + minTimeVehicleForOrbits(second, singleVehicle).getTimeTaken();
            System.out.println("Total time is : " + temp);
            if(temp.compareTo(result.getTimeTaken()) < 0){
                result.setChosenVehicle(vehicle);
                result.setTimeTaken(temp);
            }
            System.out.println("Done with " + vehicle);
        }
        return result;
    }

    public static double timeToTravel(Orbit orbit, Vehicle vehicle){
        return (orbit.getDistance() / vehicle.getSpeed()) * 60 +
                orbit.getNumberOfCraters() * vehicle.timeToCrossACrater();
    }

}
