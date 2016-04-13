package jeu;

import junit.framework.TestCase;

/**
 * Classe de test pour la classe Score.
 *
 * @author Benjamin Saint-Sever.
 */
public class ScoreTest extends TestCase {

    // DernierJeu factice
    private final DernierJeu dernierJeu = new DernierJeu();




    public void setUp() throws Exception {
        super.setUp();
        dernierJeu.jouer(0,0,0);
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
        s1.ajouterDernierJeu(dernierJeu);
        if (s1.getScore() == 27) {
            test1 = true;
        }else{
            System.out.println("ERREUR TESTAjouterJeu N° 1");
        }

        try {
            // Capacité max atteinte normalement
            s1.ajouterJeu(j1);
            fail();
        } catch (Exception e){
            assertTrue(true);
        }

        /******** TEST 2 ********/
        boolean test2 = false;
        Score s2 = new Score();
        Jeu j2 = new Jeu();

        j2.jouer(9, 1); //SPARE * 1
        s2.ajouterJeu(j2); // +
        j2 = new Jeu();
        j2.jouer(4, 2); // NORMAL * 8
        for (int i = 0; i < 8; i++) {
            s2.ajouterJeu(j2);
        }
        s2.ajouterDernierJeu(dernierJeu);
        System.out.println(s2.getScore());
        if (s2.getScore() == 62) {
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
        j3 = new Jeu();
        j3.jouer(8, 1); //NORMAL * 8
        for (int i = 0; i < 8; i++) {
            s3.ajouterJeu(j3);
        }
        s3.ajouterDernierJeu(dernierJeu);
        if (s3.getScore() == 91) {
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
        j4 = new Jeu();
        j4.jouer(9, 1); // SPARE * 1
        s4.ajouterJeu(j4);// +
        j4 = new Jeu();
        j4.jouer(5, 0); //NORMAL * 7
        for (int i = 0; i < 7; i++) {
            s4.ajouterJeu(j4);
        }
        s4.ajouterDernierJeu(dernierJeu);
        if (s4.getScore() == 70) {
            test4 = true;
        } else {
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
        dernierJeu.jouer(10,10,10);
        s5.ajouterDernierJeu(dernierJeu);
        //PREMIER COUPS COMPTABILISE
        if (s5.getScore() == 300) {
            test5 = true;
        } else {
            System.out.println("ERREUR TESTAjouterJeu N° 5");
        }

        /******** TEST 6 ********/
        // Jeu non joué = 0 points
        boolean test6 = false;
        Score s6 = new Score();
        Jeu j6 = new Jeu();

        for (int i = 0; i < 9; i++) {
            s6.ajouterJeu(j6);
        }
        dernierJeu.jouer(0,0,0);
        s6.ajouterDernierJeu(dernierJeu);
        //PREMIER COUPS COMPTABILISE
        if (s6.getScore() == 0) {
            test6 = true;
        } else {
            System.out.println("ERREUR TESTAjouterJeu N° 6");
        }

        /******** TEST 7 ********/
        Score s7 = new Score();
        DernierJeu last = new DernierJeu();
        last.jouer(10,5,2);
        this.auto(s7,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals(157, s7.getScore());

        /******** TEST 8 ********/
        Score s8 = new Score();
        last = new DernierJeu();
        last.jouer(5,5,2);
        this.auto(s8,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals(147, s8.getScore());


        assertTrue(test1 & test2 & test3 & test4 & test5 & test6);
    }

    public void testGetScore() throws Exception {

        //Obtention du score sans jeu.
        boolean test1 = false;
        DernierJeu dj = new DernierJeu();
        Score s = new Score();
        try {
            s.ajouterDernierJeu(dj);
            s.getScore();
        } catch (Exception e) {
            test1 = true;
        }

        //Obtention du score sans dernierjeu.
        boolean test0 = false;
        try {
            Score s0 = new Score();
            Jeu j0 = new Jeu();
            j0.jouer(1, 3);
            //Depassement intentionnel
            for (int i = 0; i < 9; i++) {
                s0.ajouterJeu(j0);
            }
            //s0.ajouterDernierJeu(dernierJeu);
            s0.getScore();
        } catch (Exception e) {
            test0 = true;
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
            s2.ajouterDernierJeu(dernierJeu);
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
        s3.ajouterDernierJeu(dernierJeu);
        if (s3.getScore() == 8) {
            test3 = true;
        }else{
            System.out.println("ERREUR TESTGetScore N° 3");
        }

        // La liste des jeux n'a pas la bonne taille
        boolean test4 = false;

        Score s4 = new Score();
        DernierJeu last = new DernierJeu();
        Jeu j4 = new Jeu();
        j4.jouer(8, 0);
        last.jouer(0,0,0);
        s4.ajouterJeu(j4);
        s4.ajouterDernierJeu(last);
        try {
            s4.getScore();
            System.out.println("ERREUR TESTGetScore N° 4");
        } catch (Exception e) {
            test4 = true;
        }

        boolean test5 = false;

        Score s5 = new Score();
        last = new DernierJeu();
        last.jouer(2,2,0);
        Jeu j5 = new Jeu();
        j5.jouer(8, 2);
        for ( int i = 0 ; i < 9 ; i++ ) {
             s5.ajouterJeu(j5);
        }
        s5.ajouterDernierJeu(last);
        try {
            s5.getScore();
            test5 = true;
        } catch (Exception e) {
            System.out.println("ERREUR TESTGetScore N° 5");
            e.printStackTrace();
        }


        Score s6 = new Score();
        last = new DernierJeu();
        last.jouer(2,2,0);
        Jeu j6 = new Jeu();
        j6.jouer(10, 0);
        for ( int i = 0 ; i < 9 ; i++ ) {
            s6.ajouterJeu(j6);
        }
        s6.ajouterDernierJeu(last);
        try {
            s6.getScore();
        } catch (Exception e) {
            System.out.println("ERREUR TESTGetScore N° 6");
            e.printStackTrace();
        }

        assertTrue(test0 & test1 & test2 & test3 & test4 & test5);
    }

    public void testGetVal() throws Exception {
        // Test exception
        Score s0 = new Score();
        DernierJeu last = new DernierJeu();
        Jeu j0 = new Jeu();
        j0.jouer(8, 0);
        last.jouer(0,0,0);
        s0.ajouterJeu(j0);
        s0.ajouterDernierJeu(last);
        try {
            s0.getVal();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }


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
        last = new DernierJeu();
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


        s1 = new Score();
        last.jouer(9,0,0);
        this.auto(s1,last
                ,9,0
                ,9,0
                ,9,0
                ,9,0
                ,9,0
                ,9,0
                ,9,0
                ,9,0
                ,9,0);

        assertEquals("9_9_9_9_9_9_9_9_9_9_", s1.getVal());

        s1 = new Score();
        last.jouer(0,10,5);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals("5/5/5/5/5/5/5/5/5/0/5", s1.getVal());

        s1 = new Score();
        last.jouer(5,0,0);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals("5/5/5/5/5/5/5/5/5/5_", s1.getVal());

        s1 = new Score();
        last.jouer(10,5,5);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals("5/5/5/5/5/5/5/5/5/X5/", s1.getVal());


        s1 = new Score();
        last = new DernierJeu();
        last.jouer(4,5,0);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,10,0);

        assertEquals("5/5/5/5/5/5/5/5/X45", s1.getVal());
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

    public void testAjouterDernierJeu() throws Exception {
        DernierJeu last = new DernierJeu();
        Score s = new Score();
        try {
            s.ajouterDernierJeu(last);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }

        Score s1 = new Score();
        last = new DernierJeu();
        last.jouer(5,5,0);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals("5/5/5/5/5/5/5/5/5/5/_", s1.getVal());

        s1 = new Score();
        last = new DernierJeu();
        last.jouer(10,8,1);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals("5/5/5/5/5/5/5/5/5/X81", s1.getVal());

        s1 = new Score();
        last = new DernierJeu();
        last.jouer(10,10,1);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals("5/5/5/5/5/5/5/5/5/XX1", s1.getVal());

        s1 = new Score();
        last = new DernierJeu();
        last.jouer(10,10,0);
        this.auto(s1,last
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5
                ,5,5);

        assertEquals("5/5/5/5/5/5/5/5/5/XX_", s1.getVal());
    }
}