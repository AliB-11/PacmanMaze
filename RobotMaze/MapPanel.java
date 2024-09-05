//package src;

import robotItems.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The MapPanel class
 * <p>
 * This class is the main panel for the robot game
 * </p>
 * <p>
 * it has the grid (map) aswell as the robot moving through it
 * </p>
 * 
 * @author
 * @version 1.0
 * @since 2023-01-24
 */
public class MapPanel extends JPanel implements ActionListener {
  // Fields

  /**
   * size is an int that holds the dimentions of the map
   */
  private int size;
  /**
   * map is a two dimentinal array of tiles
   */
  private Tiles[][] map;
  /**
   * counter is an int that counts how many times the robot was moved
   */
  private int counter = 0;
  /**
   * robotPosition is int array that holds the row and column the robot is at
   */
  private int[] robotPosition;

  /**
   * mapvisual is a two dimentonal array of JLabels that shows the tiles
   */
  JLabel[][] mapVisual;
  /**
   * error is JLabel that the robot says if there are no paths
   */
  JLabel error;
  /**
   * enter is JButton that moves the robot
   */
  JButton enter;
  /**
   * restart is a JButton that restarts the program
   */
  JButton restart;
  /**
   * robotLabel is a JLabel that is that is the visual of the robot
   */
  JLabel robotLabel;

  /**
   * robot is a Robot which is mainly its brain
   */
  Robot robot;
  /**
   * localMap is a LocalMap that gives the options that the robot can move to
   */
  LocalMap localMap;

  /**
   * hashOptions is a hashmap that stores the moves the robot can make
   */
  HashMap<String, Tiles> hashOptions;

  /**
   * file is a String which is the directory to the results file
   */
  String file = "Results.txt";
  /**
   * startBlock is an ImageIcon that holds the image of the start block
   */
  ImageIcon startBlock = new ImageIcon("images/Arrowblock.png");
  /**
   * unknownBlock is an ImageIcon that holds the image of the unknown block
   */
  ImageIcon unknownBlock = new ImageIcon("images/QuestionBlock.png");
  /**
   * endBlock is an ImageIcon that holds the image of the end block
   */
  ImageIcon endBlock = new ImageIcon("images/FinishedBlock.png");
  /**
   * robotImage is an ImageIcon that holds the image of the robot
   */
  ImageIcon robotImage = new ImageIcon("images/RobotBlock.png");
  /**
   * solidBlock is an ImageIcon that holds the image of a solid block
   */
  ImageIcon solidBlock = new ImageIcon("images/checkmark.png");
  /**
   * notSolidBlock is an ImageIcon that holds the image of a not solid block
   */
  ImageIcon notSolidBlock = new ImageIcon("images/Xblock.png");

  // Contructor

  /**
   * <p>
   * Conttructor setsBounds of the different piece of the panel
   * </p>
   * 
   * @param size the dimentions of the grid
   */
  public MapPanel(int size) {
    // set the colour of background to blue
    this.setBackground(Color.blue);
    setLayout(null);

    // initlize size of mapVisual
    mapVisual = new JLabel[size][size];
    // initlize JButton Enter
    enter = new JButton("Enter");
    // initlize JButton restart
    restart = new JButton("Restart");

    // Find the middle to set the button to be in the center everytime
    int middle = (((size * 30) + 20) / 2) - 60;
    // set the enter button to always be in the centered below the tiles
    enter.setBounds(middle, (size * 30) + 20, 120, 50);
    // set the bounds of the restart button
    restart.setBounds(10, 400, 100, 50);
    // add the restart button to the panel
    add(restart);
    // add the enter button to panel
    add(enter);

    // add action listener to restart and enter button
    restart.addActionListener(this);
    enter.addActionListener(this);

    // set this size to size passed through
    this.size = size;
    // create the map that is a two dimentinal array of tiles
    map = new Tiles[size][size];

    // create new robot object
    robot = new Robot("Son");
    // create new JLabel for robot visual
    robotLabel = new JLabel();
    // set the icon of the robot JLabel
    robotLabel.setIcon(robotImage);
    // add the robot visual to the panel
    add(robotLabel);

    // inintlize the size of the robotPositoin array
    robotPosition = new int[2];

    // create new JLabel that says there is no path
    error = new JLabel("There is no path");
    // set the bounds of JLabel
    error.setBounds(10, 370, 200, 30);
    // set the color of the text
    error.setForeground(Color.white);
    // set the font and size of the text
    error.setFont(new Font("Wide Latin", Font.PLAIN, 12));
    // add JLabel to panel
    add(error);
    // set the visiblity to false
    error.setVisible(false);

    // initlize local map
    localMap = new LocalMap(map);

    // call generate map method
    generateMap();

  }

