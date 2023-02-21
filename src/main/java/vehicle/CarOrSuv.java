/**
 * Created By Ramesh Babu Y
 * Date :2/20/2023
 * Time :9:01 AM
 * Project Name :parkinglot
 */
package vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car extends Vehicle{

    private String number;
    private String name;
    private VehicleType vehicleType;

    public Car() {
        super(VehicleType.CAR_SUV);
        this.number = number;
        this.vehicleType = VehicleType.CAR_SUV;
    }
}
