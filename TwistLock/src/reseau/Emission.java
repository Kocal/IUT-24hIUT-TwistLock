/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc-Antoine
 */
public class Emission {
    
    private Socket socket;
    private PrintWriter out;
    private Scanner sc = null;
	
    public Emission(Socket socket) {
        this.socket = socket;
        
        try {
            this.out = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void emettre(String msg) {

        System.out.println("Emission : " + msg);
        out.println(msg);
        out.flush();
        
    } 
}