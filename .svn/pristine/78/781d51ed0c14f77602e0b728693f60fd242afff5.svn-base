package vue;


import model.Alphabet;
import model.Coordinate;
import model.Interpretation;
import model.LSystem;
import model.Rules;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;





public class FenetreLSystem extends JFrame implements ChangeListener {
	/**
	 * @param PanneauManipulation JPanel pour la manipulation de l'interface
	 */
	private JPanel PanneauManipulation;
	/**
	 * @param axiome JTextField pour l'axiome LSystem
	 * @param symboleField1, symboleField2, symboleField3 JTextField pour les symboles LSystem
	 * @param productionField1, productionField2, productionField3 JTextField pour les productions LSystem
	 * @param iteration JTextField pour le nombre d'itérations LSystem
	 */

	private JTextField axiome, symboleField1, productionField1, symboleField2, productionField2, symboleField3, productionField3, iteration;
	/**
	 * @param laxiom, symboleLabel1, symboleLabel2, symboleLabel3, productionLabel1, productionLabel2, productionLabel3, ltailleSegmant, langle, lstruct, lslide,
	 * valeurAngle, valeurtaille, literation, lvitesse JLabel pour les éléments de l'interface
	 */
	private JLabel laxiom, symboleLabel1, productionLabel1, symboleLabel2, productionLabel2, symboleLabel3, productionLabel3, ltailleSegmant, langle, lstruct, lslide,
			valeurAngle, valeurtaille, literation, lvitesse;

	/**
	 * @param dessiner2D, dessiner3D, effacer JButton pour les actions de dessin et d'effacement
	 */
	private JButton dessiner2D, dessiner3D, effacer,dessinerAnimation;
	
	/**
	 * @param Jangle, Jtaille, Jvitesse JSlider pour la sélection de l'angle, la taille et la vitesse
	 */
	private JSlider Jangle, Jtaille, Jvitesse;
	/**
	 * @param structure JComboBox pour la sélection de la structure LSystem
	 */
	private JComboBox<String> structure;
	/**
	 * @param angle Variable pour stocker l'angle de rotation du dessin
	 */
	private static int angle;
	/**
	 * @param taille Variable pour stocker la taille du segment de dessin
	 */
	private static int taille;
	/**
	 * @param lsystemStandart, contextuel, stochastique Variables booléennes pour les différents types de LSystem
	 */
	public static boolean lsystemStandart = false, contextuel = false, stochastique = false;

