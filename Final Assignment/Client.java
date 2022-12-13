/*
 * 
 * AnnaMaria Summer
 * SE 320 - Software Construction
 * Final Assignment - Question 1 and 2 Client
 * 
 * Client class 
 * Allows the client to enter height and weight and the server will return the calculated BMI
 * 
 */

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
	// Text fields for receiveing weight and height
	private JTextField textFieldWeight = new JTextField();
	private JTextField textFieldHeight = new JTextField();

	// Text area to display contents
	private JTextArea textArea = new JTextArea();
	
	// IO streams
	private DataOutputStream outputToServer;
	private DataInputStream inputFromServer;

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		// Panel to hold the label and text field for weight
		JPanel weightPanel = new JPanel();
		weightPanel.setLayout(new BorderLayout());
		weightPanel.add(new JLabel("Enter Weight in kilograms"), BorderLayout.WEST);
		weightPanel.add(textFieldWeight, BorderLayout.CENTER);
		
		// Panel to hold the label and text field for height
		JPanel heightPanel = new JPanel();
		heightPanel.setLayout(new BorderLayout());
		heightPanel.add(new JLabel("Enter Height in centimeters"), BorderLayout.WEST);
		heightPanel.add(textFieldHeight, BorderLayout.CENTER);
		
		// Panel to hold the panels for height and weight
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(weightPanel, BorderLayout.NORTH);
		inputPanel.add(heightPanel, BorderLayout.SOUTH);
		
		textFieldWeight.setHorizontalAlignment(JTextField.CENTER);
		textFieldHeight.setHorizontalAlignment(JTextField.CENTER);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

		// Register listeners
		textFieldWeight.addActionListener(this); 
		textFieldHeight.addActionListener(this);

		setTitle("Client");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // It is necessary to show the frame here!

		try {
			// Create a socket to connect to the server
			Socket socket = new Socket("localhost", 8000);

			// Create an input stream to receive data from the server
			inputFromServer = new DataInputStream(socket.getInputStream());

			// Create an output stream to send data to the server
			outputToServer = new DataOutputStream(socket.getOutputStream());
		}
		catch (IOException ex) {
			textArea.append(ex.toString() + '\n');
		}
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (e.getSource() instanceof JTextField) {
			try {
				// Get the height and weight from the text field
				double weight = Double.parseDouble(textFieldWeight.getText().trim());
				double height = Double.parseDouble(textFieldHeight.getText().trim());
				
				// Send the inputs to the server
				outputToServer.writeDouble(weight);
				outputToServer.writeDouble(height);
				outputToServer.flush();
				
				// Get bmi from the server
				double bmi = inputFromServer.readDouble();
				
				// Display to the text area
				textArea.append("Weight is " + weight + "\n");
				textArea.append("Height is " + height + "\n");
				textArea.append("BMI received from the server is " + bmi + '\n');
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
