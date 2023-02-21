/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :5:30 PM
 * Project Name :parkinglot
 */
package repository;

import vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class FeeRepository {

    public static Map<VehicleType, Map<ParkingInterval,Integer>> mallParkingFeeData
            = new HashMap<>();
    public static Map<VehicleType, Map<ParkingInterval,Integer>> stadiumParkingFeeData
            = new HashMap<>();
    public static Map<VehicleType, Map<ParkingInterval,Integer>> airportParkingFeeData
            = new HashMap<>();

    static {
        mallParkingFeeData.put(VehicleType.MOTORCYCLE_SCOOTER, new HashMap<>());
        mallParkingFeeData.put(VehicleType.CAR_SUV, new HashMap<>());
        mallParkingFeeData.put(VehicleType.BUS_TRUCK, new HashMap<>());
        mallParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.DEFAULT,10);
        mallParkingFeeData.get(VehicleType.CAR_SUV).put(ParkingInterval.DEFAULT,20);
        mallParkingFeeData.get(VehicleType.BUS_TRUCK).put(ParkingInterval.DEFAULT,50);


        stadiumParkingFeeData.put(VehicleType.MOTORCYCLE_SCOOTER, new HashMap<>());
        stadiumParkingFeeData.put(VehicleType.CAR_SUV, new HashMap<>());

        stadiumParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.ZERO_TO_FOUR,30);
        stadiumParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.FOUR_TO_TWELVE,60);
        stadiumParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.TWELVE_TO_INFINITE,100);

        stadiumParkingFeeData.get(VehicleType.CAR_SUV).put(ParkingInterval.ZERO_TO_FOUR,60);
        stadiumParkingFeeData.get(VehicleType.CAR_SUV).put(ParkingInterval.FOUR_TO_TWELVE,120);
        stadiumParkingFeeData.get(VehicleType.CAR_SUV).put(ParkingInterval.TWELVE_TO_INFINITE,200);



        airportParkingFeeData.put(VehicleType.MOTORCYCLE_SCOOTER, new HashMap<>());
        airportParkingFeeData.put(VehicleType.CAR_SUV, new HashMap<>());

        airportParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.ZERO_TO_ONE,0);
        airportParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.ONE_TO_EIGHT,40);
        airportParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.EIGHT_TO_TWENTYFOUR,60);
        airportParkingFeeData.get(VehicleType.MOTORCYCLE_SCOOTER).put(ParkingInterval.EACHDAY,80);

        airportParkingFeeData.get(VehicleType.CAR_SUV).put(ParkingInterval.ZERO_TO_TWELVE,60);
        airportParkingFeeData.get(VehicleType.CAR_SUV).put(ParkingInterval.TWELVE_TO_TWENTYFOUR,80);
        airportParkingFeeData.get(VehicleType.CAR_SUV).put(ParkingInterval.EACHDAY,100);
    }

}
