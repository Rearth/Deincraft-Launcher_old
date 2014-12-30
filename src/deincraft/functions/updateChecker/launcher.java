/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.functions.updateChecker;

import deincraft.functions.linkToString;
import deincraft.other.Download;
import deincraft.other.ZipArchiveExtractor;
import deincraft.start.startargs;
import deincraft.util.OperatingSystem;
import static deincraft.util.Path.DCpath;
import deincraft.util.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Florian
 */
public class launcher {
    public static void main(String[] Args) throws IOException, Exception {
        String newlauncherversion = linkToString.download("https://www.dropbox.com/s/gkd2revodu5axw4/launcher-version.txt?dl=1");
        String installedlauncherversion = "2.0.0.52";
        System.out.println(installedlauncherversion);
        if(!newlauncherversion.equals(installedlauncherversion)) {
            //Starte Update wenn versionen nicht gleich. Update erfprderlich.
            String jarfile = new File(launcher.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
            System.out.println(jarfile);
            Download.main("https://www.dropbox.com/s/yy7brh9da534xp1/deincraft_tekkit_updater.jar?dl=1", DCpath() + "updater.jar", true);
            OperatingSystem operatingSystem = OperatingSystem.getOperatingSystem();
            try {
                ProcessBuilder pb = new ProcessBuilder(OperatingSystem.getJavaDir(), "-jar", DCpath() + "updater.jar", jarfile);
                pb.start();
            } catch (Exception e) {
                System.out.println("ausführen der Datei");
            }
            System.exit(0);
        }  
    }
}
