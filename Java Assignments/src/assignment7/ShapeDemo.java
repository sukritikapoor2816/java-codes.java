package assignment7;

class Shape {

    void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {

    double radius = 5;

    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

class Rectangle extends Shape {

    double length = 10;
    double width = 5;

    void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class ShapeDemo {

    public static void main(String[] args) {

        Circle c = new Circle();
        c.display();
        c.calculateArea();

        System.out.println();

        Rectangle r = new Rectangle();
        r.display();
        r.calculateArea();
    }
}