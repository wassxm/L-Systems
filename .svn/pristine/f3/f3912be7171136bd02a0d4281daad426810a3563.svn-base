package vue;

import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.invoke.StringConcatException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.*;

/*La classe "Panneau" est une classe Java utilisée pour représenter un panneau de dessin pour un système de L-système */
public class Panneau extends JPanel {
	/**
	 * @param doitDessiner un boolean qui indique si le panneau doit effectuer le dessin ou non.
	 * @param dessinerFichier un boolean qui indique si le dessin doit être sauvegardé dans un fichier ou non.
	 * @param tailleSegmant un entier représentant la taille des segments du dessin.
	 * @param angle un entier représentant l'angle de rotation du L-systeme.
	 * @param nbIteration un entier représentant le nombre d'itérations du L-systeme.
	 * @param axiome une chaîne de caractères représentant l'axiome du L-systeme.
	 * @param listAlphabet un ensemble de chaînes de caractères représentant l'alphabet du L-systeme.
	 * @param ruleStoch une map associant des caractères à des tableaux de chaînes de caractères représentant les règles stochastiques du L-systeme.
	 * @param ruleContext une map associant des chaînes de caractères à des tableaux de chaînes de caractères représentant les règles contextuelles du L-systeme.
	 * @param rule un objet de la classe Rules représentant les règles du L-systeme.
	 * @param couleur un objet de la classe Color représentant la couleur du dessin.
	 * @param resultas une liste d'objets de la classe Coordinate représentant les coordonnées du dessin.
	 */
	private boolean doitDessiner = false, dessinerFichier = false, dessinerAnimation = false;
	
	private int tailleSegmant = 0, angle = 0, nbIteration = 0;
	private String axiome = " ";
	private Set<String> listAlphabet;
	private Map<Character, String[]> ruleStoch;
	private Map<String, String[]> ruleContext;
	private Rules rule;
	private Color couleur;
	private ArrayList<Coordinate> resultas;
	private int currentLineIndex = 0;
	
