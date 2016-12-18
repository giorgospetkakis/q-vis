package core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.QvFrameProperties;
import core.QvFrame;

public class HrdyFrameTest {
	private QvFrame testFrame = new QvFrame();
	
	@Test
	public void initGLTest(){
		assertEquals("Real location does not match properties", QvFrameProperties.LOCATION, testFrame.getLocation());
	}
}
