/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :4:55 PM
 * Project Name :parkinglot
 */
package feeprocessor;

import services.FeeCalculatorService;
import services.FourToTwelveCalculatorService;
import services.TwelveToInfiniteFeeCalculatorService;
import services.ZeroToFourFeeCalculatorService;
import vehicle.VehicleType;

public class StadiumParkingFeeProcessor implements FeeStrategy{

    FeeCalculatorService feeCalculatorService;

    public StadiumParkingFeeProcessor() {
        this.feeCalculatorService = new ZeroToFourFeeCalculatorService();
        this.feeCalculatorService.setNext(new FourToTwelveCalculatorService())
                .setNext(new TwelveToInfiniteFeeCalculatorService());
    }


    public double calculateCost(long durationInMinutes, VehicleType vehicleType) {
        return this.feeCalculatorService.calculate(durationInMinutes,vehicleType);
    }
}
