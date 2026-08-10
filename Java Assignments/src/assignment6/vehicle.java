package assignment6;

public class vehicle {

    String brand = "Toyota";
    String model = "Fortuner";
    int year = 2025;

    // Inner class to display vehicle details
    class VehicleDetails {

        void displayDetails() {
            System.out.println("Vehicle Details:");
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
        }
    }

    // Method using Anonymous class
    void performAction() {

        Runnable action = new Runnable() {

            public void run() {
                System.out.println("Vehicle is starting...");
            }
        };

        action.run();
    }

    // Main method
    public static void main(String[] args) {

        // Creating Vehicle object
        vehicle v = new vehicle();

        // Creating Inner class object
        vehicle.VehicleDetails details = v.new VehicleDetails();

        // Display vehicle details
        details.displayDetails();

        // Calling Anonymous class action
        v.performAction();
    }
}