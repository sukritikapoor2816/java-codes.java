package assignment28;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class TemperatureServer {
    public static void main(String[] args) {
        try {
            TemperatureConverterImpl converter =
                    new TemperatureConverterImpl();
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("TemperatureService", converter);
            System.out.println("Temperature Server is ready!");
            System.out.println("Waiting for client requests...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

