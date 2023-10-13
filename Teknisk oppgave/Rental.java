import java.time.LocalDateTime;

public class Rental {
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Constructor
    public Rental(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getter and Setter methods
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}



