
import java.util.LinkedHashSet;

/* Question 1:
 * Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} 
 * and {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find their union, difference, 
 * and intersection. (You can clone the sets to preserve the original sets from being 
 * changed by these set methods.)
 */

public class Question1 {

	public Question1() {
		System.out.println("\nQuestion 1:");
		// Creating the first set
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("George");
		set1.add("Jim");
		set1.add("John");
		set1.add("Blake");
		set1.add("Kevin");
		set1.add("Michael");
		System.out.println("  Original set 1:\n\t" + set1);
		
		// Creating the second set
		LinkedHashSet<String> set2 = new LinkedHashSet<>();
		set2.add("George");
		set2.add("Katie");
		set2.add("Kevin");
		set2.add("Michelle");
		set2.add("Ryan");
		System.out.println("  Original set 2:\n\t" + set2);
		
		// Finding the intersection, union, and difference of the sets
		findIntersection((LinkedHashSet<String>) set1.clone(),(LinkedHashSet<String>) set2.clone());
		findUnion((LinkedHashSet<String>) set1.clone(),(LinkedHashSet<String>) set2.clone());
		findDifference((LinkedHashSet<String>) set1.clone(),(LinkedHashSet<String>) set2.clone(),1);
		findDifference((LinkedHashSet<String>) set2.clone(),(LinkedHashSet<String>) set1.clone(),2);
		
	}
	
	private void findIntersection(LinkedHashSet<String> intersectionSet, LinkedHashSet<String> set2) {
		
		// Finding intersection
		intersectionSet.retainAll(set2);
		System.out.println("  Intersection Set:\n\t" + intersectionSet);
		
	}
	
	private void findUnion(LinkedHashSet<String> unionSet, LinkedHashSet<String> set2) {
		
		// Finding union
		unionSet.addAll(set2);
		System.out.println("  Union Set:\n\t" + unionSet);
		
	}
	
	private void findDifference(LinkedHashSet<String> differenceSet, LinkedHashSet<String> set2, int setNum) {
		
		// Finding difference
		differenceSet.removeAll(set2);
		System.out.println("  Difference Set " + setNum + ":\n\t" + differenceSet);
		
	}
	
}
