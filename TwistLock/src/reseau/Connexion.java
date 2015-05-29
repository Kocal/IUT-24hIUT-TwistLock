package reseau;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnaud
 */
public class Connexion {

    private Socket socket = null;

    private Scanner scan = null;
    private String adresseIp = null;
    private String numeroPort = null;

    public Connexion() {
        scan = new Scanner(System.in);

        System.out.println("Adresse IP du serveur ?");
        adresseIp = scan.nextLine();
        System.out.println("Numero de port du serveur ?");
        numeroPort = scan.nextLine();
        try {
            System.out.println("Connexion au serveur (" + adresseIp + ":" + numeroPort + ") en cours...");
            socket = new Socket(adresseIp, Integer.parseInt(numeroPort));
            System.out.println("Connexion réussie.");

            Emission emission = new Emission(socket);
            emission.emettre("Chicken Brothers");

            Thread threadReception = new Thread(new Reception(socket));
            threadReception.start();

            while (true);

        } catch (UnknownHostException ex) {
            System.err.println("Erreur : impossible de se connecter au serveur d'adresse " + adresseIp + ".");
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.err.println("Erreur : aucun serveur à l'écoute du port " + numeroPort + ".");
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
