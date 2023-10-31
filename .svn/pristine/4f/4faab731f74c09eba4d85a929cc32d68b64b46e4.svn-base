package model;

import java.util.*;
/**
 * Classe représentant un ensemble de règles associant des caractères à des chaînes de caractères.
 */
public class Rules {

	private Map<Character, String> rulesDictionary;

	/**
     * Constructeur de la classe Rules.
     *
     * @param rules Un dictionnaire associant des caractères à des chaînes de caractères.
     */
	public Rules(Map<Character, String> rules) {
		this.rulesDictionary = rules;
	}

	 /**
     * Récupère la valeur associée à une clé dans le dictionnaire de règles.
     *
     * @param key La clé pour laquelle on souhaite récupérer la valeur.
     * @return La valeur associée à la clé, ou la clé elle-même si elle n'existe pas dans le dictionnaire.
     */
	public String getValue(char key) {
		if (rulesDictionary.containsKey(key))
			return this.rulesDictionary.get(key);
		return Character.toString(key);
	}

	/**
     * Ajoute un élément au dictionnaire de règles.
     *
     * @param key   La clé à ajouter.
     * @param value La valeur associée à la clé.
     */
	public void addElement(char key, String value) {
		this.rulesDictionary.put(key, value);
	}

	/**
     * Récupère le dictionnaire de règles.
     *
     * @return Le dictionnaire de règles associant des caractères à des chaînes de caractères.
     */
	public Map<Character, String> getRulesDictionary() {
		return rulesDictionary;
	}

}