
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.TreeSet;


public class Question2 {
	
	private File textFile = new File("question2.txt");
	private TreeSet<String> treeSet = new TreeSet<>();
	

	public Question2() {
		System.out.println("\nQuestion 2:");
		readFromFile();
		
	}
	
	private void readFromFile() {
		
		try {
			
			FileReader fr = new FileReader(textFile);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while (line != null) {
				
				treeSet.add(line);
				line = br.readLine();
			}
			
		} catch (Exception e) {
			System.out.println("Excepetion occured:\n" + e);
		}
		
		System.out.println("  Tree set:\n\t" + treeSet);
		
	}
	
}
