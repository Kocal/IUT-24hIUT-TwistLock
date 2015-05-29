package reseau;

import intelligenceArtificielle.IA;
import tablier.Tablier;
import twistlock.Constante.Couleur;

/**
 *
 * @author Arnaud
 */
public class Traitement {

    String message = null;
    String code = null;

    private IA ia = null;

    private tablier.Tablier tablier;

    public Traitement(String messageRecu) {
        message = messageRecu;
        code = message.substring(0, 2);

        System.out.println("Code du dernier message recu : " + code);

        String team;

        switch (code) {
            case "1-":
                ia = new IA(Couleur.ROUGE);
                break;

            case "2-":
                ia = new IA(Couleur.VERT);
                break;

            case "01":
                // Attente du prochain message qui commence par MAP
                // if (MAP)
                // Appeller la fonction d'initialisation de la map
                String msg = "M" + messageRecu.split("M")[1];
                msg = msg.substring(0, msg.length() - 1);

                System.out.println(msg);

                this.tablier = new Tablier(msg);

                System.out.println(this.tablier);

                break;

            case "10":
                // "A vous de jouer"
                // On joue le meilleur coup

                Emission.emettre(ia.getMeilleurCoin().getChaine(ia.t));

                break;

            case "20":

                Couleur couleur = null;

                if (ia.col == Couleur.VERT) {
                    // Nous vert
                    couleur = Couleur.ROUGE;
                } else {
                    couleur = Couleur.VERT;
                }

                message = message.split(":")[2];

                ia.t.mettreAJourPositionEnnemi(message, couleur);

            case "21":

                //"coup joué illégal"
                // perte twist lock courant
                // perte twist lock pénalité
                break;

            case "22":

                //"coup adversaire illégal"
                // bah...
                break;

            case "50":

                // "partie terminé"
                //coupé connexion
                break;

            case "91":

                //non valide
                break;

            default:
                System.out.println("Erreur : code non reconnu [" + code + "]");
                break;
        }
    }

    public Tablier getTablier() {
        return this.tablier;
    }

    public void setTablier(Tablier t) {
        this.tablier = t;
    }
}
