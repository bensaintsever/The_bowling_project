package bowling;

import jeu.DernierJeu;
import jeu.Jeu;
import jeu.ReglesDuJeu;
import jeu.Score;
import joueur.Joueur;

import java.util.Iterator;

/**
 * Classe de lancement.
 */
final class Bowling {

    /**
     * Sera le joueur qui jouera au bowling.
     */
    private final Joueur joueur;

    /**
     * Variable score contient le score de la partie.
     */
    private final Score score;

    /**
     * Constructeur de la classe Bowling.
     * La liste contenu dans joueur sera initialisé au préalable.
     * @param j Joueur qui joue au bowling.
     */
    Bowling(final Joueur j) {
        this.joueur = j;
        this.score = new Score();
    }

    /**
     * Méthode qui démarre une partie.
     * @throws Exception lève une exception en cas de problème
     */
    public void demarrerPartie() throws Exception {
        Iterator<Integer> iter = this.joueur.getListeCoups().iterator();
        for (int i = 0; i < ReglesDuJeu.getNombreDeJeu() - 1; i++) {
            Jeu jeu = new Jeu();
            jeu.jouer(iter.next(), iter.next());
            score.ajouterJeu(jeu);
        }
        DernierJeu dj = new DernierJeu();
        dj.jouer(iter.next(), iter.next(), iter.next());
        score.ajouterDernierJeu(dj);
    }

    /**
     * Méthode qui affiche le score de la partie.
     * @throws Exception Lève une exception si la partie n'est pas terminée.
     */
    public void afficherScore() throws Exception {
        System.out.println(joueur.getNomJoueur() + " : \n" + score.getVal()
                + "\na obtenu " + score.getScore() + " points");
    }

    /**
     * Méthode main de l'application.
     *
     * @param args paramètres donnés lors du lancement de l'application.
     */
    public static void main(final String[] args) {
        Joueur j = new Joueur("Tom");
        /*j.ajouterCoup(2, 5);
        j.ajouterCoup(7, 3);
        j.ajouterCoup(5, 5);
        j.ajouterCoup(1, 0);
        j.ajouterCoup(0, 0);
        j.ajouterCoup(4, 6);
        j.ajouterCoup(10, 0);
        j.ajouterCoup(10, 0);
        j.ajouterCoup(10, 0);
        j.ajouterDernierCoup(5, 5, 5);*/


        Bowling b = new Bowling(j);

        try {
            b.demarrerPartie();
            b.afficherScore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
