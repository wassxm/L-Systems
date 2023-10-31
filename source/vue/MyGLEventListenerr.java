
package vue;

import java.util.ArrayList;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;


import model.Coordinate;
/*la classe est  utilisée pour afficher et manipuler une scène 3D dans un environnement OpenGL en utilisant la bibliothèque GLU (OpenGL Utility Library). */

public class MyGLEventListenerr implements GLEventListener {
	/**
	 * @param points Liste des coordonnées à afficher dans la fenêtre 3D.
	 * @param glu Objet GLU utilisé pour effectuer des transformations OpenGL.
	 * @param centreX Coordonnée x du centre de la scène 3D.
	 * @param centreY Coordonnée y du centre de la scène 3D.
	 * @param centreZ  Coordonnée z du centre de la scène 3D.
	 * @param angle Angle de rotation de la scène 3D.
	 */

	private ArrayList<Coordinate> points;
	private GLU glu = new GLU();
	double centerX, centerY, centerZ;
	float angle = 0.0f;

	/**
     * Constructeur de la classe MyGLEventListenerr.
     * 
     * @param points Liste des coordonnées à afficher dans la fenêtre 3D.
     */
	public MyGLEventListenerr() {
		points = Fenetre3D.getCoord();

	}

	@Override
	public void init(GLAutoDrawable drawable) {

		final GL2 gl = drawable.getGL().getGL2();
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {

		final GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, 0.0f, -200.0f);
		gl.glRotatef(angle, 0f, 1f, 0f);

		double minX = Double.MAX_VALUE;
		double maxX = Double.MIN_VALUE;
		double minY = Double.MAX_VALUE;
		double maxY = Double.MIN_VALUE;
		double minZ = Double.MAX_VALUE;
		double maxZ = Double.MIN_VALUE;

		for (Coordinate c : points) {
			if (c.getX() < minX) {
				minX = c.getX();
			}
			if (c.getX() > maxX) {
				maxX = c.getX();
			}
			if (c.getY() < minY) {
				minY = c.getY();
			}
			if (c.getY() > maxY) {
				maxY = c.getY();
			}
			if (c.getZ() < minZ) {
				minZ = c.getZ();
			}
			if (c.getZ() > maxZ) {
				maxZ = c.getZ();
			}
		}

		centerX = (maxX + minX) / 2.0;
		centerY = (maxY + minY) / 2.0;
		centerZ = (maxZ + minZ) / 2.0;

		double scaleFactor = 100.0 / Math.max(Math.max(maxX - minX, maxY - minY), maxZ - minZ);

		gl.glTranslatef((float) -centerX, (float) -centerY, (float) -centerZ);
		gl.glScalef((float) scaleFactor, (float) scaleFactor, (float) scaleFactor);

		gl.glColor3f(1f, 2f, 1f);

		gl.glBegin(GL2.GL_LINES);
		for (int i = 0; i < points.size() - 1; i++) {
			gl.glVertex3d(points.get(i).getX(), points.get(i).getY(), points.get(i).getZ());
			gl.glVertex3d(points.get(i + 1).getX(), points.get(i + 1).getY(), points.get(i + 1).getZ());
		}

		gl.glRotatef(angle, 0f, 1f, 0f);

		gl.glEnd();

		angle += 0.1f;
		angle %= 360f;

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		final GL2 gl = drawable.getGL().getGL2();
		if (height <= 0) {
			height = 1;
		}
		final float h = (float) width / (float) height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f, h, 1.0, 1000.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

	}


}