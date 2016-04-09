package jeu;

import java.util.ArrayList;

/**
 * @author Thomas Guillou.
 *         Classe Score permet de calculer le score totale d'une partie de
 *         bowling.
 */
public class Score {

    /**
     * Contient la liste des jeux effectués durant la partie.
     * Cette liste sera complété au fur et à mesure de la partie.
     */
    private ArrayList<Jeu> listeJeu;

    /**
     * Contient le dernier des jeux joués. Il est différencié
     * des autres jeux car il peut contenir trois lancer.
     */
    private DernierJeu dernierJeu;

    /**
     * Contient l'affichage du score durant la partie.
     * Exemple : 5/8_XX ... ou XX7_0_0_0_ .
     */
    private String val;

    /**
     * Constructeur de la classe Score.
     * Initialise les attributs.
     */
    public Score() {
        listeJeu = new ArrayList<Jeu>();
        val = "";
    }

    /**
     * Méthode qui ajoute à la liste des jeux le jeu en paramètre
     * L'affichage du score est mis à jour (uniquement le String val).
     *
     * @param j Jeu à ajouter à la liste.
     * @throws Exception génére une exception si le nombre de jeu a
     *                   atteint le max selon règleDuJeu.
     */
    public final void ajouterJeu(final Jeu j) throws Exception {
        if (listeJeu.size() == ReglesDuJeu.getNombreDeJeu()) {
            throw new Exception("La partie est terminée, "
                    + "pas de nouveau coup possible");
        }
        listeJeu.add(j);
        switch (j.getCoup()) {
            case TROU:
                val += j.getNombreQuilleTombeCoup1();
                val += j.getNombreQuilleTombeCoup2();
                break;
            case SPARE:
                val += j.getNombreQuilleTombeCoup1();
                val += "/";
                break;
            case STRIKE:
                val += "X";
                break;
            // Pour la convention, on rajoute un default
            default:
                break;
        }
    }

    /**
     * Méthode qui définit le dernier jeu.
     * L'affichage du score est mis à jour (uniquement le String val).
     *
     * @param j DernierJeu à ajouter
     * @throws Exception génére une exception si le nombre de jeu est
     *                   n'a pas atteint le max - 1
     */
    public final void ajouterDernierJeu(final DernierJeu j) throws Exception {
        if (listeJeu.size() != ReglesDuJeu.getNombreDeJeu() - 1) {
            throw new Exception("Impossible de rajouter"
                    + "un dernier coup en plein milieu de la partie");
        }
        dernierJeu = j;
        switch (j.getJeu1().getCoup()) {
            case TROU:
                val += j.getJeu1().getNombreQuilleTombeCoup1();
                val += j.getJeu1().getNombreQuilleTombeCoup2();
                return; // Pas le droit à un second jeu
            case SPARE:
                val += j.getJeu1().getNombreQuilleTombeCoup1();
                val += "/";
                break;
            case STRIKE:
                val += "X";
                break;
            // Pour la convention, on rajoute un default
            default:
                break;
        }
        switch (j.getJeu2().getCoup()) {
            case TROU:
                if (j.getJeu1().getCoup() == Coup.SPARE) {
                    val += j.getJeu2().getNombreQuilleTombeCoup1();
                    return;
                }
                val += j.getJeu2().getNombreQuilleTombeCoup1();
                val += j.getJeu2().getNombreQuilleTombeCoup2();
                return;
            case SPARE:
                val += j.getJeu2().getNombreQuilleTombeCoup1();
                val += "/";
                return;
            case STRIKE:
                val += "X";
                break;
            // Pour la convention, on rajoute un default
            default:
                break;
        }
        switch (j.getJeu3().getCoup()) {
            case TROU:
                val += j.getJeu3().getNombreQuilleTombeCoup1();
                return;
            case SPARE:
                // IMPOSSIBLE
                break;
            case STRIKE:
                val += "X";
                break;
            // Pour la convention, on rajoute un default
            default:
                break;
        }
    }

    /**
     * Calcul le score totale de la partie si celle-çi est terminée.
     *
     * @return le score calculé selon l'ensemble des jeux joués.
     * @throws Exception génére une exception si le nombre de jeu n'a pas
     *                   atteint le max selon règleDuJeu.
     */
    public final int getScore() throws Exception {
        if (listeJeu.size() != ReglesDuJeu.getNombreDeJeu()) {
            throw new Exception("La partie n'est pas terminée !");
        }

        int score = 0;
        final int dix = 10;
        final int neuf = 9;
        final int huit = 8;

        Jeu j;
        for (int i = 0; i < ReglesDuJeu.getNombreDeJeu(); i++) {
            j = listeJeu.get(i);
            switch (j.getCoup()) {
                case TROU:
                    score += j.getNombreQuilleTombeTotale();
                    break;

                case SPARE:
                    score += dix;
                    if (i < neuf) {
                        score += listeJeu.get(i + 1).
                                getNombreQuilleTombeTotale();
                    }
                    break;
                case STRIKE:
                    score += dix;
                    // Pour éviter les dépassement d'adresse mémoire (il y a
                    // pas une formulation plus simple ??)
                    if (i < neuf) {
                        score += listeJeu.get(i + 1).
                                getNombreQuilleTombeTotale();
                    }
                    if (i < huit) {
                        score += listeJeu.get(i + 2).
                                getNombreQuilleTombeTotale();
                    }
                    break;
                // Pour la convention, on rajoute un default
                default:
                    break;
            }
        }

        return score;
    }

    /**
     * Retourne l'affichage du score.
     *
     * @return un String contenant l'affichage du score actuel.
     */
    public final String getVal() {
        return val;
    }
}
