/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.login;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class sendPacket {
    public static void send(String Username, String Passwort){
        
        Socket socket = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("134.255.231.125");
            int port = Integer.parseInt("26128");
             
            socket = new Socket(inetAddress, port);
            System.out.println("InetAddress: " + inetAddress);
            System.out.println("Port: " + port);
             
            //Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
      //      String sysUsername = System.getProperty("user.name");
  /*      //name
        String TextUsername = null;
        String ActPath = "\\launcher\\Namen.txt";
        String nametxt = Path(ActPath);
        BufferedReader reader2 = null;
            try {
            reader2 = new BufferedReader(new FileReader(nametxt));
            TextUsername = reader2.readLine();
            
            
            } catch (FileNotFoundException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader2.close();
            } catch (IOException ex) {
                Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        //PW
        ActPath = "\\launcher\\Passwort.txt";
        String PWtxt = Path(ActPath);
        BufferedReader reader3 = null;
        String TextPasswort = null;
            try {
            reader3 = new BufferedReader(new FileReader(PWtxt));TextPasswort = reader3.readLine();
            
            } catch (FileNotFoundException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader3.close();
            } catch (IOException ex) {
                Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } */

            //send
          //  System.out.println("Send" + Username + Passwort);
            String userInput = Username + ":" + Passwort;
            System.out.println(userInput);
            printWriter.println(userInput);
            //scan (hab verschiedene sachen funktioniert, aber es kommt nichts vom Server
            //String serverEcho = scanner.nextLine();
            //System.out.println(serverEcho);
 
        } catch (UnknownHostException ex) {
            Logger.getLogger(TCPautoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPautoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if( socket != null){
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(TCPautoLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }   
}
