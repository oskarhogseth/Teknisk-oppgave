import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRentalManager extends RentalService {
    protected List<Rental> rentals;

    // Constructor
    public CarRentalManager() {
        super();
        this.rentals = new ArrayList<>();
    }

    // Method to find all available vehicles
    public List<Vehicle> findAllAvailableVehicles() {
        List<String> rentedVehicleRegNumbers = rentals.stream()
                .map(rental -> rental.getVehicle().getRegistrationNumber())
                .collect(Collectors.toList());

        return super.vehicles.values().stream()
                .filter(vehicle -> !rentedVehicleRegNumbers.contains(vehicle.getRegistrationNumber()))
                .collect(Collectors.toList());
    }

    // Method to start a new rental
    public void startRental(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        if (vehicle == null || startTime == null || endTime == null) {
            throw new IllegalArgumentException("Vehicle, startTime, or endTime cannot be null");
        }
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time must be after start time");
        }
        Rental newRental = new Rental(vehicle, startTime, endTime);
        rentals.add(newRental);
    }    

    // Method to find all available vehicles within a given time frame
    public List<Vehicle> findAvailableVehiclesInTimeFrame(LocalDateTime startTime, LocalDateTime endTime) {
        return findAllAvailableVehicles().stream()
                .filter(vehicle -> rentals.stream()
                        .noneMatch(rental -> rental.getVehicle().equals(vehicle) &&
                                (rental.getStartTime().isBefore(endTime) && rental.getEndTime().isAfter(startTime))))
                .collect(Collectors.toList());
    }

    // Method to calculate the price of a rental
    public int calculateRentalPrice(Rental rental) {
        long hours = ChronoUnit.HOURS.between(rental.getStartTime(), rental.getEndTime());
        int hourlyPrice = rental.getVehicle().calculateHourlyPrice();
        // Consider even a part of an hour as a full hour for billing
        long totalHours = hours + (ChronoUnit.MINUTES.between(rental.getStartTime(), rental.getEndTime()) % 60 > 0 ? 1 : 0); // adds 1 to the total hours
        return (int) totalHours * hourlyPrice;
    }    
}

