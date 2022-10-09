/**
 * AnnaMaria Summer
 * SE 320 - Software Construction
 * Assignment 2 - Question 1
 * Revise the GenericStack class above to implement it using an array rather than an ArrayList:
 *  - You must have a constructor to construct a stack with the default initial capacity.
 *  - You must have another constructor to construct a stack with a specified initial capacity.
 *  - You should check the array size before adding a new element to the stack. If the array is
 *    full, create a new array that doubles the current array size and copy the elements from
 *    the current array to the new array.
 */

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args){
        // Creating a test stack of the default size
        GenericStack<String> testWithDefaultSize = new GenericStack<>();

        // Getting user input for the size of an array
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size for the array: ");
        int arraySize = sc.nextInt();
        GenericStack<String> testWithChosenSize = new GenericStack<>(arraySize);
        System.out.println("Stack Empty: " + testWithChosenSize.isEmpty());
        testWithChosenSize.push("Hello");
        testWithChosenSize.push("There");
        testWithChosenSize.push("General");
        testWithChosenSize.push("Kenobi");

        System.out.println(testWithChosenSize.toString());
        System.out.println("Stack Empty: " + testWithChosenSize.isEmpty());
        System.out.println("pop: " + testWithChosenSize.pop());
        System.out.println(testWithChosenSize.toString());
        System.out.println("peek: " + testWithChosenSize.peek());
        System.out.println("Size of array: "+ testWithChosenSize.getSize());

    }

    public static class GenericStack<E>{
        private E[] array;

        // Default array capacity randomly chosen as 5
        private final int DEFAULT_CAPACITY = 2;

        // Constructor to construct a stack with the default initial capacity
        public GenericStack(){
            array = (E[]) new Object[DEFAULT_CAPACITY];
        }

        // Constructor to construct a stack with a specified initial capacity
        public GenericStack(int inputCapacity){
            array = (E[]) new Object[inputCapacity];
        }

        public int getSize() {
            // Finding the first position that is null in the array (the top of the stack):
            // Loop index variable i
            int i = 0;
            // While array at index i is not null, increment i
            for (i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    break;
                }

            }

            // The last value of i is the location of the top of the stack, i+1 is the size of the stack
            int stackSize = i;
            return stackSize;
        }

        public E peek() {
            return (E) array[getSize() - 1];
        }

        public void push(E o) {
            // Checking the array size
            if (array[array.length - 1] != null) {
                // If array is full, create new array that doubles the current array size
                E[] newArray = (E[]) new Object[array.length * 2];

                // copy the elements form the current array to the new array
                int i;
                for (i = 0; i < array.length; i ++) {
                    newArray[i] = array[i];
                }
                // Adding the new element to the end of the new array
                newArray[i] = o;

                // Redefining array to the size of the new array
                array = (E[]) new Object[newArray.length];

                // Setting array equal to the new array
                array = newArray;
            } else {
                // else add the new element to the array
                // getSize() returns the size of the stack which would also be the first position of a null spot in the array
                array[getSize()] = o;
            }


        }

        public E pop() {
            E o = array[getSize() - 1];
            array[getSize() - 1] = null;
            return o;
        }

        public boolean isEmpty() {
            if (array[0] == null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            // String variable for the array as a string
            String arrayAsString = "\nStack:";
            // Adding each element of the array to the string
            for (int i = 0; i < getSize(); i++) {
                arrayAsString += ("\n" + array[i]);
            }
            return arrayAsString;
        }

    }

}
