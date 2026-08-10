package assignment8;

class Vehicle {

    String vehicleName;
    String vehicleNumber;

    Vehicle(String vehicleName, String vehicleNumber) {
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
    }
}

class CarInsurance extends Vehicle {

    String insuranceType;

    CarInsurance(String vehicleName, String vehicleNumber, String insuranceType) {
        super(vehicleName, vehicleNumber);
        this.insuranceType = insuranceType;
    }

    void displayDetails() {

        System.out.println("Vehicle Name: " + super.vehicleName);
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Insurance Type: " + insuranceType);
    }
}

public class VehicleInsurance {

    public static void main(String[] args) {

        CarInsurance c = new CarInsurance(
            "Toyota Fortuner",
            "MH12AB1234",
            "Comprehensive Insurance"
        );

        c.displayDetails();
    }
}