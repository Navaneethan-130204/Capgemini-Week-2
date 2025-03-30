interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

abstract class Vehicles implements Insurable{

    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private int days;
    private String insurancePolicyNumber;

    public Vehicles(String vehicleNumber, String type, double rentalRate, int days, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.days = days;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public int getDays() {
        return days;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
    }

    abstract double CalculateRentalCost(int days);
}

class Cars extends Vehicles {

    public Cars(String vehicleNumber, String type, double rentalRate, int days, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate, days, insurancePolicyNumber);
    }

    public double CalculateRentalCost(int days) {
        return days * getRentalRate();
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    public void getInsuranceDetails() {
        System.out.println("Insurance: " + calculateInsurance() + "\nPolicy: " + getInsurancePolicyNumber());
    }
}

class Bikes extends Vehicles {

    public Bikes(String vehicleNumber, String type, double rentalRate, int days, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate, days, insurancePolicyNumber);
    }

    public double CalculateRentalCost(int days) {
        return days * getRentalRate();
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    public void getInsuranceDetails() {
        System.out.println("Insurance: " + calculateInsurance() + "\nPolicy: " + getInsurancePolicyNumber());
    }
}

class Truck extends Vehicles {

    public Truck(String vehicleNumber, String type, double rentalRate, int days, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate, days, insurancePolicyNumber);
    }

    public double CalculateRentalCost(int days) {
        return days * getRentalRate();
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.20;
    }

    public void getInsuranceDetails() {
        System.out.println("Insurance: " + calculateInsurance() + "\nPolicy: " + getInsurancePolicyNumber());
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        Bikes b1 = new Bikes("TN13AC2689" , "Bike", 1000, 10, "FG56586");
        Cars c1 = new Cars("TN13NK1710", "Car", 2500, 5, "VR15353");
        Truck t1 = new Truck("KA55DK6522", "Truck", 5000, 2, "SD25663");

        Vehicles[] vehicles = {b1, c1, t1};
        for(Vehicles v : vehicles) {
            v.displayDetails();
            System.out.println("Total Rental Cost: " + v.CalculateRentalCost(v.getDays()));
            v.getInsuranceDetails();
            System.out.println("-----------------------------------");
        }
    }
}
