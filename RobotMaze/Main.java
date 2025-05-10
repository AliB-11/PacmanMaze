//package src;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;
import java.io.File;

/**
 * Main class
 * Transfers information between panels
 */
public class Main {

  public static int size;

  public static String data;

  public static JFrame GUI = new JFrame();

  public static Container pane = GUI.getContentPane();

  /**
   * main Method creates the JFrame and starts program
   * 
   * @param args
   */
  public static void main(String[] args) {

    // remove all the content in the pane
    pane.removeAll();

    // set the title of the JFrame
    GUI.setTitle("Pacman Maze");
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
   * setIntroPanelVisible makes intro panel visible
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
    pane.revalidate(); // Force layout update
    pane.repaint(); // Force redraw
    GUI.setVisible(true);
  }

  /**
   * setEndPanelVisible Method makes the end panel visible
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
    pane.revalidate(); // Force layout update
    pane.repaint(); // Force redraw
    GUI.setVisible(true);
  }

  /**
   * setMapPanelVisible Method sets the mapPanel visible
   */
  public static void setMapPanelVisible() {
    // create new object mapPanel and pass it the size of the map
    JPanel mapPanel = new MapPanel(size);
    // remove content from pane
    pane.removeAll();
    // add mapPanel to the pane
    pane.add(mapPanel);
    pane.revalidate(); // Force layout update
    pane.repaint(); // Force redraw
    // make the JFrame visible
    GUI.setVisible(true);
  }

  /**
   * setIcon Method sets the icon of the JFrame
   * 
   * @param GUI
   */
  private static void setIcon(JFrame GUI) {
    // create Image called icon
    Image icon = null;

    try {
      // read the file called "pacman.png" and set that to image icon
      icon = ImageIO.read(new File("images/PacR.png"));

      // catch input output exception
    } catch (IOException e) {
      // print the stack trace
      e.printStackTrace();
    }

    // set the icon of the JFrame to the image icon
    GUI.setIconImage(icon);
  }
}
