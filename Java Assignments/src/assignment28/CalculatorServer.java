package assignment28;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl calculator = new CalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", calculator);

            System.out.println("Calculator Server is ready!");
            System.out.println("Waiting for client requests...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
