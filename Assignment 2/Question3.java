import java.util.Scanner;

/**
 * AnnaMaria Summer
 * SE 320 - Software Construction
 * Assignment 2 - Question 3
 *
 * Write a Java program that prompts the user to enter a number between 0
 * and 10 and displays the entered number.
 *
 * Use an "assert statement" to determine
 * whether the user entered a number within the valid range.
 *
 * If the user entered a number that is out of range,
 *      the program must report an error with assertion error message
 *      "The entered number is out of range".
 */

public class Question3 {

    public static void main(String[] args) {

        System.out.println("Enter number 0 to 10: ");
        Scanner scanner = new Scanner(System.in);
        int userInputNum = scanner.nextInt();
        assert userInputNum <= 0 : "The entered number is out of range";
        assert userInputNum >= 10 : "The entered number is out of range";
    }

}
