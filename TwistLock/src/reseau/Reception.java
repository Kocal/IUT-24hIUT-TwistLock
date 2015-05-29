package reseau;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnaud
 */
public class Reception implements Runnable {

    private static final int TAILLE = 1024;

    static byte buffer[] = new byte[TAILLE];

    DatagramSocket socket = null;
    int port = -1;
    private String message = null;

    public Reception(DatagramSocket socketServeur, int portServeur) {
        socket = socketServeur;
        port = portServeur;
    }

    @Override
    public void run() {
        try {
            while (true) {
                message = null;

                /*for (int i = 0; i < buffer.length; i++) {
                 buffer[i] = '\0';
                 }*/
                buffer = new byte[TAILLE];

                DatagramPacket donneesRecues = new DatagramPacket(buffer, buffer.length);
                socket.receive(donneesRecues);

                message = new String(donneesRecues.getData());
                System.out.println("Reception : " + message);

                Traitement traitement = new Traitement(message);
            }
        } catch (IOException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
