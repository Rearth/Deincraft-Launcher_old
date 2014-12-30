/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.functions.updateChecker;

import deincraft.functions.linkToString;
import deincraft.other.Download;
import deincraft.other.ZipArchiveExtractor;
import static deincraft.util.Path.DCpath;
import deincraft.util.Text;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Florian
 */
public class gamedata {
    public static void main(String[] Args) throws IOException, Exception {
        File gamedataVersion = new File(DCpath() + "launcher/gamedata-version.txt");
        if (!gamedataVersion.exists()) {
           gamedataVersion.createNewFile();
        }
        String newgamedataversion = linkToString.download("https://www.dropbox.com/s/cuaog9ht7ub4aik/gamedata-version.txt?dl=1");
        String installedgamedataversion = Text.read(gamedataVersion.toString());
        if(!newgamedataversion.equals(installedgamedataversion)) {
            //Starte Update wenn versionen nicht gleich. Update erfprderlich.
            Download.main("https://www.dropbox.com/s/wlai75m4knvml4e/gamedata.zip?dl=1", DCpath() + "gamedata.zip", true);
            ZipArchiveExtractor.main(DCpath() + "gamedata.zip",DCpath());
            Text.write(gamedataVersion.toString(), newgamedataversion);
        }
    }
}
