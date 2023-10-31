package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Coordinate;
import model.Interpretation; // Import de la classe FenetreLSystem

public class LSystemTest {

    @SuppressWarnings("deprecation")
    @Test
    public void testRotation() {
        Interpretation inter = new Interpretation();
        // Création de deux coordonnées pour représenter c1 et c2
        Coordinate c1 = new Coordinate(0, 0, 0);
        Coordinate c2 = new Coordinate(3, 4, 0);

        // Appel de la fonction rotation avec des valeurs d'angle et de longueur
        double angle = 90.0;
        int longeur = 5;
        Coordinate result = inter.rotation(angle, c1, c2, longeur); // Appel de la méthode rotation de FenetreLSystem

        // Vérification du résultat avec une marge d'erreur delta de 0.001
        assertEquals("Vérification de la coordonnée x", 3,3, 0.001);
        assertEquals("Vérification de la coordonnée y", 9, result.getY(), 0.001);
        assertEquals("Vérification de la coordonnée z", 0, result.getZ(), 0.001);
    }

    public static void main(String[] args) {
        // Instancier l'objet de test
        LSystemTest testFonctionRotation = new LSystemTest();

        // Exécuter le test unitaire
        try {
            testFonctionRotation.testRotation(); // Appeler la méthode de test
            System.out.println("Test passed"); // Afficher si le test réussit
        } catch (AssertionError e) {
            System.out.println("Test not passed"); // Afficher si le test échoue
            e.printStackTrace(); // Afficher la trace d'erreur
        }
    }
}