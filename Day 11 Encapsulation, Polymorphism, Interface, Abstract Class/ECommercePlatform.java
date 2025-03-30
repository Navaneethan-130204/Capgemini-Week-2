interface Taxable {
    double calculateTax();
    void getTaxDetails();
}
abstract class Product implements Taxable{

    private int productId;
    private String name;
    private double price;
    private double tax;

    public Product (int productId,String name, double price, double tax) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        setTax(tax);
    }


    public double getPrice() {
        return price;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double calculateTax() {
        return (tax / 100) * price;
    }

    public double taxableAmount() {
        return getPrice() + calculateTax();
    }

    public void getTaxDetails() {
        System.out.println("Tax Amount: " + calculateTax());
        System.out.println("Total Taxable Amount: " + taxableAmount());
    }

    abstract double calculateDiscount();

    public void display() {
        System.out.println("Product Id: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Electronics extends Product  {

    private double discount;

    public Electronics (int productId, String name, double price, double tax, double discount) {
        super(productId, name, price, tax);
        this.discount = discount;
    }

    public double calculateDiscount() {
        return ((discount / 100) * taxableAmount());
    }
}

class Clothing extends Product {

    private double discount;

    public Clothing(int productId, String name, double price, double tax, double discount) {
        super(productId, name, price, tax);
        this.discount = discount;
    }

    public double calculateDiscount() {
        return ((discount / 100) * taxableAmount());
    }
}

class Groceries extends Product {

    private double discount;

    public Groceries(int productId, String name, double price, double tax, double discount) {
        super(productId, name, price, tax);
        this.discount = discount;
    }

    public double calculateDiscount() {
        return ((discount / 100) * taxableAmount());
    }
}
public class ECommercePlatform {

    public static void main(String[] args) {

        Electronics e1 = new Electronics(100, "Mobile Phone", 25000, 15, 10);
        Clothing c1 = new Clothing(200, "Jean", 1500, 10, 25);
        Groceries g1 = new Groceries(300, "Meat", 250, 5, 10);

        Product[] products = {e1, c1, g1};

        for(Product p : products) {
            p.display();
            p.getTaxDetails();
            System.out.println("Discounted Amount: " + p.calculateDiscount());
            System.out.println("Total Amount: " + ((p.getPrice() + p.calculateTax()) - p.calculateDiscount()));
            System.out.println("------------------------------------");
        }
    }
}
