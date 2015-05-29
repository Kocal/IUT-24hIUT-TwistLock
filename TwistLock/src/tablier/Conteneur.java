package tablier;

/**
 *
 * @author Kocal
 */
public class Conteneur {

    public int ligne;
    public int colonne;
    public int valeur;

    public Conteneur(int ligne, int colonne, int valeur) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.valeur = valeur;
    }

    public String getColonneAfficher() {
        return Character.toString((char) ('A' + colonne));
    }

    public String getLigneAfficher() {
        return Integer.toString(ligne + 1);
    }

    public String getPositionAfficher(int coin) throws Exception {
        if (coin < 1 || coin > 4) {
            throw new Exception("Erreur : Le numéro de coin doit être dans l'intervalle 1-4");
        }
        return this.getLigneAfficher() + this.getColonneAfficher() + Integer.toString(coin);
    }
    
    public String getPositionAfficher(Coin c) throws Exception {
        return this.getLigneAfficher() + this.getColonneAfficher() + Integer.toString(this.getNumeroCoin(c));
    }

    public int getNumeroCoin(Coin c) throws Exception {
        int numCoin = -1;

        if (c.getConteneurs().size() != 4) {
            throw new Exception("Le conteneur a un nombre anormal de coin");
        }
        for (int i = 0; i < c.getConteneurs().size(); i++) {
            if (c.getConteneurs().get(i) == this) {
                numCoin = i + 1;
            }
        }
        if (numCoin == -1) {
            throw new Exception("Le coin n'appartient pas au conteneur");
        }
        return numCoin;
    }
}
