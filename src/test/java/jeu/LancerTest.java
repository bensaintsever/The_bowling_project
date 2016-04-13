package jeu;

import junit.framework.TestCase;

/**
 * Jeu de test pour la classe Lancer.
 *
 * @author Benjamin Saint-Sever.
 */
public class LancerTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();

    }

    public void testLance() throws Exception {
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= i; j++) {
                int nbquilleRestante = (new Lancer(i, j).lance());
                if (nbquilleRestante != (i - j)) {
                    assertTrue(false);
                }
            }
        }

        try{
            new Lancer(2,3).lance();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testLanceAvecAucuneQuille() throws Exception {
        try{
            new Lancer(0,0).lance();
            fail();
        }catch (Exception e){
            assertTrue(true);
        }
    }
}