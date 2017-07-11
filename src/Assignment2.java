import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This program provides a GUI to take a binary string 
 * from the user and converts the input from binary to
 * decimal and displays the result in a text field in 
 * the interface.
 * 
 * @author Dave Arnold
 * @version 1.0
 * @since 2017-07-05
 *
 */

public class Assignment2 {
	
	static JFrame frame;
	static JPanel panel;
	static JTextField binaryTextField, decimalTextField;
	static JLabel binaryString,decimalString;
	static JButton convertBtn;
	
	/**
	 * This is the main method that uses Java Swing to create a GUI. 
	 * It uses the Handler class to monitor button clicks, and to capture
	 * input in the binaryTextField.
	 *  
	 * @param args Unused
	 *  
	 */
		
	public static void main(String[] args) {
		
		frame = new JFrame("Convert Binary to Decimal");
 	    frame.setSize(600, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		binaryString = new JLabel("Binary String");
		binaryString.setBounds(10, 10, 100, 25);
		panel.add(binaryString);

		binaryTextField = new JTextField();
		binaryTextField.setBounds(110, 10, 325, 25);
		panel.add(binaryTextField);

		decimalString = new JLabel("Decimal String");
		decimalString.setBounds(10, 40, 100, 25);
		panel.add(decimalString);

		decimalTextField = new JTextField();
		decimalTextField.setBounds(110, 40, 325, 25);
		panel.add(decimalTextField);

		convertBtn = new JButton("Convert to Decimal");
		convertBtn.setBounds(110, 85, 325, 30);
		convertBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(convertBtn);
		
		frame.setVisible(true);
		
		Handler theHandler = new Handler();   //ActionListener object
		binaryTextField.addActionListener(theHandler);
		convertBtn.addActionListener(theHandler);
		}
	
	/**
	 * This method validates user input is a binary string and throws
	 * NumberFormatException if it is not. If the user enters a valid
	 * binary string, this method will parse the string as a long with
	 * base 2, and display the result to the user in the decimalTextField of the GUI.
	 * 
	 * @param s String of elements entered by user
	 * @throws NumberFormatException   when user enters an invalid binary character
	 */
	
	public static void parseBinary(String s) throws NumberFormatException {
		Pattern p = Pattern.compile("([2-9])");
		Matcher m = p.matcher(s);
		
		if(m.find()){
			String invalidChr=null;
			int userInput=0;
			String[] inputArray = s.split("");
			for(int i=0;i<inputArray.length;i++){
				userInput=Integer.parseInt(inputArray[i]);
				if (userInput>=2){
					invalidChr=String.valueOf(userInput);
					throw new NumberFormatException(" Illegal character: "+invalidChr );
					}
				} // end inner if
			} // end outer if
		
		else{
			String decimalResult = ("Output: "+Long.parseLong(s,2));
			decimalTextField.setText(decimalResult);
			}
		}
	
	/**
	 * This class monitors and handles user input. Implements
	 * ActionListener.
	 * 
	 */
	
	public static class Handler implements ActionListener{
		
		/**
		 * This method monitors user input events, and takes input
		 * and calls parseBinary method. Handles exceptions thrown by
		 * parseBinary method.
		 * 
		 * @param arg0  events resulting from button click or enter key.
		 */
		
		public void actionPerformed(ActionEvent arg0) {
			
			try{
			parseBinary(binaryTextField.getText());
			}
			catch(Exception ex){
				decimalTextField.setText("Invalid Format for Binary String - "+ ex.getMessage());
				} 
			}
	} // end Handler class
	
} // end class
