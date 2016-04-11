package bowling;

import jeu.DernierJeu;
import jeu.Jeu;
import jeu.Score;
import joueur.Joueur;

/**
 * Classe de lancement.
 */
final class Bowling {

    /**
     * Sera le joueur qui jouera au bowling.
     */
    private Joueur joueur;

    /**
     * Constructeur de la classe Bowling
     */
    public Bowling(Joueur j) {
        this.joueur = j;
    }













    /**
     * Méthode main de l'application.
     *
     * @param args paramètres donnés lors du lancement de l'application.
     */
    public static void main(final String[] args) {
        new Joueur("Tom");
        Score score = new Score();

        final int nbJeu = 10;
        for (int i = 0; i < nbJeu - 1; i++) {
            Jeu jeu = new Jeu();
            try {
                final int coup1 = 10;
                final int coup2 = 0;
                jeu.jouer(coup1, coup2);
                score.ajouterJeu(jeu);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



        final int coup1 = 10;
        final int coup2 = 2;
        final int coup3 = 4;
        DernierJeu dj = new DernierJeu();
        try {
            dj.jouer(coup1, coup2, coup3);
            score.ajouterDernierJeu(dj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(score.getVal() + " " + score.getScore());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            final int coup1 = 4;
            final int coup2 = 2;
            jeu.jouer(coup1, coup2);
            System.out.println(jeu.getNombreQuilleTombe());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
