import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalManagerTest {
    private CarRentalManager manager;
    private Vehicle car;
    private Van van;

    @BeforeEach
    void setUp() {
        manager = new CarRentalManager();
        car = new Vehicle("AB12345", 5);
        van = new Van("CD67890", 3, 200, 200, 400);
    }

    @Test
    void testAddVehicle() {
        manager.addVehicle(car);
        assertEquals(car, manager.findVehicleByRegistrationNumber("AB12345"));

        // Test for exception when adding null
        assertThrows(IllegalArgumentException.class, () -> manager.addVehicle(null));

        // Test for exception when adding vehicle with existing registration number
        assertThrows(IllegalArgumentException.class, () -> manager.addVehicle(new Vehicle("AB12345", 4)));
    }

    @Test
    void testRemoveVehicleByRegistrationNumber() {
        manager.addVehicle(car);
        manager.removeVehicleByRegistrationNumber("AB12345");
        assertThrows(IllegalArgumentException.class, () -> manager.findVehicleByRegistrationNumber("AB12345"));

        // Test for exception when removing non-existing vehicle
        assertThrows(IllegalArgumentException.class, () -> manager.removeVehicleByRegistrationNumber("AB12345"));
    }

    @Test
    void testStartRental() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(5);
        manager.addVehicle(car);
        manager.startRental(car, startTime, endTime);

        // Test for exception when inputs are null
        assertThrows(IllegalArgumentException.class, () -> manager.startRental(null, null, null));

        // Test for exception when end time is before start time
        assertThrows(IllegalArgumentException.class, () -> manager.startRental(car, endTime, startTime));
    }

    @Test
    void testCalculateRentalPrice() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(5);
        manager.addVehicle(car);
        Rental rental = new Rental(car, startTime, endTime);
        int price = manager.calculateRentalPrice(rental);
        assertEquals(550, price); // Assuming 110 kr per hour

        manager.addVehicle(van);
        Rental vanRental = new Rental(van, startTime, endTime);
        int vanPrice = manager.calculateRentalPrice(vanRental);
        assertEquals(1350, vanPrice); // Assuming 110 kr per hour + 10 kr per cubic meter)
    }
}
