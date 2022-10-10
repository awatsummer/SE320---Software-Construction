import java.util.ArrayList;

/**
 * AnnaMaria Summer
 * SE 320 - Software Construction
 * Assignment 2 - Question 2
 *
 * Write the following method that returns a new ArrayList
 * containing the non-duplicate elements from the original list
 */

public class Question2 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);

        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.println("List without duplicates: " + newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        /* Your implementation here */
        System.out.println("Original list: "+ list);
        // nested for loop to compare each of the elements
        for (int i = 0; i < list.size(); i++) {
            // Comparing each object to all the objects in the rest of the list
            for (int j = i+1; j < list.size(); j++) {
                // If the objects at index i is the same as the object at index j, remove the object at index j
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                }
            }
        }
        // Returning the updated list
        return list;
    }

}
