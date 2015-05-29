package tablier;

/**
 *
 * @author Kocal
 */
public class Conteneur {
    public int ligne;
    public int colonne;
    public int valeur;
    
    public Conteneur(int ligne, int colonne, int valeur)
    {
        this.ligne=ligne;
        this.colonne=colonne;
        this.valeur=valeur;
    }
    
    public String getColonneAfficher(){
        return Character.toString((char)('A'+colonne));
    }
    
    public String getLigneAfficher(){
        return Integer.toString(ligne+1);
    }
    
    public String getPositionAfficher(int coin) throws Exception
    {
        if(coin<1 || coin>4)
        {
            throw new Exception("Erreur : Le numéro de coin doit être dans l'intervalle 1-4");
        }
        return this.getLigneAfficher()+this.getColonneAfficher()+Integer.toString(coin);
    }
}
