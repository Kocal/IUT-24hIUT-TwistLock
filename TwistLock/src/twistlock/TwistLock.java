package twistlock;

import reseau.Connexion;

/**
 *
 * @author Kocal
 */
public class TwistLock {

    public static void main(String[] args) {
        // TODO code application logic here
//        tablier.Tablier t = new tablier.Tablier("MAP=1:2:3:4:5:6:7:8:9:10|11:12:13:14:15:16:17:18:19:20|21:22:23:24:25:26:27:28:29:30|");
        tablier.Tablier t = new tablier.Tablier(5, 10);
        System.out.println(t);
        System.out.println(t.getConteneur(0, 1).valeur);
        System.out.println(t.getConteneur(1, 0).valeur);

        Connexion connexion = new Connexion();
    }
}
