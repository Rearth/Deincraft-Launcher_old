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
import javax.swing.JOptionPane;

/**
 *
 * @author Florian
 */
public class setRAM {
    public static String main(String[] Args) throws IOException {
        long memorySize = ((com.sun.management.OperatingSystemMXBean) 
        ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        long RAMinMB = memorySize / 1024 /1024; 
        
        String RAM;
        File ramfile = new File(DCpath() + "launcher/RAM.txt");
        if (ramfile.exists()) {
            RAM = Text.read(DCpath() + "launcher/RAM.txt");
            int intRAM;
            try {
                intRAM = Integer.parseInt(RAM); 
            } catch (Exception e) {
                intRAM = 0;
            }

            if ((intRAM >= 1024) && (intRAM <= RAMinMB)) {
                if (intRAM <= 1535) {
                    JOptionPane.showMessageDialog(null, "Wenn der eingestellte RAM unter 1536 liegt, \n\rkönnte es im Spiel ziemlich laggen.", "RAM Warnung", JOptionPane.OK_CANCEL_OPTION);
                }
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
            RAM = "2572";
        } else if (RAMinMB >= 4000) {
            RAM = "2048";
        } else {
            RAM = "1536";
        }
        ramfile.createNewFile(); 
        Text.write(DCpath() + "launcher/RAM.txt", String.valueOf(RAM));
        return RAM;
    }
}
