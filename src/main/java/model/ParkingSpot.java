/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :12:44 PM
 * Project Name :parkinglot
 */
package model;

import lombok.Getter;
import lombok.Setter;
import parking.ParkingSpotType;
import vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ParkingSpot {

    private int parkingSpotId;
    private boolean isOccupied;
    private ParkingSpotType parkingSpotType;
    private Vehicle vehicle;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;


    public ParkingSpot(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public void unPark() {
        this.exitTime = LocalDateTime.now();
        this.isOccupied = false;
        this.vehicle = null;
    }

    public void park(){
        this.isOccupied = true;
        this.entryTime=LocalDateTime.now();
    }
}
