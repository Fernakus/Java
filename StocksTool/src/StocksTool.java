// Imports
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.*;


public class StocksTool extends JFrame {
	private DecimalFormat df2 = new DecimalFormat(".##");
	// Create Text Fields
	private JTextField intInvestment = new JTextField();
	private JTextField currentPrice = new JTextField();
	private JTextField futurePrice = new JTextField();
	private JTextField gains = new JTextField();
	private JTextField losses = new JTextField();
	private JTextField balanceWithGains = new JTextField();
	private JTextField balanceWithLosses = new JTextField();

	
	private JTextField intInvestment2 = new JTextField();
	private JTextField currentPrice2 = new JTextField();
	private JTextField numOfShares = new JTextField();
	private JTextField percentUP = new JTextField();
	private JTextField percentDOWN = new JTextField();
	private JTextField balanceWithGains1 = new JTextField();
	private JTextField balanceWithLosses1 = new JTextField();
	
	private JTextField calculatorDisplay = new JTextField();
	
	public StocksTool() {
		calculatorDisplay.setText("");
		// Set Layout of Frame
		setLayout(new GridLayout(1, 3));

		/************ This code contained within the blue is all code for the 'Stocks Gain/Loss Calculator' section ************/
		// Create Master Panel
		JPanel masterPanel1 = new JPanel();
		masterPanel1.setBorder(BorderFactory.createTitledBorder("Quick Stock Gain/Loss Calculator"));
		masterPanel1.setLayout(new BorderLayout());
		
		// Create Panel for Labels & Text Fields
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(7,2));
		
		// Add Labels/Text Fields
		p1.add(new JLabel("Initial Investment $"));
		p1.add(intInvestment);
		p1.add(new JLabel("Current Stock Price $"));
		p1.add(currentPrice);
		p1.add(new JLabel("Future Stock Price $"));
		p1.add(futurePrice);
		p1.add(new JLabel("Gains $"));
		p1.add(gains);
		p1.add(new JLabel("Losses $"));
		p1.add(losses);
		p1.add(new JLabel("Balance + Gains $"));
		p1.add(balanceWithGains);
		p1.add(new JLabel("Balance - Losses $"));
		p1.add(balanceWithLosses);
		
		// Create A Button Panel
		JPanel p2 = new JPanel();
		
		// Create A Button
		JButton calculate1 = new JButton("Calculate");
		
		// Add Button to 'p2'
		p2.add(calculate1);
		
		// Add All To masterPanel1
		masterPanel1.add(p1, BorderLayout.CENTER);
		masterPanel1.add(p2, BorderLayout.SOUTH);
		/************* This code contained within the blue is all code for the 'Stocks Gain/Loss Calculator' section *************/
		
		
		
		
		/*************** This code contained within the blue is all code for the 'Quick Shares Calculator' section ***************/
		// Create 'masterPanel2' and set title and layout
		JPanel masterPanel2 = new JPanel();		
		masterPanel2.setBorder(BorderFactory.createTitledBorder("Quick Shares Calculator"));
		masterPanel2.setLayout(new BorderLayout());
		
		// Create panel to hold labels and text field
		JPanel p3 = new JPanel(new GridLayout(7, 2));
		
		// Create labels, add them along with text fields
		p3.add(new JLabel("Initial Investment $"));
		p3.add(intInvestment2);
		p3.add(new JLabel ("Stock Price $"));
		p3.add(currentPrice2);
		p3.add(new JLabel("Num Of Shares #"));
		p3.add(numOfShares);
		p3.add(new JLabel("Quick 75% Profit $"));
		p3.add(percentUP);
		p3.add(new JLabel("Quick 75% Loss $"));
		p3.add(percentDOWN);
		p3.add(new JLabel("Balance + Gains $"));
		p3.add(balanceWithGains1);
		p3.add(new JLabel("Balance - Losses $"));
		p3.add(balanceWithLosses1);
		
		// Create second calculate button
		JButton calculate2 = new JButton("Calculate");
		
