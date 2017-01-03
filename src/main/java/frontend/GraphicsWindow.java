package frontend;


import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import display.GraphicsListener;
import org.apache.log4j.Logger;

import java.awt.Point;
import java.util.Properties;

import javax.swing.JFrame;

/**
 * The display window for graphics.
 * 
 * @author giorgospetkakis
 *
 */
public class GraphicsWindow extends JFrame {

  /**
   * The serialUID of the JFrame Object.
   */
  private static final long serialVersionUID = -6894193930216341153L;
  private static final Logger LOG;
  
  static {
    LOG = Logger.getLogger(GraphicsWindow.class);
  }
  
  private GLCapabilities glcap;
  private GraphicsListener display;
  private GLCanvas canvas;
  private Animator anim;
  
  /**
   * The constructor for the GraphicsWindow class. Requires specific external properties.
   * 
   * @param gwprop The loaded properties of the GraphicsWindow
   */
  public GraphicsWindow(Properties gwprop) {
    //Initialize GlCapabilities
    glcap = new GLCapabilities(GLProfile.get(GLProfile.GL2));
    
    //Set Graphics Properties
    glcap.setRedBits(Integer.parseInt(gwprop.getProperty("bit_depth", "8")));
    glcap.setGreenBits(Integer.parseInt(gwprop.getProperty("bit_depth", "8")));
    glcap.setBlueBits(Integer.parseInt(gwprop.getProperty("bit_depth", "8")));
    glcap.setAlphaBits(Integer.parseInt(gwprop.getProperty("bit_depth", "8")));
    
    //Set Window Properties
    this.setTitle(gwprop.getProperty("title", "QVis [Display]"));
    this.setLocation(new Point(
        Integer.parseInt(gwprop.getProperty("locationX", "0")), 
        Integer.parseInt(gwprop.getProperty("locationY", "0"))));
    
    this.setSize(
        Integer.parseInt(gwprop.getProperty("width", "100")),
        Integer.parseInt(gwprop.getProperty("height", "100")));
    
    this.setResizable(Boolean.parseBoolean(gwprop.getProperty("resizable", "false")));
    this.setUndecorated(Boolean.parseBoolean(gwprop.getProperty("undecorated", "true")));
    this.setVisible(Boolean.parseBoolean(gwprop.getProperty("startVisible", "true")));
    
    //Set Non-configurable Properties
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    canvas = new GLCanvas(glcap);
    anim = new Animator(canvas);
    
    display = new GraphicsListener(0, 0, this.getSize().width, this.getSize().height);
    canvas.addGLEventListener(display);
    
    this.add(canvas);
    anim.start();
    
    LOG.info("Initialized Graphics Window");
  }
}