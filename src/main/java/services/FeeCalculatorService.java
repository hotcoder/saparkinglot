/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :5:24 PM
 * Project Name :parkinglot
 */
package fee;

import vehicle.VehicleType;

import java.util.Date;

public interface FeeCalculatorService {

    public FeeCalculatorService setNext(FeeCalculatorService feeCalculatorService);

    public double calculate(long durationInMinutes, VehicleType vehicleType);
}
