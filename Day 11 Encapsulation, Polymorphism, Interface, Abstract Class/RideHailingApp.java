interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle implements GPS {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    private String location;

    public Vehicle(int vehicleId, String driverName, double ratePerKm, String location) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.location = location;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + location);
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    public Car(int vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Bike extends Vehicle {
    public Bike(int vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    public Auto(int vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

public class RideHailingApp {
    public static void main(String[] args) {

        Vehicle v1 = new Car(101, "Ravi Kumar", 15, "Chennai Central");
        Vehicle v2 = new Bike(202, "Arun", 10, "Guindy");
        Vehicle v3 = new Auto(303, "Sundar", 12, "T Nagar");

        Vehicle[] rides = {v1, v2, v3};
        double distance = 10;

        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: ₹" + v.calculateFare(distance));
            v.updateLocation("Customer Pickup Point");
            System.out.println("Updated Location: " + v.getCurrentLocation());
            System.out.println("----------------------------------");
        }
    }
}
