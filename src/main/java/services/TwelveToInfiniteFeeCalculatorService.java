/**
 * Created By Ramesh Babu Y
 * Date :2/17/2023
 * Time :3:26 PM
 * Project Name :parkinglot
 */
package services;

import repository.FeeRepository;
import repository.ParkingInterval;
import vehicle.VehicleType;

public class TwelveToInfiniteFeeCalculatorService implements FeeCalculatorService {

    private FeeCalculatorService feeCalculatorService;
    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return this.feeCalculatorService = feeCalculatorService;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        int fee  = 0;

        while (durationInMinutes > 0){
            if(durationInMinutes < 60){
                fee  = fee + FeeRepository.stadiumParkingFeeData.get(vehicleType).get(ParkingInterval.TWELVE_TO_INFINITE);
                break;
            }
            if(durationInMinutes >= 60){
                fee  = fee + FeeRepository.stadiumParkingFeeData.get(vehicleType).get(ParkingInterval.TWELVE_TO_INFINITE);
                durationInMinutes = durationInMinutes - 60;
            }
        }
        return fee;
    }
}
