/*
 * AnnaMaria Summer
 * SE 320 - Software Construction
 * Final Assignment - Question 3
 * 
 * Implement the following generic method for linear search (return the first 
 * index value if the key is found in the list, return -1 otherwise). 
 * public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
 * 
 */

public class Question3 { 
	
	// Returns the first index value if the key is found in the list
	// Returns -1 otherwise
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) { 
		// For loop through the list
		for (int i = 0; i < list.length; i++) {
			// If list at index i equals the key, return index i
			if (list[i] == key) {
				return i;
			}
		}
		
		// If end of for loop is reached and no index is returned, return -1
		return -1;
	} 

	public static void main(String[] args) { 
		Integer[] list = {3, 4, 5, 1, -3, -5, -1}; 
		
		// Test cases:
		System.out.println(linearSearch(list, 2));  // Expected output = -1 -> PASS
		System.out.println(linearSearch(list, 5));  // Expected output = 2 -> PASS
		System.out.println(linearSearch(list, -1));  // Expected output = 6 -> PASS
		System.out.println(linearSearch(list, 12));  // Expected output = -1 -> PASS
	} 
} 