/*  -------------------------------------------------------
 *  HashTable.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Mar 2, 2019
 *  ------------------------------------------------------- */

// Imports
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Class
public class HashTable implements HashTableInterface {
	/*
	 * -- HashNode Class --
	 * This is the HashNode class 
	 * as a private class built into the 
	 * HashTable class. More elegant to 
	 * incorporate HashNode class into one class.
	 */
	private class HashNode {
		// Variables
		private Employee emp;
		private HashNode prev, next;
				
		// Single-arg constructor
		public HashNode(Employee e) {
			this.emp = e;
			prev = next = null;
		}
	}
	
	/*
	 * -- HashTableException Class --
	 * This is the HashTableException class 
	 * as a private class built into the 
	 * HashTable class. More elegant to 
	 * incorporate into one class. Used for throwing 
	 * custom exceptions by extending runtime exception
	 */
	private class HashTableException extends RuntimeException{
		private static final long serialVersionUID = 1600408968359349958L;
		public HashTableException(String s) {
			super(s);
		}
	}
	
	/**** -- HashTable Object Below -- ****/
	// Data Members
	private int hashKey, itemCount, bucketsFilled;
	private final int MAX = 1000;
	private HashNode[] hashTable;
	private Scanner in = new Scanner(System.in);
	
	// No-arg Constructor
	public HashTable() throws ClassNotFoundException, IOException {
		hashTable = new HashNode[MAX];
		itemCount = bucketsFilled = 0;
		read();
	}
		
	/*
	 * ---- HashTable Methods ----          
	 * 1)  put()                                 
	 * 2)  get()
	 * 3)  count()
	 * 4)  countBuckets()
	 * 5)  remove()                             
	 * 6)  hash()  							    
	 * 7)  isFull() 	
	 * 8)  print()
	 * 9)  printWithIndex()
	 * 
	 * -- Employee Methods --
	 * 10) write()
	 * 11) read()
	 * 12) genEmployee()
	 * 13) validateUsername()
	 * 14) validatePass()
	 * 15) validateId()
	 * 
	 * -- Other Methods --
	 * 16) yesTo()						 
	 */
	
	// put()
	public void put(Employee e) throws HashTableException, IOException{
		// Generate the hashed address to lookup in hashTable[]
		hashKey = hash(e.getId() + "");
		
		// Exception case
		if (isFull()) throw new HashTableException("on put(): Table is full.");
		else {
			/* hashTable[hashKey] = HashNode || nullity
			 * 
			 * If our HashNode != nullity it means we have an item(technically HashNode) at this address.
			 * This item might have a doubly linked list of items, we will check for the various cases.
			 * 
			 * Throught-out the graphical examples, (xxx) is an arbitrary number, could be anything else.
			 */
			if (hashTable[hashKey] != null) {
				// Create Pointer
				HashNode pointer = hashTable[hashKey];
				
				// Traverse through doubly linked list
				while (pointer != null) {

					// If item equals the item in HashNode ask to insert a duplicate
					if (e.getId() == pointer.emp.getId()) {
						System.out.println("Duplicate ID's!!");
						return;
					}
					
					// Else if node points to nullity: (xxx) --> nullity
					else if (pointer.next == null && (e + "").compareTo(pointer.emp + "") > 0) {
						/*
						 * Following procedure occurs:
						 * 1. (xxx) --> (newNode) --> nullity
						 * 2. (xxx) <--> (newNode) --> nullity
						 * 3. increment item count, new node added
						 */
						pointer.next = new HashNode(e);
						pointer.next.prev = pointer;
						itemCount++;

					}
					
					// Else if item we are inserting is larger: item > (xxx) <--> (xxx)
					else if ((e + "").compareTo(pointer.emp + "") < 0) {
						// Create new HashNode
						HashNode newNode = new HashNode(e);
						
						// if we have one node in the bucket: nullity <-- (xxx) --> nullity
						if (pointer.prev == null) {
							pointer.prev = newNode;
							newNode.next = pointer;
							itemCount++;
						}
						
						// If we are at some arbitrary spot: ... <--> (prev) <--> (next) <--> ...
						else {
							/*
							 * Following procedure occurs:
							 * 1. (prev) --> (newNode)
							 * 2. (prev) <--> (newNode)
							 * 3. (prev) <--> (newNode) <-- (next) <--> ...
							 * 3. (prev) <--> (newNode) <--> (next) <--> ...
							 * 4. increment item count, new node added
							 */
							pointer.prev.next = newNode;
							newNode.prev = pointer.prev;
							pointer.prev = newNode; 
							newNode.next = pointer;
							itemCount++;
						}
					}
					
					// Else traverse pointer
					else pointer = pointer.next;
				}
			}
			
			// The bucket is emtpy
			else {
				/*
				 * 1. Create a new HashNode at hashed Address
				 * 2. Increment itemCount we added a new node
				 * 3. Increment bucketsFilled because we just filled an empty bucket
				 */
				hashTable[hashKey] = new HashNode(e);
				itemCount++;
				bucketsFilled++;
			}
		}
	}
	
