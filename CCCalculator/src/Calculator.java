/*  -------------------------------------------------------
 *  calculatorGUI.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Nov 13, 2018
 *  ------------------------------------------------------- */
// Imports
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculator extends Convertor{
	// Buttons For Calculator GUI	
	/* Operators */
	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("x");
	private JButton divButton = new JButton("÷");
	private JButton equalsButton = new JButton("=");
	
	/* Special Cases*/
	private JButton modButton = new JButton("%");
	private JButton decimalButton = new JButton(".");
	private JButton openBracButton = new JButton("(");
	private JButton closeBracButton = new JButton(")");
	private JButton exponentButton = new JButton("x^y");
	private JButton clearButton = new JButton("AC");
	private JButton backButton = new JButton("<--");
	
	/* Operands */
	private JButton oneButton = new JButton("1");
	private JButton twoButton = new JButton("2");
	private JButton threeButton = new JButton("3");
	private JButton fourButton = new JButton("4");
	private JButton fiveButton = new JButton("5");
	private JButton sixButton = new JButton("6");
	private JButton sevenButton = new JButton("7");
	private JButton eightButton = new JButton("8");
	private JButton nineButton = new JButton("9");
	private JButton zeroButton = new JButton("0");
	
	// Text Fields
	private JTextField field = new JTextField();
	private JTextField field2 = new JTextField();
	
	// JPanels
	private JPanel p1 = new JPanel(); // will hold our calculator screen
	private JPanel p2 = new JPanel(); // will hold a row of calculator buttons
	private JPanel p3 = new JPanel(); // will hold a row of calculator buttons
	private JPanel p4 = new JPanel(); // will hold a row of calculator buttons
	private JPanel p5 = new JPanel(); // will hold a row of calculator buttons
	private JPanel p6 = new JPanel(); // will hold our equal button
	private JPanel p7 = new JPanel(); // will hold notation screen
	
	// No-arg constructor
	public Calculator() {
		// Set the Layout
		setLayout(new GridLayout(7,1));
		
		// Add panels to the frame
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);
		add(p7);
		
		// Add to p1
		p1.setLayout(new GridLayout(1,1));
		p1.add(field);
		
		// Add to p2 the buttons for that row
		p2.setLayout(new GridLayout(1, 5));
		p2.add(sevenButton);
		p2.add(eightButton);
		p2.add(nineButton);
		p2.add(backButton);
		p2.add(divButton);
		
		// Add to p3 the buttons for that row
		p3.setLayout(new GridLayout(1, 5));
		p3.add(fourButton);
		p3.add(fiveButton);
		p3.add(sixButton);
		p3.add(mulButton);
		p3.add(openBracButton);
		
		// Add to p4 the buttons for that row
		p4.setLayout(new GridLayout(1, 5));
		p4.add(oneButton);
		p4.add(twoButton);
		p4.add(threeButton);
		p4.add(addButton);
		p4.add(closeBracButton);
		
		// Add to p5 the buttons for that row
		p5.setLayout(new GridLayout(1, 5));
		p5.add(zeroButton);
		p5.add(decimalButton);
		p5.add(clearButton);
		p5.add(subButton);
		p5.add(exponentButton);
		
		// Add to p6
		p6.setLayout(new GridLayout(1,1));
		p6.add(equalsButton);
		
		// Add to p7
		p7.setLayout(new GridLayout(1,1));
		p7.add(field2);
		
		
		// Add the ActionListener to all buttons
		/* Operands */
		zeroButton.addActionListener(new ButtonListener());
		oneButton.addActionListener(new ButtonListener());
		twoButton.addActionListener(new ButtonListener());
		threeButton.addActionListener(new ButtonListener());
		fourButton.addActionListener(new ButtonListener());
		fiveButton.addActionListener(new ButtonListener());
		sixButton.addActionListener(new ButtonListener());
		sevenButton.addActionListener(new ButtonListener());
		eightButton.addActionListener(new ButtonListener());
		nineButton.addActionListener(new ButtonListener());
		
		/* Operators */
		backButton.addActionListener(new ButtonListener());
		mulButton.addActionListener(new ButtonListener());
		addButton.addActionListener(new ButtonListener());
		subButton.addActionListener(new ButtonListener());
		divButton.addActionListener(new ButtonListener());

		
		/* Special Cases */
		openBracButton.addActionListener(new ButtonListener());
		closeBracButton.addActionListener(new ButtonListener());
		equalsButton.addActionListener(new ButtonListener());
		decimalButton.addActionListener(new ButtonListener());
		clearButton.addActionListener(new ButtonListener());
		exponentButton.addActionListener(new ButtonListener());
		
		// Set both textfields to uneditable so user can only enter in data via the GUI buttons
		field.setEditable(false);
		field2.setEditable(false);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String currEqn = field.getText();
			String command = e.getActionCommand();
			
			switch(command) {
				case "1":				
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
				case "0":
				case "+":
				case "-":
				case "(":
				case ")":
					field.setText(currEqn + command);
					break;
				//case ".":
					
				case "÷":
					field.setText(currEqn + "/");
					break;
					
				case "x":
					field.setText(currEqn + "*");
					break;
					
				case "x^y":
					field.setText(currEqn + "^");
					break;
					
				case "AC":
					// Reset the textfields
					field.setText("");
					field2.setText("");
					break;
				
				case "<--":
					// Backspace
					if (field.getText() == null || field.getText().equals("")) break;
					else {
						// Remove last the char from the string
						String newEquation = field.getText().substring(0, field.getText().length() - 1);
						field.setText(newEquation);
						break;
					}
				case "=":
					if (verifyInfix(field.getText()) == true) {
						// We have a valid verified infix expression, call convertToPostifx()
						String postFix = convertToPostfix(field.getText());
						field.setText("" + evalPostfix(postFix));
						field2.setText("" + postFix);
					}

					else {
						field.setText("");
						field2.setText("Error");
					}
					break;		
			}
		}
	}
}
