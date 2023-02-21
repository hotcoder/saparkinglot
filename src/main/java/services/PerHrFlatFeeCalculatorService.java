/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :5:37 PM
 * Project Name :parkinglot
 */
package fee;

import repository.FeeRepository;
import repository.ParkingInterval;
import services.FeeCalculatorService;
import vehicle.VehicleType;

public class PerHrFlatFeeCalculatorService implements FeeCalculatorService {

    @Override
    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService) {
        return null;
    }

    @Override
    public double calculate(long durationInMinutes, VehicleType vehicleType) {
        return (durationInMinutes/60) * FeeRepository.mallParkingFeeData
                .get(vehicleType).get(ParkingInterval.DEFAULT);
    }
}
