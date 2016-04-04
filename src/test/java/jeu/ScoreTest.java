package jeu;

import junit.framework.TestCase;

/**
 * Classe de test pour la classe Score.
 * @author Benjamin Saint-Sever.
 */
public class ScoreTest extends TestCase {

    private Jeu j1;

    public void setUp() throws Exception {
        super.setUp();
        j1 = new Jeu();
    }

    public void testAjouterJeu() throws Exception {
        /******** TEST 1 ********/
        boolean test1 = false;
        Score s1 = new Score();
        j1.jouer(1, 2); //NORMAL
        s1.ajouterJeu(j1);
        if (s1.getScore() == 3) {
            test1 = true;
        }

        /******** TEST 2 ********/
        Score s2 = new Score();
        boolean test2 = false;
        j1.jouer(9, 1); //SPARE
        s2.ajouterJeu(j1); // +
        j1.jouer(4, 2); // NORMAL
        s2.ajouterJeu(j1);

        if (s2.getScore() == 20) {
            test2 = true;
        }

        /******** TEST 3 ********/
        boolean test3 = false;
        Score s3 = new Score();
        j1.jouer(10, 0); //STRIKE
        s3.ajouterJeu(j1); // +
        j1.jouer(8, 1); //NORMAL
        s3.ajouterJeu(j1);
        if (s3.getScore() == 28) {
            test2 = true;
        }

        /******** TEST 4 ********/
        boolean test4 = false;
        Score s4 = new Score();
        j1.jouer(10, 0); //STRIKE
        s3.ajouterJeu(j1); //+
        j1.jouer(9, 1); // SPARE
        s3.ajouterJeu(j1);// +
        j1.jouer(5, 0); //NORMAL
        s3.ajouterJeu(j1);
        if (s3.getScore() == 40) {
            test4 = true;
        }

        /******** TEST 5 ********/
        boolean test5 = false;
        Score s5 = new Score();
        j1.jouer(10, 0); //STRIKE
        s3.ajouterJeu(j1); //+
        j1.jouer(10, 0); // STRIKE
        s3.ajouterJeu(j1);// +
        j1.jouer(10, 0); //STRIKE
        s3.ajouterJeu(j1);
        //PREMIER COUPS COMPTABILISE
        if (s3.getScore() == 30) {
            test4 = true;
        }

        assertTrue(test1 & test2 & test3 & test4);
    }

    public void testGetScore() throws Exception {
        testAjouterJeu();
    }

    public void testGetVal() throws Exception {
        Score s = new Score();
        j1.jouer(10, 0);
        s.ajouterJeu(j1);
        j1.jouer(5, 2);
        s.ajouterJeu(j1);
        j1.jouer(1, 9);
        s.ajouterJeu(j1);

        assertEquals("X521/", s.getVal());

    }

}