package assignment10;

abstract class Payment {

    abstract void makePayment();
}

class CreditCard extends Payment {

    void makePayment() {
        System.out.println("Payment made using Credit Card.");
    }
}

class UPI extends Payment {

    void makePayment() {
        System.out.println("Payment made using UPI.");
    }
}

public class PaymentDemo {

    public static void main(String[] args) {

        CreditCard card = new CreditCard();
        UPI upi = new UPI();

        card.makePayment();
        upi.makePayment();
    }
}