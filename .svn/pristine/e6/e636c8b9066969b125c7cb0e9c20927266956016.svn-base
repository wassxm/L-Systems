package model;

import java.util.Map;
/*La classe LSystemContextuel représente un L-système contextuel. */
public class LSystemContextuel extends AbstractLsystem {

	/**
	 * Classe représentant un L-système contextuel.
	 * 
	 * @param list        L'alphabet utilisé pour le L-système.
	 * @param productions Les règles de production du L-système sous forme de map avec des clés représentant les contextes des symboles de l'alphabet.
	 * @param axiom       L'axiome initial du L-système.
	 * @param it          Le nombre d'itérations à effectuer pour la simulation du L-système.
	 * @param longeur     La longueur initiale des segments du L-système.
	 * @param angle       L'angle de rotation des segments du L-système.
	 * 
	 * @return            La chaîne générée par la simulation du L-système.
	 */
	public LSystemContextuel(Alphabet list, Map<String, String[]> productions, String axiom, int it, int longeur,
			int angle) {
		super(productions, list, axiom, it, longeur, angle);

	}

	
	@Override
	public String simulation() {
		String resultat = axiom;

		for (int i = 0; i < this.nombreIteration; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < resultat.length(); j++) {
				String actuel = String.valueOf(resultat.charAt(j));
				String contexte = "";
				String predecesseurStrict = actuel;

				if (j > 0) {
					contexte += resultat.charAt(j - 1);
					predecesseurStrict = resultat.substring(j - 1, j + 1);
				}
				if (j < resultat.length() - 1) {
					contexte += resultat.charAt(j + 1);
				}

				String cle = predecesseurStrict + ":" + contexte;
				String[] production = this.contex.get(cle);

				
				if (production == null) {
					production = this.contex.get(actuel);
				}

	
				if (production == null) {
					sb.append(actuel);
				} else {
					sb.append(String.join("", production));
				}
			}

			resultat = sb.toString();
		}

		return resultat;
	}

}