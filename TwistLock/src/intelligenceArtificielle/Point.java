/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intelligenceArtificielle;

import tablier.Coin;
import tablier.Conteneur;
import tablier.Tablier;

/**
 *
 * @author Aurélien
 */
public class Point {
    public int ligne;
    public int colonne;

    public Point() {
    }

    public Point(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }
    
    public String getChaine(Tablier t)
    {
        Coin[][] coins = t.getCoins();
        Coin c = coins[ligne][colonne];
        for(int i=0;i<t.getHauteur();i++)
        {
            for(int j=0;j<t.getLargeur();j++)
            {
                Conteneur cont = t.getConteneur(i, j);
                for(int k=0;k<cont.getCoins().size();k++)
                {
                    if(cont.getCoins().get(k) == c)
                    {
                        try {
                            return cont.getPositionAfficher(k+1);
                        }
                        catch (Exception ex) {
                            System.err.println(ex);
                        }
                    }
                }
            }
        }
        return "0A1";
    }
}
