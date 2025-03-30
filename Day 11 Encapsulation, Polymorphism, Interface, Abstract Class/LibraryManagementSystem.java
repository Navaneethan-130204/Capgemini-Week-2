interface Reservable {
    void reserveItem(String name);
    boolean checkAvailability();
}

abstract class LibraryItem implements Reservable{

    private int itemId;
    private String title;
    private String author;
    private int days;
    private boolean isAvailable = true;
    private String name = "";

    public LibraryItem(int itemId, String title, String author, int days) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public String getName() {
        return name;
    }

    public void reserveItem(String name) {
        if(isAvailable) {
            this.isAvailable = false;
            this.name = name;
            System.out.println(title + " has been reserved by " + name + ".");
        }
        else {
            System.out.println(title + " is already reserved.");
        }
    }

    abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item Id: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

}

class Book extends LibraryItem {

    public Book (int itemId, String title, String author, int days) {
        super(itemId, title, author, days);
    }

    @Override
    public int getLoanDuration () {
        return getDays();
    }
}

class Magazine extends LibraryItem {

    public Magazine (int itemId, String title, String author, int days) {
        super(itemId, title, author, days);
    }

    @Override
    public int getLoanDuration () {
        return getDays();
    }
}

class DVD extends LibraryItem {

    public DVD (int itemId, String title, String author, int days) {
        super(itemId, title, author, days);
    }

    @Override
    public int getLoanDuration () {
        return getDays();
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryItem item1 = new Book(101, "The Alchemist", "Paulo Coelho", 5);
        LibraryItem item2 = new Magazine(202, "National Geographic", "NG Society", 10);
        LibraryItem item3 = new DVD(303, "Inception", "Christopher Nolan", 15);

        LibraryItem[] items = {item1, item2, item3};

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            System.out.println("Available? " + (item.checkAvailability() ? "Yes" : "No"));
            item.reserveItem("John Doe");
            System.out.println("Reserved by: " + item.getName());
            System.out.println("------------------------------------");
        }

        item1.reserveItem("Alice");
    }
}

