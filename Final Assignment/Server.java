/*
 * 
 * AnnaMaria Summer
 * SE 320 - Software Construction
 * Final Assignment - Question 1 Server
 * 
 * Server class 
 * Receives the height and weight from a client and returns the calculated BMI to the client
 * 
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Server extends JFrame {
	// Text area for displaying contents
	private JTextArea textArea = new JTextArea();

	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		// Place text area on the frame
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

		setTitle("Server");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // It is necessary to show the frame here!

		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			textArea.append("Server started at " + new Date() + '\n');

			// Listen for a connection request
			Socket socket = serverSocket.accept();

			// Create data input and output streams
			DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

			while (true) {
				// Receive height and weight from the client
				double height = inputFromClient.readDouble();
				double weight = inputFromClient.readDouble();
				
				// Compute BMI
				double bmi = weight / (height * height);

				// Send BMI back to the client
				outputToClient.writeDouble(bmi);

				textArea.append("Weight received from client: " + weight + '\n');
				textArea.append("Height received from client: " + height + '\n');
				textArea.append("BMI found: " + bmi + '\n');
			}
		}
		catch(IOException ex) {
			System.err.println(ex);
		}
	}
}