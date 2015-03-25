/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.start;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Florian
 */
public class Crash {
    static int lastinit = 0;
    public static int Files() {
        try {
            File directory = new File(deincraft.util.Path.DCpath() + "/modpacks/tekkitmain/crash-reports");
            String[] list = directory.list();
            return list.length;
        } catch (Exception e) {
            return 0;
        }       
    }
    
    public static void init() {
        lastinit = Files();
    }
    
    public static void check() {
        Path path = Paths.get(deincraft.util.Path.DCpath() + "/modpacks/tekkitmain/logs/");
        if(Files() == lastinit) {
            JOptionPane.showMessageDialog(null, "MineCraft ist Soeben abgestürtzt.", "MineCraft Crashed", JOptionPane.OK_CANCEL_OPTION);
        } else if (!Files.exists(path)) {
            JOptionPane.showMessageDialog(null, "MineCraft konnte nicht gestartet werden.", "MineCraft Crashed", JOptionPane.OK_CANCEL_OPTION);
        }
    }
    
    public static void main(String[] Args) {
        System.out.println(Files());
    }
}
