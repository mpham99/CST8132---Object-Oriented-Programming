/*
 * Name: Minh Duc Pham
 * Lab 10
 * SimpleClient.java
 */
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;
public class SimpleClient {
 
	public static void main(String [] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		// asks for server address
		System.out.println("Enter IP Address of the server that is running on port 1254");
		String serverAddress = input.nextLine();
		
		// create new socket
        Socket socket = new Socket(serverAddress, 1254);
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        //print out received message from server
        String message = serverInput.readLine();
        System.out.println(message);
        
        input.close();
        socket.close();
        System.exit(0);
    }// end of main
}// end of class
