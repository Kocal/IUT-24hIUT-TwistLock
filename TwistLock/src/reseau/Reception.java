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

public class Reception implements Runnable{

    private Socket socket = null;
    private BufferedReader in;
    private String message = null;
    private String trame = null;
	
    public Reception(Socket socket){
        
        this.socket = socket;
        
        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    @Override
    public void run() {

        while(true){
            try {

                message = in.readLine();
                System.out.println("Le serveur vous dit :" + message);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
    
    public String getTrame() {
        return trame;
    }
}