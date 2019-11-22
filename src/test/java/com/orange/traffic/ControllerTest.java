package com.orange.traffic;

import com.orange.traffic.data.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created 11/18/2019
 *
 * @author sjkumar
 */
public class ControllerTest {

    @Test
    public void start() {
    }

    @Test
    public void minTimeVehicle() {
        ResponseContainerSmall result = Controller.minTimeVehicle(Weather.WINDY,
                OrbitMaxSpeedAdapter.create(10, Orbit.Orbits.ORBIT_1), Arrays.asList(Vehicle.Vehicles.values()));
        assertEquals(result, new ResponseContainerSmall(Vehicle.Vehicles.BIKE, 148.0));
    }

    @Test
    public void timeToTravel() {
        double val = Controller.timeToTravel(Orbit.Orbits.ORBIT_1, Vehicle.Vehicles.BIKE);
        assertEquals(val, (18.0/10)*60 + 20*2, 0.7);
        Orbit temp = OrbitMaxSpeedAdapter.create(5, Orbit.Orbits.ORBIT_1);
        Orbit sunnyOrbit1 = new WeatherOrbitWrapper(Weather.SUNNY, temp);

        val = Controller.timeToTravel(sunnyOrbit1, VehicleOrbitAdapter.create(temp, Vehicle.Vehicles.BIKE));
        assertEquals(val, (18.0/5)*60 + 2*18, 0.7);
    }

    @Test
    public void processTwoOrbitsWindy() {
        Controller controller = new Controller(Weather.WINDY, 10, 10);
        ResponseContainer result = controller.process();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.BIKE);

        assertEquals(result.getOrbit().name(), "ORBIT_2");
    }

    @Test
    public void processTwoOrbitsRainy() {
        //ORBIT_1, TUKTUK - 114, CAR - 144
        //ORBIT_2, TUKTUK - 112, CAR - 116
        Controller controller = new Controller(Weather.RAINY, 15, 15);
        ResponseContainer result = controller.process();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.TUKTUK);

        assertEquals(result.getOrbit().name(), "ORBIT_2");
    }

    @Test
    public void processTwoOrbitsRainy_SuperCarWins() {
        //ORBIT_1, TUKTUK - 114, CAR - 144
        //ORBIT_2, TUKTUK - 112, CAR - 96
        Controller controller = new Controller(Weather.RAINY, 15, 20);
        ResponseContainer result = controller.process();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.SUPER_CAR);

        assertEquals(result.getOrbit().name(), "ORBIT_2");
    }

    @Test
    public void processTwoOrbitsSunny() {
        //ORBIT_1, BIKE - 144, TUKTUK - 108, CAR - 126
        //ORBIT_2, BIKE - 138, TUKTUK - 109, CAR - 127
        Controller controller = new Controller(Weather.SUNNY, 15, 12);
        ResponseContainer result = controller.process();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.TUKTUK);

        assertEquals(result.getOrbit().name(), "ORBIT_1");
    }

    @Test
    public void processTwoOrbitsSunny_1() {
        //ORBIT_1, BIKE - 144, TUKTUK - 108, CAR - 126
        //ORBIT_2, BIKE - 138, TUKTUK - 109, CAR - 127
        Controller controller = new Controller(Weather.SUNNY, 12, 10);
        ResponseContainer result = controller.process();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.TUKTUK);

        assertEquals(result.getOrbit().name(), "ORBIT_1");
    }

    @Test
    public void processTwoOrbitsSunny_2() {
        //ORBIT_1, BIKE - 144, TUKTUK - 108, CAR - 126
        //ORBIT_2, BIKE - 138, TUKTUK - 109, CAR - 127
        Controller controller = new Controller(Weather.WINDY, 14, 20);
        ResponseContainer result = controller.process();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.SUPER_CAR);

        assertEquals(result.getOrbit().name(), "ORBIT_2");
    }

    @Test
    public void processV2Simple() {
        Controller controller = new Controller(Weather.SUNNY, 20,12,15,12);
        ResponseContainerSmall result = controller.processV2();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.TUKTUK);
        System.out.println("Finally " + result.getTimeTaken());
    }

    @Test
    public void processV2SimpleSecond() {
        Controller controller = new Controller(Weather.WINDY, 5,10,20,20);
        ResponseContainerSmall result = controller.processV2();
        assertEquals(result.getChosenVehicle(), Vehicle.Vehicles.SUPER_CAR);
        System.out.println("Finally " + result.getTimeTaken());
    }
}