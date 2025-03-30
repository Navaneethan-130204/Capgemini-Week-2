interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

abstract class Employee implements Department {

    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void assignDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentDetails() {
        return department;
    }

    abstract void calculateSalary();

    void displayDetails(){
        System.out.println("Employee Id: " + getEmployeeId());
        System.out.println("Employee Name: " + getName());
        System.out.println("Base Salary: " + getBaseSalary());
        System.out.println("Department: " + getDepartmentDetails());
    }
}

class FullTimeEmployee extends Employee {

    int hours;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, int hours) {
        super(employeeId, name, baseSalary);
        this.hours = hours;
    }

    public void calculateSalary() {
        double salaryPerHour = 100;
        double newSalary = hours * salaryPerHour;
        newSalary += getBaseSalary();
        System.out.println("Total Salary: " + newSalary);
    }
}

class PartTimeEmployee extends Employee {

    int hours;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hours) {
        super(employeeId, name, baseSalary);
        this.hours = hours;
    }

    public void calculateSalary() {
        double salaryPerHour = 50;
        double newSalary = hours * salaryPerHour;
        newSalary += getBaseSalary();
        System.out.println("Total Salary: " + newSalary);
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        FullTimeEmployee f1 = new FullTimeEmployee(100, "David", 15000, 10);
        f1.assignDepartment("Developer");
        f1.displayDetails();
        f1.calculateSalary();
        System.out.println();

        PartTimeEmployee p1 = new PartTimeEmployee(200, "Rick", 15000, 15);
        p1.assignDepartment("Testing");
        p1.displayDetails();
        p1.calculateSalary();

        System.out.println();
        p1.setBaseSalary(2000);
        p1.displayDetails();
        p1.calculateSalary();
    }
}