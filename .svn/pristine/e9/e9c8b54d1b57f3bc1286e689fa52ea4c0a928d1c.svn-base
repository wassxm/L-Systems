package model;

import java.util.Map;

public abstract class AbstractLsystem {

	protected Alphabet list; // Liste d'alphabet
	protected Rules listRules; // Liste de règles
	protected String axiom; // Axiome
	protected int longeur; // Longueur
	protected int angle; // Angle
	protected int nombreIteration; // Nombre d'itérations
	protected Map<Character, String[]> rulesStochastique; // Règles stochastiques
	protected Map<String, String[]> contex; // Contexte

	/**
	 * Constructeur avec liste d'alphabet et liste de règles
	 *
	 * @param list       La liste d'alphabet
	 * @param listRules  La liste de règles
	 * @param action     L'action
	 * @param nbIt       Le nombre d'itérations
	 * @param longeur    La longueur
	 * @param angle      L'angle
	 */
	public AbstractLsystem(Alphabet list, Rules listRules, String action, int nbIt, int longeur, int angle) {
		this.list = list;
		this.listRules = listRules;
		this.axiom = action;
		this.longeur = longeur;
		this.angle = angle;
		this.nombreIteration = nbIt;
	}

	/**
	 * Constructeur avec liste d'alphabet et règles stochastiques
	 *
	 * @param list           La liste d'alphabet
	 * @param productions    Les règles stochastiques
	 * @param action         L'action
	 * @param nbIt           Le nombre d'itérations
	 * @param longeur        La longueur
	 * @param angle          L'angle
	 */
	public AbstractLsystem(Alphabet list, Map<Character, String[]> productions, String action, int nbIt, int longeur,
			int angle) {
		this.list = list;
		this.rulesStochastique = productions;
		this.axiom = action;
		this.longeur = longeur;
		this.angle = angle;
		this.nombreIteration = nbIt;
	}

	/**
	 * Constructeur avec contexte, liste d'alphabet et action
	 *
	 * @param contex         Le contexte
	 * @param list           La liste d'alphabet
	 * @param action         L'action
	 * @param nbIt           Le nombre d'itérations
	 * @param longeur        La longueur
	 * @param angle          L'angle
	 */
	public AbstractLsystem(Map<String, String[]> contex, Alphabet list, String action, int nbIt, int longeur, int angle) {
		this.list = list;
		this.contex = contex;
		this.axiom = action;
		this.longeur = longeur;
		this.angle = angle;
		this.nombreIteration = nbIt;
	}

	/**
	 * Méthode abstraite de simulation
	 *
	 * @return Le résultat de la simulation
	 */
	public abstract String simulation();

	/**
	 * Getter pour la longueur
	 *
	 * @return La longueur
	 */
	public int getLongeur() {
		return longeur;
	}

	/**
	 * Getter pour l'angle
	 *
	 * @return L'angle
	 */
	public int getangle() {
		return angle;
	}

	/**
	 * Getter pour le nombre d'itérations
	 *
	 * @return Le nombre d'itérations
	 */
	public int getNombreIteration() {
		return nombreIteration;
	

	}

}