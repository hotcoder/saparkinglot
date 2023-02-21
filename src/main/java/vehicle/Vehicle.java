package vehicle;

public abstract class Vehicle {

     public String number = null;
     public String name = null;
     public VehicleType vehicleType = null;

     public Vehicle(VehicleType vehicleType) {
          this.vehicleType = vehicleType;
     }
}
