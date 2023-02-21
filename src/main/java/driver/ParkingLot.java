package driver;

import model.ParkingSpot;
import feeprocessor.FeeStrategy;
import model.ParkingTicket;
import model.Receipt;
import utils.Util;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Ramesh Babu Y
 * Date :2/19/2023
 * Time :4:52 PM
 * Project Name :parkinglot
 */

public class ParkingLot {

    private Map<Integer, ParkingSpot> parkingSpotBySpotId = new HashMap<>();
    private Map<Integer,ParkingTicket> parkingTickets = new HashMap<>();

    private FeeStrategy feeStrategy;

    private Map<VehicleType,Integer> totalSpotsByVehicleType = new HashMap<>();

    private Map<VehicleType,Integer> spotsOccupied = new HashMap<>();

    private int counter = 0;



    public ParkingLot(FeeStrategy feeStrategy, int numberOfMotoCycleSpots, int numberOfCarSpots,int numberOfTruckSpots) {
        this.feeStrategy = feeStrategy;

        totalSpotsByVehicleType.put(VehicleType.MOTORCYCLE_SCOOTER,numberOfMotoCycleSpots);
        totalSpotsByVehicleType.put(VehicleType.CAR_SUV,numberOfCarSpots);
        totalSpotsByVehicleType.put(VehicleType.BUS_TRUCK,numberOfTruckSpots);

        spotsOccupied.put(VehicleType.MOTORCYCLE_SCOOTER,0);
        spotsOccupied.put(VehicleType.CAR_SUV,0);
        spotsOccupied.put(VehicleType.BUS_TRUCK,0);

        this.parkingSpotBySpotId = new HashMap<>();
        this.parkingTickets = new HashMap<>();
    }


    public ParkingTicket park(Vehicle vehicle){
        if(totalSpotsByVehicleType.getOrDefault(vehicle.vehicleType,0) == 0){
            System.out.println("Parking not allowed to this type of vehicle");
            return null;
        }

        if(this.spotsOccupied.get(vehicle.vehicleType) == this.totalSpotsByVehicleType.get(vehicle.vehicleType)){
            System.out.println("No space available");
            return null;
        }

        ParkingSpot parkingSpot = new ParkingSpot(++this.counter);
        parkingSpot.park();
        parkingSpot.setVehicle(vehicle);
        parkingSpotBySpotId.put(this.counter,parkingSpot);

        ParkingTicket ticket = new ParkingTicket();
        ticket.setTicketNumber(parkingSpot.getParkingSpotId());
        ticket.setAllocatedSpotId(parkingSpot.getParkingSpotId());
        ticket.setEntryTime(parkingSpot.getEntryTime());

        this.spotsOccupied.computeIfPresent(vehicle.vehicleType,(key, val) -> val + 1);
        this.parkingTickets.put(ticket.getTicketNumber(),ticket);

        return ticket;
    }

    public Receipt unPark(ParkingTicket inputTicket){
        ParkingTicket ticketFromDB = this.parkingTickets.get(inputTicket.getTicketNumber());
        if(ticketFromDB == null){
            System.out.println("Invalid Parking Ticket");
            return null;
        }
        ParkingSpot parkingSpot = null;

        if(ticketFromDB != null) {
            parkingSpot = this.parkingSpotBySpotId.get(ticketFromDB.getTicketNumber());
        }else if(ticketFromDB.getVacatedAt() != null){
            System.out.println("Vehicle already unparked on this ticket");
            return null;
        }

        Receipt receipt = new Receipt();
        receipt.setEntryDate(ticketFromDB.getEntryTime());
        receipt.setExitDate(LocalDateTime.now());
        long durationInMinutes = Util.calculateDurationInMinutes(receipt.getEntryDate(),receipt.getExitDate());
        receipt.setDuration(durationInMinutes);

        double amount = this.feeStrategy.calculateCost(durationInMinutes, parkingSpot.getVehicle().vehicleType);
        receipt.setFee(amount);
        receipt.setNumber(ticketFromDB.getTicketNumber());

        printReceipt(receipt);

        this.spotsOccupied.computeIfPresent(parkingSpot.getVehicle().vehicleType, (key, val) -> val - 1);
        this.parkingSpotBySpotId.remove(parkingSpot.getParkingSpotId());
        this.parkingTickets.remove(ticketFromDB.getTicketNumber());
        parkingSpot.unPark();

        return receipt;
    }

    private static void printReceipt(Receipt receipt) {
        System.out.println("*********************************************************");
        System.out.println("Parking Ticket : ");
        System.out.println("Receipt Number : "+ receipt.getNumber());
        System.out.println("Entry Date Time : "+ receipt.getEntryDate());
        System.out.println("Exit Date Time : "+ receipt.getExitDate());
        System.out.println("Fee : "+ receipt.getFee());
        System.out.println("*********************************************************");
    }
}
