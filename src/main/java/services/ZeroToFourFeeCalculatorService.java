/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :4:57 PM
 * Project Name :parkinglot
 */
package services;

import repository.FeeRepository;
import repository.ParkingInterval;
import vehicle.VehicleType;

public class ZeroToFourFeeCalculatorService implements FeeCalculatorService{

    private FeeCalculatorService feeCalculatorService;


    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return this.feeCalculatorService = feeCalculatorService;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        double fee  = FeeRepository.stadiumParkingFeeData.get(vehicleType).get(ParkingInterval.ZERO_TO_FOUR);
        durationInMinutes = durationInMinutes - (4*60);
        if(durationInMinutes > 0){
            fee =  fee +
                    this.feeCalculatorService.calculate(durationInMinutes, vehicleType);
        }
        return fee;
    }
}
