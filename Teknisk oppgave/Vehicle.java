public class Vehicle {
    private String registrationNumber;
    private int numberOfSeats;
    
    // Constructor
    public Vehicle(String registrationNumber, int numberOfSeats) {
        this.registrationNumber = registrationNumber;
        this.numberOfSeats = numberOfSeats;
    }
    
    // Getter and Setter methods
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    // Method to calculate the hourly price
    public int calculateHourlyPrice() {
        return 110;
    }

    @Override
    public String toString() {
        return String.format("Vehicle: %s, Seats: %d", registrationNumber, numberOfSeats);
    }
}

