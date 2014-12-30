/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.util;

/**
 *
 * @author Florian
 */
public class Path {
        public static String DCpath(){
        String path = null;
        String sysUsername = System.getProperty("user.name");
        OperatingSystem operatingSystem = OperatingSystem.getOperatingSystem();
        if (operatingSystem.equals(OperatingSystem.OSX)) {
            path = "/Users/" + sysUsername + "/Library/Application Support/deincraft/";
        } else if (operatingSystem.equals(OperatingSystem.WINDOWS)) {
            path = "C:/Users/" + sysUsername + "/AppData/Roaming/.deincraft/";
        } else {
            path = "/home/" + sysUsername + "/deincraft/";
        }
        return path;
    }
}
