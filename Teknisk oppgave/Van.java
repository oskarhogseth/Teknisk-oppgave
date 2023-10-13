public class Van extends Vehicle {
    private int height;
    private int width;
    private int depth;
    
    // Constructor
    public Van(String registrationNumber, int numberOfSeats, int height, int width, int depth) {
        super(registrationNumber, numberOfSeats);
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    
    // Getter and Setter methods for dimensions
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getDepth() {
        return depth;
    }
    
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    // Method to calculate the volume of the storage area in cubic meters
    public double calculateVolume() {
        return ((double) height * width * depth) / 1000000;
    }
    
    // Method to calculate the hourly price, including the additional cost for the storage area
    @Override
    public int calculateHourlyPrice() {
        int basePrice = super.calculateHourlyPrice();
        int additionalPrice = (int) Math.ceil(calculateVolume()) * 10;
        return basePrice + additionalPrice;
    }

    @Override
    public String toString() {
        return String.format("Van: %s, Seats: %d, Cargo Volume: %.1f m^3", 
            getRegistrationNumber(), getNumberOfSeats(), calculateVolume());
    }
}