  /**
   * <p>
   * generateMap Method generats the map
   * </p>
   */
  public void generateMap() {
    // create Random object called rand
    Random rand = new Random();

    // loop a two dimentinal array
    for (int i = 0; i < size; i++) {
      for (int k = 0; k < size; k++) {

        // if the block is the starting block
        if (i == 0 && k == 0) {
          // STARTING BLOCK
          // generate start block bounds, image, and specfics
          map[0][0] = new Tiles(0, 0, true, false, true);
          mapVisual[0][0] = new JLabel();
          mapVisual[0][0].setBounds(10, 10, 30, 30);
          mapVisual[0][0].setIcon(startBlock);

          // if the block is the end block
        } else if (i == size - 1 && k == size - 1) {
          // ENDING BLOCK
          // generate end block bounds, image, and specfics
          map[size - 1][size - 1] = new Tiles(size - 1, size - 1, true, false, false);
          mapVisual[size - 1][size - 1] = new JLabel();
          mapVisual[size - 1][size - 1].setBounds(((size - 1) * 30) + 10, ((size - 1) * 30) + 10, 30, 30);
          mapVisual[size - 1][size - 1].setIcon(endBlock);

          // if its any other block
        } else {
          // ANY OTHER BLOCK
          // create the bounds, image, and specifcs of the other blocks
          mapVisual[i][k] = new JLabel();
          mapVisual[i][k].setBounds((i * 30) + 10, (k * 30) + 10, 30, 30);
          mapVisual[i][k].setIcon(unknownBlock);
          // get a random number from 1 to 10
          int randomInt = rand.nextInt(10) + 1;

          // SET IF BLOCK IS SOLID OR NOT
          // if the number is from 4 - 10
          if (randomInt > 3) {
            // make the block solid
            map[i][k] = new Tiles(k, i, true, false, false);
            // if the block is from 1 - 3
          } else if (randomInt <= 3) {
            // make the block not solid
            map[i][k] = new Tiles(k, i, false, false, false);
          } else {
            // NO ELSE
          }
        }
        // ADD THE JLABEL TO THE PANEL
        add(mapVisual[i][k]);
      }
    }
  }

  /**
   * <p>
   * updateMap Method up dates the visuals of the map
   * </p>
   */
  public void updateMap() {

    // if the robot has completed the map
    if (robotPosition[0] == size - 1 && robotPosition[1] == size - 1) {
      // get the amount of moves it took to complete
      String data = "Run Completed in: " + counter-- + " Moves\n";
      // add that to the file
      data += readFiles(file);
      // call write to file method
      writeTextToFile(file, data);

      // call method in main class to display end Panel
      Main.setEndPanelVisible(data);
    }

    try {
      // loop through two dimentinal array
      for (int i = 0; i < size; i++) {
        for (int k = 0; k < size; k++) {
          // if the block should be shown now
          if (map[i][k].getShow() == true) {
            // if the block is solid
            if (map[i][k].getType() == true) {
              // set the icon to solid block
              mapVisual[i][k].setIcon(solidBlock);
              // if the block should be shown, but is not solid
            } else {
              // set the icon to not solid block
              mapVisual[i][k].setIcon(notSolidBlock);
            }
          }
        }
      }
      // always set the visual of the start and end block to its special tile
      mapVisual[0][0].setIcon(startBlock);
      mapVisual[size - 1][size - 1].setIcon(endBlock);
      // set where the robot has moved to
      robotLabel.setBounds((robotPosition[0] * 30) + 10, (robotPosition[1] * 30) + 10, 30, 30);
      // catch index out of bounds exception
    } catch (IndexOutOfBoundsException e) {
      // System.out.println(e);
    }
  }

