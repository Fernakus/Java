/*  -------------------------------------------------------
 *  HashTableInterface.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Mar 2, 2019
 *  ------------------------------------------------------- */

// Imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public interface HashTableInterface {
	public void put(Employee emp) throws IOException;
	public Employee get(String id);
	public int count();
	public int countBuckets();
	public void remove(String id) throws IOException, ClassNotFoundException;
	public int hash(String s);
	public boolean isFull();
	public void print();
	public void printWithIndex();
	public Employee genEmployee() throws IOException, ClassNotFoundException;
	public boolean validateUsername(String id) throws FileNotFoundException, IOException, ClassNotFoundException;
	public boolean validatePass(String pass);
	public boolean validateId(String id);
	public boolean yesTo(String prompt);
}
