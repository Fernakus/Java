/*  -------------------------------------------------------
 *  Node.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Nov 5, 2018
 *  ------------------------------------------------------- */

public class Node {
	// Variables
	private Object item;
	private Node next;
	
	// Default Constructor
	public Node (Object newItem, Node next) {
		item = newItem;
		this.next = next;
	}

	// Getters
	public Object getItem() {
		return item;
	}
	
	public Object getNext() {
		return next;
	}
	
	// Setters
	public void setItem(Object newItem) {
		item = newItem;
	}
}
