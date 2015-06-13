/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.functions.updateChecker;

import deincraft.functions.linkToString;
import static deincraft.functions.updateChecker.launcher.installedlauncherversion;
import deincraft.other.Download;
import deincraft.other.ZipArchiveExtractor;
import deincraft.util.OperatingSystem;
import static deincraft.util.Path.DCpath;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Florian
 */
public class runtime {
    public static void main(String[] Args) throws IOException, Exception {
        File ownRT = new File(DCpath() + "runtime/jre-x64/1.8.0_25/bin/javaw.exe");
        if (ownRT.exists()) {
          return;  
        } 
       // System.out.println(System.getProperty("os.arch"));
        if((OperatingSystem.getOperatingSystem() == OperatingSystem.WINDOWS) && ((System.getProperty("os.arch").contains("64")) || OperatingSystem.getJavaDir().contains("(x86)"))) {
            //Starte Update wenn versionen nicht gleich. Update erfprderlich.
            String jarfile = new File(launcher.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
            System.out.println(jarfile);
            Download.main("https://www.dropbox.com/s/0tkszqu4qli7wug/runtime.zip?dl=1", DCpath(), "runtime.zip");
            try {
                ZipArchiveExtractor.main(DCpath() + "runtime.zip",DCpath());
            } catch (Exception e) {
                System.out.println("Runtime Enpacken Fehler!");
            }
        }  
    }
}
