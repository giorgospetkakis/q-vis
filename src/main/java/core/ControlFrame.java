package core;

import org.apache.log4j.Logger;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The user control frame.
 * @author giorgospetkakis
 *
 */

public class ControlFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private static final Logger LOG = Logger.getLogger(QvFrame.class);

  private JPanel contentPane;

  public ControlFrame() {
    initFrame();
  }

  private void initFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setTitle(ControlFrameProperties.TITLE);
    this.setLocation(ControlFrameProperties.LOCATION);
    this.setSize(ControlFrameProperties.WIDTH, ControlFrameProperties.HEIGHT);

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    initComponents();

    this.setVisible(ControlFrameProperties.STARTVISIBLE);

    LOG.info("Initialized ControlFrame with" + " title " + ControlFrameProperties.TITLE
        + " and size " + ControlFrameProperties.WIDTH + ", " + ControlFrameProperties.HEIGHT
        + " at location " + ControlFrameProperties.LOCATION.toString());
  }

  private void initComponents() {
    JButton test = new JButton("Display Frame");
    test.setName("displayframebutton");
    test.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Run.displayFrame.setVisible(!Run.displayFrame.isVisible());
      }
    });
    contentPane.add(test, BorderLayout.SOUTH);

    //List all components in log.
    String logString = "";
    for (Component c : contentPane.getComponents()) {
      logString = logString + c.getName() + " ";
    }

    LOG.info("Initialized " + contentPane.getComponentCount() + " ControlFrame components: "
        + logString);
  }
}
