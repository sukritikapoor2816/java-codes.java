package assignment7;

interface Product {

    void displayProduct();
}

class ProductDetails {

    String name;
    double price;

    ProductDetails(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Electronic extends ProductDetails implements Product {

    Electronic(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Electronic Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Clothing extends ProductDetails implements Product {

    Clothing(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Clothing Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Grocery extends ProductDetails implements Product {

    Grocery(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Grocery Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

public class Ecommerce {

    public static void main(String[] args) {

        Electronic e = new Electronic("Laptop", 50000);
        Clothing c = new Clothing("T-Shirt", 800);
        Grocery g = new Grocery("Rice", 1200);

        e.displayProduct();

        System.out.println();

        c.displayProduct();

        System.out.println();

        g.displayProduct();
    }
}