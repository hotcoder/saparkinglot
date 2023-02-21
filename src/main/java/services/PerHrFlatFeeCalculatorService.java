/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :5:37 PM
 * Project Name :parkinglot
 */
package services;

import repository.FeeRepository;
import repository.ParkingInterval;
import services.FeeCalculatorService;
import vehicle.VehicleType;

public class PerHrFlatFeeCalculatorService implements FeeCalculatorService {

    FeeRepository feeRepository = new FeeRepository();

    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return null;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        double perHrFee = FeeRepository.mallParkingFeeData
                .get(vehicleType).get(ParkingInterval.DEFAULT);
        double fee = 0;
        while (durationInMinutes > 0){
            if(durationInMinutes <60) {
                fee = fee +perHrFee;
                break;
            }else if(durationInMinutes >= 60){
                durationInMinutes = durationInMinutes - 60;
                fee = fee +perHrFee;
            }
        }
        return fee;
    }
}
