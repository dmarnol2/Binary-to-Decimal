import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Assignment2 {
	
	

	public static void main(String[] args) {
		JFrame frame = new JFrame("Convert Binary to Decimal");
 	    frame.setSize(600, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		
		
		panel.setLayout(null);
		
		JLabel binaryString = new JLabel("Binary String");
		binaryString.setBounds(10, 10, 100, 25);
		panel.add(binaryString);

		JTextField binaryTextField = new JTextField();
		binaryTextField.setBounds(130, 10, 160, 25);
		panel.add(binaryTextField);

		JLabel decimalString = new JLabel("Decimal String");
		decimalString.setBounds(10, 40, 100, 25);
		panel.add(decimalString);

		JPasswordField decimalTextField = new JPasswordField();
		decimalTextField.setBounds(130, 40, 160, 25);
		panel.add(decimalTextField);

		JButton convertBtn = new JButton("Convert to Decimal");
		convertBtn.setBounds(130, 85, 160, 30);
		convertBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(convertBtn);
		
		frame.setVisible(true);
		
		Handler theHandler = new Handler();   //ActionListener object
		binaryTextField.addActionListener(theHandler);
		//decimalTextField.addActionListener(theHandler); //do not need to monitor decimalTextField
		convertBtn.addActionListener(theHandler);

	}
	
	public static class Handler implements ActionListener{
		/**
		  Method: actionPerformed
		  Inputs: actionEvent
		  Returns:

		  Description: Gets user input and authenticates
		*/
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("do something");
			
		}
	} // end Handler class

}
