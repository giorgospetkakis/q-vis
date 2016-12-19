package core;

import com.jogamp.opengl.GLProfile;

import java.awt.Point;

/**
 * Initialization properties for the graphics frame.
 * @author giorgos
 *
 */

//TODO Move this to an external file (not hard-coded)
public class QvFrameProperties {

  // General Properties
  public static final String TITLE = "hrdy display";
  public static final int HEIGHT = 600;
  public static final int WIDTH = 600;
  public static final Point LOCATION = new Point(0, 0);

  public static final boolean STARTVISIBLE = false;
  public static final boolean RESIZABLE = false;
  public static final boolean UNDECORATED = true;

  // OpenGL Properties
  public static final GLProfile GLPROFILE = GLProfile.get(GLProfile.GL2);
  public static final int BIT_DEPTH = 8;
}
