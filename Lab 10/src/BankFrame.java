/* File name: BankFrame.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 2
 * Date: April 20th
 * Professor: Angela Giddings                                              
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.awt.Window.Type;
import javax.swing.JRadioButton;

/**
 * The main frame of the program
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class BankFrame extends JFrame {
	
	private JTextField tfAccNum;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfPhoneNum;
	private JTextField tfEmail;
	private JTextField tfBalance;
	private JTextField tfMinBalance;
	private JTextField tfInterest;
	private JTextField tfFee;
    private ButtonGroup button;
    private Bank bank = new Bank(1000);
    
  
	/**
	 * Initialize value and add actions for buttons
	 */
	public BankFrame() {
		super("Banking System");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 150, 122));
		panel.setBounds(0, 0, 1000, 62);
		getContentPane().add(panel);
		
		JLabel lblMinhDucPhams = new JLabel("Minh Duc Pham's Banking System");
		lblMinhDucPhams.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblMinhDucPhams.setBackground(new Color(233, 150, 122));
		panel.add(lblMinhDucPhams);
		
		tfAccNum = new JTextField();
		tfAccNum.setBounds(377, 117, 584, 20);
		getContentPane().add(tfAccNum);
		tfAccNum.setColumns(10);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(377, 145, 584, 20);
		getContentPane().add(tfFirstName);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(377, 180, 584, 20);
		getContentPane().add(tfLastName);
		
		tfPhoneNum = new JTextField();
		tfPhoneNum.setColumns(10);
		tfPhoneNum.setBounds(377, 214, 584, 20);
		getContentPane().add(tfPhoneNum);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(377, 253, 584, 20);
		getContentPane().add(tfEmail);
		
		tfBalance = new JTextField();
		tfBalance.setColumns(10);
		tfBalance.setBounds(377, 289, 584, 20);
		getContentPane().add(tfBalance);
		
		tfMinBalance = new JTextField();
		tfMinBalance.setColumns(10);
		tfMinBalance.setBounds(377, 330, 584, 20);
		getContentPane().add(tfMinBalance);
		
		tfInterest = new JTextField();
		tfInterest.setColumns(10);
		tfInterest.setBounds(377, 366, 584, 20);
		getContentPane().add(tfInterest);
		
		tfFee = new JTextField();
		tfFee.setColumns(10);
		tfFee.setBounds(377, 406, 584, 20);
		getContentPane().add(tfFee);
		
		tfFee.setEditable(false);
		tfMinBalance.setEditable(false);
		tfInterest.setEditable(false);
		tfAccNum.setEditable(false);
		tfFirstName.setEditable(false);
		tfLastName.setEditable(false);
		tfPhoneNum.setEditable(false);
		tfEmail.setEditable(false);
		tfBalance.setEditable(false);
		
		JRadioButton radioChequingAccount = new JRadioButton("Chequing Account");
		radioChequingAccount.setBounds(259, 69, 171, 23);
		getContentPane().add(radioChequingAccount);
		radioChequingAccount.addActionListener(

				new ActionListener() { // anonymous inner class 
					public void actionPerformed( ActionEvent e ) {
						if(e.getSource() == radioChequingAccount) {
							tfMinBalance.setEditable(false);
							tfInterest.setEditable(false);
							tfMinBalance.setText("");
							tfInterest.setText("");
							
							tfFee.setEditable(true);
							tfAccNum.setEditable(true);
							tfFirstName.setEditable(true);
							tfLastName.setEditable(true);
							tfPhoneNum.setEditable(true);
							tfEmail.setEditable(true);
							tfBalance.setEditable(true);
							
						}// end of if
					} // end method actionPerformed
				} // end anonymous inner class
				);
		
		JRadioButton radioSavingsAccount = new JRadioButton("Savings Account");
		radioSavingsAccount.setBounds(464, 69, 171, 23);
		getContentPane().add(radioSavingsAccount);
		radioSavingsAccount.addActionListener(

				new ActionListener() { // anonymous inner class 
					public void actionPerformed( ActionEvent e ) {
						if(e.getSource() == radioSavingsAccount) {
							tfFee.setEditable(false);
							tfFee.setText("");
							
							tfMinBalance.setEditable(true);
							tfInterest.setEditable(true);
							tfAccNum.setEditable(true);
							tfFirstName.setEditable(true);
							tfLastName.setEditable(true);
							tfPhoneNum.setEditable(true);
							tfEmail.setEditable(true);
							tfBalance.setEditable(true);
							
						}// end of if
					} // end method actionPerformed
				} // end anonymous inner class
				);
		
		//add button into group
		button = new ButtonGroup();
		button.add(radioSavingsAccount);
		button.add(radioChequingAccount);
		
		JButton addAcc = new JButton("Add an account");
		addAcc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addAcc.setBounds(20, 73, 171, 41);
		getContentPane().add(addAcc);
		addAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char type = 'a';
				boolean isDouble = false;
				boolean e1 = false,e2,e3,e4,e5,e6,e7,e8,e9;
				int accNum = 0;
				double balance = 0;
				String fName = "";
				String lName = "";
				long phoNo = 0;
				String email = "";
				double fee = 0;
				double minBalance = 0;
				double interest = 0;
				
				//get Account Number
				if (tfAccNum.getText().length() <= 8) {
					try {
						accNum = Integer.parseInt(tfAccNum.getText());
						if (Bank.searchAccounts(accNum) != null) {
							accNum = 0;
							JOptionPane.showMessageDialog(null, "Account number already in use. Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
							e1 = true;
						}else if(accNum <0) {
							accNum = 0;
							JOptionPane.showMessageDialog(null, "Please enter a positive number", "Error!", JOptionPane.ERROR_MESSAGE);
							e1 = true;
						}
					} catch (Exception ex) {
						accNum = 0;
						JOptionPane.showMessageDialog(null, "Invalid account number. Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
						e1 = true;
					}
				}else {
					accNum = Integer.parseInt(tfAccNum.getText());
					e1 = false;
				}
				//get opening balance
				try{
				    Double.parseDouble(tfBalance.getText());
				    isDouble = true;
				}catch( Exception ex ){
					isDouble = false;
				}
				
				if(isDouble == false) {
					JOptionPane.showMessageDialog(null, "Invalid opening balance amount. Please try again", "Error!", JOptionPane.ERROR_MESSAGE);
					e2 = true;
				}else if(Double.parseDouble(tfBalance.getText()) < 0){
					JOptionPane.showMessageDialog(null, "The opening balance must be a positive number ! Please enter again", "Error!", JOptionPane.ERROR_MESSAGE);
					e2 = true;
				}else {
					balance = Double.parseDouble(tfBalance.getText());
					e2 = false;
				}
				
				//get first name
				fName = tfFirstName.getText();
				if(fName.matches("[a-zA-Z]+") == false) {
					JOptionPane.showMessageDialog(null, "Invalid first name ! Please enter a word", "Error!", JOptionPane.ERROR_MESSAGE);
					fName = "";
					e3 = true;
				}else {
					fName = tfFirstName.getText();
					e3 = false;
				}
				
				//get last name
				lName = tfLastName.getText();
				if(lName.matches("[a-zA-Z]+") == false) {
					JOptionPane.showMessageDialog(null, "Invalid last name ! Please enter a word", "Error!", JOptionPane.ERROR_MESSAGE);
					lName = "";
					e4 = true;
				}else {
					lName = tfLastName.getText();
					e4 = false;
				}
				
				//get phone number
				if (tfPhoneNum.getText().length() == 7 || tfPhoneNum.getText().length() == 10) {
					try {
						phoNo = Long.parseLong(tfPhoneNum.getText());
						e5 = false;
					} catch (Exception ex) {
						phoNo = 0;
						JOptionPane.showMessageDialog(null, "Invalid phone number. Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
						e5 = true;
					}
				} else {
					phoNo = 0;
					JOptionPane.showMessageDialog(null, "Invalid phone number. Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
					e5 = true;
				}
				
				//get email address
				email = tfEmail.getText();
				int atPos = email.indexOf('@');
				int dotPos = email.lastIndexOf('.');
				
				if(atPos==-1 || dotPos==-1 || atPos>dotPos) {
					JOptionPane.showMessageDialog(null, "Invalid email address ! Please enter again. ", "Error!", JOptionPane.ERROR_MESSAGE);
					email = "";
					atPos = email.indexOf('@');
					dotPos = email.lastIndexOf('.');
					e6 = true;
				}else {
					email = tfEmail.getText();
					e6 = false;
				}
				
				
				if(radioChequingAccount.isSelected()) {
					type = 'c';
					// get monthly fee
					try {
						fee = Double.parseDouble(tfFee.getText());
						e7 = false;
						if(fee<0) {
							JOptionPane.showMessageDialog(null, "The monthly fee must be larger than 0! Please enter again: ", "Error!", JOptionPane.ERROR_MESSAGE);
							e7 = true;
							fee = 0;
						}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Invalid monthly fee ! Please enter again", "Error!", JOptionPane.ERROR_MESSAGE);
						e7 = true;
						fee = 0;
					}
					
					if (e1 == false && e2 == false && e3 == false && e4 == false && e5 == false && e6 == false && e7 == false) {
						bank.addAccount(type, accNum, fName, lName, phoNo, email, balance, minBalance, interest, fee);
						tfFee.setText("");
						tfMinBalance.setText("");
						tfInterest.setText("");
						tfAccNum.setText("");
						tfFirstName.setText("");
						tfLastName.setText("");
						tfPhoneNum.setText("");
						tfEmail.setText("");
						tfBalance.setText("");
					}
					
				}// Chequing Account cases
				else if(radioSavingsAccount.isSelected()) {
					type = 's';
					
					//get minimum Balance
					try {
						minBalance = Double.parseDouble(tfMinBalance.getText());
						e8 = false;
						if(minBalance>balance) {
							JOptionPane.showMessageDialog(null, "The minimum balance must be smaller than the opening balance ! Please enter again", "Error!", JOptionPane.ERROR_MESSAGE);
							minBalance = 0;
							e8 = true;
						}
						else if(minBalance<0) {
							JOptionPane.showMessageDialog(null, "The minimum balance must be larger than 0 ! Please enter again", "Error!", JOptionPane.ERROR_MESSAGE);
							minBalance = 0;
							e8 = true;
						}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Invalid minimum balance ! Please enter again ", "Error!", JOptionPane.ERROR_MESSAGE);
						minBalance = 0;
						e8 = true;
					}
					
					// get interest rate
					try {
						interest = Double.parseDouble(tfInterest.getText());
						e9 = false;
						if(interest <=0 || interest>=1) {
							JOptionPane.showMessageDialog(null, "Interest rate must be between (0,1)! Please enter again ", "Error!", JOptionPane.ERROR_MESSAGE);
							interest = 0;
							e9 = true;
						}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Invalid interest rate ! Please enter again", "Error!", JOptionPane.ERROR_MESSAGE);
						interest = 0;
						e9 = true;
					}
					if(e1 == false && e2 == false && e3 == false && e4 == false && e5 == false && e6 == false && e8 == false && e9 == false) {
						bank.addAccount(type, accNum, fName, lName, phoNo, email, balance, minBalance, interest, fee);
						tfFee.setText("");
						tfMinBalance.setText("");
						tfInterest.setText("");
						tfAccNum.setText("");
						tfFirstName.setText("");
						tfLastName.setText("");
						tfPhoneNum.setText("");
						tfEmail.setText("");
						tfBalance.setText("");
					}
					

				}// Savings Account cases
				
			}// end of Action Performed
		}// end anonymous inner class
		);
		
		JButton update = new JButton("Update an account");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.updateAccount();
			}// end method
		}//end anonymous inner class
		);
		update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		update.setBounds(20, 130, 171, 46);
		getContentPane().add(update);
		
		JButton display = new JButton("Display an account");
		display.setFont(new Font("Tahoma", Font.PLAIN, 16));
		display.setBounds(20, 202, 171, 41);
		getContentPane().add(display);
		display.addActionListener(
				new ActionListener() { // anonymous inner class 
					public void actionPerformed( ActionEvent e ) {
						bank.displayAccount();
					} // end method actionPerformed
				} // end anonymous inner class
				);
		
		JButton print = new JButton("Print all accounts");
		print.setFont(new Font("Tahoma", Font.PLAIN, 16));
		print.setBounds(20, 277, 171, 41);
		getContentPane().add(print);
		print.addActionListener(

				new ActionListener() { // anonymous inner class 
					public void actionPerformed( ActionEvent e ) {
						AllAccountsFrame allAcs = new AllAccountsFrame();
//						allAcs.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						allAcs.setSize( 1500, 500 ); // set frame size
						allAcs.setVisible( true ); // display frame
						allAcs.setResizable(true);
					} // end method actionPerformed
				} // end anonymous inner class
				);
		
		JButton monthlyUpdate = new JButton("Run monthly update");
		monthlyUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monthlyUpdate.setBounds(20, 346, 170, 41);
		getContentPane().add(monthlyUpdate);
		monthlyUpdate.addActionListener(

				new ActionListener() { // anonymous inner class 
					public void actionPerformed( ActionEvent e ) {
						bank.monthlyUpdate();
					} // end method actionPerformed
				} // end anonymous inner class
				);
		
		JButton readFromFile = new JButton("Read from file");
		readFromFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		readFromFile.setBounds(20, 405, 170, 41);
		getContentPane().add(readFromFile);
		readFromFile.addActionListener(

				new ActionListener() { // anonymous inner class 
					public void actionPerformed( ActionEvent e ) {
						String file = "";
						JFrame frameReadFile = new JFrame("Read from file");
						file = JOptionPane.showInputDialog(frameReadFile, "Please input the file name");
						bank.readFile(file);
					} // end method actionPerformed
				} // end anonymous inner class
				);

		JLabel labelAccNum = new JLabel("Account Number");
		labelAccNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAccNum.setBounds(248, 110, 133, 31);
		getContentPane().add(labelAccNum);
		
		JLabel labelFirstName = new JLabel("First Name");
		labelFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFirstName.setBounds(248, 142, 80, 23);
		getContentPane().add(labelFirstName);
		
		JLabel labelLastName = new JLabel("Last Name");
		labelLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLastName.setBounds(247, 176, 101, 24);
		getContentPane().add(labelLastName);
		
		JLabel labelPhoneNumber = new JLabel("Phone Number");
		labelPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPhoneNumber.setBounds(247, 211, 112, 23);
		getContentPane().add(labelPhoneNumber);
		
		JLabel labelEmailAddress = new JLabel("Email Address");
		labelEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmailAddress.setBounds(247, 250, 101, 23);
		getContentPane().add(labelEmailAddress);
		
		JLabel labelOpeningBalance = new JLabel("Opening Balance");
		labelOpeningBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelOpeningBalance.setBounds(247, 286, 123, 23);
		getContentPane().add(labelOpeningBalance);
		
		JLabel labelMinimumBalance = new JLabel("Minimum Balance");
		labelMinimumBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMinimumBalance.setBounds(247, 327, 116, 23);
		getContentPane().add(labelMinimumBalance);
		
		JLabel labelInterestRate = new JLabel("Interest Rate");
		labelInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelInterestRate.setBounds(248, 361, 101, 26);
		getContentPane().add(labelInterestRate);
		
		JLabel labelMonthlyFee = new JLabel("Monthly Fee");
		labelMonthlyFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMonthlyFee.setBounds(247, 403, 116, 23);
		getContentPane().add(labelMonthlyFee);
		
	}// end of constructor
	
	/**
	 * The main method, set the size for the frame
	 * @param args The command line arguments
	 * @throws FileNotFoundException If the attempt to open a file is failed
	 */
	public static void main(String[] args) throws FileNotFoundException {
		BankFrame frame = new BankFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 1005, 500 ); // set frame size
		frame.setVisible( true ); // display frame
		frame.setResizable(false);
	}// end of main
	
}// end of class
