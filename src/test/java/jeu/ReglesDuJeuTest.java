package jeu;

import junit.framework.TestCase;

/**
 * @author Thomas Guillou
 * Test pour la classe RegleDuJeu
 * Valable pour les règle officiel du jeu de bowling
 */
public class ReglesDuJeuTest extends TestCase {


    public final void testGetNombreDeJeu() throws Exception {
        assertEquals(ReglesDuJeu.getNombreDeJeu(),10);
    }

    public final void testGetNombreDeCoupsParJeu() throws Exception {
        assertEquals(ReglesDuJeu.getNombreDeCoupsParJeu(),2);
    }

    public final void testGetNombreDeQuilleParJeu() throws Exception {
        assertEquals(ReglesDuJeu.getNombreDeQuilleParJeu(),10);
    }
}