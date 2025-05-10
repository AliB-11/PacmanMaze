//package src;

import robotItems.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The IntroPanel class
 * This class creates a intro panel for the user to interact with
 * it prompts the user to play
 */

public class IntroPanel extends JPanel implements ActionListener {
  // Fields

  JButton small;

  JButton medium;

  JButton large;

  JTextField intro;

  JLabel start;

  // Contructor

  /**
   * This constructor will create all the piece for the intro panel
   */
  public IntroPanel() {

    // set the background colour to blue
    this.setBackground(Color.YELLOW);
    setLayout(null);

    // create all the buttons and the text on them
    small = new JButton("Small");
    medium = new JButton("Medium");
    large = new JButton("Large");
    start = new JLabel();
    // create the textfield and write the prompt
    intro = new JTextField("        Select the Size Map to Play");
    intro.setEditable(false);

    // set the bounds of the buttons and the textfield
    intro.setBounds(33, 140, 250, 50);
    small.setBounds(115, 210, 100, 50);
    medium.setBounds(115, 280, 100, 50);
    large.setBounds(115, 350, 100, 50);
    start.setBounds(15, 15, 300, 165);
    start.setIcon(new ImageIcon("images/Start.png"));

    // add all the piece to the panel
    add(intro);
    add(small);
    add(medium);
    add(large);
    add(start);

    // add actions listeners to the three buttons
    small.addActionListener(this);
    medium.addActionListener(this);
    large.addActionListener(this);
  } // END OF CONSTRUCTOR

  /**
   * actionPerformed method looks at which size map the user wants to play
   */
  public void actionPerformed(ActionEvent e) {
    // declare and intilize variable for size
    int size = 0;
    // delcare and initlize varible to look at which button was clicked
    String button = e.getActionCommand();

    // if the small button was clickd
    if (button.equals("Small")) {
      size = 5;
      // if the medium button was clicked
    } else if (button.equals("Medium")) {
      size = 8;
      // if the large button was clicked
    } else if (button.equals("Large")) {
      size = 10;
    } else {

    }

    Main.size = size;
    // call setMapPanelVisible method in main class
    Main.setMapPanelVisible();

  }
} // END OF CLASS
