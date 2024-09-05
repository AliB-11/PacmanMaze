package robotItems;
import java.util.HashMap;

/** 
* The LocalMap class 
* <p> This class checks where he robot can move</p>
* @author 
* @version 1.0
* @since 2023-01-24
*/
public class LocalMap {
  // Fields

  /**
  * fullMap is a two dimentinal array of tiles that holds all the tiles of the map
  */
  private Tiles[][] fullMap;

  // Constructor

   /**
   * <p> This constructor set the whole map to fullmap variable </p>
   * @param map two dimentinal array of tiles
   */
  public LocalMap(Tiles[][] map) {
    // set fullmap equal to map
    fullMap = map;
    
  }
  
  /** 
   * <p> Method updateLocalMap goes through the different spots the robot can move to </p>
   * @param robotPosition an array that has the positon of the robot
   * @param map the updated map
   * @return HashMap<String, Tiles> The different spots the robot can move
   */
  // Methods
  public HashMap<String, Tiles> updateLocalMap(int[] robotPosition, Tiles[][] map){

    // set fullmap equal to map
    fullMap = map;
    
    // create hashmap of string keys and tile values called hashoptions
    HashMap<String, Tiles> hashOptions = new HashMap<>();

    // delcare int array that holds the postion of the robot
    int [] robotPositionPlaceHolder = robotPosition.clone();
    

    try {
      // clone the array to start from the deafult
      robotPositionPlaceHolder = robotPosition.clone();
      // moving up is going up on the two dimentonal array so minus 1 to the row
      robotPositionPlaceHolder[0] = robotPositionPlaceHolder[0] -1;
      // get the tile that is at that new postion
      Tiles up = fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]];
      // if the tile can be walked on
      if (up.getType() == true){
      // add the option to the hashmap
      hashOptions.put("Up", up);
      }
      // tell the mapPanel to update the vision of the tile
      fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]].setShow(true);

      // catch index out of bounds (if there is no tile above the robot)
    } catch (IndexOutOfBoundsException e){
        //System.out.println(e);
    }

    try {
      // clone the robotposition array
      robotPositionPlaceHolder = robotPosition.clone();
      // moving right is plus 1 on the columns
      robotPositionPlaceHolder[1] = robotPositionPlaceHolder[1] +1;
      // get the tile at the new position
      Tiles right = fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]];
      // if the tile can be walked on
      if (right.getType() == true){
        // add the tile to the hashmap
        hashOptions.put("Right", right);
        }
        // tell the mapPanel to update the vision of the tile
      fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]].setShow(true);

      // catch index out of bounds (if there is no tile to the right of the robot)
    } catch (IndexOutOfBoundsException e){
        //System.out.println(e);
    }
    
    try {
      // clone the robotPostion array
      robotPositionPlaceHolder = robotPosition.clone();
      // moving down is plus 1 to the row
      robotPositionPlaceHolder[0] = robotPositionPlaceHolder[0] +1;
      // get the tile at the new position
      Tiles down = fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]];
      // if the tile can be walked on
      if (down.getType() == true){
        // add the option to the hashmap
        hashOptions.put("Down", down);
        }
        // tell the mapPanel to update the vision of the tile
      fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]].setShow(true);

      // catch index out of bounds(if there is not tile below the robot)
    } catch (IndexOutOfBoundsException e){
        //System.out.println(e);
    }


    try {
      // clone the robot position
      robotPositionPlaceHolder = robotPosition.clone();
      // moving left is minus 1 on the columns
      robotPositionPlaceHolder[1] = robotPositionPlaceHolder[1] -1;
      // get the tile of the new position
      Tiles left = fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]];
      // if the tile can be walked on
      if (left.getType() == true){
        // add the tile to the hashmap
        hashOptions.put("Left", left);
        }
        // tell mapPanel to update the vision of the tile
      fullMap[robotPositionPlaceHolder[0]][robotPositionPlaceHolder[1]].setShow(true);

      // catch index out of bounds (if there is no tile to the left of the robot)
    } catch (IndexOutOfBoundsException e){
        //System.out.println(e);
    }

    // return the hashoptions
    return hashOptions;

  }

  
  /** 
   * <p> getMap Method return the updated full map </p>
   * @return Tiles[][]
   */
  public Tiles[][] getMap(){
    return fullMap;
  }

  
}