package assignment6;

public class foodDelivery {

    String restName = "Pizza Hut, Bavdhan";
    String foodName = "UNLIMITED Pizza";
    double price = 300;

    // Inner Class
    class orderDetails {

        void displayDetails() {
            System.out.println("Restaurant Name: " + restName);
            System.out.println("Food Name: " + foodName);
            System.out.println("Price: " + price);
        }
    }

    // Interface
    interface deliveryStatus {
        void status();
    }

    public static void main(String[] args) {

        // Inner Class
        foodDelivery food = new foodDelivery();

        foodDelivery.orderDetails order = food.new orderDetails();

        order.displayDetails();

        // Anonymous Class
        deliveryStatus status = new deliveryStatus() {

            public void status() {
                System.out.println("Delivery Status: Order is out for delivery.");
            }
        };

        status.status();
    }
}