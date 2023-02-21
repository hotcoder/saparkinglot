/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :5:35 PM
 * Project Name :parkinglot
 */
package fee;

import services.*;
import vehicle.VehicleType;

public class MallParkingFeeProcessor implements FeeStrategy{

    FeeCalculatorService feeCalculatorService;

    public MallParkingFeeProcessor() {
        this.feeCalculatorService = new PerHrFlatFeeCalculatorService();
    }


    public double calculateCost(long durationInMinutes, VehicleType vehicleType) {
        return this.feeCalculatorService.calculate(durationInMinutes, vehicleType);
    }
}