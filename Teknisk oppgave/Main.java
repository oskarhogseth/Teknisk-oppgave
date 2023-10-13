import java.time.LocalDateTime;

public class Main {

    // Added a main class for my own visual verfication.
    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println("                CAR RENTAL SYSTEM               ");
        System.out.println("------------------------------------------------");

        CarRentalManager manager = new CarRentalManager();

        // Step 1: Add vehicles to the fleet and display them
        System.out.println("\nStep 1: Initial Fleet");
        System.out.println("------------------------------------------------");
        addAndDisplayVehicles(manager);

        // Step 2: Simulate a car rental and display available vehicles
        System.out.println("\nStep 2: Available Vehicles After Rental");
        System.out.println("------------------------------------------------");
        simulateAndDisplayRental(manager);

        // Step 3: Query available vehicles within a time frame
        System.out.println("\nStep 3: Available Vehicles Within Time Frame");
        System.out.println("------------------------------------------------");
        queryAndDisplayVehiclesWithinTimeFrame(manager);

        // Step 4: Calculate and display the rental price
        System.out.println("\nStep 4: Rental Price Calculation");
        System.out.println("------------------------------------------------");
        calculateAndDisplayRentalPrice(manager);

        System.out.println("------------------------------------------------");
    }

    private static void addAndDisplayVehicles(CarRentalManager manager) {
        Vehicle car1 = new Vehicle("AB12345", 5);
        Vehicle car2 = new Vehicle("CD67890", 4);
        Van van1 = new Van("EF11223", 3, 200, 200, 400);
        manager.addVehicle(car1);
        manager.addVehicle(car2);
        manager.addVehicle(van1);
        int index1 = 1;
        for (Vehicle vehicle : manager.findAllAvailableVehicles()) {
            System.out.println(index1 + ". " + vehicle);
            index1++;
        }
    }
    

    private static void simulateAndDisplayRental(CarRentalManager manager) {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(5);
        manager.startRental(manager.findVehicleByRegistrationNumber("AB12345"), startTime, endTime);
        int index2 = 1;
        for (Vehicle vehicle : manager.findAllAvailableVehicles()) {
            System.out.println(index2 + ". " + vehicle);
            index2++;
        }
    }

    private static void queryAndDisplayVehiclesWithinTimeFrame(CarRentalManager manager) {
        LocalDateTime queryStartTime = LocalDateTime.now().plusHours(2);
        LocalDateTime queryEndTime = queryStartTime.plusHours(4);
        int index3 = 1;
        for (Vehicle vehicle : manager.findAvailableVehiclesInTimeFrame(queryStartTime, queryEndTime)) {
            System.out.println(index3 + ". " + vehicle);
            index3++;
        }
    }

    private static void calculateAndDisplayRentalPrice(CarRentalManager manager) {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(5);

        // For normal vehicle
        Rental carRental = new Rental(manager.findVehicleByRegistrationNumber("AB12345"), startTime, endTime);
        int carPrice = manager.calculateRentalPrice(carRental);
        System.out.println("Price of the rental for Vehicle AB12345: " + carPrice + " kr");

        // For van
        Rental vanRental = new Rental(manager.findVehicleByRegistrationNumber("EF11223"), startTime, endTime);
        int vanPrice = manager.calculateRentalPrice(vanRental);
        System.out.println("Price of the rental for Van EF11223: " + vanPrice + " kr");
    }
}

