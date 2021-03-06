package jeu;

/**
 * @author Thomas Guillou
 *         Classe qui effectue un jeu de bowling, c'est à dire un ou deux
 *         lancer.
 * @version 1.0
 */
public class Jeu {


    /**
     * Variable constante qui définie le nombre de quille debout au début de
     * chaques jeux.
     */
    private static final int NOMBRE_QUILLE_DEPART = 10;

    /**
     * Objet permettant de connaître l'état d'avancement du jeu.
     */
    private Coup coup = Coup.AUCUN_LANCER;

    /**
     * Contient le nombre de quilles tombées lors du premier coup.
     */
    private int nombreQuilleTombeCoup1 = 0;

    /**
     * Contient le nombre de quilles tombées lors du deuxième coup.
     */
    private int nombreQuilleTombeCoup2 = 0;

    /**
     * Méthode qui effectue un jeu normal, c'est à dire deux lancers.
     * La valeur de chaque coups doit être entre 0 et le NOMBRE_QUILLE_DEPART.
     * (0 <= coup <= NOMBRE_QUILLE_DEPART)
     * La somme des coups doit être également entre 0 et le
     * NOMBRE_QUILLE_DEPART. (0 <= coup1+coup2 <= NombreQuilleDepart)
     * <p>
     * ATTENTION : Si le premier coup (coup1) à pour valeur le
     * NOMBRE_QUILLE_DEPART,
     * le deuxième coup ne sera pas effectué car le joueur aura effectué un
     * strike.
     *
     * @param coup1 nombre de quilles tombées lors du premier coup.
     * @param coup2 nombre de quilles tombées lors du deuxième coup.
     * @throws Exception genere une exception si les valeurs des coups ne
     *                   sont pas conformes.
     */
    public final void jouer(final int coup1, final int coup2) throws Exception {
        if (coup1 + coup2 < 0 || coup1 + coup2 > NOMBRE_QUILLE_DEPART) {
            throw new Exception("La somme des coups jouées doit être entre 0 "
                    + "et " + NOMBRE_QUILLE_DEPART);
        }
        if (coup1 < 0 || coup1 > NOMBRE_QUILLE_DEPART) {
            throw new Exception("Le coup1 doit avoir une valeur entre 0 et "
                    + NOMBRE_QUILLE_DEPART);
        }
        // Ici inutile de tester (coup2 > NOMBRE_QUILLE_DEPART)
        // Car ce cas est traité dans les tests précédent.
        if (coup2 < 0) {
            throw new Exception("Le coup2 doit avoir une valeur entre 0 et "
                    + NOMBRE_QUILLE_DEPART);
        }

        this.nombreQuilleTombeCoup1 = 0;
        this.nombreQuilleTombeCoup2 = 0;

        // LANCER DU COUP1
        Lancer l = new Lancer(NOMBRE_QUILLE_DEPART, coup1);
        int nombreQuilleRestant = l.lance();

        if (nombreQuilleRestant == 0) {
            this.coup = Coup.STRIKE;
            this.nombreQuilleTombeCoup1 = NOMBRE_QUILLE_DEPART;
            return;
        }
        this.nombreQuilleTombeCoup1 = NOMBRE_QUILLE_DEPART
                - nombreQuilleRestant;


        // LANCER DU COUP2
        l = new Lancer(nombreQuilleRestant, coup2);
        nombreQuilleRestant = l.lance();

        this.nombreQuilleTombeCoup2 = NOMBRE_QUILLE_DEPART - nombreQuilleRestant
                - nombreQuilleTombeCoup1;

        if (nombreQuilleRestant == 0) {
            this.coup = Coup.SPARE;
            return;
        }

        this.coup = Coup.TROU;
    }

    /**
     * Accesseur get de coup effectué durant ce jeu.
     *
     * @return Le coup (STRIKE,SPARE ou TROU (ou AUCUN_LANCER)) effectué.
     */
    public final Coup getCoup() {
        return this.coup;
    }


    /**
     * Accesseur get du nombre de quille tombés lors du premier coup
     * (variable nombreQuilleTombeCoup1).
     *
     * @return le nombre de quille tombé lors du premierCoup.
     */
    public final int getNombreQuilleTombeCoup1() {
        return nombreQuilleTombeCoup1;
    }

    /**
     * Accesseur get du nombre de quille tombés lors du deuxième coup
     * (variable nombreQuilleTombeCoup2).
     *
     * @return le nombre de quille tombé lors du deuxièmeCoup.
     */
    public final int getNombreQuilleTombeCoup2() {
        return nombreQuilleTombeCoup2;
    }

    /**
     * Accesseur get du nombre de quille tombés lors du jeu.
     *
     * @return la somme des quilles tombées lors du jeu.
     */
    public final int getNombreQuilleTombeTotale() {
        return nombreQuilleTombeCoup1 + nombreQuilleTombeCoup2;
    }

    /**
     * Accesseur get du nombre de quille du départ.
     *
     * @return nombre de quille de départ.
     */
    public final int getNombreQuilleDepart() {
        return NOMBRE_QUILLE_DEPART;
    }
}
