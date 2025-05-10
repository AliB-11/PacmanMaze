package robotItems;
/** 
* The Tiles class 
*/
public class Tiles {
  // Feilds

  
  /**
   * X is the x coordinate of the tile
   */
  private int X;
  /**
   * Y is the y coordinate of the tile
   */
  private int Y;
  /**
   * type is a boolean for if or if not the block can be walked on
   */
  private boolean type;
  /**
   * show is a boolean for if the tile should be shown
   */
  private boolean show;
  /**
   * walkedOn is a boolean that holds if the robot has walked on this tile
   */
  private boolean walkedOn;
  
  // Contructor

  /**
   * <p> Constructor sets the values of the variables in the paramater </p>
   * @param X
   * @param Y
   * @param type
   * @param show
   * @param walkedOn
   */
  public Tiles(int X, int Y, boolean type, boolean show, boolean walkedOn) {
    // set fields to the vlaues of varaibles passed
    this.X = X;
    this.Y = Y;
    this.type = type;
    this.show = show;
    this.walkedOn = walkedOn;

  }
  // getters and setters

  /**
   * @return
   */
  public int getX() {
    return X;
  }

  
  /** 
   * @param x
   */
  public void setX(int x) {
    X = x;
  }

  
  /** 
   * @return int
   */
  public int getY() {
    return Y;
  }

  
  /** 
   * @param y
   */
  public void setY(int y) {
    Y = y;
  }

  
  /** 
   * @return boolean
   */
  public boolean getType() {
    return type;
  }

  
  /** 
   * @param type
   */
  public void setType(boolean type) {
    this.type = type;
  }

  
  /** 
   * @param show
   */
  public void setShow(boolean show){
    this.show = show;
  }

  
  /** 
   * @return boolean
   */
  public boolean getShow(){
    return show;
  }

  
  /** 
   * @return boolean
   */
  public boolean getWalkedOn(){
    return walkedOn;
  }

  
  /** 
   * @param walkedOn
   */
  public void setWalkedOn(boolean walkedOn){
    this.walkedOn = walkedOn;
  }

  
  /** 
   * @return String
   */
  // Overridden
  public String toString(){
    // create a string that holds the x, y and if the block is solid or not
    String info = "(" + X +", " + Y + ") " + "solid: " + type;
    // return this string
    return info;
  }

}
