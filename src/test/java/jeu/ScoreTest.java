package jeu;

import junit.framework.TestCase;

/**
 * Classe de test pour la classe Score.
 *
 * @author Benjamin Saint-Sever.
 */
public class ScoreTest extends TestCase {


    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAjouterJeu() throws Exception {
        /******** TEST 1 ********/
        boolean test1 = false;
        Score s1 = new Score();
        Jeu j1 = new Jeu();

        j1.jouer(1, 2); //NORMAL
        s1.ajouterJeu(j1);
        if (s1.getScore() == 3) {
            test1 = true;
        }

        /******** TEST 2 ********/
        boolean test2 = false;
        Score s2 = new Score();
        Jeu j2 = new Jeu();

        j2.jouer(9, 1); //SPARE
        s2.ajouterJeu(j2); // +
        j2.jouer(4, 2); // NORMAL
        s2.ajouterJeu(j2);

        if (s2.getScore() == 20) {
            test2 = true;
        }

        /******** TEST 3 ********/
        boolean test3 = false;
        Score s3 = new Score();
        Jeu j3 = new Jeu();

        j3.jouer(10, 0); //STRIKE
        s3.ajouterJeu(j3); // +
        j3.jouer(8, 1); //NORMAL
        s3.ajouterJeu(j3);
        if (s3.getScore() == 28) {
            test3 = true;
        }

        /******** TEST 4 ********/
        boolean test4 = false;
        Score s4 = new Score();
        Jeu j4 = new Jeu();

        j4.jouer(10, 0); //STRIKE
        s4.ajouterJeu(j4); //+
        j4.jouer(9, 1); // SPARE
        s4.ajouterJeu(j4);// +
        j4.jouer(5, 0); //NORMAL
        s4.ajouterJeu(j4);
        if (s4.getScore() == 40) {
            test4 = true;
        }

        /******** TEST 5 ********/
        boolean test5 = false;
        Score s5 = new Score();
        Jeu j5 = new Jeu();

        j5.jouer(10, 0); //STRIKE
        s5.ajouterJeu(j5); //+
        j5.jouer(10, 0); // STRIKE
        s5.ajouterJeu(j5);// +
        j5.jouer(10, 0); //STRIKE
        s5.ajouterJeu(j5);
        //PREMIER COUPS COMPTABILISE
        if (s5.getScore() == 30) {
            test5 = true;
        }

        assertTrue(test1 & test2 & test3 & test4 & test5);
    }

    public void testGetScore() throws Exception {

        //Optention du score sans jeu.
        boolean test1 = false;
        try {
            new Score().getScore();
        } catch (Exception e) {
            test1 = true;
        }

        //Depassement du nombre de jeu possible.
        boolean test2 = false;
        try {
            Score s2 = new Score();
            Jeu j2 = new Jeu();
            j2.jouer(1, 3);
            //Depassement intentionnel
            for (int i = 0; i < 13; i++) {
                s2.ajouterJeu(j2);
            }
            s2.getScore();
        } catch (Exception e) {
            test2 = true;
        }

        //Get score sur un trou.
        boolean test3 = false;

        Score s3 = new Score();
        Jeu j3 = new Jeu();
        j3.jouer(8, 0);
        s3.ajouterJeu(j3);
        if (s3.getScore() == 8) {
            test3 = true;
        }

        //Get score sur un Spare.
        boolean test4 = false;

        Score s4 = new Score();
        Jeu j4 = new Jeu();

        j4.jouer(7, 3);
        s4.ajouterJeu(j4);
        j4.jouer(1, 2);
        if (s4.getScore() == 14) {
            test4 = true;
        }

        //Get score sur un STRIKE.
        boolean test5 = false;

        Score s5 = new Score();
        Jeu j5 = new Jeu();

        j5.jouer(10, 0);
        s5.ajouterJeu(j5);
        j5.jouer(1, 2);

        if (s5.getScore() == 16) {
            test5 = true;
        }


        assertTrue(test1 & test2 & test3 & test4 & test5);
    }

    public void testGetVal() throws Exception {
        Score s1 = new Score();
        Jeu j1 = new Jeu();

        j1.jouer(10, 0);
        s1.ajouterJeu(j1);
        j1.jouer(5, 2);
        s1.ajouterJeu(j1);
        j1.jouer(1, 9);
        s1.ajouterJeu(j1);

        assertEquals("X521/", s1.getVal());

    }

}