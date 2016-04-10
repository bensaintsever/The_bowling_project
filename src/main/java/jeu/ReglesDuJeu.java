package jeu;

/**
 * Classe permettant d'identifier les règles du jeu pour le jeu de bowling.
 *
 * @author Benjamin Saint-Sever
 */
final class ReglesDuJeu {

    /**
     * Nombre de frames/jeu pour un joueur, dans une partie.
     */
    private static final int NOMBRE_DE_JEU = 10;

    /**
     * Nombre de coups par jeu.
     */
    private static final int NOMBRE_DE_COUPS_PAR_JEU = 2;

    /**
     * Nombre de quille par jeu.
     */
    private static final int NOMBRE_DE_QUILLE_PAR_JEU = 10;

    /**
     * Constructeur des règles du jeu.
     * Il est private car instancier une regle du jeu n'a pas de sens
     */
    private ReglesDuJeu() {
    }

    /**
     * Permet de recupérer le nombre de jeu dans une partie.
     *
     * @return le nombre de jeu.
     */
    public static int getNombreDeJeu() {
        return NOMBRE_DE_JEU;
    }

    /**
     * Permet de recupérer le nombre de coups par jeu.
     *
     * @return le nombre de coups par jeu.
     */
    public static int getNombreDeCoupsParJeu() {
        return NOMBRE_DE_COUPS_PAR_JEU;
    }

    /**
     * Permet de recupérer le nombre de quille par jeu.
     *
     * @return le nombre de quille par jeu.
     */
    public static int getNombreDeQuilleParJeu() {
        return NOMBRE_DE_QUILLE_PAR_JEU;
    }

}
