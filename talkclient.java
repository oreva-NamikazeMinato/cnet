import java.io.*;
import java.net.*;

public class talkclient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9999);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("TALK CLIENT");
            System.out.println("-----------");

            while (true) {
                System.out.println("Send message to server:");
                String userMessage = userInput.readLine();

                if (userMessage.equals("END")) {
                    break;
                }

                writer.println(userMessage);
                System.out.println("Message sent successfully");

                System.out.println("\nMessage received from server: " + serverReader.readLine());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
