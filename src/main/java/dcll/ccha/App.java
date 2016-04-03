package dcll.ccha;

import jeu.Jeu;
import jeu.Score;
import joueur.Joueur;

/**
 * Classe de lancement.
 */
public final class App {

    /**
     * Constructeur de la classe App pour que checkstyle soit content.
     * Le constructeur est privé car instancier la classe App n'a pas de sens :
     * En effet celle-çi ne contient que la méthode main (static)
     */
    private App() {
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
        for (int i = 0; i < nbJeu; i++) {
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
