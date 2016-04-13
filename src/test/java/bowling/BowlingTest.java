package bowling;

import joueur.Joueur;
import junit.framework.TestCase;

/**
 * Classe de test de la classe Bowling
 * @author Thomas GUILLOU
 */
public class BowlingTest extends TestCase {

    private Bowling bowl;
    private Joueur joueur;

    public void setUp() throws Exception {
        super.setUp();
        joueur = new Joueur("Tom");
        bowl = new Bowling(joueur);
    }

    public void testDemarrerPartie() throws Exception {
        try {
            bowl.demarrerPartie();
        } catch (Exception e) {
            assertEquals(e.toString(),"java.lang.Exception: "
                    + "Le joueur n'a pas entré tous ses coups");
        }

        joueur.ajouterCoup(0,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        try {
            bowl.demarrerPartie();
        } catch (Exception e) {
            assertEquals(e.toString(),"java.lang.Exception: "
                    + "Le joueur n'a pas entré tous ses coups");
        }
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        joueur.ajouterDernierCoup(10,10,10);

        bowl.demarrerPartie();
        assertEquals(bowl.toString(),
                "Tom : \n__X__X__X__X__XXX\na obtenu 70 points");
    }

    public void testToString() throws Exception {


        assertEquals(bowl.toString(),"Tom : problème avec le résultat");

        joueur.ajouterCoup(0,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,0);
        joueur.ajouterDernierCoup(10,10,10);

        bowl.demarrerPartie();
        assertEquals(bowl.toString(),
                "Tom : \n__X__X__X__X__XXX\na obtenu 70 points");

        joueur = new Joueur("Toto2");
        joueur.ajouterCoup(5,5);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(7,3);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(0,7);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(1,1);
        joueur.ajouterCoup(10,0);
        joueur.ajouterCoup(10,0);
        joueur.ajouterDernierCoup(10,10,10);

        bowl = new Bowling(joueur);
        bowl.demarrerPartie();
        assertEquals(bowl.toString(),
                "Toto2 : \n5/X7/X_7X11XXXXX\na obtenu 188 points");
    }
}
