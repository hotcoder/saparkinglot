/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :1:52 PM
 * Project Name :parkinglot
 */
package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ParkingTicket {

    private Integer ticketNumber;
    private String licensePlateNumber;
    private Integer allocatedSpotId;
    private LocalDateTime entryTime;
    private LocalDateTime vacatedAt;
    private double charges;

    // to simulate time progress
    public void updateEntryTime(int days ,int hr , int minutes ){
        this.setEntryTime(this.entryTime.minusDays(days));
        this.setEntryTime(this.entryTime.minusHours(hr));
        this.setEntryTime(this.entryTime.minusMinutes(minutes));
    }

}
