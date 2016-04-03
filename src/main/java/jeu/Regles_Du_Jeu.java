package jeu;

/**
 * Classe permettant d'identifier les règles du jeu pour le jeu de bowling.
 *
 * @author Benjamin Saint-Sever
 */
public class Regles_Du_Jeu {

    /**
     * Nombre de frames/jeu pour un joueur, dans une partie.
     */
    private final int NOMBRE_DE_JEU = 10;

    /**
     * Nombre de coups par jeu.
     */
    private final int NOMBRE_DE_COUPS_PAR_JEU = 2;

    /**
     * Nombre de quille par jeu.
     */
    private final int NOMBRE_DE_QUILLE_PAR_JEU = 10;

    /**
     * Permet de recupérer le nombre de jeu dans une partie.
     *
     * @return le nombre de jeu.
     */
    public int getNombreDeJeu() {
        return NOMBRE_DE_JEU;
    }

    /**
     * Permet de recupérer le nombre de coups par jeu.
     *
     * @return le nombre de coups par jeu.
     */
    public int getNOMBRE_DE_COUPS_PAR_JEU() {
        return NOMBRE_DE_COUPS_PAR_JEU;
    }

    /**
     * Permet de recupérer le nombre de quille par jeu.
     *
     * @return le nombre de quille par jeu.
     */
    public int getNOMBRE_DE_QUILLE_PAR_JEU() {
        return NOMBRE_DE_QUILLE_PAR_JEU;
    }

}
