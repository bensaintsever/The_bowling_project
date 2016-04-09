package jeu;

/**
 * @author Thomas Guillou
 * @author Benjamin Saint-Sever
 *         Classe qui effectue un jeu de bowling, c'est à dire un ou deux
 *         lancer.
 * @version 1.0
 */
public class DernierJeu {


    /**
     * Le coup numéro 1 permettant de connaître l'état d'avancement du jeu.
     */
    private Coup coup1;

    /**
     * Le coup numéro 2  permettant de connaître l'état d'avancement du jeu.
     */
    private Coup coup2;

    /**
     * Le coup numéro 3 permettant de connaître l'état d'avancement du jeu.
     */
    private Coup coup3;

    /**
     * Contient le nombre de quilles tombées lors de l'ensemble des lancers
     * effectués.
     */
    private int nombreQuilleTombe;


    /**
     * Constructeur de Jeu.
     */
    public DernierJeu() {
        this.coup1 = Coup.AUCUN_LANCER;
        this.coup2 = Coup.AUCUN_LANCER;
        this.coup3 = Coup.AUCUN_LANCER;
        this.nombreQuilleTombe = 0;
    }


    /**
     * Méthode qui effectue un jeu normal, c'est à dire deux lancers.
     * La valeur de chaque coups doit être entre 0 et le ReglesDuJeu.getNombreDeQuilleParJeu(.
     * (0 <= coup <= ReglesDuJeu.getNombreDeQuilleParJeu()
     * La somme des coups doit être également entre 0 et le
     * ReglesDuJeu.getNombreDeQuilleParJeu(. (0 <= coup1+coup2 <= NombreQuilleDepart)
     * <p>
     * ATTENTION : Si le premier coup (coup1) à pour valeur le
     * ReglesDuJeu.getNombreDeQuilleParJeu(,
     * le deuxième coup ne sera pas effectué car le joueur aura effectué un
     * strike.
     *
     * @param coup1 nombre de quilles tombées lors du premier coup.
     * @param coup2 nombre de quilles tombées lors du deuxième coup.
     * @throws Exception genere une exception si les valeurs des coups ne
     *                   sont pas conformes.
     */
    public final void jouer(final int coup1, final int coup2)
            throws
            Exception {
        if (coup1 + coup2 < 0 || coup1 + coup2 > ReglesDuJeu.getNombreDeQuilleParJeu()) {
            throw new Exception("La somme des coups jouées doit être entre 0 "
                    + "et " + ReglesDuJeu.getNombreDeQuilleParJeu());
        }
        if (coup1 < 0 || coup1 > ReglesDuJeu.getNombreDeQuilleParJeu()) {
            throw new Exception("Le coup1 doit avoir une valeur entre 0 et "
                    + ReglesDuJeu.getNombreDeQuilleParJeu());
        }
        // Ici inutile de tester (coup2 > ReglesDuJeu.getNombreDeQuilleParJeu()
        // Car ce cas est traité dans les tests précédent.
        if (coup2 < 0) {
            throw new Exception("Le coup2 doit avoir une valeur entre 0 et "
                    + ReglesDuJeu.getNombreDeQuilleParJeu());
        }


        /* Jeu classique jusqu'a au jeu numéro 10 */

            /* COUP 1 */
        lancerCoup1(coup1);
        if (this.coup1 == Coup.STRIKE)
            return;

            /* COUP 2 */
        lancerCoup2(coup2);

    }

    /**
     * Méthode qui effectue un jeu spécial, c'est à dire trois lancers.
     * La valeur de chaque coups doit être entre 0 et le ReglesDuJeu.getNombreDeQuilleParJeu(.
     * (0 <= coup <= ReglesDuJeu.getNombreDeQuilleParJeu()
     * La somme des coups doit être également entre 0 et le
     * ReglesDuJeu.getNombreDeQuilleParJeu(. (0 <= coup1+coup2 <= NombreQuilleDepart)
     * <p>
     * ATTENTION : Si le premier coup (coup1) à pour valeur le
     * ReglesDuJeu.getNombreDeQuilleParJeu(,
     * le deuxième coup ne sera pas effectué car le joueur aura effectué un
     * strike.
     *
     * @param coup1 nombre de quilles tombées lors du premier coup.
     * @param coup2 nombre de quilles tombées lors du deuxième coup.
     * @param coup3 nombre de quilles tombées lors du troisième
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



                /* Jeu spécial au 10 eme jeu */

