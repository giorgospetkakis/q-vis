package display;

import com.jogamp.opengl.DebugGL2;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

/**
 * The GraphicsListener that connects the GraphicsWindow to its frame loop.
 * @author giorgospetkakis
 *
 */
public class GraphicsListener implements GLEventListener {

  /**
   * Local instance of GL2 to allow calling GL methods.
   */
  private GL2 gl;
  
  /**
   * Local instance of GLU to allow calling GL methods.
   */
  private GLU glu;
  
  /**
   * Minimum bound of X dimension.
   */
  private int minX;
  
  /**
   * Minimum bound of Y dimension.
   */
  private int minY;
  
  /**
   * Maximum bound of X dimension.
   */
  private int maxX;
  
  /**
   * Maximum bound of Y dimension.
   */
  private int maxY;
  
  /**
   * Empty GraphicsListener constructor. All bounds are set to 0 by default.
   */
  public GraphicsListener() {
    
  }
  
  /**
   * GraphicsListener constructor with specified bounds. (Recommended)
   * 
   * @param minX Minimum bound of X dimension.
   * @param minY Minimum bound of Y dimension.
   * @param maxX Maximum bound of X dimension.
   * @param maxY Maximum bound of Y dimension.
   */
  public GraphicsListener(int minX, int minY, int maxX, int maxY) {
    this.minX = minX;
    this.minY = minY;
    this.maxX = maxX;
    this.maxY = maxY;
  }

  /**
   * Set the draw bounds.
   * 
   * @param minX Minimum bound of X dimension.
   * @param minY Minimum bound of Y dimension.
   * @param maxX Maximum bound of X dimension.
   * @param maxY Maximum bound of Y dimension.
   */
  public void setBounds(int minX, int minY, int maxX, int maxY) {
    this.minX = minX;
    this.minY = minY;
    this.maxX = maxX;
    this.maxY = maxY;
  }

  @Override
  public void display(GLAutoDrawable arg0) {
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

  }

  @Override
  public void dispose(GLAutoDrawable arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(GLAutoDrawable drawable) {
    gl = drawable.getGL().getGL2();
    glu = new GLU();

    gl.glClearColor(0, 0, 0, 0);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    glu.gluOrtho2D(minX, maxX, minY, maxY);
    drawable.setGL(new DebugGL2(drawable.getGL().getGL2()));
  }

  @Override
  public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
    // TODO Auto-generated method stub

  }
}
