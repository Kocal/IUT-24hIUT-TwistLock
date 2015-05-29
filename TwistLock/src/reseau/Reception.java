package reseau;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnaud
 */
public class Reception implements Runnable {

    private Socket socket = null;
    private BufferedReader in;
    private String message = null;

    public Reception(Socket socket) {
        this.socket = socket;

        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            System.err.println("Erreur : Recuperation du flux d'entrée de la socket impossible.");
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        message = null;

        try {
            while (!Thread.currentThread().isInterrupted() && (message = in.readLine()) != null) {
                System.out.println("Reception : " + message);
                Traitement traitement = new Traitement(message);
            }
        } catch (IOException ex) {
            System.err.println("Erreur : impossible de recevoir des message...");
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMessage() {
        return message;
    }
}