  /**
   * <p>
   * actionPerformed Method is what happens if the buttons are clicked
   * </p>
   * 
   * @param e
   */
  public void actionPerformed(ActionEvent e) {
    // get which button is clicked
    String button = e.getActionCommand();

    // increase the counter by 1
    counter = counter + 1;

    // if the enter button was clicked
    if (button.equals("Enter")) {
      // if it is the first time it was clicked
      if (counter == 1) {

        // set the robot positon to 0, 0
        robotPosition[0] = 0;
        robotPosition[1] = 0;

        // get the options that robot can move by calling method in local map
        hashOptions = localMap.updateLocalMap(robotPosition, map);
        // update the map
        map = localMap.getMap();
        // set the tile that robot is on to walked on true
        map[robotPosition[0]][robotPosition[1]].setWalkedOn(true);
        // call updateMap method to update visuals
        updateMap();

      }
      // if it is another other time the enter button was pressed
      else {
        // Robot movement
        // get the position the robot is moving to
        robotPosition = robot.moveRobot(hashOptions, map, robotPosition);

        // if it responds with -1, -1, that means that robot has decided there is no
        // path
        if (robotPosition[0] == -1 && robotPosition[1] == -1) {
          // set the error message to visible
          error.setVisible(true);
        } else {

          // get the new postions the robot can move to
          hashOptions = localMap.updateLocalMap(robotPosition, map);
          // update the map
          map = localMap.getMap();
          // set the tile that the robot moved to, to walkedOn true
          map[robotPosition[0]][robotPosition[1]].setWalkedOn(true);
          // update map visuals
          updateMap();
        }
      }
    }
    // if the restart button was clicked
    else if (button.equals("Restart")) {
      // call method in main class to restart the program
      Main.main(null);
    } else {
      // NO ELSE
    }

  }

  /**
   * @param fileName
   * @return String
   */
  public static String readFiles(String fileName) {
    try {
      // initiate buffer reader and read the file thats called fileName
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      // initiate stringbuilder for the contents of the Strings
      StringBuilder fileContents = new StringBuilder();
      // read line
      String line = br.readLine();
      // while the line is not null
      while (line != null) {
        // append the line
        fileContents.append(line);
        fileContents.append(System.lineSeparator());
        // read the line
        line = br.readLine();
      } // end of while loop
      br.close();
      return fileContents.toString();
    } // end of try
    catch (IOException e) {
      // catch input output exception
      return null;
    }
  }

  /**
   * @param fileName
   * @param text
   * @return boolean
   */
  public static boolean writeTextToFile(String fileName, String text) {
    try {
      // initiate print writer
      PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
      // right each line
      pw.print(text);
      pw.close();
      return true;
    } catch (IOException e) {
      // catch input output exception
      return false;
    }
  }

  /**
   * @return int[]
   */
  public int[] getRobotPosition() {
    return robotPosition;
  }

  /**
   * @return Tiles[][]
   */
  public Tiles[][] getMap() {
    return map;
  }

  /**
   * @param map
   */
  public void setMap(Tiles[][] map) {
    this.map = map;
  }

  /**
   * @return String
   */
  public String toString() {
    // return the type of each tile
    String info = "";
    for (int i = 0; i < size; i++) {
      for (int k = 0; k < size; k++) {
        info += map[i][k].getType() + ", ";

      }
    }
    return info;

  }

}