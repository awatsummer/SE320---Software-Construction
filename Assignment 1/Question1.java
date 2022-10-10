import java.util.InputMismatchException;
import java.util.Scanner;

/**
  	Author: AnnaMaria Summer
	Date: 9/15/22
	Assignment 1
	Question 1
	
	1. Write a Java program that prompts the user to enter two integers 
		and displays their sum. Use exception handling to prompt the user 
		for reading the number again if the input is incorrect.	
*/

public class Question1 {	
	
	public static void main(String[] args) {
		
		System.out.println("This program will take 2 integer inputs and display the sum\n");
		
		// Initializing scanner, the 2 numbers variables, and the boolean to determine if input is correct
		Scanner s = new Scanner(System.in);
		boolean valid = true;
		int num1 = 0;
		int num2 = 0;
		
		// Do-while loop to ensure program runs until valid numbers are entered (until valid=true)
		do {
			
			try {
				// Getting the 2 number inputs and if no exceptions are thrown, valid will be set to true
				System.out.println("Enter 2 integers: ");
				s = new Scanner(System.in);
				num1 = s.nextInt();
				num2 = s.nextInt();
				valid = true;
				
			} catch(InputMismatchException e) {
				// Catching exception if the input entered is not an integer and setting valid=false
				System.out.println("Not an integer! ");
				s.nextLine();
				valid = false;
			} 
			
		} while(valid == false);
		
		s.close();
		
		// Printing out the sum of the input numbers
		System.out.println("Sum of the numbers: " + (num1 + num2));
	}
	
	
	
	
}