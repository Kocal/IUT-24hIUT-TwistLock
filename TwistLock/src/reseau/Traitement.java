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
                // Appeller fonction qui définie la couleur avec en paramètre ROUGE
                break;

            case "2-":
                // Appeller fonction qui définie la couleur avec en paramètre VERT
                break;

            case "01":
                // Attente du prochain message qui commence par MAP
                // if (MAP)
                // Appeller la fonction d'initialisation de la map
                break;

            default:
                System.out.println("Erreur : code non reconnu [" + code + "]");
                break;
        }
    }
}