	// get()
	public Employee get(String id) {
		// Generate hashKey
		hashKey = hash(id);
		
		// If (item) --> nullity
		if (hashTable[hashKey] == null) return null;
		
		// Else if: (searchedItem) == (item)
		else if(hashTable[hashKey].emp.getId().equals(id)) return hashTable[hashKey].emp;
		
		// Else: begin traverse O(n)
		else {
			// Create pointer
			HashNode pointer = hashTable[hashKey];
			
			// Traverse
			while (pointer != null) {
				// If (searchedItem) == (item) return Node
				if (pointer.emp.getId().equals(id)) return pointer.emp;
				
				// Traverse pointer
				pointer = pointer.next;
			}
			return null;
		}
	}
		
	// count()
	public int count() {
		return itemCount;
	}
	
	// countBuckets()
	public int countBuckets() {
		return bucketsFilled;
	}
	
	// remove()
	public void remove(String id) throws IOException, ClassNotFoundException{
		// Calculate hashKey
		hashKey = hash(id);
		
		// If item at the hashKey address == nullity
		if (hashTable[hashKey] == null) {
			
			// Item not in table, want to insert?
			System.out.println("'" + id + "' not in HashTable!");
			if (yesTo("Would you like to insert (" + id + ")")) {
				Employee emp = genEmployee();
				put(emp);
				System.out.println("Employee Created!");
			}
			return;
		}
		
		// Else if: (xxx) --> null (aka there is only one node, no linked ones attached)
		else if (hashTable[hashKey].next == null) {
			// Set bucket to nullity and decrement itemCount and bucketsFilled
			hashTable[hashKey] = null;
			itemCount--;
			bucketsFilled--;
		}
		
		// Else: (xxx) <--> (xxx) <--> ...
		else {
			// Traversing through linked list of (n) nodes
			while (hashTable[hashKey] != null) {
				
				// If: (item) at the hashedAddress == item we are looking for
				if (hashTable[hashKey].emp.getId().equals(id)) {
					
					// nullity <-- (searchedItem) 
					if (hashTable[hashKey].prev == null) {
						/*
						 * 1. nullity <-- (xxx) <--> ....
						 * 2. decrement itemCount, removed an item
						 * 3. break
						 */
						hashTable[hashKey] = hashTable[hashKey].next;
						itemCount--;
						break;
					}
					
					// Else if: ... <--> (xxx) <--> (searchedItem) <--> (xxx) <--> ...
					else if (hashTable[hashKey].prev != null && hashTable[hashKey].next != null) {
						/*
						 * 1. ... <--> (xxx) --> (xxx) <--> ...
						 * 2. ... <--> (xxx) <--> (xxx) <--> ...  
						 * 3. decrement itemCount, removed an item
						 * 4. break
						 */
						hashTable[hashKey].prev.next = hashTable[hashKey].next;
						hashTable[hashKey].next.prev = hashTable[hashKey].prev;
						itemCount--;
						break;
					}
					
					// Else if: ... <--> (xxx) <--> (searchedItem) --> nullity
					else if (hashTable[hashKey].prev != null && hashTable[hashKey].next == null) {
						/*
						 * 1. ... <--> (xxx) --> nullity
						 * 2. decrement itemCount, removed an item 
						 * 3. break
						 */
						hashTable[hashKey].prev.next = null;
						itemCount--;
						break;
					}
				}
				
				// Traverse Linked List 
				hashTable[hashKey] = hashTable[hashKey].next;
			}
		}
		
		write();
	}
	
