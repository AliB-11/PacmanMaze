//package src;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;
import java.io.File;

/**
 * The Main class
 * <p>
 * This class deals with transfer information between panels
 * </p>
 * <p>
 * it also sets the visiablity of the different panels
 * </p>
 * 
 * @author 
 * @version 1.0
 * @since 2023-01-24
 */
public class Main {

  /**
   * size is an int that is the dimentons of the map
   */
  public static int size;
  /**
   * data is the string message read from the file
   */
  public static String data;
  /**
   * GUI is a JFrame that the panels are added to
   */
  public static JFrame GUI = new JFrame();
  /**
   * pane is Container that holds the different panels
   */
  public static Container pane = GUI.getContentPane();

  /**
   * <p>
   * main Method calls creates the JFrame and starts the program
   * </p>
   * 
   * @param args
   */
  public static void main(String[] args) {

    // remove all the content in the pane
    pane.removeAll();

    // set the title of the JFrame
    GUI.setTitle("Robot Maze Runner");
    // set the size of the JFrame
    GUI.setSize(340, 500);
    // close the JFrame if the X is clicked
    GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // call setIcon method
    setIcon(GUI);

    // call setIntroPanelVisible
    setIntroPanelVisible();

  }

  /**
   * <p>
   * setIntroPanelVisible Method makes the intro panel visible
   * </p>
   */
  public static void setIntroPanelVisible() {
    // create object intropanel
    JPanel introPanel = new IntroPanel();
    // remove all the content from the pane
    pane.removeAll();
    // add the intro panel to the pane
    pane.add(introPanel);
    // make the JFrame visible
    GUI.setVisible(true);
  }

  /**
   * <p>
   * setEndPanelVisible Method makes the end panel visible
   * </p>
   * 
   * @param data
   */
  public static void setEndPanelVisible(String data) {
    // create new object endPanel and pass it the file data as a string
    JPanel endPanel = new EndPanel(data);
    // remove the content from pane
    pane.removeAll();
    // add the end panel to the pane
    pane.add(endPanel);
    // make JFrame visible
    GUI.setVisible(true);
  }

  /**
   * <p>
   * setMapPanelVisible Method sets the mapPanel visible
   * </p>
   */
  public static void setMapPanelVisible() {
    // create new object mapPanel and pass it the size of the map
    JPanel mapPanel = new MapPanel(size);
    // remove content from pane
    pane.removeAll();
    // add mapPanel to the pane
    pane.add(mapPanel);
    // make the JFrame visible
    GUI.setVisible(true);
  }

  /**
   * <p>
   * setIcon Method sets the icon of the JFrame
   * </p>
   * 
   * @param GUI
   */
  private static void setIcon(JFrame GUI) {
    // create Image called icon
    Image icon = null;

    try {
      // read the file called "luffyReplit2.png" and set that to image icon
      icon = ImageIO.read(new File("images/luffyReplit2.png"));

      // catch input output exception
    } catch (IOException e) {
      // print the stack trace
      e.printStackTrace();
    }

    // set the icon of the JFrame to the image icon
    GUI.setIconImage(icon);
  }
}