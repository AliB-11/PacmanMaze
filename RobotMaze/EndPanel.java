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

public class EndPanel extends JPanel implements ActionListener {

    // Fileds

    /**
     * endImage is a JLabel that will hold display an image
     */
    JLabel endImage;
    /**
     * endText is a JLabel that will have a message that says congrats
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

    // contructor
    public EndPanel(String data) {

        // set the background colour
        this.setBackground(Color.yellow);
        setLayout(null);

        // initilize the button, label, and txtArea
        playAgain = new JButton("Replay");
        endImage = new JLabel();

        txtArea = new JTextArea();

        // new object trophy that holds the image luffygame.png
        ImageIcon trophy = new ImageIcon("images/EndScreen4.png");

        // set the image to the label
        endImage.setIcon(trophy);

        // set the bounds of the button, text, and image
        playAgain.setBounds(125, 400, 100, 50);

        endImage.setBounds(5, 5, 330, 465);

        // add an action listener to the button
        playAgain.addActionListener(this);

        // set the text of the jtextarea as the string passed in contstructor
        txtArea.setText(data);
        txtArea.setCaretPosition(0);

        // create new object jscrollpane and put the txtarea in it
        jScrollPane = new JScrollPane(txtArea);
        // set the bounds of the jscrollpane
        jScrollPane.setBounds(50, 310, 250, 70);

        // add the scrollpane, image, text, and button to the panel
        add(playAgain);
        add(jScrollPane);
        add(endImage);

    }

    /**
     * Method actionPerformed happens when the button is clicked
     * Calls a main method from main class to restart the program
     */
    public void actionPerformed(ActionEvent e) {
        // call main method in main class to restart the program
        Main.main(null);
    }
}
