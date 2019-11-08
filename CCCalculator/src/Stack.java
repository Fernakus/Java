/*  -------------------------------------------------------
 *  Stack.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Nov 5, 2018
 *  ------------------------------------------------------- */
public class Stack implements StackInterface{
	// Variables
	private Node top;
	
	// Constructor
	public Stack() {
		top = null;
	}
	
	// Methods
	// isEmpty()
	public boolean isEmpty() {
		return top == null;
	}
	
	// push()
	public void push(Object item) {
		top = new Node(item, top);
	}
	
	// pop() 
	public Object pop() throws StackException{
		if (!isEmpty()) {
			Object temp = top.getItem();
			top = (Node)top.getNext();
			return temp;
		}
		else throw new StackException("StackException on pop: stack empty");
	}

	// popAll()
	public void popAll() {
		top = null;
	}

	// peek()
	public Object peek() throws StackException{
		if (!isEmpty()) return top.getItem();
		else throw new StackException("StackException on pop: stack empty");
	}
}
