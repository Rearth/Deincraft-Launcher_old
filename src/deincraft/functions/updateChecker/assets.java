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
public class assets {
    public static void main(String[] Args) throws IOException, Exception {
        File assetsVersion = new File(DCpath() + "launcher/assets-version.txt");
        if (!assetsVersion.exists()) {
           assetsVersion.createNewFile();
        }
        String newassetsversion = linkToString.download("https://www.dropbox.com/s/hftwl9zga062zgl/assets-version.txt?dl=1");
        String installedassetsversion = Text.read(assetsVersion.toString());
        if(!newassetsversion.equals(installedassetsversion)) {
            //Starte Update wenn versionen nicht gleich. Update erfprderlich.
            Download.main("https://www.dropbox.com/s/awcsm8ccwwf8y0z/assets.zip?dl=1", DCpath() + "assets.zip", true);
            ZipArchiveExtractor.main(DCpath() + "assets.zip",DCpath());
            Text.write(assetsVersion.toString(), newassetsversion);
        }
    }
}
