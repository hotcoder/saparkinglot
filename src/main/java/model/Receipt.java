package model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :3:49 PM
 * Project Name :parkinglot
 */


@Data
public class Receipt {

    private int number;
    private double fee;
    private Long duration;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;

}
