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
import static deincraft.util.Path.DCpath;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        
        launcher.main(null);
        assets.main(null);
        cache.main(null);
        gamedata.main(null);
    }
}
