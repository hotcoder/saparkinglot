/**
 * Created By Ramesh Babu Y
 * Date :2/17/2023
 * Time :3:25 PM
 * Project Name :parkinglot
 */
package fee;

import repository.FeeRepository;
import repository.ParkingInterval;
import vehicle.VehicleType;

public class FourToTwelveCalculatorService implements FeeCalculatorService {

    private FeeCalculatorService feeCalculatorService;
    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        this.feeCalculatorService=feeCalculatorService;
        return  feeCalculatorService;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        int fee  = FeeRepository.stadiumParkingFeeData.get(vehicleType).get(ParkingInterval.FOUR_TO_TWELVE);
        durationInMinutes = durationInMinutes - (8*60);
        if(durationInMinutes > 0){
            fee += this.feeCalculatorService.calculate(durationInMinutes, vehicleType);
        }
        return fee;
    }
}
