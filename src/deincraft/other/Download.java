/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.other;

import deincraft.util.Text;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static deincraft.util.Path.DCpath;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author DavidW
 */
public class Download {
    public static void main(String link, String ZielOrt, String Filename) throws Exception {
            //Download.downloader (new URL(link),ZielOrt,Show);
        String Args[] = {link, ZielOrt, Filename};
        Download.main(Args);
    }
  

    public static void downloader (URL link, String ZielOrt, Boolean Show) throws Exception {
        
            float test = 1;
            float test2 = 1024;
            float gesamt = 0;
            float gesamt2 = 0;
            int gesamt3;
            

           
            JFrame fenster = new JFrame("Downloading"); 
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setSize(600, 300);
            System.out.println("Downloading without frame");
       //     fenster.pack();
            fenster.setLocationRelativeTo(null);
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
                gesamt2 *= 100;
                
                gesamt3 = (int) gesamt2;
                gesamt2 = gesamt3;
                gesamt2 /= 100;
                fenster.setTitle("Download: " + gesamt2 + "%  " + aktsize +"MB" + "/" + kompsize + "MB");
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
    
    public static void main2(String[] args) throws Exception {

        URL oracle = new URL("https://www.dropbox.com/s/awcsm8ccwwf8y0z/assets.zip?dl=1");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        String full = null;
        while ((inputLine = in.readLine()) != null){
            //System.out.println(inputLine);
            full = full + inputLine;
            //System.out.println(full.length());
        }
        in.close();
        //Text.write(DCPath() + "assets2.zip", inputLine);
        Text.write(DCpath() + "assets2.zip", full);
    }
    
    
   final static int size=1024;

    public static void  fileUrl(String fAddress, String localFileName, String destinationDir) {
    OutputStream outStream = null;
    URLConnection  uCon = null;
            JFrame fenster = new JFrame("Downloading"); 
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel Panel = new javax.swing.JPanel();
            Label LeftProg = new Label("");
            Label RightProg = new Label("");
            float test = 1;
            float test2 = 1024;
            float gesamt = 0;
            float gesamt2 = 0;
            int gesamt3;
            fenster.setSize(608, 80);
            Panel.add(LeftProg);
            Panel.add(RightProg);
            Panel.setSize(120, 30);
            Panel.setLocation(10, 10);
            fenster.getContentPane().add(Panel);
            fenster.setVisible(true);
            LeftProg.setVisible(false);
            RightProg.setVisible(false);
            int leftS = 1;
            int rightS = 570 - leftS;
            LeftProg.setBackground(Color.green);
            RightProg.setBackground(Color.red);
            LeftProg.setSize(leftS,30);
            RightProg.setSize(rightS,30);
            LeftProg.setLocation(10, 5);
            RightProg.setLocation( 11, 5 );
            LeftProg.setVisible(true);
            RightProg.setVisible(true);
            
            RightProg.setText(" Setting Connection");
            
            System.out.println("Download with frame" + Panel.getLocation()+LeftProg.getLocation());
            boolean showedname = false;
            
    InputStream is = null;
    try {
        URL Url;
        byte[] buf;
        int ByteRead,ByteWritten=0;
        Url = new URL(fAddress);
        outStream = new BufferedOutputStream(new FileOutputStream(destinationDir + "/" + localFileName));
        
        uCon = Url.openConnection();
        is = uCon.getInputStream();
        float komplettsize = Url.openConnection().getContentLength();
        String filename = "Unbekannt";
        int kompsize = (int) komplettsize / 1048576;
        
        buf = new byte[size];
        while ((ByteRead = is.read(buf)) != -1) {
            outStream.write(buf, 0, ByteRead);
            ByteWritten += ByteRead;
            
            
            test = test + test2;
                gesamt = test / komplettsize;
                int aktsize =  (int) test / 1048576;
                gesamt2 = gesamt * 100;
                gesamt2 *= 100;
                
                gesamt3 = (int) gesamt2;
                gesamt2 = gesamt3;
                gesamt2 /= 100;
                fenster.setTitle("Download: " + (int)gesamt2 + "%  " + aktsize +"MB" + "/" + kompsize + "MB");
                
                leftS = (int)gesamt2 * 6;
                if ( leftS >= 599) {
                    leftS = 600;
                }
                LeftProg.setSize(leftS,30);
                RightProg.setSize(570 - leftS,30);
                if (showedname == false ){
                    String raw = Url.openConnection().getHeaderField("Content-Disposition");
                    // raw = "attachment; filename=abc.jpg"
                    if(raw != null && raw.contains("=")) {
                        filename = raw.split("=")[1];
                        filename = filename.split(";")[0];
                    } else {
                        filename = "Unbekannt";
                    }
                    showedname = true;
                    System.out.println(filename);
                    RightProg.setText("                                                                                                Datei: " + filename);
                }
                if (leftS >= 300) {
                    RightProg.setText("");
                    LeftProg.setText("Datei: " + filename);
                }
            
        }
        System.out.println("Downloaded Successfully.");
        System.out.println("File name:\""+localFileName+ "\"\nNo ofbytes :" + ByteWritten);
    }catch (Exception e) {
        e.printStackTrace();
        }
    finally {
            try {
            fenster.setVisible(false);
            is.close();
            outStream.close();
            }
            catch (IOException e) {
        e.printStackTrace();
            }
        }
}

    public static void  fileDownload(String fAddress, String destinationDir, String fileName)
{    
    int slashIndex =fAddress.lastIndexOf('/');
    int periodIndex =fAddress.lastIndexOf('.');

    if (periodIndex >=1 &&  slashIndex >= 0 
    && slashIndex < fAddress.length()-1)
    {
        fileUrl(fAddress,fileName,destinationDir);
    }
    else
    {
        System.err.println("path or file name.");
    }
}


    public static void main(String[] args){
            //fileDownload("https://www.dropbox.com/s/awcsm8ccwwf8y0z/assets.zip?dl=1",DCpath(), "assets3.zip");
    fileDownload(args[0], args[1], args[2]);
    }
    
    
    public static void setframe(String Args){
        
        
    }
}

 
