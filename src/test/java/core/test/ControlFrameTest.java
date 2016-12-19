package core.test;

import static org.junit.Assert.assertEquals;

import core.ControlFrame;
import core.ControlFrameProperties;
import org.junit.Before;
import org.junit.Test;

public class ControlFrameTest {
  
  private ControlFrame frame;
  
  @Before
  public void initFrame() {
    frame = new ControlFrame();
  }
  
  @Test
  public void initFrameTest() {
    assertEquals("Control frame initialization failed ",
        ControlFrameProperties.TITLE, frame.getTitle());
  }
}
