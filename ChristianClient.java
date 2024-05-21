import java.net.*;
import java.io.*;
import java.util.Scanner; 


public class ChristianClient {
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
                System.out.println("\n\nConnected to the server. Write in this format '1 + 1");
                while (true) {
                    System.out.print("Enter quit to escape");
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
