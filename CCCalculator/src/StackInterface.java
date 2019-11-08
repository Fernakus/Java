/*  -------------------------------------------------------
 *  StackInterface.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Nov 5, 2018
 *  ------------------------------------------------------- */

public interface StackInterface {
	public boolean isEmpty();
	public void push(Object item);
	public Object pop() throws StackException;
	public void popAll();
	public Object peek() throws StackException;
}
