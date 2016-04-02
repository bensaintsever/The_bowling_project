package jeu;

import junit.framework.TestCase;

/**
 * @author Benjamin Saint-Sever
 */
public class LancerTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();

    }

    public void testLance() throws Exception {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                int nbquilleRestante = (new Lancer(i,j).lance());
                if(nbquilleRestante != (i-j))
                    assertTrue(false);
            }
        }
        assertTrue(true);
    }

}