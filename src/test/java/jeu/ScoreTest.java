package jeu;

import junit.framework.TestCase;

/**
 * Classe de test pour la classe Score.
 *
 * @author Benjamin Saint-Sever.
 */
public class ScoreTest extends TestCase {


    public void testAjouterJeu() throws Exception {
        /******** TEST 1 ********/
        boolean test1 = false;
        Score s1 = new Score();
        Jeu j1 = new Jeu();


        j1.jouer(1, 2); //NORMAL * 10
        for (int i = 0; i < 10; i++) {
            s1.ajouterJeu(j1);
        }
        if (s1.getScore() == 30) {
            test1 = true;
        }else{
            System.out.println("ERREUR TESTAjouterJeu N° 1");
        }

        /******** TEST 2 ********/
        boolean test2 = false;
        Score s2 = new Score();
        Jeu j2 = new Jeu();

        j2.jouer(9, 1); //SPARE * 1
        s2.ajouterJeu(j2); // +
        j2.jouer(4, 2); // NORMAL * 9
        for (int i = 0; i < 9; i++) {
            s2.ajouterJeu(j2);
        }

        if (s2.getScore() == 68) {
            test2 = true;
        }
        else{
            System.out.println("ERREUR TESTAjouterJeu N° 2");
        }

        /******** TEST 3 ********/
        boolean test3 = false;
        Score s3 = new Score();
        Jeu j3 = new Jeu();

        j3.jouer(10, 0); //STRIKE * 1
        s3.ajouterJeu(j3); // +
        j3.jouer(8, 1); //NORMAL * 9
        for (int i = 0; i < 9; i++) {
            s3.ajouterJeu(j3);
        }
        if (s3.getScore() == 100) {
            test3 = true;
        }else{
            System.out.println("ERREUR TESTAjouterJeu N° 3");
        }

        /******** TEST 4 ********/
        boolean test4 = false;
        Score s4 = new Score();
        Jeu j4 = new Jeu();

        j4.jouer(10, 0); //STRIKE * 1
        s4.ajouterJeu(j4); //+
        j4.jouer(9, 1); // SPARE * 1
        s4.ajouterJeu(j4);// +
        j4.jouer(5, 0); //NORMAL * 8
        for (int i = 0; i < 8; i++) {
            s4.ajouterJeu(j4);
        }
        if (s4.getScore() == 75) {
            test4 = true;
        }{
            System.out.println("ERREUR TESTAjouterJeu N° 4");
        }

        /******** TEST 5 ********/
        boolean test5 = false;
        Score s5 = new Score();
        Jeu j5 = new Jeu();

        j5.jouer(10, 0); //STRIKE * 10
        for (int i = 0; i < 10; i++) {
            s5.ajouterJeu(j5);
        }
        //PREMIER COUPS COMPTABILISE
        if (s5.getScore() == 240) {
            test5 = true;
        }{
            System.out.println("ERREUR TESTAjouterJeu N° 5");
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
            for (int i = 0; i < 12; i++) {
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
        for (int i = 0; i < 9; i++) {
            j3.jouer(0, 0);
        }
        s3.ajouterJeu(j3);
        if (s3.getScore() == 8) {
            test3 = true;
        }else{
            System.out.println("ERREUR TESTGetScore N° 3");
        }




        assertTrue(test1 & test2 & test3);
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
        j1.jouer(6, 0);
        s1.ajouterJeu(j1);
        j1.jouer(10, 0);
        for (int i = 0; i < 5; i++) {
            s1.ajouterJeu(j1);
        }


        assertEquals("X521/6_XXXXXX", s1.getVal());

    }

}