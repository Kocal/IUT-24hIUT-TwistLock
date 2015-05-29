package twistlock;

import intelligenceArtificielle.IA;
import reseau.Connexion;

/**
 *
 * @author Kocal
 */
public class TwistLock {

    public static void main(String[] args) {
        // TODO code application logic here
        tablier.Tablier t = new tablier.Tablier("MAP=5:7:52:18:10:44:51|"
                + "52:49:24:46:12:41:25|"
                + "26:28:22:23:13:38:26|"
                + "43:29:33:41:06:52:50|"
                + "42:45:48:12:16:51:20|"
                + "37:06:25:26:26:43:33|"
                + "5:47:24:5:23:22:18|"
                + "5:38:38:41:39:17:40|"
                + "8:19:17:53:29:20:27|"
                + "35:6:12:28:28:31:17|");

        System.out.println(t);

        IA ia = new IA(Constante.Couleur.VERT);
        t.mettreAJourPositionEnnemi("4F3", Constante.Couleur.ROUGE);
        System.out.println(ia.getMeilleurCoin().getChaine(t));
        Connexion connexion = new Connexion();
    }
}
