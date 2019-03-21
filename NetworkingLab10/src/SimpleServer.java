/**
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String [] args) throws IOException {
		ServerSocket listen = new ServerSocket(1254);

		try {
			while (true) {
				Socket socket = listen.accept();
				try {
					PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
					output.println("Hi there!");
				} finally {
					socket.close();
				}// end of try
				
			}// end of while
		}
		finally {
			listen.close();
		}
		
	}// end of main
}// end of class
