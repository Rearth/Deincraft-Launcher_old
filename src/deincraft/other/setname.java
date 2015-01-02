/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.other;

import static deincraft.util.Path.DCpath;
import deincraft.util.Text;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import my.JavaApplication1.DeincraftUI;

/**
 *
 * @author DavidW
 */
public class setname {
    public static boolean main (JTextField jTextField1, JTextField jTextField2, JLabel jLabel2,JPanel jPanel1, JLabel jLabel10) throws IOException {
        String Username = (jTextField1.getText());
        String Passwort = (jTextField2.getText());
        
        if (Username.equals("")) {
            JOptionPane.showMessageDialog(null, "Bitte gib zuerst einen Nutzernamen ein", "Nutzername", JOptionPane.OK_CANCEL_OPTION);   
        }
        else if (Passwort.equals("")) {
            JOptionPane.showMessageDialog(null, "Bitte gib zuerst ein Passwort ein", "Passwort", JOptionPane.OK_CANCEL_OPTION);
        } else {
            if (deincraft.auth.wp_login.main(Username, Passwort) == false) {
                //JOptionPane.showMessageDialog(null, "Passwort nicht Richtig", "Login Fehler", JOptionPane.OK_CANCEL_OPTION);   
            } else {
                try {
                    Text.write(DCpath() + "launcher/username.txt", Username);
                    Text.write(DCpath() + "launcher/password.txt", Passwort);
                    jLabel2.setText(Username);
                    
                    jPanel1.setVisible(false);
                    jLabel10.setVisible(true);
                    return true;
                } catch (IOException ex) {
                    Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        }
        return false;
    }
}
    /*    try {

            BufferedReader reader = new BufferedReader(new FileReader(namentxt));
            String TextUsername = reader.readLine();

            if (!TextUsername.equals(Username)) {

                FileWriter fw = new FileWriter(namentxt);
                PrintWriter pw = new PrintWriter(fw);
                pw.write("");
                pw.flush();
                pw.close();

                try (BufferedWriter out = new BufferedWriter(new FileWriter(namentxt, true))) {
                    out.write(Username);
                    out.flush();
                    jLabel2.setText(TextUsername);
                }

            }
            if (TextUsername.equals(Username)) {
                jLabel2.setText(TextUsername);
            }
            //TextUsername ist dann der Username für später

        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        String Value1, Value2;
        Value1 = (jTextField1.getText());
        Value2 = (jLabel2.getText());

        if (Value2 == null ? Value1 == null : Value2.equals(Value1)) {

        }
        //PW
        String Passworttxt = DCpath() + "launcher/password.txt";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(Passworttxt));
            String TextPasswort = reader.readLine();

            if (TextPasswort != Passwort) {

                FileWriter fw = new FileWriter(Passworttxt);
                PrintWriter pw = new PrintWriter(fw);
                pw.write("");
                pw.flush();
                pw.close();

                try (BufferedWriter out = new BufferedWriter(new FileWriter(Passworttxt, true))) {
                    out.write(Passwort);
                    out.flush();
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(namentxt));
            String TextUsername = reader.readLine();

            if (TextUsername != Username) {

                FileWriter fw = new FileWriter(namentxt);
                PrintWriter pw = new PrintWriter(fw);
                pw.write("");
                pw.flush();
                pw.close();

                    try (BufferedWriter out = new BufferedWriter(new FileWriter(namentxt, true))) {
                        out.write(Username);
                        out.flush();
        
                    } catch (IOException ex) {
                        Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            } catch (IOException ex) {
                Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
*/