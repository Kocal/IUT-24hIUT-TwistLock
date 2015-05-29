package reseau;

import intelligenceArtificielle.IA;
import twistlock.Constante.Couleur;


/**
 *
 * @author Arnaud
 */
public class Traitement {

    String message = null;
    String code = null;
    
    private IA ia;

    public Traitement(String messageRecu) {
        message = messageRecu;
        code = message.substring(0, 2);

        System.out.println("Code du dernier message recu : " + code);
        
        String team;

        switch (code) {
          case "1-":
                
                team = messageRecu.substring(10);
                
                if(team == "Chicken Brothers") {
                    
                    if(messageRecu.contains("VERT"))
                        ia = new IA(Couleur.VERT);
                    
                    if(messageRecu.contains("ROUGE"))
                        ia = new IA(Couleur.ROUGE);
                    
                }
                //System.out.println(">>> " + );
                
                
                // "Bonjour équipe 1..."
                // Appeller fonction qui définie la couleur avec en paramètre ROUGE
                
                /*
                
                NOUS = ChickenBrothers tmtc
                
                if(équipe1 == NOUS)
                     IA ia = new IA(ROUGE);
                */
                
                break;

            case "2-":
                
                team = messageRecu.substring(10);
                
                if(team == "Chicken Brothers") {
                    
                    if(messageRecu.contains("VERT"))
                        ia = new IA(Couleur.VERT);
                    
                    if(messageRecu.contains("ROUGE"))
                        ia = new IA(Couleur.ROUGE);
                    
                }

                
                //ia.setEtatPartie(EtatPartie.BATAILLE);
                
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
