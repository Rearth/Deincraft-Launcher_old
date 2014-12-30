/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.auth;

import static deincraft.util.Path.DCpath;
import deincraft.util.Text;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Florian
 */
public class load {
    
    public static boolean load() throws IOException {
        File usertxt = new File(DCpath() + "launcher/username.txt");
        File passtxt = new File(DCpath() + "launcher/password.txt");
        if (usertxt.exists() && passtxt.exists()) {
            String username = Text.read(DCpath() + "launcher/username.txt");
            String Password = Text.read(DCpath() + "launcher/password.txt");
            if (username == null || Password == null) {
                return false;
            }
            if (deincraft.auth.wp_login.main(username, Password) == true){
                my.JavaApplication1.DeincraftUI.Username = username;
                my.JavaApplication1.DeincraftUI.Password = Password;
                return true;
            }
        }
        usertxt.createNewFile();
        passtxt.createNewFile();
        return false;
    }
}