	// hash()
	public int hash(String s) {
		String hash = s.hashCode() + "";
		char sum = '0';
		int five = 5;
		for (int i = 0; i < hash.length(); i++) {
			sum += ((hash.charAt(i)) * (Math.pow(2, five += 5)) % MAX);
		}
		return sum % MAX;
	}
	
	// isFull()
	public boolean isFull() {
		return itemCount == MAX;
	}
	
	// print()
	public void print() {
		System.out.println();
		System.out.println("------ Current Hash Table ------");
		for (int i = 0; i < MAX; i++) {
			if (hashTable[i] == null) continue;
			else if (hashTable[i].next != null) {
				HashNode pointer = hashTable[i];
				System.out.print("[");
				while (pointer != null) {
					System.out.print("(" + hashTable[i].emp.getName() + " " 
										 + hashTable[i].emp.getSirname() 
										 + ", " + hashTable[i].emp.getPosition() 
										 + ", " + hashTable[i].emp.getId() 
										 + ") <--> ");
					pointer = pointer.next;
				}
				System.out.println("nullity]");
			}
			
			else {
				System.out.println("[(" + hashTable[i].emp.getName() 
										+ " " 
										+ hashTable[i].emp.getSirname() 
										+ ", " + hashTable[i].emp.getPosition() 
										+ ", " + hashTable[i].emp.getId() 
										+ ") --> nullity]");
			}
		}
		System.out.println();
	}
	
	// printWithIndex()
	public void printWithIndex() {
		System.out.println();
		System.out.println("------ Current Hash Table ------");
		for (int i = 0; i < MAX; i++) {
			if (hashTable[i] == null) continue;
			else if (hashTable[i].next != null) {
				HashNode pointer = hashTable[i];
				System.out.print("Index[" + i + "]: ");
				System.out.print("[");
				while (pointer != null) {
					System.out.print("(" + hashTable[i].emp.getName() 
										 + " " 
										 + hashTable[i].emp.getSirname() 
										 + ", " 
										 + hashTable[i].emp.getPosition() 
										 + ", " 
										 + hashTable[i].emp.getId() 
										 + ") <--> ");
					pointer = pointer.next;
				}
				System.out.println("nullity]");
			}
			
			else {
				System.out.print("Index[" + i + "]: ");
				System.out.println("[(" + hashTable[i].emp.getName() 
										+ " " 
										+ hashTable[i].emp.getSirname() 
										+ ", " 
										+ hashTable[i].emp.getPosition() 
										+ ", " 
										+ hashTable[i].emp.getId() 
										+ ") --> nullity]");
			}
		}
		System.out.println();
	}
	
	// write()
	public void write() throws IOException {
		// Create Output Stream
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("EmployeeDatabase.dat"));
		
