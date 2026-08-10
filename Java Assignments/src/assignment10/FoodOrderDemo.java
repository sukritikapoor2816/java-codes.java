package assignment10;

abstract class FoodOrder {

    double amount;

    FoodOrder(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    DineInOrder(double amount) {
        super(amount);
    }

    void calculateBill() {

        double total = amount + 50;

        System.out.println("Dine-In Order");
        System.out.println("Food Amount: " + amount);
        System.out.println("Total Bill: " + total);
    }
}

class TakeAwayOrder extends FoodOrder {

    TakeAwayOrder(double amount) {
        super(amount);
    }

    void calculateBill() {

        double total = amount + 30;

        System.out.println("Take-Away Order");
        System.out.println("Food Amount: " + amount);
        System.out.println("Total Bill: " + total);
    }
}

public class FoodOrderDemo {

    public static void main(String[] args) {

        DineInOrder dineIn = new DineInOrder(500);
        TakeAwayOrder takeAway = new TakeAwayOrder(500);

        dineIn.calculateBill();

        System.out.println();

        takeAway.calculateBill();
    }
}