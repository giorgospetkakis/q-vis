package core.test;

import static org.junit.Assert.assertEquals;

import core.QvFrame;
import core.QvFrameProperties;
import org.junit.Test;

public class QvFrameTest {
  private QvFrame testFrame = new QvFrame();

  @Test
  public void initGlTest() {
    assertEquals("Real location does not match properties", QvFrameProperties.LOCATION,
        testFrame.getLocation());
  }
}
