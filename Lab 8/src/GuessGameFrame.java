// Lab Exercise 1 Solution: GuessGameFrame.java
// Guess the number
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GuessGameFrame extends JFrame 
{
	private static Random generator = new Random();
	private int number; // number chosen by application
	private int guessCount; // number of guesses
	private int lastDistance; // distance between last guess and number
	private JTextField guessInputJTextField; // for guessing
	private JLabel prompt1JLabel; // first prompt to user
	private JLabel prompt2JLabel; // second prompt to user
	private JLabel prompt3JLabel; // third prompt to user
	private JLabel prompt4JLabel; // fourth prompt to user
	private JLabel messageJLabel; // displays message of game status
	private JButton newGameJButton; // creates new game
	private Color background; // background color of application
	Container container; 

	// set up GUI and initialize values
	public GuessGameFrame()
	{
		super("Guessing Game");
		setLayout(new FlowLayout());

		guessCount = 0; // initialize number of guesses to 0
		background = Color.LIGHT_GRAY; // set background to light gray

		prompt1JLabel = new JLabel( 
				"I have a number between 1 and 1000." ); // describe game
		prompt2JLabel = new JLabel( 
				"Can you guess my number? Enter your Guess:" ); // prompt user
		prompt3JLabel = new JLabel("You have guessed " + guessCount + " times");
		prompt4JLabel = new JLabel("The answer is " + number);
		prompt4JLabel.setVisible(false);
		guessInputJTextField = new JTextField( 5 ); // to enter guesses
		guessInputJTextField.addActionListener( new GuessHandler( ) );
		messageJLabel = new JLabel( "Guess result appears here." );

		/* Write a statement that creates the "New Game" button */
		newGameJButton = new JButton("New Game");
		newGameJButton.addActionListener(

				new ActionListener() // anonymous inner class
				{
					public void actionPerformed( ActionEvent e )
					{
						messageJLabel.setText("Guess Results");
						guessInputJTextField.setEditable(false);
						background=Color.LIGHT_GRAY;
						theGame();
						repaint();
					} // end method actionPerformed
				} // end anonymous inner class
				); // end call to addActionListener

		container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(prompt1JLabel);
		container.add(prompt2JLabel);
		container.add(guessInputJTextField);
		container.add(messageJLabel);
		container.add(newGameJButton);
		container.add(prompt3JLabel);
		container.add(prompt4JLabel);

		theGame(); // start new game
		
	} // end GuessGameFrame constructor

	// choose a new random number
	public void theGame()
	{
		number = generator.nextInt(1000)+1;
		System.out.println(number);
	} // end method theGame

	// change background color
	public void paint( Graphics g )
	{
		super.paint( g );
		getContentPane().setBackground( background ); // set background
	} // end method paint

	// react to new guess
	public void react( int guess ) 
	{
		guessCount++; // increment guesses
		int currentDistance = 1000;

		prompt3JLabel.setText("You have guessed " + guessCount + " times");
		prompt4JLabel.setText("The answer is " + number);
		prompt4JLabel.setVisible(true);

		// first guess
		if ( guessCount == 1 ) 
		{
			lastDistance = Math.abs(guess - number);
			if ( guess > number )
				messageJLabel.setText( "Too High. Try a lower number." );
			else
				messageJLabel.setText( "Too Low. Try a higher number." );
		} // end if

		else {
			currentDistance = Math.abs(guess - number);
			// guess is too high
			if ( guess > number ) 
			{
				messageJLabel.setText( "Too High. Try a lower number." );
				background = ( currentDistance <= lastDistance ) ?
						Color.RED : Color.BLUE;
				lastDistance = currentDistance;
			} // end if

			else if ( guess < number ) // guess is too low
			{
				messageJLabel.setText( "Too Low. Try a higher number." );
				background = ( currentDistance <= lastDistance ) ?
						Color.RED : Color.BLUE;
				lastDistance = currentDistance;
			} // end else if

			else // guess is correct
			{
				messageJLabel.setText("CORRECT !");
				background = Color.LIGHT_GRAY;
				guessInputJTextField.setEditable(false);
				prompt4JLabel.setVisible(true);
				guessCount = 0;
			} // end else

			repaint();
		} // end else
	} // end method react

	// inner class acts on user input
	class GuessHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			int guess = Integer.parseInt(guessInputJTextField.getText());
			react(guess);
		} // end method actionPerformed

	} // end inner class GuessHandler
} // end class GuessGameFrame

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/