	//Créez un objet Timer avec une période de rafraîchissement de 200 ms
		private Timer timer = new Timer(1000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //Incrémentez l'index de ligne actuel
		        currentLineIndex++;
		        System.out.println("ci : "+currentLineIndex+" rs :"+resultas.size()+" nbi : "+nbIteration);
		        //Redessinez la zone de dessin
		        repaint();
		        //Vérifiez si toutes les lignes ont été dessinées
		        if (currentLineIndex > nbIteration ) {
		            //Arrêtez le timer
		        	System.out.println("Je STOP");
		        	setDoitDessiner(false);
		            timer.stop();
		            
		        }
		        if(currentLineIndex ==0) {
		        	timer.start();
		        }
		    }
		});

	public Panneau() {

		setVisible(true);
		setPreferredSize(new Dimension(1300, 800));
		setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 40));
		setBackground(Color.DARK_GRAY);

		listAlphabet = new HashSet<>();
		for (char c = 'A'; c <= 'Z'; c++) {
			listAlphabet.add(String.valueOf(c));
		}

		resultas = new ArrayList<Coordinate>();

	}

	 /**
     * Définit si le panneau doit effectuer le dessin ou non.
     * 
     * @param doitDessiner boolean pour indiquer si le panneau doit effectuer le dessin
     */
	public void setDoitDessiner(boolean doitDessiner) {
		this.doitDessiner = doitDessiner;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(!dessinerAnimation) {
			if (doitDessiner) {
				Alphabet alphabet = new Alphabet(this.listAlphabet);
				AbstractLsystem l = null;
				if (FenetreLSystem.lsystemStandart) {
					l = new LSystem(alphabet, this.rule, this.axiome, this.nbIteration, this.tailleSegmant, this.angle);
				} else if (FenetreLSystem.contextuel) {
					l = new LSystemContextuel(alphabet, this.ruleContext, this.axiome, this.nbIteration, this.tailleSegmant,
							this.angle);
				} else {
					l = new LSystemStochastiques(alphabet, this.ruleStoch, this.axiome, this.nbIteration, this.tailleSegmant,
							this.angle);
				}
	
				Interpretation inter = new Interpretation();
				if (this.dessinerFichier == false) {
					resultas = inter.calculateCoordinates(l);
				}
				
				for (int i = 0; i < this.resultas.size() - 1; i++) {
					g.setColor(this.couleur);
					g.drawLine((int) this.resultas.get(i).getX(), (int) resultas.get(i).getY(),
							(int) resultas.get(i + 1).getX(), (int) this.resultas.get(i + 1).getY());
				}
			}
		}
		else {
			//Dans la méthode paintComponent, remplacez la boucle de dessin actuelle par :
			if (doitDessiner) {
			    Alphabet a = new Alphabet(this.listAlphabet);
			    LSystem l = new LSystem(a, this.rule, this.axiome, this.nbIteration, this.tailleSegmant, this.angle);
			    Interpretation inter = new Interpretation();
			    //Calculez les coordonnées pour la première itération
			    resultas = inter.calculateCoordinatesWithIndex(l, currentLineIndex);
			    //Démarrez le timer
			    timer.start();
			}

			//Dans la méthode paintComponent, remplacez la boucle de dessin actuelle par :
			if (resultas != null) {
			    //Dessinez toutes les lignes jusqu'à l'index de ligne actuel
			    for (int i = 0; i < resultas.size()-1; i++) {
			        g.setColor(this.couleur);
			        g.drawLine((int) resultas.get(i).getX(), (int) resultas.get(i).getY(), (int) resultas.get(i + 1).getX(),
			                (int) resultas.get(i + 1).getY());
			    }
			}
		}
	}
	/**
     * Définit la taille des segments du dessin.
     * 
     * @param tailleSegmant la taille des segments du dessin
     */
	public void setTailleSegmant(int tailleSegmant) {
		this.tailleSegmant = tailleSegmant;
	}
	
	public void contientEntiers(String chaine) throws StringConcatException {
        
        if (chaine.isEmpty()) {
        	throw new StringConcatException("Le mot est vide");
		}
		for (int i = 0; i < chaine.length(); i++) {
            char c = chaine.charAt(i);
            
            if (Character.isDigit(c)) {
            	throw new StringConcatException("Mot contient des chiffres"); 
            }
        }
        //return false;
    }

	/**
     * Définit l'axiome du L-systeme.
     * 
     * @param axiome l'axiome du L-systeme
     */
	public void setAxiome(String axiome) {
		this.axiome = axiome;
	}

	/**
     * Définit l'angle de rotation du L-systeme.
     * 
     * @param angle l'angle de rotation du L-systeme
     */
	public void setAngle(int angle) {
		this.angle = angle;
	}
	/**
     * Définit les règles du L-systeme.
     * 
     * @param rs les règles du L-systeme
     */
	public void setRs(Rules rs) {
		this.rule = rs;
	}
	/**
     * Définit les règles contextuelles du L-systeme.
     * 
     * @param rs les règles contextuelles du L-systeme
     */
	public void setRuleContext(Map<String, String[]> rs) {
		this.ruleContext = rs;
	}
	/**
     * Définit les règles stochastiques du L-systeme.
     * 
     * @param ruleStoch les règles stochastiques du L-systeme
     */
	public void setRuleStoch(Map<Character, String[]> ruleStoch) {
		this.ruleStoch = ruleStoch;
	}
	/**
     * Définit le nombre d'itérations du L-systeme.
     * 
     * @param nbIteration le nombre d'itérations du L-systeme
     */
	public void setNbIteration(int nbIteration) {
		this.nbIteration = nbIteration;
	}

	public int getAngle() {
		return this.angle;
	}

	public int getTailleSegmant() {
		return this.tailleSegmant;
	}
	/**
     * Définit la couleur du dessin.
     * 
     * @param clr la couleur du dessin
     */
	public void setClr(Color clr) {
		this.couleur = clr;
	}

	public void setResultas(ArrayList<Coordinate> resultas) {
		this.resultas = resultas;
	}

	public ArrayList<Coordinate> getResultas() {
		return resultas;
	}

    /**
     * Définit si le dessin doit être sauvegardé dans un fichier ou non.
     * 
     * @param dessinerFichier boolean pour indiquer si le dessin doit être sauvegardé dans un fichier
     */
	public void setDessinerFichier(boolean dessinerFichier) {
		this.dessinerFichier = dessinerFichier;
	}
	public void setCurrentIndex(int cui) {
		this.currentLineIndex=cui;
	}
	public boolean isDessinerAnimation() {
		return dessinerAnimation;
	}

	public void setDessinerAnimation(boolean dessinerAnimation) {
		this.dessinerAnimation = dessinerAnimation;
	}
}