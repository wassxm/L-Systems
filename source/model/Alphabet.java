package model;

import java.util.*;

public class Alphabet {

    private Set<String> listAlphabet;

    /**
     * Constructeur
     * @param list Un ensemble de chaînes de caractères représentant l'alphabet.
     */
    public Alphabet(Set<String> list) {
        this.listAlphabet = list;
    }

    /**
     * Ajoute un élément à l'alphabet.
     * @param e L'élément à ajouter.
     */
    public void addElement(String e) {
        this.listAlphabet.add(e);
    }

    /**
     * Renvoie l'ensemble de chaînes de caractères représentant l'alphabet.
     * @return L'ensemble de chaînes de caractères représentant l'alphabet.
     */
    public Set<String> getListAlphabet() {
        return this.listAlphabet;
    }

    /**
     * Vérifie si un élément est présent dans l'alphabet.
     * @param e L'élément à vérifier.
     * @return true si l'élément est présent dans l'alphabet, false sinon.
     */
    public boolean isPresent(String e) {
        return this.listAlphabet.contains(e);
    }

    /**
     * Supprime un élément de l'alphabet.
     * @param e L'élément à supprimer.
     */
    public void removeElement(String e) {
        this.listAlphabet.remove(e);
    }
}