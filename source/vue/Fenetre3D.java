package vue;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import model.Coordinate;
/* la classe Fenetre3D crée une fenêtre graphique en 3D avec une scène animée utilisant OpenGL, et permet d'afficher des coordonnées 3D à partir d'un ArrayList d'objets Coordinate */
public class Fenetre3D extends JFrame {

	private static ArrayList<Coordinate> coord;

	/**
	 * Constructeur de la classe Fenetre3D.
	 *
	 * @param c ArrayList de Coordinate représentant les coordonnées à afficher dans la scène 3D.
	 */
	public Fenetre3D(ArrayList<Coordinate> c) {
		setTitle("LSystem 3D");
		setSize(1100, 800);
		setLocationRelativeTo(this);

		coord = c;
		GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault());
		GLCanvas glCanvas = new GLCanvas(glCapabilities);

		MyGLEventListenerr glListener = new MyGLEventListenerr();
		glCanvas.addGLEventListener(glListener);

		add(glCanvas);

		final FPSAnimator animator = new FPSAnimator(glCanvas, 60);

		addWindowListener(new WindowListener() {

			public void windowClosing(WindowEvent e) {
				animator.stop();
				dispose();
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				

			}

			@Override
			public void windowClosed(WindowEvent arg0) {

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				

			}

		});

		animator.start();
	}
	
	/**
	 * Méthode permettant d'obtenir la liste de coordonnées utilisée dans la scène 3D.
	 *
	 * @return ArrayList de Coordinate représentant les coordonnées utilisées dans la scène 3D.
	 */
	public static ArrayList<Coordinate> getCoord() {
		return coord;
	}

	private static final long serialVersionUID = -1227038124975588633L;
}