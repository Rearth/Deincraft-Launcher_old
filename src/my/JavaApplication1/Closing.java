/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.JavaApplication1;

import javax.swing.JOptionPane;
import deincraft.other.tipps;

/**
 *
 * @author Florian
 */
public class Closing {
    
    public static boolean canclose = true;
    public static void close() {
        if (canclose == false) {
            JOptionPane.showMessageDialog(null, "Minecraft muss zuerst geschlossen werden, \n\rum den Launcher zu Beenden.", "Minecraft geöffnet.", JOptionPane.ERROR_MESSAGE);
        } else {
            //int zufall = (int) (Math.random() * ((tipps.tipps.length) - 0) + 0);
            int opcion = JOptionPane.showConfirmDialog(null, "Soll Deincraft Geschlossen werden?"/* \n\r \n\r TIPP: \n\r \n\r" + tipps.tipps[zufall]*/, "Deincraft Beenden?", JOptionPane.YES_NO_OPTION);
            if (opcion == 0) {
                System.out.print("Schließen");
                System.exit(0);
            } else {
                System.out.print("Offen bleiben");
            }
        }
    }
}
