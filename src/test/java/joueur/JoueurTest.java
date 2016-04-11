package joueur;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * @author Thomas Guillou
 * Classe de test de la classe Joueur
 */
public class JoueurTest extends TestCase {

    /**
     * joueur de référence pour les tests
     */
    private Joueur joueur;

    /**
     * Méthode d'initialisation du Joueur
     * @throws Exception
     */
    public void setUp() throws Exception {
        super.setUp();
        joueur = new Joueur("Tom");
    }

    /**
    * Test sur la recupération du nom du Joueur.
    * @throws Exception
    */
    public void testGetNomJoueur() throws Exception {
        // Given
        String nomJoueur = "JoueurTest";
        Joueur j = new Joueur(nomJoueur);
        // When
        String nomJ = j.getNomJoueur();
        // Then
        assertEquals(nomJ, nomJoueur);
    }

    /**
     * Test sur la récupération de la liste de coup
     * @throws Exception
     */
    public void testGetListeCoups() throws Exception {
        // Given
        ArrayList<Integer> liste = new ArrayList<Integer>();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.add(4);
        // When
        joueur.ajouterCoup(1,2);
        joueur.ajouterCoup(3,4);
        ArrayList<Integer> listeResultat = joueur.getListeCoups();
        // Then
        assertEquals(listeResultat, liste);
    }

    /**
     * Test de la méthode d'ajout d'un coup
     * @throws Exception
     */
    public void testAjouterCoup() throws Exception {
        // Given
        joueur.ajouterCoup(1,2);
        // When
        ArrayList<Integer> listeResultat = joueur.getListeCoups();
        // Then
        assertEquals(listeResultat.get(0), new Integer(1));
        assertEquals(listeResultat.get(1), new Integer(2));
    }
}