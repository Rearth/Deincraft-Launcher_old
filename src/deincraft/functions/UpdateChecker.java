/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.functions;

import deincraft.functions.updateChecker.assets;
import deincraft.functions.updateChecker.cache;
import deincraft.functions.updateChecker.gamedata;
import deincraft.functions.updateChecker.launcher;
import deincraft.functions.updateChecker.runtime;
import static deincraft.util.Path.DCpath;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Florian
 */
public class UpdateChecker {
    public static void main(String[] Args) throws Exception {        
        
        Path pfad = Paths.get(DCpath() + "launcher");
        File file = new File(DCpath() + "launcher");
        
        if (Files.notExists(pfad)) {
            file.mkdirs();
        }
        try {
            launcher.main(null);
            assets.main(null);
            cache.main(null);
            gamedata.main(null);
            runtime.main(null);
        } catch (Exception e) {
            System.out.println("Update überprüfung Fehlgeschlagen.");
            JOptionPane.showMessageDialog(null, "Update Überpfüfung Fehlgeschlagen. \n\rMöglicherweise keine Internet Verbindung?");
            File gamedata = new File(DCpath() + "modpacks/tekkitmain/bin");
            if (gamedata.exists()) {
                JOptionPane.showMessageDialog(null, "Starte ohne Überprüfung");
            } else {
                JOptionPane.showMessageDialog(null, "Launcher konnte nicht gestartet werden.");
                System.exit(2);
            }
        }
    }
}
