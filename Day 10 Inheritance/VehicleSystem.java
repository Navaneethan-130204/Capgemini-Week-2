interface Refuelable {
    void Refuel ();
}

class Vehicles {

    public int maxSpeed;
    public String model;

    public Vehicles (String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayVehicle() {
        System.out.println("Model: " + model + "\nMax Speed: " + maxSpeed + " Km/h");
    }
}

class ElectricVehicle extends Vehicles {


    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void Charge() {
        displayVehicle();
        System.out.println("Charging the electric vehicle.");
    }
}

class PetrolVehicle extends Vehicles implements Refuelable{

    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void Refuel() {
        displayVehicle();
        System.out.println("Refueling the petrol vehicle.");
    }
}

public class VehicleSystem {

    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("BMW X6", 250);
        PetrolVehicle pv = new PetrolVehicle("Volkswagen Virtus", 220);
        ev.displayVehicle();
        System.out.println();
        pv.displayVehicle();
    }
}