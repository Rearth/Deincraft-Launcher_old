/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.functions;

import static deincraft.util.Path.DCpath;
import deincraft.util.Text;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 *
 * @author Florian
 */
public class setRAM {
    public static String main(String[] Args) throws IOException {
        String RAM;
        File ramfile = new File(DCpath() + "launcher/RAM.txt");
        if (ramfile.exists()) {
            RAM = Text.read(DCpath() + "launcher/RAM.txt");
            if (("3072".equals(RAM)) || ("2560".equals(RAM)) || ("1024".equals(RAM)) || ("1536".equals(RAM)) || ("2048".equals(RAM))) {
                
                return RAM;
            } else {
                RAM = ramautoselect();
                return RAM;  
            }
            
        } else {
            
            RAM = ramautoselect();
            
            return RAM;
        }
    }
    
    public static String ramautoselect() throws IOException {
        String RAM = null;
        File ramfile = new File(DCpath() + "launcher/RAM.txt");
        long memorySize = ((com.sun.management.OperatingSystemMXBean) 
        ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        long RAMinMB = memorySize / 1024 /1024; 
        if (RAMinMB >= 8000) {
            RAM = "3072";
        } else if (RAMinMB >= 6000) {
            RAM = "2048";
        } else if (RAMinMB >= 4000) {
            RAM = "1536";
        } else {
            RAM = "1024";
        }
        ramfile.createNewFile(); 
        Text.write(DCpath() + "launcher/RAM.txt", String.valueOf(RAM));
        return RAM;
    }
}
