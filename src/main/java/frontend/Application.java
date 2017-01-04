package frontend;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Application initialization and window properties loading class.
 * 
 * @author giorgospetkakis
 *
 */
public class Application { 
  private static Logger LOG;
  
  static {
    LOG = Logger.getLogger(Application.class);
  }
  
  private static GraphicsWindow graphicsWindow;
  private static ControlWindow controlWindow;
  
  /**
   * The main method (starting point) for QVis.
   * @param args The build arguments.
   */
  public static void main(String[] args) {
    String[] filenames = { args[1], args[2] };
    
    //Configure log4j
    PropertyConfigurator.configure(args[0]);
    
    for (String file : filenames) {
      InputStream input = null;
      Properties properties = new Properties();
      
      try { 
        input = Application.class.getResourceAsStream(file);
        
        if (input == null) {
          LOG.error("Cannot find " + file);
          return;
        }
        
        properties.load(input);
        
        if (file.equals("GraphicsWindow.properties")) {
          setGraphicsWindow(new GraphicsWindow(properties));
          LOG.info("Loaded GraphicsWindow Properties");
          
        } else if (file.equals("ControlWindow.properties")) {
          setControlWindow(new ControlWindow(properties));
          LOG.info("Loaded ControlWindow Properties");
          
        } else {
          LOG.error("Could not recognize properties file " + file);
        }
        
      } catch (IOException exception) {
        LOG.error("Could load input from " + file, exception);
        
      } finally {
        
        if (input != null) {
          try {
            input.close();
            
          } catch (IOException exception) {
            LOG.error("Could not close input stream", exception);
          }
        }
      }
    }
  }

  public static GraphicsWindow getGraphicsWindow() {
    return graphicsWindow;
  }

  public static void setGraphicsWindow(GraphicsWindow graphicsWindow) {
    Application.graphicsWindow = graphicsWindow;
  }

  public static ControlWindow getControlWindow() {
    return controlWindow;
  }

  public static void setControlWindow(ControlWindow controlWindow) {
    Application.controlWindow = controlWindow;
  }
}
