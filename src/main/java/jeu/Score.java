package jeu;

import java.util.ArrayList;

/**
 * @author Thomas Guillou
 * Classe Score permet de calculer le score totale d'une partie de bowling
 */
public class Score {
    /**
     * Contient la liste des jeux effectués durant la partie
     * Cette liste sera complété au fur et à mesure de la partie
     */
    private ArrayList<Jeu> listeJeu;

    /**
     * Contient l'affichage du score durant la partie
     * Exemple : 5/8_XX ... ou XX7_0_0_0_
     */
    private String val;

    /**
     * Constructeur de la classe Score
     * Initialise les attributs
     */
    public Score() {
        listeJeu = new ArrayList<Jeu>();
        val = "";
    }

    /**
     * Méthode qui ajoute à la liste des jeux le jeu en paramètre
     * L'affichage du score est mis à jour (uniquement le String val)
     * ATTENTION Si le nombre de jeu a atteint le max selon les règleDuJeu, une excepetion sera levée
     * @param j Jeu à ajouter à la liste
     */
    public void ajouterJeu(Jeu j) throws Exception {
        if (listeJeu.size() == ReglesDuJeu.getNombreDeJeu()) {
            throw new Exception("La partie est terminée, " +
                    "pas de nouveau coup possible");
        }
        listeJeu.add(j);
        switch (j.getCoup())
        {
            case TROU :
                val += j.getNombreQuilleTombe();
                val += "_";
                break;
            case SPARE :
                val += j.getNombreQuilleTombe();
                val += "/";
                break;
            case STRIKE :
                val += "X";
                break;
            // Pour la convention, on rajoute un default
            default:
                break;
        }
    }

    /**
     * Calcul le score totale de la partie si celle-çi est terminée
     * @return le score calculé selon l'ensemble des jeux joués.
     * ATTENTION Si le nombre de jeu n'a pas atteint le max selon les règleDuJeu, une exception sera levée
     */
    public int getScore() throws Exception {
        if (listeJeu.size() != ReglesDuJeu.getNombreDeJeu()) {
            throw new Exception("La partie n'est pas terminée !");
        }

        int score = 0;
        Jeu j;
        for ( int i = 0 ; i < ReglesDuJeu.getNombreDeJeu() ; i++ )
        {
            j=listeJeu.get(i);
            switch (j.getCoup())
            {
                case TROU :
                    score += j.getNombreQuilleTombe();
                    break;

                case SPARE :
                    score += 10;
                    if ( i < 9 )
                    {
                        score += listeJeu.get(i+1).getNombreQuilleTombe();
                    }
                    break;
                case STRIKE :
                    score += 10;
                    // Pour éviter les dépassement d'adresse mémoire (il y a pas une formulation plus simple ??)
                    if ( i < 9)
                        score += listeJeu.get(i+1).getNombreQuilleTombe();
                    if ( i < 8 )
                        score += listeJeu.get(i+2).getNombreQuilleTombe();
                    break;
                // Pour la convention, on rajoute un default
                default:
                    break;
            }
        }

        return score;
    }

    /**
     * Retourne l'affichage du score
     * @return un String contenant l'affichage du score actuel
     */
    public String getVal()
    {
        return val;
    }
}
