class Course {

    public String courseName;
    public int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course Name: " + courseName + "\nDuration: " + duration);
    }
}

class OnlineCourse extends Course{

    public String platform;
    public boolean isRecorded;


    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayDetails() {
        System.out.println("Course Name: " + courseName + "\nDuration: " + duration + "\nPlatform: "
                + platform + "\nIs Recorded? " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {

    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayDetails() {
        System.out.println("Course Name: " + courseName + "\nDuration: " + duration + "\nPlatform: "
                + platform + "\nIs Recorded? " + isRecorded + "\nFee: " + fee + "\nDiscount: " + discount);
    }
}

public class Education {

    public static void main(String[] args) {

        PaidOnlineCourse poc = new PaidOnlineCourse("Java Programming", 8, "Microsoft Teams", true, 25000, 10);
        poc.displayDetails();
    }
}
