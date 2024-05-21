import java.net.*;
import java.io.*;
import java.util.Scanner; 


public class ChristianClient {
    public class Client {
        public static void main(String[] args) {
            String hostName = "localhost"; 
            int portNumber = 4446;
            try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                Scanner scanner = new Scanner(System.in)
            ) {
                String userInput;
                System.out.println("\n\nConnected to the server. Type your math expressions (e.g., '1 + 2') to send.");
                while (true) {
                    System.out.print("Enter expression (or 'quit' to exit): ");
                    userInput = scanner.nextLine(); 
    
                    if ("quit".equalsIgnoreCase(userInput)) { 
                        break; 
                    }
                    out.println(userInput); 
    String response = in.readLine();
                    System.out.println("Server response: " + response); 
                }
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host " + hostName);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " + hostName);
                System.exit(1); 
            }
        }
    }
}