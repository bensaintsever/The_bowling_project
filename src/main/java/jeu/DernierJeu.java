package jeu;

/**
 * @author Thomas Guillou
 * @author Benjamin Saint-Sever
 *         Classe qui effectue un dernier jeu de bowling, c'est à dire deux
 *         ou trois lancer.
 * @version 1.0
 */
public class DernierJeu {


    /**
     * Le coup numéro 1 permettant de connaître l'état d'avancement du jeu.
     */
    private Jeu jeu1;

    /**
     * Le coup numéro 2  permettant de connaître l'état d'avancement du jeu.
     * Possible uniquement si le jeu précédent n'est pas un TROU
     */
    private Jeu jeu2;

    /**
     * Le coup numéro 3 permettant de connaître l'état d'avancement du jeu.
     * Possible uniquement si les deux jeu précédents sont des STRIKE
     */
    private Jeu jeu3;

    /**
     * Contient le nombre de quilles tombées lors du premier coup.
     */
    private int nombreQuilleTombeCoup1;

    /**
     * Contient le nombre de quilles tombées lors du deuxième coup.
     */
    private int nombreQuilleTombeCoup2;

    /**
     * Contient le nombre de quilles tombées lors du deuxième coup.
     */
    private int nombreQuilleTombeCoup3;


    /**
     * Constructeur de Jeu.
     */
    public DernierJeu() {
        this.nombreQuilleTombeCoup1 = 0;
        this.nombreQuilleTombeCoup2 = 0;
        this.nombreQuilleTombeCoup3 = 0;
    }

    /**
     * Accesseur get du Jeu 2.
     * @return le jeu 2.
     */
    public final Jeu getJeu2() {
        return jeu2;
    }

    /**
     * Accesseur get du Jeu 3.
     * @return le jeu 3.
     */
    public final Jeu getJeu3() {
        return jeu3;
    }

    /**
     * Accesseur get du Jeu 1.
     * @return le jeu 1.
     */
    public final Jeu getJeu1() {
        return jeu1;
    }

    /**
     * Méthode qui effectue un jeu spécial, c'est à dire trois lancers.
     * La valeur de chaque coups doit être entre 0 et le
     * ReglesDuJeu.getNombreDeQuilleParJeu().
     * (0 <= coup <= ReglesDuJeu.getNombreDeQuilleParJeu()
     * La somme des coups doit être également entre 0 et le
     * ReglesDuJeu.getNombreDeQuilleParJeu()
     * (0 <= coup1+coup2 <= NombreQuilleDepart)
     * <p>
     * ATTENTION : Si le premier coup (coup1) à pour valeur le
     * ReglesDuJeu.getNombreDeQuilleParJeu(,
     * le deuxième coup ne sera pas effectué car le joueur aura effectué un
     * strike.
     *
     * @param coup1 nombre de quilles tombées lors du premier coup.
     * @param coup2 nombre de quilles tombées lors du deuxième coup.
     * @param coup3 nombre de quilles tombées lors du troisième.
     *              coup.
     * @throws Exception genere une exception si les valeurs des coups ne
     *                   sont pas conformes.
     */
    public final void jouer(final int coup1, final int coup2, final int coup3)
            throws
            Exception {

        if (coup1 < 0 || coup1 > ReglesDuJeu.getNombreDeQuilleParJeu()) {
            throw new Exception("Le coups 1 ne respecte pas les regles");
        }
        if (coup2 < 0 || coup2 > ReglesDuJeu.getNombreDeQuilleParJeu()) {
            throw new Exception("Le coups 2 ne respecte pas les regles");
        }
        if (coup3 < 0 || coup3 > ReglesDuJeu.getNombreDeQuilleParJeu()) {
            throw new Exception("Le coups 3 ne respecte pas les regles");
        }

        if (coup1 == ReglesDuJeu.getNombreDeQuilleParJeu()) {
            this.jeu1 = new Jeu();
            this.jeu1.jouer(coup1, 0);
            if (coup2 == ReglesDuJeu.getNombreDeCoupsParJeu()) {
                this.jeu2 = new Jeu();
                this.jeu2.jouer(coup2, 0);
                if (coup3 == ReglesDuJeu.getNombreDeCoupsParJeu()) {
                    this.jeu3 = new Jeu();
                    this.jeu3.jouer(coup3, 0);
                }
            } else {
                this.jeu2 = new Jeu();
                this.jeu2.jouer(coup2, coup3);
            }
        } else {
            this.jeu1 = new Jeu();
            this.jeu1.jouer(coup1, coup2);
            if (this.jeu1.getCoup() == Coup.SPARE) {
                this.jeu2 = new Jeu();
                this.jeu2.jouer(coup3, 0);
            }
        }
    }



}
