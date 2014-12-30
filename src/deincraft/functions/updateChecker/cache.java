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
public class cache {
    public static void main(String[] Args) throws IOException, Exception {
        File cacheVersion = new File(DCpath() + "launcher/cache-version.txt");
        if (!cacheVersion.exists()) {
           cacheVersion.createNewFile();
        }
        String newcacheversion = linkToString.download("https://www.dropbox.com/s/9bxtxwkyw8pcmma/cache-version.txt?dl=1");
        String installedcacheversion = Text.read(cacheVersion.toString());
        if(!newcacheversion.equals(installedcacheversion)) {
            //Starte Update wenn versionen nicht gleich. Update erfprderlich.
            Download.main("https://www.dropbox.com/s/0go8ednwi3nmpdo/cache.zip?dl=1", DCpath() + "cache.zip", true);
            ZipArchiveExtractor.main(DCpath() + "cache.zip",DCpath());
            Text.write(cacheVersion.toString(), newcacheversion);
        }
    }
}
