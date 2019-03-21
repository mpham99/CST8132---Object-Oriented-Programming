/* File name: AllAccountsFrame.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 2
 * Date: April 20th
 * Professor: Angela Giddings                                              
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

/**
 * The frame for all accounts table
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class AllAccountsFrame extends JFrame {
	private JButton backButton;
	private JTable table1;

	/**
	 * The constructor to call setupUI() and add action for back button
	 */
	public AllAccountsFrame() {
		setupUI();
		backButton.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false); 
						dispose(); 
					}//end of method actionPerformed
				}//end of anonymous class
				);
	}// end of constructor

	/**
	 * Setup the UI for the UI
	 */
	private void setupUI() {
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		backButton = new JButton();
		backButton.setText("Back");
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(backButton, gbc);

		//init table data
		String[] cols = {"Account Number", "Holder", "Balance", "Minimum Balance", "Interest Rate", "Monthly Fee"};
		Object[][] data = new Object[Bank.accounts.size()][3];
		int i = 0;
		for (BankAccount acc : Bank.accounts) {
			data[i++] = acc.toArray();
		}
		//create table
		table1 = new JTable(data, cols);
		//add table to a scroll pane
		JScrollPane jpane = new JScrollPane(table1);
		jpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		//add scroll pane to panel
		panel1.add(jpane, gbc);

		//add panel to frame
		this.getContentPane().add(new JScrollPane(panel1));
	}//end of setupUI method

}
