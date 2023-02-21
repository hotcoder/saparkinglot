/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :9:03 AM
 * Project Name :parkinglot
 */
package vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TruckOrBus extends Vehicle{

    private String number;
    private String name;
    private VehicleType vehicleType;

    public TruckOrBus() {
        super(VehicleType.BUS_TRUCK);
        this.vehicleType = VehicleType.BUS_TRUCK;
    }
}
