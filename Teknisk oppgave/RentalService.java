import java.util.HashMap;
import java.util.Map;

public class RentalService {
    protected Map<String, Vehicle> vehicles;

    // Constructor
    public RentalService() {
        this.vehicles = new HashMap<>();
    }

    // Method to add a new vehicle
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        if (vehicles.containsKey(vehicle.getRegistrationNumber())) {
            throw new IllegalArgumentException("A vehicle with the same registration number already exists");
        }
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    // Method to search for a vehicle by its registration number
    public Vehicle findVehicleByRegistrationNumber(String registrationNumber) {
        Vehicle vehicle = vehicles.getOrDefault(registrationNumber, null);
        if (vehicle == null) {
            throw new IllegalArgumentException("No vehicle found with the given registration number");
        }
        return vehicle;
    }

    // Method to remove a vehicle by its registration number
    public void removeVehicleByRegistrationNumber(String registrationNumber) {
        if (!vehicles.containsKey(registrationNumber)) {
            throw new IllegalArgumentException("No vehicle found with the given registration number");
        }
        vehicles.remove(registrationNumber);
    }
}





