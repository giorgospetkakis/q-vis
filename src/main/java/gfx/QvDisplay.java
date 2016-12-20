package gfx;

import com.jogamp.opengl.DebugGL2;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
/**
 * GLEventListener class that is responsible for drawing to the canvas.
 * @author giorgospetkakis
 *
 */

public class QvDisplay implements GLEventListener {

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
  private final int minX = 0;
  /**
   * Minimum bound of Y dimension.
   */
  private final int minY = 0;
  /**
   * Maximum bound of X dimension.
   */
  private final int maxX = 600;
  /**
   * Maximum bound of Y dimension.
   */
  private final int maxY = 600;
  
  /**
   * Empty constructor to allow instantiation.
   */
  public QvDisplay() {

  }
  
  /**
   * Standard GL display method overriden from GLEventListener.
   */
  @Override
  public void display(GLAutoDrawable drawable) {
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    
    //Noise.display(maxX, maxY, gl);
  }
  
  /**
   * Standard GL dispose method overriden from GLEventListener.
   */
  @Override
  public void dispose(GLAutoDrawable drawable) {

  }

  /**
   * Standard GL init method overriden from GLEventListener.
   */
  @Override
  public void init(GLAutoDrawable drawable) {
    gl = drawable.getGL().getGL2();
    glu = new GLU();

    gl.glClearColor(0, 0, 0, 0);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    glu.gluOrtho2D(minX, maxX, minY, maxY);
    drawable.setGL(new DebugGL2(drawable.getGL().getGL2()));
  }

  /**
   * Standard GL reshape method overriden from GLEventListener.
   */
  @Override
  public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {

  }
}
