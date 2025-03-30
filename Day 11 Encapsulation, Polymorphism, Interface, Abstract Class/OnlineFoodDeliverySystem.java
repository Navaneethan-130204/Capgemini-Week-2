interface Discountable {
    double applyDiscount();
    void getDiscountDetails();
}

abstract class FoodItem implements Discountable{

    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Amount: " + price * quantity);
    }

    abstract void calculateTotalPrice();

}

class VegItem extends FoodItem {

    private double discount;

    public VegItem(String itemName, double price, int quantity, double discount) {
        super(itemName, price, quantity);
        this.discount = discount;
    }

    public double applyDiscount() {
        return (discount / 100) * getPrice();
    }

    public void getDiscountDetails(){
        System.out.println("Discount (" + discount + "%): " + applyDiscount());
    }

    public void calculateTotalPrice() {
        System.out.println("Discounted Amount: " +  (getPrice() - applyDiscount()));
    }
}

class NonVegItem extends FoodItem {

    private double discount;

    public NonVegItem(String itemName, double price, int quantity, double discount) {
        super(itemName, price, quantity);
        this.discount = discount;
    }

    public double applyDiscount() {
        return (discount / 100) * getPrice();
    }

    public void getDiscountDetails(){
        System.out.println("Discount (" + discount + "%): " + applyDiscount());
    }

    public void calculateTotalPrice() {
        System.out.println("Discounted Amount: " +  (getPrice() - applyDiscount()));
    }
}


public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        VegItem v1 = new VegItem("Mushroom Fried Rice", 100, 2, 10);
        NonVegItem nv1 = new NonVegItem("Mutton Chukka", 350, 1, 20);
        System.out.println("================================");
        FoodItem[] items = {v1, nv1};
        for(FoodItem item : items) {
            item.getItemDetails();
            item.getDiscountDetails();
            item.calculateTotalPrice();
            System.out.println("================================");
        }
    }
}
