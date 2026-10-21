package assignment27;
import java.io.*;
import java.net.*;
public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);
        System.out.println("Connected to echo server!");
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        String message;
        while (true) {
            System.out.print("Enter message: ");
            message = keyboard.readLine();
            output.println(message);
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
            String response = input.readLine();
            System.out.println("Echo from server: " + response);
        }
        socket.close();
        keyboard.close();
        System.out.println("Disconnected from server.");
    }
}