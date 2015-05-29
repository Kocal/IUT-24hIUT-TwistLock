/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intelligenceArtificielle;

/**
 *
 * @author Emilien
 */
public class Joueur {
    
    enum color{vert, rouge};
    
    public static final int nbCoupMax = 20;
    public int nbCoup = 0;
    public color couleur;
    
    Joueur(){
        this.couleur = color.vert;
    }
    
    Joueur(color col){
        this.couleur = col;
    }
}
