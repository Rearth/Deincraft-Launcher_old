/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.login;
/**
 *
 * @author Florian
 */
public class TCPautoLogin extends Thread {
public static String Username;
public static String Password;
public static boolean enabled;
static boolean firstrun = true;

    public void run()
    {
        while(true){
            
            if (CheckLog.Check() == true && enabled == true) {
                sendPacket.send(Username, Password);
                System.out.println("have send");
            }
            
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
        }
    }
     
    public static void main(String user, String Passwd, boolean Enabled) {
        try {
            Username = user;
            Password = Passwd;
            enabled = Enabled;
            if (firstrun == true){
                TCPautoLogin t = new TCPautoLogin();        //erstellt einen neuen Thread in der klasse TCPautoLogin.    
                t.start(); //startet den neuen Thread. Beginnt in der run methode. 
                firstrun = false;
            }
        } catch (Exception e) {
        }
    }
}
