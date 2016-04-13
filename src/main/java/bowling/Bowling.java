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
     * @throws Exception Si le joueur n'a pas entré tous ses coups
     */
    public void demarrerPartie() throws Exception {
        if (joueur.getListeCoups().size()
                != ReglesDuJeu.getNombreDeJeu() * 2 + 1) {
            // + 1 car le dernierCoup possède un coup de plus
            throw new Exception("Le joueur n'a pas entré tous ses coups");
        }

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
     */
    @Override
    public String toString() {
        try {
           return (joueur.getNomJoueur() + " : \n" + score.getVal()
                    + "\na obtenu " + score.getScore() + " points");
        } catch (Exception e) {
            return joueur.getNomJoueur() + " : problème avec le résultat";
        }
    }
}
