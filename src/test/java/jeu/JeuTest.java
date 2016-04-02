package jeu;

import junit.framework.TestCase;

/**
 * Jeu de test pour la classe Jeu.
 *
 * @author Benjamin Saint-Sever.
 */
public class JeuTest extends TestCase {

    private static Jeu testJeu;

    public void setUp() throws Exception {
        super.setUp();

        testJeu = new Jeu();

    }

    public void testJouer() throws Exception {

        int nbTests = 0;

        try {
            //Test des possibilités de jeu valide.
            for (int i = 0; i <= 10; i++) {
                for (int j = 0; j <= (10 - i); j++) {
                    testJeu.jouer(i, j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        //Test des non possibilités de jeu, le programme doit générer des
        // exceptions si il n'y a pas de possibilité de jouer de cette façon.
        try {
            nbTests++;
            testJeu.jouer(9, 9);
        } catch (Exception e) {
            nbTests--;
        }

        try {
            nbTests++;
            testJeu.jouer(0, 11);
        } catch (Exception e) {
            nbTests--;
        }
        try {
            nbTests++;
            testJeu.jouer(12, 0);
        } catch (Exception e) {
            nbTests--;
        }

        try {
            nbTests++;
            testJeu.jouer(-1, 5);
        } catch (Exception e) {
            nbTests--;
        }

        try {
            nbTests++;
            testJeu.jouer(1, -5);

        } catch (Exception e) {
            nbTests--;
        }

        try {
            nbTests++;
            testJeu.jouer(6, -5);

        } catch (Exception e) {
            nbTests--;
        }


        try {
            nbTests++;
            testJeu.jouer(-1, -5);
        } catch (Exception e) {
            nbTests--;
        }

        //Si tous les tests ont bien généré une exception.
        assertEquals(nbTests, 0);

    }

    public void testGetNombreQuilleTombe() throws Exception {

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j < (10 - i); j++) {
                testJeu.jouer(i, j);
                int nbQuilleTombe = testJeu.getNombreQuilleTombe();
                if (nbQuilleTombe != (i + j)) {
                    assertTrue(false);
                }
            }
        }

        assertTrue(true);
    }

    public void testGetNombreQuilleDepart(){
        assertEquals(testJeu.getNombreQuilleDepart(),10);
    }

}