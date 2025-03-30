import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    public void viewRecords() {
        System.out.println("Medical History:");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    abstract double calculateBill();
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double roomChargePerDay) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * roomChargePerDay;
    }
}

class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {

        Patient p1 = new InPatient(1001, "Aarav", 45, 5, 2000);
        Patient p2 = new OutPatient(1002, "Meera", 32, 800);

        p1.addRecord("Admitted for surgery");
        p1.addRecord("Discharged after 5 days");
        p2.addRecord("Visited for general checkup");

        Patient[] patients = {p1, p2};
        System.out.println("=================================");
        for (Patient p : patients) {
            p.getPatientDetails();
            p.viewRecords();
            System.out.println("Total Bill: ₹" + p.calculateBill());
            System.out.println("=================================");
        }
    }
}
