import java.util.Date;

class Order {

    public String orderId;
    public String orderDate;

    public Order (String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public void getOrderStatus() {
        System.out.println("Order Id: " + orderId + "\nOrder Date: " + orderDate);
    }
}

class ShippedOrder extends Order {

    public int trackingNumber;

    public ShippedOrder(String orderId, String orderDate, int trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override

    public void getOrderStatus() {
        System.out.println("Order Id: " + orderId + "\nOrder Date: " + orderDate + "\nTracking Number: " + trackingNumber);
    }
}

class Delivered extends ShippedOrder {

    private String date;
    public Delivered(String orderId, String orderDate, int trackingNumber, String date) {
        super(orderId, orderDate, trackingNumber);
        this.date = date;
    }

    @Override

    public void getOrderStatus() {
        System.out.println("Order Id: " + orderId + "\nOrder Date: " + orderDate + "\nTracking Number: " + trackingNumber + "\nDelivery Date: " + date);
    }
}

public class OnlineRetailOrderManagement {

    public static void main(String[] args) {

        Order delivery = new Delivered("100", " 13 February, 2025", 301, "15 February, 2025");
        delivery.getOrderStatus();
    }
}
