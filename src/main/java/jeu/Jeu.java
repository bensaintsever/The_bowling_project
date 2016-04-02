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
    private final int nombreQuilleDepart = 10;

    //private Comptage coup;
    /**
     * Contient le nombre de quilles tombées lors de l'ensemble des lancers
     * effectués.
     */
    private int nombreQuilleTombe;

    /**
     * Méthode qui effectue un jeu normal, c'est à dire deux lancers.
     * La valeur de chaque coups doit être entre 0 et le nombreQuilleDepart.
     * (0 <= coup <= nombreQuilleDepart)
     * La somme des coups doit être également entre 0 et le
     * nombreQuilleDepart. (0 <= coup1+coup2 <= NombreQuilleDepart)
     * <p>
     * ATTENTION : Si le premier coup (coup1) à pour valeur le
     * nombreQuilleDepart,
     * le deuxième coup ne sera pas effectué car le joueur aura effectué un
     * strike.
     *
     * @param coup1 nombre de quilles tombées lors du premier coup.
     * @param coup2 nombre de quilles tombées lors du deuxième coup.
     * @throws Exception genere une exception si les valeurs des coups ne
     *                   sont pas conformes.
     */
    public final void jouer(final int coup1, final int coup2) throws Exception {
        if (coup1 + coup2 < 0 || coup1 + coup2 > nombreQuilleDepart) {
            throw new Exception("La somme des coups jouées doit être entre 0 "
                    + "et " + nombreQuilleDepart);
        }
        if (coup1 < 0 || coup1 > nombreQuilleDepart) {
            throw new Exception("Le coup1 doit avoir une valeur entre 0 et "
                    + nombreQuilleDepart);
        }
        if (coup2 < 0 || coup2 > nombreQuilleDepart) {
            throw new Exception("Le coup2 doit avoir une valeur entre 0 et "
                    + nombreQuilleDepart);
        }

        // LANCER DU COUP1
        Lancer l = new Lancer(nombreQuilleDepart, coup1);
        int nombreQuilleRestant = l.lance();

        if (nombreQuilleRestant == 0) {
            //this.coup = Comptage.STRIKE;
            this.nombreQuilleTombe = nombreQuilleDepart;
            return;
        }
        this.nombreQuilleTombe = nombreQuilleRestant;

        // LANCER DU COUP2
        l = new Lancer(nombreQuilleRestant, coup2);
        nombreQuilleRestant = l.lance();

        if (nombreQuilleRestant == 0) {
            //this.coup = Comptage.SPARE;
            return;
        }

        //this.coup = Comptage.TROU;
        this.nombreQuilleTombe = nombreQuilleDepart - nombreQuilleRestant;
    }

   /* public Comptage getComptage()
    {
        return coup;
    }
    */

    /**
     * Accesseur get du nombre de quille tombés lors du jeu (variable
     * nombreQuilleTombe).
     *
     * @return le nombre de quille tombé lors du jeu.
     */
    public final int getNombreQuilleTombe() {
        return nombreQuilleTombe;
    }

    /**
     * Accesseur get du nombre de quille du départ.
     *
     * @return nombre de quille de départ.
     */
    public final int getNombreQuilleDepart() {
        return nombreQuilleDepart;
    }
}
