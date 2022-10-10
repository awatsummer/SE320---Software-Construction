import java.util.InputMismatchException;
import java.util.Scanner;

/*

	Author: AnnaMaria Summer
	Date: 9/15/22
	Assignment 1
	Question 2

	2. Write a Java program that meets the following requirements:
		- Creates an array with 100 randomly chosen integers.
		- Prompts the user to enter the index of the array, 
			then displays the corresponding element value. If 
			the specified index is out of bounds, catch the exception 
			and display the message "Out of Bounds".
*/

public class Question2 {
	
	public static void main(String[] args) {
		
		// Initializing an array of 100 random integers
		int[] myArray = new int[100];
		for(int i=0; i < myArray.length; i++) { 
			myArray[i] = (int) (Math.random()*100); 
			System.out.print(myArray[i] + ", ");
		}
		System.out.println();
		
		// Creating scanner and initializing the user input variable (inputIndex)
		Scanner myScanner = new Scanner(System.in);
		int inputIndex = 0;
		
		try {
			
			System.out.println("Please enter the index you would like to see");
			inputIndex = myScanner.nextInt();
			if(inputIndex < 0 || inputIndex > myArray.length) { 
				throw new IndexOutOfBoundsException(); 
			}
			System.out.println("Number in index " + inputIndex + " = " + myArray[inputIndex]);
			
		} catch(InputMismatchException e1) {
			
			System.out.println("Not an integer!");
			
		} catch(IndexOutOfBoundsException e2) {
			
			System.out.println("Out of bounds!");
			
		} finally {
			
			myScanner.close();
			
		}
	}
	
}