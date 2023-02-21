/**
 * Created By Ramesh Babu Y
 * Date :2/17/2023
 * Time :3:23 PM
 * Project Name :parkinglot
 */
package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

public class Util {

    public static long calculateDurationInMinutes(LocalDateTime dateTime) {
        Duration duration = Duration.between(dateTime, LocalDateTime.now());
        long millis = duration.toMillis();
        long minutes = (millis)/(1000*60);
        return minutes;
    }

    public static long calculateDurationInMinutes(LocalDateTime startTime , LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        return (duration.getSeconds())/60;
    }
}
