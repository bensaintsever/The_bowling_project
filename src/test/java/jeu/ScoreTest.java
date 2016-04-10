package jeu;

import junit.framework.TestCase;

/**
 * Classe de test pour la classe Score.
 *
 * @author Benjamin Saint-Sever.
 */
public class ScoreTest extends TestCase {

    // DernierJeu factice
    private final DernierJeu dj = new DernierJeu();




    public void setUp() throws Exception {
        super.setUp();
        dj.jouer(0,0,0);
    }

    public void testAjouterJeu() throws Exception {
        /******** TEST 1 ********/
        boolean test1 = false;
        Score s1 = new Score();
        Jeu j1 = new Jeu();

        j1.jouer(1, 2); //NORMAL * 10
        for (int i = 0; i < 9; i++) {
            s1.ajouterJeu(j1);
        }
        s1.ajouterDernierJeu(dj);
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
        for (int i = 0; i < 8; i++) {
            s2.ajouterJeu(j2);
        }
        s2.ajouterDernierJeu(dj);
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
        for (int i = 0; i < 8; i++) {
            s3.ajouterJeu(j3);
        }
        s3.ajouterDernierJeu(dj);
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
        for (int i = 0; i < 7; i++) {
            s4.ajouterJeu(j4);
        }
        s4.ajouterDernierJeu(dj);
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
        for (int i = 0; i < 9; i++) {
            s5.ajouterJeu(j5);
        }
        s5.ajouterDernierJeu(dj);
        //PREMIER COUPS COMPTABILISE
        if (s5.getScore() == 240) {
            test5 = true;
        }{
            System.out.println("ERREUR TESTAjouterJeu N° 5");
        }

        //assertTrue(test1 & test2 & test3 & test4 & test5);
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
            s2.ajouterDernierJeu(dj);
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
        for (int i = 0; i < 8; i++) {
            j3 = new Jeu();
            j3.jouer(0, 0);
            s3.ajouterJeu(j3);
        }
        s3.ajouterDernierJeu(dj);
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
        DernierJeu last = new DernierJeu();
        last.jouer(10,0,0);
        s1.ajouterDernierJeu(last);
        assertEquals("X521/6_XXXXXX__", s1.getVal());



        s1 = new Score();
        last.jouer(0,0,0);
        this.auto(s1,last
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0);

        assertEquals("XXXXXXXXX__", s1.getVal());

        s1 = new Score();
        last.jouer(10,10,10);
        this.auto(s1,last
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0);

        assertEquals("XXXXXXXXXXXX", s1.getVal());

        s1 = new Score();
        last.jouer(10,10,10);
        this.auto(s1,last
                ,0,0
                ,10,0
                ,5,5
                ,10,0
                ,5,0
                ,10,0
                ,10,0
                ,10,0
                ,10,0);

        assertEquals("__X5/X5_XXXXXXX", s1.getVal());

        s1 = new Score();
        last.jouer(9,1,10);
        this.auto(s1,last
                ,0,0
                ,1,1
                ,2,2
                ,3,3
                ,4,4
                ,5,5
                ,6,4
                ,7,3
                ,8,2);

        assertEquals("__112233445/6/7/8/9/XX", s1.getVal());
    }

    /**
     *  Rempli automatiquement le score avec les valeurs indiquées
     */
    private void auto(Score s,final DernierJeu dj,final int... val) {
        int i = 0;
        try {
            while (i < val.length) {
                Jeu j = new Jeu();

                j.jouer(val[i],val[i+1]);
                s.ajouterJeu(j);
                i += 2;
            }
            s.ajouterDernierJeu(dj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testAjouterDernierJeu() {
        DernierJeu last = new DernierJeu();
        // TO DO
    }

}