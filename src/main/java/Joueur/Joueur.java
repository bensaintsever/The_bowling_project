package joueur;

import java.util.ArrayList;

/**
 * @author Benjamin Saint-Sever.
 *         Classe identifiant un joueur.
 */
public class Joueur {
    /**
     * Nom du joueur.
     */
    private final String nom_joueur;

    /**
     * Liste de coups joué par le joueur.
     */
    private ArrayList<Integer> listeCoups;

    /**
     * Constructeur de joueur.
     *
     * @param nom nom du joueur.
     */
    public Joueur(String nom) {
        this.nom_joueur = nom;
        this.listeCoups = new ArrayList<Integer>();
    }

    /**
     * Permet de recuperer le nom du joueur.
     *
     * @return le nom du joueur.
     */
    public String getNomJoueur() {
        return nom_joueur;
    }

    /**
     * Permet de recuperer la liste des coups joué.
     *
     * @return la liste des coups joué.
     */
    public ArrayList<Integer> getListeCoups() {
        return listeCoups;
    }

    /**
     * Permet d'ajouter les coups d'un jeu dans la liste des coups effectué
     * par le joueur.
     *
     * @param lancer1 coup 1 du joueur.
     * @param lancer2 coup 2 du joueur.
     */
    public void ajouterCoup(int lancer1, int lancer2) {
        this.listeCoups.add(lancer1);
        this.listeCoups.add(lancer2);
    }

}