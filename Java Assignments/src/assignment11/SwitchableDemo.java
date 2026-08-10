package assignment11;

import java.util.Scanner;

interface Switchable {

    void turnOn();
}

class Light implements Switchable {

    public void turnOn() {
        System.out.println("Light is ON.");
    }
}

class Fan implements Switchable {

    public void turnOn() {
        System.out.println("Fan is ON.");
    }
}

public class SwitchableDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 'light' to turn on the light or 'fan' to turn on the fan:");
        String choice = sc.nextLine();

        Light light = new Light();
        Fan fan = new Fan();
        if (choice.equalsIgnoreCase("light")) {
            light.turnOn();
        } else if (choice.equalsIgnoreCase("fan")) {
            fan.turnOn();
        } else {
            System.out.println("Invalid input. Please enter 'light' or 'fan'.");
        }
        sc.close();
    }
}