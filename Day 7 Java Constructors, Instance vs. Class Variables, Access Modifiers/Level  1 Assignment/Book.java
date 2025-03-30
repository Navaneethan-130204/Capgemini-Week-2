class Book {

    private String title;
    private String author;
    private int price;
    private boolean isAvailable;

    public Book (String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed \"" + title + "\" by " + author);
        }
        else {
            System.out.println("Sorry \"" + title +"\" is already borrowed.");
        }
    }

    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("IsAvailable: " + ((isAvailable) ? "Yes" : "No"));
    }

    public static void main(String[] Args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 299);
        Book book2 = new Book("Atomic Habits", "James Clear", 499);

        book1.displayBook();
        System.out.println();
        book2.displayBook();

        System.out.println("\nAttempting to borrow books...");
        book1.borrowBook();
        book1.borrowBook();
        System.out.println();
        book1.displayBook();
    }
}
