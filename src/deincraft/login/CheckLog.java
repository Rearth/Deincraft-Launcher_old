/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.login;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.*;
import java.nio.charset.*;
import static deincraft.util.Path.DCpath;
/**
 *
 * @author Florian
 */
public class CheckLog {

    public static boolean Check(){
    //String appData = System.getProperty("user.home") + "\\Local Settings\\Application Data";
    //String installdir = (DCpath());
    Path latestlog = Paths.get(DCpath() + "modpacks/tekkitmain/logs/latest.log");
    Path templog = Paths.get(DCpath() + "modpacks/tekkitmain/logs/latest.temp.log");
    FileOutputStream fop = null;
    File file;
    String content = "Verbunden";

        try {
             Files.createFile(templog);
        } catch (Exception e) {
        }
    
        try {
            
            String fileContent = new String(Files.readAllBytes(latestlog), StandardCharsets.UTF_8);
            
            if (fileContent.contains("[Client thread/INFO]: [Client thread] Client side modded connection established")){
                
                //Files.copy(latestlog, templog, REPLACE_EXISTING);
                
                //File.Write(templog, "Verbunden" + "\r\n");
                
                //Files.copy(templog, latestlog, ATOMIC_MOVE);
                //FileOutputStream output = new FileOutputStream("verbunden", false);
                
                
                file = new File(DCpath() + "modpacks/tekkitmain/logs/latest.log");
			fop = new FileOutputStream(file, false);
 
			// if file doesnt exists, then create it
 
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
 
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
                
                
                System.out.println("return: true");
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        System.out.println("return: false");
        return false;
    }
}
