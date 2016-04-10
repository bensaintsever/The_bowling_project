package jeu;

import junit.framework.TestCase;

/**
 * @author Thomas Guillou
 *
 * Classe de test pour le DernierJeu
 */
public class DernierJeuTest extends TestCase {

    private DernierJeu dj;
    private Jeu jeuSimule;

    public void setUp() throws Exception {
        super.setUp();
        this.dj = new DernierJeu();
        this.jeuSimule = new Jeu();
    }

    public void testGetJeu2() throws Exception {
        assertEquals(dj.getJeu2().getCoup(),Coup.AUCUN_LANCER);

        // / On fait un Trou, donc pas de troisième lancer
        // Le jeu 2 aura aucun lancer
        dj.jouer(1,1,1);
        assertEquals(dj.getJeu2().getCoup(),Coup.AUCUN_LANCER);

        // On fait un Spare, donc on peut jouer un lancer en plus
        // Le jeu 2 aura un seul lancer (1 quille tombe ici)
        dj.jouer(1,9,1);
        jeuSimule = new Jeu();
        jeuSimule.jouer(1,0);
        assertEquals(dj.getJeu2().getNombreQuilleTombeTotale(),
                jeuSimule.getNombreQuilleTombeTotale());

        // On fait un Strike, donc on peut jouer deux lancer en plus
        // Le jeu 2 aura deux lancer
        dj.jouer(10,9,1);
        jeuSimule = new Jeu();
        jeuSimule.jouer(9,1);
        assertEquals(dj.getJeu2().getCoup(),Coup.SPARE);
        assertEquals(dj.getJeu2().getNombreQuilleTombeTotale(),
                jeuSimule.getNombreQuilleTombeTotale());

        dj.jouer(10,1,1);
        jeuSimule = new Jeu();
        jeuSimule.jouer(1,1);
        assertEquals(dj.getJeu2().getCoup(),Coup.TROU);
        assertEquals(dj.getJeu2().getNombreQuilleTombeTotale(),
                jeuSimule.getNombreQuilleTombeTotale());

        // On fait deux strikes
        dj.jouer(10,10,1);
        assertEquals(dj.getJeu2().getCoup(),Coup.STRIKE);
    }

    public void testGetJeu3() throws Exception {
        assertEquals(dj.getJeu3().getCoup(),Coup.AUCUN_LANCER);

        // On ne peux avoir un jeu3 qu'en faisait 2 strikes
        dj.jouer(0,0,5);
        assertEquals(dj.getJeu3().getCoup(),Coup.AUCUN_LANCER);
        dj.jouer(10,0,5);
        assertEquals(dj.getJeu3().getCoup(),Coup.AUCUN_LANCER);
        dj.jouer(5,5,5);
        assertEquals(dj.getJeu3().getCoup(),Coup.AUCUN_LANCER);
        dj.jouer(0,10,5);
        assertEquals(dj.getJeu3().getCoup(),Coup.AUCUN_LANCER);
        dj.jouer(10,10,10);
        assertEquals(dj.getJeu3().getCoup(),Coup.STRIKE);
        dj.jouer(10,10,1);
        assertEquals(dj.getJeu3().getCoup(),Coup.TROU);

        // On ne peut jouer qu'un lancer au Jeu 3
        // Car on a déja usé les 2 coups précédent en faisant des STRIKES
        dj.jouer(10,10,1);
        jeuSimule = new Jeu();
        jeuSimule.jouer(1,0);
        assertEquals(dj.getJeu3().getCoup(),Coup.TROU);
        assertEquals(dj.getJeu3().getNombreQuilleTombeTotale(),
                jeuSimule.getNombreQuilleTombeTotale());
    }

    public void testGetJeu1() throws Exception {
        assertEquals(dj.getJeu1().getCoup(),Coup.AUCUN_LANCER);

        dj.jouer(1,1,1);
        jeuSimule = new Jeu();
        jeuSimule.jouer(1,1);
        assertEquals(dj.getJeu1().getCoup(),Coup.TROU);
        assertEquals(dj.getJeu1().getNombreQuilleTombeTotale(),
                jeuSimule.getNombreQuilleTombeTotale());


        dj.jouer(10,0,0);
        jeuSimule = new Jeu();
        jeuSimule.jouer(10,0);
        assertEquals(dj.getJeu1().getCoup(),Coup.STRIKE);
        assertEquals(dj.getJeu1().getNombreQuilleTombeCoup2(),
                jeuSimule.getNombreQuilleTombeCoup2());
        assertEquals(dj.getJeu1().getNombreQuilleTombeCoup1(),
                jeuSimule.getNombreQuilleTombeCoup1());
        assertEquals(dj.getJeu1().getNombreQuilleTombeTotale(),
                jeuSimule.getNombreQuilleTombeTotale());

        dj.jouer(9,1,1);
        jeuSimule = new Jeu();
        jeuSimule.jouer(9,1);
        assertEquals(dj.getJeu1().getCoup(),Coup.SPARE);
        assertEquals(dj.getJeu1().getNombreQuilleTombeTotale(),
                jeuSimule.getNombreQuilleTombeTotale());
    }

    public void testJouer() throws Exception {

    }
}