package Exceptions;

public class VehicleBooked extends Exception {
    public VehicleBooked() {
        super("The vehicle is already booked!");
    }
}
