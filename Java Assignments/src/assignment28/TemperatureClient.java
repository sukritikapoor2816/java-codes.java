package assignment28;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class TemperatureClient {
    public static void main(String[] args) {
        try {
            Registry registry =
                    LocateRegistry.getRegistry("localhost", 1098);
            TemperatureConverter converter =
                    (TemperatureConverter)
                    registry.lookup("TemperatureService");
            Scanner sc = new Scanner(System.in);
            System.out.println("Temperature Converter");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.print("Enter temperature: ");
            double temperature = sc.nextDouble();
            if (choice == 1) {
                double result =converter.celsiusToFahrenheit(temperature);
                System.out.println("Temperature in Fahrenheit: "+ result);
            } else if (choice == 2) {
                double result =converter.fahrenheitToCelsius(temperature);
                System.out.println("Temperature in Celsius: "+ result);
            } else {
                System.out.println("Invalid choice!");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}