/**
 * Created By Ramesh Babu Y
 * Date :2/19/2023
 * Time :4:00 PM
 * Project Name :parkinglot
 */
package services;

import repository.FeeRepository;
import vehicle.VehicleType;

import static repository.ParkingInterval.EACHDAY;

public class EachDayFeeCalculatorService implements FeeCalculatorService {

    private FeeCalculatorService feeCalculatorService;


    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return this.feeCalculatorService = feeCalculatorService;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        return Math.ceil((durationInMinutes/60)/ 24.0) * FeeRepository.airportParkingFeeData.get(vehicleType).get(EACHDAY);
    }
}