	public FenetreLSystem() {
		setTitle("LSystem");
		setLayout(new BorderLayout());

		final Panneau panneauPrincipale = new Panneau();
		this.add(panneauPrincipale);
		PanneauManipulation = new JPanel();
		PanneauManipulation.setLayout(new FlowLayout());
		PanneauManipulation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Settings"));
		PanneauManipulation.setPreferredSize(new Dimension(350, 550));
		PanneauManipulation.setOpaque(true);
		panneauPrincipale.add(PanneauManipulation);

		laxiom = new JLabel("axiom");
		laxiom.setFont(new Font("Tahoma", 1, 16));
		laxiom.setPreferredSize(new Dimension(60, 30));
		PanneauManipulation.add(laxiom);

		axiome = new JTextField();
		axiome.setPreferredSize(new Dimension(230, 30));
		axiome.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(axiome);

		literation = new JLabel("Nombre d'iteration");
		literation.setPreferredSize(new Dimension(180, 30));
		literation.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(literation);

		iteration = new JTextField();
		iteration.setPreferredSize(new Dimension(120, 30));
		iteration.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(iteration);

		symboleLabel1 = new JLabel("regle 1");
		symboleLabel1.setFont(new Font("Tahoma", 1, 16));
		symboleLabel1.setPreferredSize(new Dimension(80, 30));
		PanneauManipulation.add(symboleLabel1);

		symboleField1 = new JTextField();
		symboleField1.setPreferredSize(new Dimension(50, 30));
		symboleField1.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(symboleField1);

		productionLabel1 = new JLabel(" ---->");
		productionLabel1.setFont(new Font("Tahoma", 1, 16));
		productionLabel1.setPreferredSize(new Dimension(60, 20));
		PanneauManipulation.add(productionLabel1);

		productionField1 = new JTextField();
		productionField1.setPreferredSize(new Dimension(100, 30));
		productionField1.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(productionField1);

		symboleLabel2 = new JLabel("regle 2");
		symboleLabel2.setFont(new Font("Tahoma", 1, 16));
		symboleLabel2.setPreferredSize(new Dimension(80, 30));
		PanneauManipulation.add(symboleLabel2);

		symboleField2 = new JTextField();
		symboleField2.setPreferredSize(new Dimension(50, 30));
		symboleField2.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(symboleField2);

		productionLabel2 = new JLabel(" ---->");
		productionLabel2.setFont(new Font("Tahoma", 1, 16));
		productionLabel2.setPreferredSize(new Dimension(60, 20));
		PanneauManipulation.add(productionLabel2);

		productionField2 = new JTextField();
		productionField2.setPreferredSize(new Dimension(100, 30));
		productionField2.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(productionField2);

		symboleLabel3 = new JLabel("regle 3");
		symboleLabel3.setFont(new Font("Tahoma", 1, 16));
		symboleLabel3.setPreferredSize(new Dimension(80, 30));
		PanneauManipulation.add(symboleLabel3);

		symboleField3 = new JTextField();
		symboleField3.setPreferredSize(new Dimension(50, 30));
		symboleField3.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(symboleField3);

		productionLabel3 = new JLabel(" ---->");
		productionLabel3.setFont(new Font("Tahoma", 1, 16));
		productionLabel3.setPreferredSize(new Dimension(60, 40));
		PanneauManipulation.add(productionLabel3);

		productionField3 = new JTextField();
		productionField3.setPreferredSize(new Dimension(100, 30));
		productionField3.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(productionField3);

		ltailleSegmant = new JLabel("taille segmant");
		ltailleSegmant.setFont(new Font("Tahoma", 1, 16));
		ltailleSegmant.setPreferredSize(new Dimension(150, 40));
		PanneauManipulation.add(ltailleSegmant);

		valeurtaille = new JLabel("");
		valeurtaille.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(valeurtaille);

		Jtaille = new JSlider(JSlider.HORIZONTAL, 0, 80, panneauPrincipale.getTailleSegmant());
		Jtaille.setMajorTickSpacing(10);
		Jtaille.setMinorTickSpacing(1);

		Jtaille.setPreferredSize(new Dimension(280, 16));
		Jtaille.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				valeurtaille.setText(Integer.toString(Jtaille.getValue()));
				FenetreLSystem.taille = Jtaille.getValue();

			}

			
		});
		PanneauManipulation.add(Jtaille);

		langle = new JLabel("angle");
		langle.setPreferredSize(new Dimension(60, 30));
		langle.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(langle);

		valeurAngle = new JLabel("");
		valeurAngle.setFont(new Font("Tahoma", 1, 16));
		PanneauManipulation.add(valeurAngle);

		Jangle = new JSlider(JSlider.HORIZONTAL, 0, 360, panneauPrincipale.getAngle());
		Jangle.setMajorTickSpacing(50);
		Jangle.setMinorTickSpacing(1);

		Jangle.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				valeurAngle.setText(Integer.toString(Jangle.getValue()));
				FenetreLSystem.angle = Jangle.getValue();

			}
		});

		
		Jangle.setPreferredSize(new Dimension(280, 16));
		PanneauManipulation.add(Jangle);

		lstruct = new JLabel("structure");
		lstruct.setFont(new Font("Tahoma", 1, 16));
		lstruct.setPreferredSize(new Dimension(140, 40));
		PanneauManipulation.add(lstruct);

		structure = new JComboBox<>();
		structure.addItem("Flocon de koch");
		structure.addItem("Dragon");
		structure.addItem("Arbre");
		structure.addItem("ArbreComplex");
		structure.setPreferredSize(new Dimension(280, 30));
		structure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) structure.getSelectedItem();
				panneauPrincipale.setDessinerFichier(false);
				
				switch (item) {

				case "Flocon de koch": {
					ArrayList<Coordinate> arbre = new ArrayList<Coordinate>();

					try {
						File file = new File("source/Flocon_de_koch.txt");
						Scanner scanner = new Scanner(file);

						while (scanner.hasNextLine()) {

							String line = scanner.nextLine();
							String[] parts = line.split(" ");
							double x = Double.parseDouble(parts[0]);
							double y = Double.parseDouble(parts[1]);
							Coordinate point = new Coordinate(x, y, 0);
							arbre.add(point);

						}

						scanner.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					panneauPrincipale.setDoitDessiner(true);
					panneauPrincipale.setDessinerFichier(true);
					panneauPrincipale.setClr(Color.YELLOW);
					panneauPrincipale.setResultas(arbre);
					
					repaint();
					break;

				}

				case "Arbre": {
					ArrayList<Coordinate> arbre = new ArrayList<Coordinate>();

					try {
						File file = new File("source/arbreSimple.txt");
						Scanner scanner = new Scanner(file);

						while (scanner.hasNextLine()) {

							String line = scanner.nextLine();
							String[] parts = line.split(" ");
							double x = Double.parseDouble(parts[0]);
							double y = Double.parseDouble(parts[1]);
							Coordinate point = new Coordinate(x, y, 0);
							arbre.add(point);

						}

						scanner.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					panneauPrincipale.setDoitDessiner(true);
					panneauPrincipale.setDessinerFichier(true);
					panneauPrincipale.setClr(Color.YELLOW);
					panneauPrincipale.setResultas(arbre);
					
					repaint();
					break;
				}

				case "ArbreComplex": {

					ArrayList<Coordinate> arbre = new ArrayList<Coordinate>();

					try {
						File file = new File("source/arbre.txt");
						Scanner scanner = new Scanner(file);

						while (scanner.hasNextLine()) {

							String line = scanner.nextLine();
							String[] parts = line.split(" ");
							double x = Double.parseDouble(parts[0]);
							double y = Double.parseDouble(parts[1]);
							Coordinate point = new Coordinate(x, y, 0);
							arbre.add(point);

						}

						scanner.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					panneauPrincipale.setDoitDessiner(true);
					panneauPrincipale.setDessinerFichier(true);
					panneauPrincipale.setClr(Color.YELLOW);
					panneauPrincipale.setResultas(arbre);
					
					repaint();

					break;
				}

				case "Dragon": {
					ArrayList<Coordinate> arbre = new ArrayList<Coordinate>();

					try {
						File file = new File("source/Dragon.txt");
						Scanner scanner = new Scanner(file);

						while (scanner.hasNextLine()) {

							String line = scanner.nextLine();
							String[] parts = line.split(" ");
							double x = Double.parseDouble(parts[0]);
							double y = Double.parseDouble(parts[1]);
							Coordinate point = new Coordinate(x, y, 0);
							arbre.add(point);

						}

						scanner.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					panneauPrincipale.setDoitDessiner(true);
					panneauPrincipale.setDessinerFichier(true);
					panneauPrincipale.setClr(Color.YELLOW);
					panneauPrincipale.setResultas(arbre);
					
					repaint();
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + item);
				}

			}
		});
		PanneauManipulation.add(structure);

		dessiner2D = new JButton("Draw 2D");
		dessiner2D.setPreferredSize(new Dimension(120, 30));
		dessiner2D.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Map<Character, String> rule;
				Map<String, String[]> ruleContex;
				Map<Character, String[]> ruleStoch;
				panneauPrincipale.setDoitDessiner(true);
				panneauPrincipale.setDessinerFichier(false);
				panneauPrincipale.setTailleSegmant(FenetreLSystem.taille);
				panneauPrincipale.setClr(Color.YELLOW);
				
				try {
					panneauPrincipale.contientEntiers(axiome.getText());
					panneauPrincipale.setAxiome(axiome.getText());
				} catch (Exception e2) {
					axiome.setText("Erreur");
				}

				panneauPrincipale.setAngle(FenetreLSystem.angle);

				if (FenetreLSystem.lsystemStandart) {
					rule = new HashMap<>();
					Rules rs = new Rules(rule);
					try {
						panneauPrincipale.contientEntiers(symboleField1.getText());
						panneauPrincipale.contientEntiers(productionField1.getText());
						rs.addElement(symboleField1.getText().charAt(0), productionField1.getText());
					} catch (Exception e2) {
						symboleField1.setText("Erreur");
						productionField1.setText("Erreur");
					}

					try {
						panneauPrincipale.contientEntiers(symboleField2.getText());
						panneauPrincipale.contientEntiers(productionField2.getText());
						rs.addElement(symboleField2.getText().charAt(0), productionField2.getText());
					} catch (Exception e2) {
						symboleField2.setText("");
						productionField2.setText("");
					}

					try {
						panneauPrincipale.contientEntiers(symboleField3.getText());
						panneauPrincipale.contientEntiers(productionField3.getText());
						rs.addElement(symboleField3.getText().charAt(0), productionField3.getText());
					} catch (Exception e2) {
						symboleField3.setText("");
						productionField3.setText("");
					}
					panneauPrincipale.setRs(rs);

				} else if (FenetreLSystem.contextuel) {
					ruleContex = new HashMap<>();
					String[] chaine = new String[3];
					try {
						panneauPrincipale.contientEntiers(symboleField1.getText());
						panneauPrincipale.contientEntiers(productionField1.getText());
						chaine[0] = productionField1.getText();
					} catch (Exception e2) {
						symboleField1.setText("Erreur");
						productionField1.setText("Erreur");
					}

					try {
						panneauPrincipale.contientEntiers(symboleField2.getText());
						panneauPrincipale.contientEntiers(productionField2.getText());
						chaine[1] = productionField2.getText();
					} catch (Exception e2) {
						symboleField2.setText("");
						productionField2.setText("");
					}

					try {
						panneauPrincipale.contientEntiers(symboleField3.getText());
						panneauPrincipale.contientEntiers(productionField3.getText());
						chaine[2] = productionField3.getText();
					} catch (Exception e2) {
						symboleField3.setText("");
						productionField3.setText("");
					}
					ruleContex.put(symboleField1.getText(), chaine);
					panneauPrincipale.setRuleContext(ruleContex);

				} else {
					ruleStoch = new HashMap<>();
					String[] chaine = new String[15];
					try {
						panneauPrincipale.contientEntiers(symboleField1.getText());
						panneauPrincipale.contientEntiers(productionField1.getText());
						for (int i = 0; i < 8; i++) {
							chaine[i] = productionField1.getText();
						}
					} catch (Exception e2) {
						symboleField1.setText("Erreur");
						productionField1.setText("Erreur");
					}

					try {
						panneauPrincipale.contientEntiers(symboleField2.getText());
						panneauPrincipale.contientEntiers(productionField2.getText());
						for (int i = 8; i < 13; i++) {
							chaine[i] = productionField2.getText();
						}
					} catch (Exception e2) {
						symboleField2.setText("");
						productionField2.setText("");
					}

					try {
						panneauPrincipale.contientEntiers(symboleField3.getText());
						panneauPrincipale.contientEntiers(productionField3.getText());
						for (int i = 13; i < 15; i++) {
							chaine[i] = productionField3.getText();
						}
					} catch (Exception e2) {
						symboleField3.setText("");
						productionField3.setText("");
					}
					ruleStoch.put(symboleField1.getText().charAt(0), chaine);
					panneauPrincipale.setRuleStoch(ruleStoch);
				}

				try {
					panneauPrincipale.setNbIteration(Integer.parseInt(iteration.getText()));
				} catch (Exception e2) {
					iteration.setText("Erreur");

				}

				Interpretation.setBeginHeight(200);
				Interpretation.setBeginWidth(300);
				repaint();

			}
		});
		PanneauManipulation.add(dessiner2D);

		dessiner3D = new JButton("Draw 3D");
		dessiner3D.setPreferredSize(new Dimension(120, 30));
		dessiner3D.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Coordinate> points = new ArrayList<>();
				Set<String> al = new HashSet<>();
				for (char c = 'A'; c <= 'Z'; c++) {
					al.add(String.valueOf(c));
				}

				Alphabet a = new Alphabet(al);

				Map<Character, String> rule = new HashMap<>();
				Rules rs = new Rules(rule);
				if (symboleField1.getText().equals("") == false && productionField1.getText().equals("") == false) {
					rs.addElement(symboleField1.getText().charAt(0), productionField1.getText());

				}
				if (symboleField2.getText().equals("") == false && productionField2.getText().equals("") == false) {
					rs.addElement(symboleField2.getText().charAt(0), productionField2.getText());
				}
				if (symboleField3.getText().equals("") == false && productionField3.getText().equals("") == false) {
					rs.addElement(symboleField3.getText().charAt(0), productionField3.getText());
				}

				LSystem l = new LSystem(a, rs, axiome.getText(), Integer.parseInt(iteration.getText()),
						FenetreLSystem.taille, FenetreLSystem.angle);

				Interpretation.setBeginX(0);
				Interpretation.setBeginY(-50);
				Interpretation.setBeginZ(0);
				Interpretation inter = new Interpretation();
				points = new ArrayList<>();
				points = inter.calculateCoordinates3D(l);
				new Fenetre3D(points).setVisible(true);
			}
		});

		PanneauManipulation.add(dessiner3D);
		if(this.lsystemStandart) {	
		dessinerAnimation = new JButton("Draw with animation");
		dessinerAnimation.setPreferredSize(new Dimension(220, 30));
		dessinerAnimation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panneauPrincipale.setDessinerAnimation(true);
				Map<Character, String> rule;
				Map<String, String[]> ruleContex;
				Map<Character, String[]> ruleStoch;
				panneauPrincipale.setDoitDessiner(true);
				panneauPrincipale.setTailleSegmant(FenetreLSystem.taille);
				panneauPrincipale.setClr(Color.YELLOW);
				try {
					panneauPrincipale.setAxiome(axiome.getText());
				} catch (Exception e2) {
					axiome.setText("Error ");
				}

				panneauPrincipale.setAngle(FenetreLSystem.angle);

				if (FenetreLSystem.lsystemStandart) {
					rule = new HashMap<>();
					Rules rs = new Rules(rule);
					if (symboleField1.getText().equals("") == false && productionField1.getText().equals("") == false) {
						rs.addElement(symboleField1.getText().charAt(0), productionField1.getText());
					}
					if (symboleField2.getText().equals("") == false && productionField2.getText().equals("") == false) {
						rs.addElement(symboleField2.getText().charAt(0), productionField2.getText());
					}
					if (symboleField3.getText().equals("") == false && productionField3.getText().equals("") == false) {
						rs.addElement(symboleField3.getText().charAt(0), productionField3.getText());
					}
					panneauPrincipale.setRs(rs);
				} else if (FenetreLSystem.contextuel) {
					ruleContex = new HashMap<>();
					String[] chaine = new String[3];
					if (symboleField1.getText().equals("") == false && productionField1.getText().equals("") == false) {
						chaine[0] = productionField1.getText();

					}

					if (symboleField2.getText().equals("") == false && productionField2.getText().equals("") == false) {
						chaine[1] = productionField2.getText();

					}

					if (symboleField3.getText().equals("") == false && productionField3.getText().equals("") == false) {
						chaine[2] = productionField3.getText();
						
					}
					ruleContex.put(symboleField1.getText(), chaine);
					panneauPrincipale.setRuleContext(ruleContex);

				} else {
					ruleStoch = new HashMap<>();
					String[] chaine = new String[15];
					if (symboleField1.getText().equals("") == false && productionField1.getText().equals("") == false) {

						for (int i = 0; i < 8; i++) {
							chaine[i] = productionField1.getText();
						}
						

					}
					
					if (symboleField2.getText().equals("") == false && productionField2.getText().equals("") == false) {
						for (int i = 8; i < 13; i++) {
							chaine[i] = productionField1.getText();
						}
						
					}
					
					if (symboleField3.getText().equals("") == false && productionField3.getText().equals("") == false) {
						for (int i = 13; i < 15; i++) {
							chaine[i] = productionField1.getText();
						}
					}
					ruleStoch.put(symboleField1.getText().charAt(0), chaine);
					panneauPrincipale.setRuleStoch(ruleStoch);
				}

				try {
					panneauPrincipale.setNbIteration(Integer.parseInt(iteration.getText()));
				} catch (Exception e2) {
					iteration.setText("Error");

				}

				Interpretation.setBeginHeight(200);
				Interpretation.setBeginWidth(300);
				repaint();
				
			}
		});
		
		PanneauManipulation.add(dessinerAnimation);
		}
		

		effacer = new JButton("Effacer");
		effacer.setPreferredSize(new Dimension(160, 30));
		effacer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				axiome.setText(null);
				symboleField1.setText(null);
				productionField1.setText(null);
				symboleField2.setText(null);
				productionField2.setText(null);
				symboleField3.setText(null);
				productionField3.setText(null);
				valeurAngle.setText(null);
				valeurtaille.setText(null);
				iteration.setText(null);

			}
		});
		PanneauManipulation.add(effacer);

		pack();
		setLocationRelativeTo(this);

	}

	/**
	 * @return angle La valeur de l'angle de rotation du dessin
	 */
	public static int getAngle() {
		return angle;
	}

	/**
	 * @param lsystemStandart Variable booléenne pour définir si le LSystem est de type standard
	 */
	public void setLsystemStandart(boolean lsystemStandart) {
		this.lsystemStandart = lsystemStandart;
	}

	/**
	 * @param contextuel Variable booléenne pour définir si le LSystem est de type contextuel
	 */
	public void setContextuel(boolean contextuel) {
		this.contextuel = contextuel;
	}
	/**
	 * @param stochastique Variable booléenne pour définir si le LSystem est de type stochastique
	 */
	public void setStochastique(boolean stochastique) {
		this.stochastique = stochastique;
	}
	/**
	 * Méthode principale pour exécuter l'application FenetreLSystem
	 * @param args Paramètres de ligne de commande (non utilisés)
	 */
	public static void main(String[] args) {
		FenetreLSystem fn = new FenetreLSystem();
		fn.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == Jangle) {
			FenetreLSystem.angle = Jangle.getValue();
			repaint();
		} else if (e.getSource() == Jtaille) {
			FenetreLSystem.taille = Jtaille.getValue();
			repaint();
		}

	}

}