//package src;

import robotItems.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** 
* The EndPanel class 
* <p> This class creates a final panel for the user to interact with </p>
* <p> it has an image, a message, a scroll pane, and a button to restart the program </p>
* @author 
* @version 1.0
* @since 2023-01-24
*/
public class EndPanel extends JPanel implements ActionListener{

    // Fileds
    
    /**
    * endImage is a JLabel that will hold display an image 
    */
    JLabel endImage;
    /**
    * endText is a JLabel that will have a message that says congrats
    */
    JLabel endText;
    /**
    * playAgain is a JButton that will we restart the program
    */
    JButton playAgain;
    /**
    * txtArea is JTextArea that holds the message from a file
    */
    JTextArea txtArea;
    /**
    * jScrollPane is a JScrollPane that shows the message from a file neater
    */
    JScrollPane jScrollPane;

    // Contructor

    /**
   * <p> This constructor will create all the piece for the panel </p>
   * @param data String that has the message to load in scroll pane
   */
    public EndPanel(String data) {

    // set the background colour of the panel
    this.setBackground(Color.yellow);
    setLayout(null);

    // initilize the button, label, and txtArea
    playAgain = new JButton("Again");
    endImage = new JLabel();
    endText = new JLabel("Congratulations On Completing The Game!!!");
    txtArea = new JTextArea();

    // new object trophy that holds the image luffygame.png
    ImageIcon trophy = new ImageIcon("images/YouWinText.png");

    // set the image to the label
    endImage.setIcon(trophy);

    // set the bounds of the button, text, and image
    playAgain.setBounds(10,360, 100, 50);
    endText.setBounds(10,10,400,40);
    endImage.setBounds(10,50,300,300);

    // add an action listener to the button
    playAgain.addActionListener(this);

    // set the text of the jtextarea as the string passed in contstructor
    txtArea.setText(data); 

    // create new object jscrollpane and put the txtarea in it
    jScrollPane = new JScrollPane(txtArea);
    // set the bounds of the jscrollpane
    jScrollPane.setBounds(120,360,200,100);


    // add the scrollpane, image, text, and button to the panel
    add(jScrollPane);
    add(endImage);
    add(endText);
    add(playAgain);
    }

    
    /** 
     * <p> Method actionPerformed happens when the button is click </p>
     * <p> Calls a main method from main class to restart the program </p>
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        // when the play again button is clicked
        // call main method in main class to restart the program
        Main.main(null);
    }
}
