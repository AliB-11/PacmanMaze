//package src;

import robotItems.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
* The IntroPanel class 
* <p> This class creates a intro  panel for the user to interact with </p>
* <p> it prompts the user to play and gives it three buttons to choose from </p>
* @author 
* @version 1.0
* @since 2023-01-24
*/

public class IntroPanel extends JPanel implements ActionListener {
  // Fields

  /**
  * small is JButton that generates a 5 x 5 map  
  */
  JButton small;
  /**
  * medium is a JButton that generates a 8 x 8 map 
  */
  JButton medium;
  /**
  * large is a JButton that generates a 10 x 10 map 
  */
  JButton large;
  /**
  * intro is a JTextField that prompts the user
  */
  JTextField intro;

  // Contructor 

  /**
   * <p> This constructor will create all the piece for the intro panel </p>
   */
  public IntroPanel() {

    // set the background colour to blue
    this.setBackground(Color.blue);
    setLayout(null);

    // create all the buttons and the text on them
    small = new JButton("5 X 5");
    medium = new JButton("8 X 8");
    large = new JButton("10 X 10");
    // create the textfield and write the prompt
    intro = new JTextField("Select What Size Map to Play");

    // set the bounds of the buttons and the textfield
    intro.setBounds(25, 5, 250, 50);
    small.setBounds(100, 70, 100, 50);
    medium.setBounds(100, 140, 100, 50);
    large.setBounds(100, 210, 100, 50);

    // add all the piece to the panel
    add(intro);
    add(small);
    add(medium);
    add(large);

    // add actions listeners to the three buttons
    small.addActionListener(this);
    medium.addActionListener(this);
    large.addActionListener(this);
  } // END OF CONSTRUCTOR

  
  /** 
   * <p> actionPerformed method looks at which size map the user wants to play</p>
   * @param e
   */
  public void actionPerformed(ActionEvent e) {
    // declare and intilize variable for size
    int size = 0;
    // delcare and initlize varible to look at which button was clicked
    String button = e.getActionCommand();

      // if the small button was clickd
    if (button.equals("5 X 5")) {
      // set size to 5
      size = 5;
      // if the medium button was clicked
    } else if (button.equals("8 X 8")) {
      // set size to 8
      size = 8;
      // if the large button was clicked
    } else if (button.equals("10 X 10")) {
      // set size to 10
      size = 10;
    } else {
      // NO ELSE
    }

    // set the variable in main class to variable size here
    Main.size = size;
    // call setMapPanelVisible method in main class
    Main.setMapPanelVisible();

  }// END OF ACTIONPERFORMED METHOD
} // END OF CLASS