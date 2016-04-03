package jeu;

/**
 * @author Thomas Guillou
 * Enumération qui contient les différents coup possible lors d'un jeu.
 */
public enum Coup {
    /**
     * AUCUN_LANCER signifie que aucun coup n'a été joué pour l'instant.
     */
    AUCUN_LANCER,

    /**
     * TROU signifie que le joueur n'a pas fait tomber toutes les quilles
     * durant le jeu (donc avec ses deux lancers).
     */
    TROU,

    /**
     * SPARE signifie que le joueur a fait tomber toutes les quilles
     * durant son deuxième lancer.
     */
    SPARE,

    /**
     * STRIKE signifie que le joueur a fait tomber toutes les quilles
     * durant son premier lancer.
     */
    STRIKE
}
