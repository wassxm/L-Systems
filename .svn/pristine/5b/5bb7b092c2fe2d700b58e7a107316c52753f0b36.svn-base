package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
/*Classe RoundButton qui représente un bouton rond personnalisé héritant de JButton.
 */

public class RoundButton extends JButton {
	/**
	 * @param text Le texte à afficher sur le bouton
	 * @param backgroundColor La couleur de fond du bouton
	 * @param foregroundColor La couleur du contour du bouton
	 * @param largeurArc La largeur de l'arc des coins du bouton
	 * @param hauteurArc La hauteur de l'arc des coins du bouton
	 */
	private static final long serialVersionUID = 1L;
	
	private Color backgroundColor = Color.white;
	private Color foregroundColor = Color.darkGray;
	private int largeurArc = 20;
	private int hauteurArc = 20;

	/**
	 * Constructeur de la classe RoundButton.
	 *
	 * @param text Le texte à afficher sur le bouton
	 */
	public RoundButton(String text) {
		super(text);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setPreferredSize(new Dimension(250, 25));
		setFont(new Font("Tahoma", 1, 16));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), largeurArc, hauteurArc);
		g2.setColor(backgroundColor);
		g2.fill(shape);
		
		super.paintComponent(g2);
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Shape shape = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, largeurArc, hauteurArc);
		g2.setColor(foregroundColor);
		g2.draw(shape);
	}
	

	/**
	 * Méthode pour définir la couleur de fond du bouton.
	 *
	 * @param backgroundColor La couleur de fond à définir
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		repaint();
	}
	/**
	 * Méthode pour définir la couleur du contour du bouton.
	 *
	 * @param foregroundColor La couleur du contour à définir
	 */
	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
		repaint();
	}
	/**
	 * Méthode pour définir la largeur de l'arc des coins du bouton.
	 *
	 * @param arcWidth La largeur de l'arc des coins à définir
	 */
	public void setArcWidth(int arcWidth) {
		this.largeurArc = arcWidth;
		repaint();
	}
	/**
	 * Méthode pour définir la hauteur de l'arc des coins du bouton.
	 *
	 * @param arcHeight La hauteur de l'arc des coins à définir
	 */
	public void setArcHeight(int arcHeight) {
		this.hauteurArc = arcHeight;
		repaint();
	}
}