        lancerCoup1(coup1);
        if (this.coup1 == Coup.STRIKE) {
            this.nombreQuilleTombe = 0;
            lancerCoup2(coup2);
            if (this.coup2 == Coup.STRIKE)
                this.nombreQuilleTombe = 0;
            lancerCoup3(coup3);
            if (this.coup2 != Coup.STRIKE) {
                if ((coup2 + coup3) > ReglesDuJeu.getNombreDeQuilleParJeu()) {
                    throw new Exception("Les coups 2 et 3, ne respectent pas "
                            + "les " + "regles");
                }
            }

        } else {
            if ((coup1 + coup2) > ReglesDuJeu.getNombreDeQuilleParJeu()) {
                throw new Exception("Les coups 1 et 2, ne respectent pas "
                        + "les " + "regles");
            }
            lancerCoup2(coup2);

            if (this.coup2 == Coup.SPARE) {
                this.nombreQuilleTombe = 0;
                lancerCoup3(coup3);
            }

        }
    }

    /**
     * Lancement du coup numéro 1.
     * @param coup1 coup numéro 1.
     */
    private void lancerCoup1(int coup1) {

        try {
            Lancer l = new Lancer(ReglesDuJeu.getNombreDeQuilleParJeu(), coup1);

            int nombreQuilleRestant = l.lance();

            if (nombreQuilleRestant == 0) {
                this.coup1 = Coup.STRIKE;
                this.nombreQuilleTombe = ReglesDuJeu.getNombreDeQuilleParJeu();
            } else {
                this.nombreQuilleTombe = nombreQuilleRestant;

                if (nombreQuilleRestant == ReglesDuJeu
                        .getNombreDeQuilleParJeu())
                    this.coup1 = Coup.TROU;
            }
        } catch (Exception e) {
            System.out.println("lancerCoup1");
        }
    }

    /**
     * Lancement du coup numéro 2.
     * @param coup2 coup numéro 2.
     */
    private void lancerCoup2(int coup2) {
        try {
            int nombreQuilleRestanteCoup1 = ReglesDuJeu.getNombreDeQuilleParJeu() - this
                    .nombreQuilleTombe;

            Lancer l = new Lancer(nombreQuilleRestanteCoup1,
                    coup2);

            int nombreQuilleRestanteCoup2 = l.lance();

            if (nombreQuilleRestanteCoup2 == 0) {
                this.coup2 = Coup.SPARE;
            }

            // SI LE NOMBRE DE QUILLES TOMBEE AU COUPS PRECEDENT N'A PAS CHANGER
            if (nombreQuilleRestanteCoup1 == nombreQuilleRestanteCoup2)
                this.coup2 = Coup.TROU;


            //NB DE QUILLE TOTAL TOMBEE
            this.nombreQuilleTombe += coup2;
        } catch (Exception e) {
            System.out.println("lancerCoup2");
        }
    }

    /**
     * Lancement du coup numéro 3.
     * @param coup3 coup numéro 3.
     */
    private void lancerCoup3(int coup3) {
        try {
            int nombreQuilleRestanteCoupPrecedent = ReglesDuJeu.getNombreDeQuilleParJeu() - this
                    .nombreQuilleTombe;

            Lancer l = new Lancer(nombreQuilleRestanteCoupPrecedent,
                    coup3);

            int nombreQuilleRestante = l.lance();

            if (nombreQuilleRestante == 0) {
                this.coup3 = Coup.SPARE;
            }

            // SI LE NOMBRE DE QUILLES TOMBEE AU COUPS PRECEDENT N'A PAS CHANGER
            if (nombreQuilleRestanteCoupPrecedent ==
                    nombreQuilleRestanteCoupPrecedent)
                this.coup3 = Coup.TROU;


            //NB DE QUILLE TOTAL TOMBE
            this.nombreQuilleTombe += coup3;
        } catch (Exception e) {
            System.out.println("lancerCoup3");
        }
    }

    /**
     * Accesseur get du premier coup effectué durant ce jeu.
     *
     * @return Le coup (STRIKE,SPARE ou TROU) effectué.
     */
    public final Coup getCoup1() {
        return this.coup1;
    }

    /**
     * Accesseur get du premier coup effectué durant ce jeu.
     *
     * @return Le coup (STRIKE,SPARE ou TROU) effectué.
     */
    public final Coup getCoup2() {
        return this.coup2;
    }

    public int getNombreCoups() {
        if (this.coup1 == Coup.AUCUN_LANCER)
            return 0;
        if (this.coup2 == Coup.AUCUN_LANCER)
            return 1;
        if (this.coup3 == Coup.AUCUN_LANCER)
            return 2;
        return 0;
    }


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
        return ReglesDuJeu.getNombreDeQuilleParJeu();
    }
}
