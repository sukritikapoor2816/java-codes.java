package assignment27;
import java.io.*;
import java.net.*;
public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server!");
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
            String reply = input.readLine();
            System.out.println("Server: " + reply);
            if (reply == null || reply.equalsIgnoreCase("exit")) {
                break;
            }
        }
        socket.close();
        keyboard.close();
        System.out.println("Disconnected from server.");
    }
}