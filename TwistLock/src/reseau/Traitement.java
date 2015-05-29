package reseau;

/**
 *
 * @author Arnaud
 */
public class Traitement {

    String message = null;
    String code = null;

    public Traitement(String messageRecu) {
        message = messageRecu;
        code = message.substring(0, 2);

        System.out.println("Code du dernier message recu : " + code);

        switch (code) {
            case "1-":
                // "Bonjour équipe 1..."
                // Appeller fonction qui définie la couleur avec en paramètre ROUGE
                break;

            case "2-":
                // "Bonjour équipe 2..."
                // Appeller fonction qui définie la couleur avec en paramètre VERT
                break;

            case "01":
                // Attente du prochain message qui commence par MAP
                // if (MAP)
                // Appeller la fonction d'initialisation de la map
                break;

            case "10":
                // "A vous de jouer"
                // On joue le meilleur coup
                break;

            case "20":
                    // "Coup adversaire"
                //Mettre à jour la grille
                break;
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
}
