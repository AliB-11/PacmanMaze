package robotItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * The Robot class
 * <p>
 * This class makes the decison for where the robot should move
 * </p>
 * 
 * @author Ali
 * @version 1.0
 * @since 2023-01-24
 */
public class Robot {
  // Fields

  /**
   * name is a String with the robots name
   */
  private String name;
  /**
   * newPositon is int array that has the row and column postion of the robot
   */
  private int[] newPosition;
  /**
   * previous moves is an arraylist of tiles the robot has moved onto previously
   */
  private ArrayList<Tiles> previousMoves;
  /**
   * localMap is the localMap the robot uses
   */
  private LocalMap localMap;

  // Contructor

  /**
   * <p>
   * This constructor will just initlize the fields
   * </p>
   * 
   * @param name String that has the name of the robot
   */
  public Robot(String name) {
    this.name = name;
    newPosition = new int[2];
    previousMoves = new ArrayList<Tiles>();
  }

  /**
   * <p>
   * moveRobot Method chooses where the robot should move to next
   * </p>
   * 
   * @param hashOptions
   * @param map
   * @param currentPosition
   * @return int[]
   */
  public int[] moveRobot(HashMap<String, Tiles> hashOptions, Tiles[][] map, int[] currentPosition) {
    // create random object
    Random rand = new Random();
    // create HashMap that holds tiles that the robot has not walked on
    HashMap<String, Tiles> nonWalkedTiles = new HashMap<>();

    // if the robot only has 1 option to move to
    if (hashOptions.size() == 1) {
      // get the only key in the hashmap
      String firstKey = hashOptions.keySet().stream().findFirst().get();
      // create a tile that equals the value in the hashmap
      Tiles check = hashOptions.get(firstKey);
      // if the if the only option to move is the start tile
      if (check.getX() == 0 && check.getY() == 0) {
        // move to the start tile
        newPosition[0] = 0;
        newPosition[1] = 0;
        // return that new postion
        return newPosition;
      }
    }

    // if hashOPtions isnt null or empty
    if (hashOptions != null && hashOptions.size() > 0) {
      // check the differnt spaces to move
      for (String key : hashOptions.keySet()) {
        // if the robot hasnt moved on them before, proritze those tiles
        if (hashOptions.get(key).getWalkedOn() == false) {
          // add these values to the nonWalkedTiles hashmap
          nonWalkedTiles.put(key, hashOptions.get(key));
        }
      }

      // if there are tiles that robot has not walked on
      if (nonWalkedTiles != null && nonWalkedTiles.size() > 0) {
        // create arraylistof the keys of the hashmap
        ArrayList<String> keysAsArrays = new ArrayList<String>(nonWalkedTiles.keySet());
        // choose a random tile that has not been walked on
        int randomNum = rand.nextInt(nonWalkedTiles.size());
        // set the new postion to that tile
        newPosition[0] = nonWalkedTiles.get(keysAsArrays.get(randomNum)).getY();
        newPosition[1] = nonWalkedTiles.get(keysAsArrays.get(randomNum)).getX();

        // remember this move by saving it to the previous move arraylist
        previousMoves.add(0, nonWalkedTiles.get(keysAsArrays.get(randomNum)));

        // return the newpostion of the robot
        return newPosition;
      }

      else {
        // IF THERE ARE TILES BUT THEY HAVE ALL BEEN WALKED ON
        boolean end = true;

        // check all the tiles
        for (int i = 0; i < map.length; i++) {
          for (int k = 0; k < map.length; k++) {
            // if there is a tile that has not been walked on and has been shown
            if (map[i][k].getWalkedOn() == false && map[i][k].getType() == true && map[i][k].getShow() == true) {
              // then do not end
              end = false;
            }
          }
        }

        // if end was true
        if (end) {
          // set postion to -1, -1 which outputs the "there are no paths" message
          newPosition[0] = -1;
          newPosition[1] = -1;

          // return the new positon
          return newPosition;
        } else { // if there are still paths to try (Make it go backwards and find them)

          // if the robot is at row 0, column 1
          if (currentPosition[0] == 0 && currentPosition[1] == 1) {
            // if the robot should cross the start tile and try the other path
            if (map[1][0].getWalkedOn() == false) {
              // move to the start tile
              newPosition[0] = 0;
              newPosition[1] = 0;
              // return the new postion
              return newPosition;
            }
            // if the robot is on row 1, column 0
          } else if (currentPosition[0] == 1 && currentPosition[1] == 0) {
            // if thr robot should cross the strat tile and try the other path
            if (map[0][1].getWalkedOn() == false) {
              // move to the start tile
              newPosition[0] = 0;
              newPosition[1] = 0;

              // return new position
              return newPosition;
            }
          }
          try { // CONTINUE IF THERE ARE PATHS TO TRY
            // go backwards and find the paths to try
            // initlize local map
            localMap = new LocalMap(map);
            // create new hashmap called mapPlaceholder
            HashMap<String, Tiles> mapPlaceholder = new HashMap<>();

            // move to the previous tile
            newPosition[0] = previousMoves.get(0).getY();
            newPosition[1] = previousMoves.get(0).getX();

            // check if the preivous tile has a tile that has not been walked on
            mapPlaceholder = localMap.updateLocalMap(newPosition, map);
            boolean remove = true;
            // iterate through the keys of hashmap
            for (String key : mapPlaceholder.keySet()) {
              // if the previous tile has a option where a tile has not been walked on
              if (mapPlaceholder.get(key).getWalkedOn() == false && mapPlaceholder.get(key).getType() == true) {
                // do not forget the previous move
                remove = false;
              }
            }

            // if remove is false
            if (remove) {
              // remove the most recent previous move
              previousMoves.remove(0);

            }
            // catch index out of bounds exception
          } catch (IndexOutOfBoundsException e) {
            // System.out.println(e);
          }

        }
      }
    } else {
      // return -1, -1 if the there is no place to move
      newPosition[0] = -1;
      newPosition[1] = -1;

      // return new position
      return newPosition;
    }
    // return new positon
    return newPosition;
  }

}