		// Loop Thorugh hashTable[]
		for (int i = 0; i < MAX; i++) {
			
			if (hashTable[i] == null) continue;
			
			// Bucket containts doubly linked list
			else if (hashTable[i].next != null) {
				// Create Pointer
				HashNode pointer = hashTable[i];
				
				// Traverse list
				while (pointer != null) {
					out.writeObject(pointer.emp);
					pointer = pointer.next;
				}
			}
			
			// One item in bucket
			else out.writeObject(hashTable[i].emp);

		}
		out.close();
	}
	
	// read()
	public void read() throws IOException, ClassNotFoundException {		
		ObjectInputStream inStream = null;
		
		// Catch EOFException && FileNotFOundException
		try {		
			// Create Input Stream
			inStream = new ObjectInputStream(new FileInputStream("EmployeeDatabase.dat"));
			
			do{
				// Read in object and cast
				Employee e = (Employee)inStream.readObject();
				
				// Call put
				put(e);
			}while(true);
		}
		
		// Handle Exceptions
		catch (FileNotFoundException ex) {
			// Create ObjectOutputStream and close it
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("EmployeeDatabase.dat"));
			out.close();
			System.out.println("No database created, initialized database!");
			System.out.println();
		}
		
		catch (EOFException ex) {
			print();
			inStream.close();
		}
	}
		
	// genEmployee()
	public Employee genEmployee() throws IOException, ClassNotFoundException {
		// Instantiate Employee
		Employee e = new Employee();
		
		System.out.println("---- Creating New Employee ----");
		System.out.println("Please enter in the following:");
		
		while(true) {
			do {
				try {
					System.out.println();
					System.out.print("Firstname: ");
					e.setName(in.nextLine());
					
					System.out.print("Lastname: ");
					e.setSirname(in.nextLine());
					
					System.out.print("Job Position: ");
					e.setPosition(in.nextLine());
					
					System.out.print("Salary($): ");
					e.setSalary(in.nextDouble());
					in.nextLine(); // discard token
					
					System.out.print("Employee ID: ");
					String id = in.nextLine();
					
					if (validatePass(id)) e.setId(id);
					else {
						while(validateId(id) != true) {
							System.out.println("Invalid ID!");
							System.out.print("Employee ID: ");
							id = in.nextLine();
						}
						e.setId(id);
					}

					System.out.print("Username: ");
					String user = in.nextLine();

					if (validateUsername(user)) {
						while(validateUsername(user)) {
							System.out.println("Username exists!");
							System.out.print("Username: ");
							user = in.nextLine();
						}
						e.setUsername(user);
					}
					else e.setUsername(user);
					
					System.out.print("Password: ");
					String pass = in.nextLine();
					
					System.out.print("Retype Password: ");
					String pass1 = in.nextLine();
					
					while (!pass.equals(pass1)) {
						System.out.println("Passwords don't match!!");
						System.out.print("Password: ");
						pass = in.nextLine();
						System.out.print("Retype Password: ");
						pass1 = in.nextLine();
					}
					e.setPass(pass1);
					System.out.println();
					break;
				}
				
				catch (InputMismatchException ex) {
					System.out.println("Invalid input try again!");
					in.nextLine(); 
				}
			}while(true);
			
			System.out.println("---- New Employee Summary ----");
			System.out.println("Firstname: " + e.getName());
			System.out.println("Lastname: "+ e.getSirname());
			System.out.println("Job Position: " + e.getPosition());
			System.out.println("Salary($): " + e.getSalary());
			System.out.println("Employee ID: " + e.getId());
			System.out.println("Username: " + e.getUsername());
			System.out.println("Password: " + e.getPass());
			System.out.println();
			
			if (yesTo("Are you satisfied with the summary")) {
				put(e); 
				write();
				System.out.println("Employee created!");
				System.out.println();
				return e;
			}
			
			else continue;
		}
	}
	
	// findUser()
	public boolean validateUsername(String username) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Condition
		if (username.length() <= 6) return false;	
		
		// Create Input Stream
		ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("EmployeeDatabase.dat"));
		
		// Catch EOFException
		try {
			do{
				// Read in object and cast
				Employee e = (Employee)inStream.readObject();
				String aUser = e.getUsername();
				
				// We have duplicate userNames
				if (username.equals(aUser)) {
					inStream.close();
					return true;
				}
			}while(true);
		}
		
		// Handle Exception
		catch (EOFException ex) {
			inStream.close();
			return false;
		}
	}
	 
	// validatePass
	public boolean validatePass(String pass) {
		// Checking for bad chars
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(pass);
		boolean containsCapitals = false;
		for (int i = 0; i < pass.length(); i++) {
			if (Character.isUpperCase(pass.charAt(i))) {
				containsCapitals = true;
				break;
			}
		}
		
		// Conditions
		if (pass.length() <= 9 && matcher.matches() && containsCapitals) return true;	
		else return false;
	}
	
	// validateId
	public boolean validateId(String id) {
		// Checking for bad chars
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(id);
		
		// Conditions
		if (id.length() != 4) return false;	
		else if (!matcher.matches()) return false;
		else return true;
	}
	
	// printEmployee
	public void printEmployee(Employee emp) {
		System.out.println();
		System.out.println("-- " + emp.getName() + " " + emp.getSirname() + " --");
		System.out.println("Job Position: " + emp.getPosition());
		System.out.println("Salary($): " + emp.getSalary());
		System.out.println("Username: " + emp.getUsername());
		System.out.println("Password: " + emp.getPass());
		System.out.println();
	}
	
	// yesTo()
    public boolean yesTo(String prompt) {    	
    	// Error Catching Structure
        do{
            System.out.print(prompt + " (y/n)? ");
            String response = in.nextLine().trim().toLowerCase();
            if (response.equals("y")) return true;
            else if (response.equals("n")) return false;         
            else System.out.println("Please answer 'y' or 'n'.");
        }while(true);
    }
}
