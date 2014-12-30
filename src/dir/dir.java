/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dir;


/**
 *
 * @author Florian
 */
public class dir {
    
    
    public String appData;
    public String deincraftdir = (appData + "./deincraft/");
    
    private static String defaultDirectory()
    {
        String OS = System.getProperty("os.name").toUpperCase();
        if (OS.contains("WIN"))
            return System.getenv("APPDATA");
        else if (OS.contains("MAC"))
            return System.getProperty("user.home") + "/Library/Application " + "Support";
        else if (OS.contains("NUX"))
            return System.getProperty("user.home");
        return System.getProperty("user.dir");
    }
    
}
