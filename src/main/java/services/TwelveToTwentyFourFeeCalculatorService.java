/**
 * Created By Ramesh Babu Y
 * Date :2/19/2023
 * Time :4:01 PM
 * Project Name :parkinglot
 */
package fee;

import repository.FeeRepository;
import repository.ParkingInterval;
import vehicle.VehicleType;

public class TwelveToTwentyFourFeeCalculatorService implements FeeCalculatorService {

    private FeeCalculatorService feeCalculatorService;


    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return this.feeCalculatorService = feeCalculatorService;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        int fee = 0 ;
        if(durationInMinutes > 0){
            fee  = FeeRepository.airportParkingFeeData.get(vehicleType).get(ParkingInterval.TWELVE_TO_TWENTYFOUR);
        }
        long remainingMinutes = durationInMinutes - (24*60);
        if(remainingMinutes > 0){
            return this.feeCalculatorService.calculate(durationInMinutes, vehicleType);
        }
        return fee;
    }
}
