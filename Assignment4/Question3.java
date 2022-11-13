
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/*
 *  Answer the following questions:

	a. Write the code to format number 12345.678 in the United Kingdom locale. Keep two digits after the decimal point.
	
	b. Write the code to format number 12345.678 in U.S. currency.
	
	c. Write the code to parse '12,345.678' into a number.
 */

public class Question3 {

	public Question3() {
		System.out.println("\nQuestion 3:");
		double given = 12345.678;
		partA(given);
		partB(given);
		String givenC = "12345.678";
		partC(givenC);
		
	}
	
	// Part A
	// Write the code to format number 12345.678 in the United Kingdom 
	// locale. Keep two digits after the decimal point.
	private void partA(double givenNum) {
		
		// Creating number format with locale set to UK
		NumberFormat nf = NumberFormat.getInstance(Locale.UK);
		
		// Making sure that there is only 2 digits after decimal point
		nf.setMaximumFractionDigits(2);
		
		// Printing number formatted as a string
		System.out.println("  Part A: " + nf.format(givenNum));
		
	}
	
	// b. Write the code to format number 12345.678 in U.S. currency.
	private void partB(double givenNum) {
		
		// Creating number currency format with locale set to US
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		
		// Printing number formatted as a string
		System.out.println("  Part B: " + nf.format(givenNum));
		
	}
	
	// c. Write the code to parse '12,345.678' into a number.
	private void partC(String givenStringNum) {
		
		// Creating number format
		NumberFormat numForm = NumberFormat.getNumberInstance();
		try {
			// Trying to parse the string into a number
			Number parsedNumber = numForm.parse(givenStringNum);
			// Printing out the number
			System.out.println("  Part C: " + parsedNumber);
		} catch (ParseException e) {
			System.out.println("Invalid given string");
			e.printStackTrace();
		}
		
	}
}
