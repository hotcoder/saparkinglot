/**
 * Created By Ramesh Babu Y
 * Date :2/16/2023
 * Time :1:52 PM
 * Project Name :parkinglot
 */
package parking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkingTicket {

    private Integer ticketNumber;
    private String licensePlateNumber;
    private Integer allocatedSpotId;
    private LocalDateTime entryTime;
    private LocalDateTime vacatedAt;
    private double charges;

}
