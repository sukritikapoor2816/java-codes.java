package assignment27;
import java.io.*;
import java.net.*;
public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is waiting for a client...");
        Socket socket = server.accept();
        System.out.println("Client connected!");
        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));
        String message;
        while (true) {
            message = input.readLine();
            if (message == null || message.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Client: " + message);
            System.out.print("Enter reply: ");
            String reply = keyboard.readLine();
            output.println(reply);
            if (reply.equalsIgnoreCase("exit")) {
                break;
            }
        }
        socket.close();
        server.close();
        keyboard.close();
        System.out.println("Chat ended.");
    }
}