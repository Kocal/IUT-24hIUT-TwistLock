package reseau;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
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
            InetAddress serveur = InetAddress.getByName(adresseIp);
            System.out.println("Connexion réussie.");

            DatagramSocket socket = new DatagramSocket();

            Thread threadReception = new Thread(new Reception(socket, Integer.parseInt(numeroPort)));
            threadReception.start();

            Emission emission = new Emission(socket, serveur, Integer.parseInt(numeroPort));
            emission.emettre("Chicken Brothers");

            //172.30.7.16:9877
        } catch (UnknownHostException ex) {
            System.err.println("Erreur : impossible de se connecter au serveur d'adresse " + adresseIp + ".");
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
