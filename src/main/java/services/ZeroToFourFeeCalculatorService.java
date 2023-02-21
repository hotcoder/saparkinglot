/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :4:57 PM
 * Project Name :parkinglot
 */
package fee;

import repository.FeeRepository;
import repository.ParkingInterval;
import vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class ZeroToFourFeeCalculatorService implements FeeCalculatorService{

    private FeeCalculatorService feeCalculatorService;


    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return this.feeCalculatorService = feeCalculatorService;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        int fee  = FeeRepository.stadiumParkingFeeData.get(vehicleType).get(ParkingInterval.ZERO_TO_FOUR);
        long remainingMinutes = durationInMinutes - (4*30);
        if(remainingMinutes > 0){
            fee += this.feeCalculatorService.calculate(remainingMinutes, vehicleType);
        }
        return fee;
    }
}
