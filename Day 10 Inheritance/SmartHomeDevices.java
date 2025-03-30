class Device {

    public int deviceId;
    public String status;

    public Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayInfo() {
        System.out.println("Device Id: " + deviceId + "\nStatus: " + status);
    }
}

class Thermostat extends Device {

    private String temperatureSetting;

    public Thermostat(int deviceId, String status, String temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override

    public void displayInfo() {
        System.out.println("Device Id: " + deviceId + "\nStatus: " + status + "\nTemperature Setting: " + temperatureSetting);
    }
}

public class SmartHomeDevices {

    public static void main(String[] args) {

        Device thermostat = new Thermostat(100, "Active", "Cool");
        thermostat.displayInfo();
    }
}
