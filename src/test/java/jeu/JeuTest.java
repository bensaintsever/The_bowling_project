package jeu;

import junit.framework.TestCase;

/**
 * Jeu de test pour la classe Jeu.
 *
 * @author Benjamin Saint-Sever.
 */
public class JeuTest extends TestCase {

    private Jeu testJeu;

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
            testJeu.jouer(15,-7);
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

    public void testGetNombreQuilleTombeTotale() throws Exception {

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j < (10 - i); j++) {
                testJeu.jouer(i, j);
                int nbQuilleTombe = testJeu.getNombreQuilleTombeTotale();
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

    public void testGetCoupAUCUN_LANCER() {
        assertEquals(this.testJeu.getCoup(),Coup.AUCUN_LANCER);
    }

    public void testGetCoupTROU() {
        try {
            this.testJeu.jouer(0,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(this.testJeu.getCoup(),Coup.TROU);

        this.testJeu = new Jeu();
        try {
            this.testJeu.jouer(0,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(this.testJeu.getCoup(),Coup.TROU);
    }

    public void testGetCoupSPARE1() {
        try {
            this.testJeu.jouer(1,9);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(this.testJeu.getCoup(),Coup.SPARE);


        this.testJeu = new Jeu();
        try {
            this.testJeu.jouer(0,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(this.testJeu.getCoup(),Coup.SPARE);

        this.testJeu = new Jeu();
        try {
            this.testJeu.jouer(8,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(this.testJeu.getCoup(),Coup.SPARE);
    }

    public void testGetCoupSTRIKE() {
        try {
            this.testJeu.jouer(10,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(this.testJeu.getCoup(),Coup.STRIKE);
    }

}