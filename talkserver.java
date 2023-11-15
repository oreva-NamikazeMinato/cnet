import java.io.*;
import java.net.*;

public class talkserver {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999);
             Socket clientSocket = serverSocket.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            System.out.println("TALK SERVER");
            System.out.println("-----------");

            while (true) {
                String receivedMessage = reader.readLine();
                System.out.println("\nMessage Received from client: " + receivedMessage);

                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Send message to client:");
                String messageToSend = userInput.readLine();

                if (messageToSend.equals("END")) {
                    break;
                }

                writer.println(messageToSend);
                System.out.println("Message sent successfully");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}