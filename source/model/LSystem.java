package model;

import java.util.ArrayList;
import java.util.List;

/*la classe LSystem implémente la logique nécessaire pour simuler un système L-système en utilisant les règles de remplacement et les paramètres spécifiés, et elle permet de générer des motifs complexes à partir d'un axiome initial. */
public class LSystem extends AbstractLsystem {

	/**
	 * Constructeur de la classe LSystem.
	 *
	 * @param list       Un objet de la classe Alphabet qui représente l'alphabet utilisé dans le système L-système.
	 * @param listRules  Un objet de la classe Rules qui représente les règles de remplacement utilisées dans le système L-système.
	 * @param action     Une chaîne de caractères qui représente l'action associée à chaque symbole de l'alphabet dans le système L-système.
	 * @param nbIt       Un entier qui représente le nombre d'itérations à effectuer dans la simulation du système L-système.
	 * @param longeur    Un entier qui représente la longueur initiale des segments générés par le système L-système.
	 * @param angle      Un entier qui représente l'angle de rotation associé à certains symboles de l'alphabet dans le système L-système.
	 */
	public LSystem(Alphabet list, Rules listRules, String action, int nbIt, int longeur, int angle) {
		super(list, listRules, action, nbIt, longeur, angle);
	}

	
	@Override
	public String simulation() {
		StringBuilder chaine = new StringBuilder(axiom);
		for (int i = 0; i < this.nombreIteration; i++) {
			StringBuilder newChaine = new StringBuilder();
			char[] charArray = chaine.toString().toCharArray();
			for (char c : charArray) {
				String replacement = listRules.getValue(c);
				newChaine.append(replacement);
			}
			chaine = newChaine;
		}
		return chaine.toString();
	}
	public String simulation(int nombreIteration) {
		StringBuilder chaine = new StringBuilder(axiom);
		List<Coordinate> listC = new ArrayList<>();
		double x = 100;
		double y = 100;
		//listC.add(new Coordinate(x, y));

		for (int i = 0; i < nombreIteration; i++) {
			StringBuilder newChaine = new StringBuilder();
			char[] charArray = chaine.toString().toCharArray();
			for (char c : charArray) {
				String replacement = listRules.getValue(c);
				newChaine.append(replacement);
			}
			chaine = newChaine;
			y += longeur;
			//listC.add(new Coordinate(x, y));
		}
		return chaine.toString();
	}

}