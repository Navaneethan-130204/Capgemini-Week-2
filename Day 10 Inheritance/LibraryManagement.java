class Book {

    public String title;
    public int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title Name: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {

    private String author;
    private String bio;

    public Author (String title, int publicationYear, String author, String bio) {
        super(title, publicationYear);
        this.author = author;
        this.bio = bio;
    }

    @Override

    public void displayInfo() {
        System.out.println("Title Name: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Bio: " + bio);
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "American novelist known for his depiction of the Jazz Age.");
        author.displayInfo();
    }
}
