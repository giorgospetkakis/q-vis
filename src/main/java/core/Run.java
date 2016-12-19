package core;

/**
 * Holds the main method and initializes the needed windows.
 * 
 * @author giorgospetkakis
 *
 */

public class Run {

  /**
   * The graphics display frame.
   */
  protected static QvFrame displayFrame;
  /**
   * The user control frame.
   */
  protected static ControlFrame controlFrame;

  /**
   * The QVis main method.
   */
  public static void main(String[] args) {
    displayFrame = new QvFrame();
    controlFrame = new ControlFrame();
  }
}
