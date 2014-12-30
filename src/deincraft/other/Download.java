/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.other;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author DavidW
 */
public class Download {
    public static void main(String link, String ZielOrt, Boolean Show) throws Exception {
            Download.downloader (new URL(link),ZielOrt,Show);
            
    }
    
    public static void downloader (URL link, String ZielOrt, Boolean Show) throws Exception {
        
            float test = 1;
            float test2 = 1024;
            float gesamt = 0;
            float gesamt2 = 0;

            JFrame fenster = new JFrame("Downloading");
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setSize(600, 20);
            if (Show == true) {
            fenster.setVisible(true);
            }
        
            InputStream in = null;
        try {
            //download
            float komplettsize = link.openConnection().getContentLength();
            int kompsize = (int) komplettsize / 1000000;
            in = new BufferedInputStream(link.openStream());
            ByteArrayOutputStream out3 = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                out3.write(buf, 0, n);
                test = test + test2;
                gesamt = test / komplettsize;
                int aktsize =  (int) test / 1000000;
                gesamt2 = gesamt * 100;
                System.out.println(gesamt2);
                fenster.setTitle(gesamt2 + "%" + aktsize +"MB" + "/" + kompsize + "MB");
            }
            out3.close();
            in.close();
            byte[] response = out3.toByteArray();
            FileOutputStream fos = new FileOutputStream(ZielOrt);
            fos.write(response);
            fos.close();
            System.out.println("Download fertig");
            //download fertig
            fenster.setEnabled(false);
            fenster.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean verify(URL link, String file) throws IOException {
        long komplettsize = 0;
        try {
            komplettsize = link.openConnection().getContentLength();
        } catch (IOException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Keine Internet Verbindung");
        }
        System.out.println(komplettsize);
        
        if (Files.size(Paths.get(file)) == komplettsize) {
            System.out.println("File OK");
            return true;
        }  
        System.out.println("Fehler beim Verifizieren.");
        return false;
    }
    
}

 
