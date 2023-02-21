package fee;

import vehicle.VehicleType;

public interface FeeStrategy {
    public double calculateCost(long durationInMinutes, VehicleType vehicleType);
}
