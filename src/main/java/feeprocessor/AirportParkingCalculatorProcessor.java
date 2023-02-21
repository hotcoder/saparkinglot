/**
 * Created By Ramesh Babu Y
 * Date :2/19/2023
 * Time :3:37 PM
 * Project Name :parkinglot
 */
package feeprocessor;

import services.*;
import vehicle.VehicleType;

public class AirportParkingCalculatorProcessor implements FeeStrategy{
    FeeCalculatorService feeCalculatorService;


    public double calculateCost(long durationInMinutes, VehicleType vehicleType) {
        feeCalculatorService = getFeeCalculatorService(vehicleType);
        return this.feeCalculatorService.calculate(durationInMinutes,vehicleType);
    }

    private FeeCalculatorService getFeeCalculatorService(VehicleType vehicleType){
        FeeCalculatorService feeCalculatorService=null;

        switch (vehicleType) {
            case MOTORCYCLE_SCOOTER:
                feeCalculatorService = new ZeroToOneFeeCalculatorService();
                feeCalculatorService.setNext(new OneToEightFeeCalculatorService())
                        .setNext(new EightToTwentyFourFeeCalculatorService())
                        .setNext(new EachDayFeeCalculatorService());
                break;
            case CAR_SUV:
                feeCalculatorService = new ZeroToTwelveFeeCalculatorService();
                feeCalculatorService.setNext(new TwelveToTwentyFourFeeCalculatorService())
                        .setNext(new EachDayFeeCalculatorService());
                break;

            default:
                System.out.println("Vehicle Not Allowed!");
                break;
        }

        return feeCalculatorService;
    }
}
