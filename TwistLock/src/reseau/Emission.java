package reseau;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc-Antoine
 */
public class Emission {

    static DatagramSocket socket = null;
    static private InetAddress adresse = null;
    static int port = -1;

    public Emission(DatagramSocket socketServeur, InetAddress adresseServeur, int portServeur) {
        socket = socketServeur;
        adresse = adresseServeur;
        port = portServeur;
    }

    static public void emettre(String message) {
        System.out.println("Emission : " + message);

        byte buffer[] = message.getBytes();
        int length = message.length();

        try {
            DatagramPacket donneesEmises = new DatagramPacket(buffer, length, adresse, port);
            socket.send(donneesEmises);

            System.out.println("Message emis.");
        } catch (SocketException ex) {
            System.err.println("Erreur : socket d'emission bug.");
            afficherInformationsServeur();
            Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.err.println("Erreur : emission impossible.");
            afficherInformationsServeur();
            Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static private void afficherInformationsServeur() {
        System.out.println("Emission informations serveur - adresse : " + adresse + " - port : " + port);
    }
}
