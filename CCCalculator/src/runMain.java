/*  -------------------------------------------------------
 *  main.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Nov 24, 2018
 *  ------------------------------------------------------- */
// Imports
import javax.swing.JFrame;

public class runMain {
	// Main Method
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
	    calculator.pack();
	    calculator.setTitle("Composite Computing Calculator");
	    calculator.setSize(320, 350); // size
	    calculator.setLocationRelativeTo(null); // Center the frame
	    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    calculator.setVisible(true);
	    calculator.setResizable(false);
	}
}
