/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :6:09 PM
 * Project Name :parkinglot
 */
package driver;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import feeprocessor.AirportParkingCalculatorProcessor;
import feeprocessor.FeeStrategy;
import feeprocessor.MallParkingFeeProcessor;
import feeprocessor.StadiumParkingFeeProcessor;
import model.ParkingTicket;
import model.Receipt;
import vehicle.CarOrSuv;
import vehicle.MotorCycle;
import vehicle.TruckOrBus;
import vehicle.Vehicle;

import java.util.Locale;

public class ParkingLotTest {

    static  FakeValuesService faker = new FakeValuesService(
            new Locale("en-US"), new RandomService());

    public static void main(String[] args) {
        try {
            //runProcess(new MallParkingFeeProcessor(),  0,  1, 0,0,1,0);
            //runProcess(new MallParkingFeeProcessor(),  1,  0, 0,0,1,0);
            //runProcess(new MallParkingFeeProcessor(),  0,  0, 1,0,1,0);

            //runProcess(new StadiumParkingFeeProcessor(),  1,  0, 0,0,4,0);
            //runProcess(new StadiumParkingFeeProcessor(),  0,  1, 0,0,4,0);

            //runProcess(new AirportParkingCalculatorProcessor(),  1,  0, 0,0,23,59);
            runProcess(new AirportParkingCalculatorProcessor(),  0,  1, 0,
            0,0,55);
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void runProcess(FeeStrategy feeStrategy, int numberOfMotoCycleSpots, int numberOfCarSpots,int numberOfTruckSpots,
     int days , int hrs , int minutes){
        ParkingLot parkingLot = new ParkingLot(feeStrategy, numberOfMotoCycleSpots, numberOfCarSpots, numberOfTruckSpots);

        ParkingTicket ticket1 = parkingLot.park(getMotorCycle());
        if(ticket1 != null) {
            ticket1.updateEntryTime(days, hrs, minutes);
            parkingLot.unPark(ticket1);
        }

        ParkingTicket ticket2 = parkingLot.park(getCarSuv());
        if(ticket2 != null) {
            ticket2.updateEntryTime(days, hrs, minutes);
            parkingLot.unPark(ticket2);
        }

        ParkingTicket ticket3 = parkingLot.park(getBusOrTruck());
        if(ticket3 != null) {
            ticket3.updateEntryTime(days, hrs, minutes);
            parkingLot.unPark(ticket3);
        }
    }

    private static Vehicle getMotorCycle() {
        Vehicle motorCycle = new MotorCycle();
        motorCycle.number = faker.numerify("AP-###");
        motorCycle.name = faker.letterify("????????");
        return motorCycle;
    }

    private static Vehicle getCarSuv() {
        Vehicle carOrSuv = new CarOrSuv();
        carOrSuv.number = faker.numerify("AP-###");
        carOrSuv.name = faker.letterify("????????");
        return carOrSuv;
    }

    private static Vehicle getBusOrTruck() {
        Vehicle truckOrBus = new TruckOrBus();
        truckOrBus.number = faker.numerify("AP-###");
        truckOrBus.name = faker.letterify("????????");
        return truckOrBus;
    }
}
