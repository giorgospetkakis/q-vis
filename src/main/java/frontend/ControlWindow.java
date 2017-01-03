package frontend;

import org.apache.log4j.Logger;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The control window for user configuration.
 * 
 * @author giorgospetkakis
 *
 */
public class ControlWindow extends JFrame {
  
  /**
   * The serialUID of the JFrame Object.
   */
  private static final long serialVersionUID = 598060083457503815L;
  private static final Logger LOG;
  
  static {
    LOG = Logger.getLogger(GraphicsWindow.class);
  }
  
  private JPanel contentPane;
  
  /**
   * The constructor for the GraphicsWindow class. Requires specific external properties.
   * 
   * @param gwprop The loaded properties of the GraphicsWindow
   */
  public ControlWindow(Properties gwprop) {
    
    //Set Unconfigurable Properties
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

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
    
    LOG.info("Initialized Control Window");
  }
}
