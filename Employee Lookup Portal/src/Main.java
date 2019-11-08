import java.io.IOException;
import java.util.Scanner;

/*  -------------------------------------------------------
 *  Main.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Mar 2, 2019
 *  ------------------------------------------------------- */

// Imports

public class Main{ 
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		// Instantiate HashTable
		HashTable t = new HashTable();
		Scanner in = new Scanner(System.in);
		
		System.out.println("---- Other Testing Below ----");
		System.out.println("Number of employees: " + t.count());
		System.out.println("Number of buckets filled: " + t.countBuckets());
		System.out.println("isFull(): " + t.isFull());
		System.out.println();

		// Generate An Employee Function
		t.genEmployee();
		t.print();
		
		// Remove An Employee Function
		System.out.print("Enter an employee ID to remove: ");
		String id = in.next();
		t.remove(id);
		t.print();
		
		// Get An Employee Function
		System.out.print("Enter an employee ID to search: ");
		id = in.next();
		Employee emp = t.get(id);
		
		// Print An Employee Function
		t.printEmployee(emp);
		
		// Other Testing
		System.out.println("---- Other Testing Below ----");
		System.out.println("Number of employees: " + t.count());
		System.out.println("Number of buckets filled: " + t.countBuckets());
		System.out.println("isFull(): " + t.isFull());
		t.printWithIndex();
	}
}