import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimplePortScanner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. Get Target Info
        System.out.print("Enter the IP address to scan (e.g., 127.0.0.1): ");
        String targetIp = input.nextLine();
        
        System.out.print("Enter start port (e.g., 1): ");
        int startPort = input.nextInt();
        
        System.out.print("Enter end port (e.g., 100): "); // Don't scan too many at once in single-thread mode!
        int endPort = input.nextInt();

        System.out.println("\nStarting scan on " + targetIp + "...");
        
        List<Integer> openPorts = new ArrayList<>();

        // 2. Loop through the ports
        for (int port = startPort; port <= endPort; port++) {
            try {
                // 3. Create a socket with a timeout
                // We don't use new Socket(ip, port) because the default timeout is too long.
                Socket socket = new Socket();
                
                // Try to connect to the IP:Port with a timeout of 200ms
                socket.connect(new InetSocketAddress(targetIp, port), 200);
                
                // If we reach this line, the connection was successful (Port is OPEN)
                socket.close();
                System.out.println("[+] Port " + port + " is OPEN");
                openPorts.add(port);
                
            } catch (Exception e) {
                // If an exception occurs (ConnectionRefused, Timeout), the port is CLOSED
                // We generally do nothing here to keep the output clean
            }
        }

        // 4. Summary
        System.out.println("\nScan Complete.");
        if (openPorts.isEmpty()) {
            System.out.println("No open ports found in range.");
        } else {
            System.out.println("Total open ports found: " + openPorts.size());
            System.out.println("Open Ports: " + openPorts);
        }
        
        input.close();
    }
}