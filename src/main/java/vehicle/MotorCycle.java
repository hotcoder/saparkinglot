/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :10:57 AM
 * Project Name :parkinglot
 */
package vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotorCycle extends Vehicle{
    private String number;
    private String name;
    private VehicleType vehicleType;

    public MotorCycle() {
        super(VehicleType.MOTORCYCLE_SCOOTER);
        this.vehicleType = VehicleType.MOTORCYCLE_SCOOTER;
    }
}
