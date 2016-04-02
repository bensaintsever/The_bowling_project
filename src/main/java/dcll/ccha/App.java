package dcll.ccha;

import jeu.Jeu;
import joueur.Joueur;

/**
 * Classe de lancement.
 */
public final class App {

    /**
     * Méthode main de l'application.
     * @param args paramètres donnés lors du lancement de l'application.
     */
    public static void main(final String[] args) {
        new Joueur("Tom");
        Jeu jeu = new Jeu();
        try {
            jeu.jouer(4,2);
            System.out.println(jeu.getNombreQuilleTombe());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructeur de la classe App pour que checkstyle soit content.
     * Le constructeur est privé car instancier la classe App n'a pas de sens :
     * En effet celle-çi ne contient que la méthode main (static)
     */
    private App() {
    }
}
