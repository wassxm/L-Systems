package model;

import java.util.Map;
import java.util.Random;
/*La classe LSystemStochastiques représente un L-système stochastique. */
public class LSystemStochastiques extends AbstractLsystem {

	/**
	 * Classe représentant un L-système stochastique.
	 * 
	 * @param list               L'alphabet utilisé pour le L-système.
	 * @param rulesStochastique  Les règles de production stochastiques du L-système sous forme de map avec des clés représentant les symboles de l'alphabet et des valeurs représentant les remplacements possibles sous forme de tableau de chaînes de caractères.
	 * @param action             L'action associée à ce L-système.
	 * @param nbIt               Le nombre d'itérations à effectuer pour la simulation du L-système.
	 * @param longeur            La longueur initiale des segments du L-système.
	 * @param angle              L'angle de rotation des segments du L-système.
	 * 
	 * @return                   La chaîne générée par la simulation du L-système.
	 */
	public LSystemStochastiques(Alphabet list, Map<Character, String[]> rulesStochastique, String action, int nbIt,
			int longeur, int angle) {
		super(list, rulesStochastique, action, nbIt, longeur, angle);

	}

	
	@Override
	public String simulation() {
		
		StringBuilder chaineCourrante = new StringBuilder(axiom);
		for (int i = 0; i < this.nombreIteration; i++) {
			StringBuilder next = new StringBuilder();
			char[] chars = chaineCourrante.toString().toCharArray();
			for (char c : chars) {
				if (this.list.isPresent(String.valueOf(c))) {
					String[] replacements = this.rulesStochastique.get(c);
					String replacement = replacements[new Random().nextInt(replacements.length)];
					next.append(replacement);
				} else {
					next.append(c);
				}
			}
			chaineCourrante = next;
		}

		return chaineCourrante.toString();

	}

}