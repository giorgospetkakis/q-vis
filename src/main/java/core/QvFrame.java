package core;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import gfx.QvDisplay;
import org.apache.log4j.Logger;

import javax.swing.JFrame;

/**
 * The graphics display frame.
 * @author giorgos
 *
 */

public class QvFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private static final Logger LOG = Logger.getLogger(QvFrame.class);

  private static QvDisplay display;

  private GLCapabilities glcap;
  private GLCanvas mainCanvas;
  private Animator mainAnimator;

  public QvFrame() {
    initGl();
    initFrame();
  }

  private void initGl() {
    glcap = new GLCapabilities(QvFrameProperties.GLPROFILE);

    glcap.setRedBits(QvFrameProperties.BIT_DEPTH);
    glcap.setGreenBits(QvFrameProperties.BIT_DEPTH);
    glcap.setBlueBits(QvFrameProperties.BIT_DEPTH);
    glcap.setAlphaBits(QvFrameProperties.BIT_DEPTH);

    LOG.info("Initialized OpenGL Capabilities: " + "Bit-Depth " + QvFrameProperties.BIT_DEPTH);
  }

  private void initFrame() {
    this.setTitle(QvFrameProperties.TITLE);
    this.setLocation(QvFrameProperties.LOCATION);
    this.setSize(QvFrameProperties.WIDTH, QvFrameProperties.HEIGHT);

    mainCanvas = new GLCanvas(glcap);

    display = new QvDisplay();
    mainCanvas.addGLEventListener(display);

    mainAnimator = new Animator(mainCanvas);
    this.add(mainCanvas);

    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    this.setResizable(QvFrameProperties.RESIZABLE);
    this.setUndecorated(QvFrameProperties.UNDECORATED);
    this.setVisible(QvFrameProperties.STARTVISIBLE);

    mainAnimator.start();

    LOG.info("Initialized HrdyFrame with" + " title " + QvFrameProperties.TITLE + " and size "
        + QvFrameProperties.WIDTH + ", " + QvFrameProperties.HEIGHT + " at location "
        + QvFrameProperties.LOCATION.toString());
  }
}
