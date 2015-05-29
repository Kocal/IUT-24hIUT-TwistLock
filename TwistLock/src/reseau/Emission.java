package reseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc-Antoine
 */
public class Emission {

    private Socket socket = null;
    private PrintWriter out = null;

    public Emission(Socket socket) {
        this.socket = socket;

        try {
            this.out = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            System.err.println("Erreur : Recuperation du flux de sortie de la socket impossible.");
            Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void emettre(String message) {
        System.out.println("Emission : " + message);
        out.println(message);
        out.flush();
    }
}
