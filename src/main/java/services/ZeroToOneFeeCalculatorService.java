/**
 * Created By Ramesh Babu Y
 * Date :2/19/2023
 * Time :4:00 PM
 * Project Name :parkinglot
 */
package services;

import repository.FeeRepository;
import repository.ParkingInterval;
import vehicle.VehicleType;

public class ZeroToOneFeeCalculatorService implements FeeCalculatorService {
    private FeeCalculatorService feeCalculatorService;


    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return this.feeCalculatorService = feeCalculatorService;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        int fee = 0 ;
        if(durationInMinutes > 0){
            fee  = FeeRepository.airportParkingFeeData.get(vehicleType).get(ParkingInterval.ZERO_TO_ONE);
        }
        long remainingMinutes = durationInMinutes - (60);
        if(remainingMinutes > 0){
            return this.feeCalculatorService.calculate(durationInMinutes, vehicleType);
        }
        return fee;
    }
}