		// Create Button Panel
		JPanel p4 = new JPanel();
		p4.add(calculate2);
		
		// Add to 'masterPanel2'
		masterPanel2.add(p3, BorderLayout.CENTER);
		masterPanel2.add(p4, BorderLayout.SOUTH);
		/*************** This code contained within the blue is all code for the 'Quick Shares Calculator' section ***************/
	
		
		
		
		
		/********************** Adding all the elements to the frame **********************/
		// Add to frame
		add(masterPanel1);
		add(masterPanel2);
		/********************** Adding all the elements to the frame **********************/
		

		
		
		/******************* This code contained within the blue is all the creations of the 'ActionListeners' *******************/
		// Action Listeners
		calculate1.addActionListener(new ButtonListener1());
		calculate2.addActionListener(new ButtonListener2());
		
		/******************* This code contained within the blue is all the creations of the 'ActionListeners' *******************/
	}
	
	// ButtonListener1 Class
	class ButtonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Set All Empty
			gains.setText("");
			losses.setText("");
			balanceWithGains.setText("");
			balanceWithLosses.setText("");
			
			// Variables
			try {
				int initialInvestment = Integer.parseInt(intInvestment.getText());
				double currentStockPrice = Double.parseDouble(currentPrice.getText());
				double futureStockPrice = Double.parseDouble(futurePrice.getText());
				double outcome;
				int numOfShares;
				double balanceWithGainss;
				double balanceWithLossess;
				// Calculations
				numOfShares = (int)(initialInvestment / currentStockPrice); // cast to Int
				outcome = (double)((numOfShares * futureStockPrice) - initialInvestment); // cast to Double
				balanceWithGainss = (initialInvestment + outcome);
				balanceWithLossess = (initialInvestment + outcome);
				
				// Output
				if (outcome > 0) {
					gains.setText("" + df2.format(outcome));
					balanceWithGains.setText("" + df2.format(balanceWithGainss));
				}
				else if (outcome < 0) {
					losses.setText("" + df2.format(outcome));
					balanceWithLosses.setText("" + df2.format(balanceWithLossess));
				}
				else {
					gains.setText("" + df2.format(outcome));
					losses.setText("" + df2.format(outcome));
					balanceWithGains.setText("" + df2.format(balanceWithGainss));
					balanceWithLosses.setText("" + df2.format(balanceWithLossess));
				}
			}
			catch (NumberFormatException ex) {
				System.out.println("NumberFormatException Caught By: JohnTheRipper");
			}
		
		}
	}
	
	// ButtonListener2 Class
	class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// Variables
				int initialInvestment = Integer.parseInt(intInvestment2.getText());
				double stockPrice = Double.parseDouble(currentPrice2.getText());
				double balanceWithGainss;
				double balanceWithLossess;
				
				// Calculations
				int numOfSharess = (int)(initialInvestment / stockPrice);
				double increase = (((stockPrice / .75) * (numOfSharess)) - (initialInvestment));
				double decrease = increase;
				balanceWithGainss = (initialInvestment + increase);
				balanceWithLossess = (initialInvestment - decrease);
				
				// Output
				numOfShares.setText("" + numOfSharess);
				percentUP.setText("" + df2.format(increase));
				percentDOWN.setText("-" + df2.format(decrease));
				balanceWithGains1.setText(df2.format(balanceWithGainss));
				balanceWithLosses1.setText(df2.format(balanceWithLossess));	
			}
			
			catch (NumberFormatException ex) {
				System.out.println("NumberFormatException Caught By: JohnTheRipper");
			}
		}
	}
	
	
	// Main Method
	public static void main(String[] args) {
	    StocksTool tool = new StocksTool();
	    tool.pack();
	    tool.setTitle("Fernwood Stock-Market Analysis Tool");
	    tool.setSize(950, 350); // size
	    tool.setLocationRelativeTo(null); // Center the frame
	    tool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tool.setVisible(true);
	 
	}

}