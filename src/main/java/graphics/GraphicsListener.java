package graphics;

import com.jogamp.opengl.DebugGL2;
import com.jogamp.opengl.GL;
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
  
  private Frame[] frames;
  
  private int currFrame;
  
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
    
    Color[][] col = new Color[maxX][maxY];
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        col[i][j] = new Color(1, 0, 0.5);
      }
    }
    
    frames = new Frame[] {new Frame(col)};
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
    
    gl.glBegin(GL.GL_POINTS);
    for (int x = minX; x < maxX; x++) {
      for (int y = minY; y < maxY; y++) {
        Color col = frames[currFrame++].pixels[x][y];
        gl.glColor3d(col.red, col.green, col.blue);
        gl.glVertex2i(x, y);
      }
    }
    gl.glEnd();
    
    if (currFrame >= frames.length) {
      currFrame = 0;
    }
  }

  @Override
  public void dispose(GLAutoDrawable arg0) {


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

  }
}
