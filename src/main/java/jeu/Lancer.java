package jeu;

/**
 * @author Thomas Guillou.
 *         Classe représentant un lancé simple de boule.
 */
public class Lancer {
    /**
     * Nombre de quilles debout à l'initialisation.
     */
    private int nbrQuilleDebout;

    /**
     * Nombre de quilles qui tomberont lors du lancé.
     */
    private int nbrQuilleTombe;

    /**
     * Constructeur d'un lancer.
     * <p>
     * ATTENTION : nombreQuilleDepart doit être supérieur ou égale à
     * nombreQuilleTombe
     * (nombreQuilleDepart >= nombreQuilleTombe)
     * ATTENTION : nombreQuilleDepart doit être strictement positif
     * (nombreQuilleDepart > 0)
     *
     * @param nombreQuilleDepart nombre de quilles debout avant le lancer.
     * @param nombreQuilleTombe  nombre de quilles qui tomberont lors du lancer.
     * @throws Exception génere une exception lorsque les paramètres de ne
     *                   sont pas conformes.
     */
    public Lancer(final int nombreQuilleDepart, final int nombreQuilleTombe)
            throws
            Exception {
        if (nombreQuilleDepart < nombreQuilleTombe) {
            throw new Exception("Le nombre de quille debout doit être "
                    + "supérieur ou égale au nombre de quilles tombés");
        }
        if (nombreQuilleDepart <= 0) {
            throw new Exception("Le nombre de quille debout doit être "
                    + "supérieur ou égale à 0");
        }
        this.nbrQuilleDebout = nombreQuilleDepart;
        this.nbrQuilleTombe = nombreQuilleTombe;
    }

    /**
     * Cette méthode effectue le lancement d'une boule.
     *
     * @return Renvoie le nombre de quille restante après le lancer.
     */
    public final int lance() {
        return nbrQuilleDebout - nbrQuilleTombe;
    }
}

