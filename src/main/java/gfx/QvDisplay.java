package gfx;

import com.jogamp.opengl.DebugGL2;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class QvDisplay implements GLEventListener{

	private GL2 gl;
	private GLU glu;
	
	private final int MIN_X = 0, MIN_Y = 0, MAX_X = 600, MAX_Y = 600;
	
	public QvDisplay() {
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		Noise.display(MAX_X, MAX_Y, gl);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		glu = new GLU();
		
		gl.glClearColor(0, 0, 0, 0);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		glu.gluOrtho2D(MIN_X, MAX_X, MIN_Y, MAX_Y);
		drawable.setGL(new DebugGL2(drawable.getGL().getGL2()));
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
		
	}
}
