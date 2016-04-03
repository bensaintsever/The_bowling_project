package jeu;

import junit.framework.TestCase;

/**
 * @author Thomas Guillou
 * Test pour la classe RegleDuJeu
 * Valable pour les règle officiel du jeu de bowling
 */
public class Regles_Du_JeuTest extends TestCase {

    private ReglesDuJeu regle;

    public void setUp() throws Exception {
        super.setUp();
        regle = new ReglesDuJeu();
    }

    public final void testGetNombreDeJeu() throws Exception {
        assertEquals(regle.getNombreDeJeu(),10);
    }

    public final void testGetNombreDeCoupsParJeu() throws Exception {
        assertEquals(regle.getNombreDeCoupsParJeu(),2);
    }

    public final void testGetNombreDeQuilleParJeu() throws Exception {
        assertEquals(regle.getNombreDeQuilleParJeu(),10);
    }
}