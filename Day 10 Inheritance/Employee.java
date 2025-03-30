public class Employee {

    public String name;
    public int id;
    public double salary;

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Id: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    private int teamSize;

    public Manager(String name, int id, int salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Id: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {

    private String language;

    public Developer(String name, int id, int salary, String language) {
        super(name, id, salary);
        this.language = language;
    }

    @Override

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Id: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Programming Language: " + language);
    }
}

class Intern extends Employee {

    private int experience;

    public Intern(String name, int id, int salary, int experience) {
        super(name, id, salary);
        this.experience = experience;
    }

    @Override

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Id: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Intern Experience: " + experience);
    }
}

class main {

    public static void main(String[] args) {

        Employee manager = new Manager("Alex", 101, 50000, 5);
        Employee developer = new Developer("Dennis", 202, 45000, "Java");
        Employee intern = new Intern("Richard", 303, 15000, 2);

        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}

