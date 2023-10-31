package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
/*La classe Accueil dans le package vue est une fenêtre d'accueil pour une application utilisant des L-Systems. Elle affiche une image de fond et trois boutons permettant
 de sélectionner le type de L-System à utiliser : L-System standard, L-System contextuel et L-System stochastique. */
public class Accueil extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	/**
	 * Classe représentant la fenêtre d'accueil du programme.
	 * Cette fenêtre affiche un menu avec trois boutons pour sélectionner le type de L-System à utiliser.
	 * Elle hérite de la classe JFrame et implémente l'interface ActionListener pour gérer les événements d'action.
	 *
	 * @param bStandart  Le bouton pour sélectionner le L-System standard.
	 * @param bcontextuel Le bouton pour sélectionner le L-System contextuel.
	 * @param bstochastique Le bouton pour sélectionner le L-System stochastique.
	 * @param image      L'image de fond de la fenêtre.
	 * @param layeredPane Le panneau en couches utilisé pour superposer les composants.
	 */
	private JButton bStandart, bcontextuel, bstochastique;
	private JLabel image;
	private JLayeredPane layeredPane;

	/**
	 * Constructeur de la classe Accueil.
	 * Crée une fenêtre d'accueil avec un menu contenant trois boutons pour sélectionner le type de L-System à utiliser.
	 */
	public Accueil() {
		BufferedImage imageFond = null;
		try {
			imageFond = ImageIO.read(getClass().getResource("/acceuil.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		image = new JLabel(new ImageIcon(imageFond));
		image.setBounds(0, 0, imageFond.getWidth(), imageFond.getHeight());

		bStandart = new RoundButton("Lsystem standart");
		bStandart.addActionListener(this);
		bStandart.setBounds(480, 270, 240, 40);

		bcontextuel = new RoundButton("Lsystem Contextuel");
		bcontextuel.addActionListener(this);
		bcontextuel.setBounds(480, 350, 240, 40);

		bstochastique = new RoundButton("Lsystem Stochastique");
		bstochastique.addActionListener(this);
		bstochastique.setBounds(480, 430, 240, 40);

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(imageFond.getWidth(), imageFond.getHeight()));

		layeredPane.add(image, -1);
		layeredPane.add(bStandart, 0);
		layeredPane.add(bcontextuel, 0);
		layeredPane.add(bstochastique, 0);
		
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setTitle("L-System Lindenmeyer");

	}

	/**
	 * Méthode principale du programme.
	 * Crée une instance de la classe Accueil et rend la fenêtre visible.
	 *
	 * @param args Les arguments de ligne de commande (non utilisés dans cette implémentation).
	 */
	public static void main(String[] args) {
		Accueil ac = new Accueil();
		ac.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == bStandart) {
			System.out.println("STANDAR");
			
			FenetreLSystem.stochastique=false;
			FenetreLSystem.contextuel=false;
			FenetreLSystem.lsystemStandart=true;

		} else if (e.getSource() == bcontextuel) {
			System.out.println("CONTEXT");
			FenetreLSystem.stochastique=false;
			FenetreLSystem.contextuel=true;
			FenetreLSystem.lsystemStandart=false;
			
		} else {
			System.out.println("STOKA");
			
			FenetreLSystem.stochastique=true;
			FenetreLSystem.contextuel=false;
			FenetreLSystem.lsystemStandart=false;
		}
		FenetreLSystem f = new FenetreLSystem();
		f.setVisible(true);
	}
}