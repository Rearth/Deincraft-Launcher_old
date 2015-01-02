/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.auth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
/**
 *
 * @author Florian
 */
public class wp_login {
 static String result;   
  public static boolean main( String username, String password ) throws MalformedURLException, IOException
  {
        String body = "log=" + username + "&pwd=" + password + "&wp- submit=Log+In&redirect_to=\"http://deincraft-tekkit.tk\"&wordpress_test_cookie=1";
        URL url = new URL( "http://www.deincraft-tekkit.tk/wp-login.php" );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod( "POST" );
        connection.setDoInput( true );
        connection.setDoOutput( true );
        connection.setUseCaches( false );
        connection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded" );
        connection.setRequestProperty( "Content-Length", String.valueOf(body.length()) );

        OutputStreamWriter writer = new OutputStreamWriter( connection.getOutputStream() );
        writer.write( body );
        writer.flush();


        BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream()) );

        for ( String line; (line = reader.readLine()) != null; )
        {
            System.out.println( line );
            result = result + line;
        }
        System.out.println(result);
        writer.close();
        reader.close();
        if (result.contains("FEHLER")) {
            if (result.contains("Dein Benutzerkonto wurde nicht aktiviert")) {
                JOptionPane.showMessageDialog(null, "Du musst erst die E-Mail bestätigen. \n\rAuf http://www.deincraft-tekkit.tk/login kannst du die E-Mail erneut senden Lassen. \r\nFals es Probleme mit der Aktivierung geben Sollte, melde nich Bitte bei und auf unserem Teamspeak Server. Oder sende uns eine E-mail", "Login Fehler", JOptionPane.OK_CANCEL_OPTION);   
            } else if (result.contains("Das Passwort, das du für den")) {
                JOptionPane.showMessageDialog(null, "Das eigegebene Passwort ist Falsch", "Login Fehler", JOptionPane.OK_CANCEL_OPTION);   
            } else if (result.contains("Ungültiger Benutzername")) {
                JOptionPane.showMessageDialog(null, "Ungültiger Benutzername", "Login Fehler", JOptionPane.OK_CANCEL_OPTION);   
            } else if (result.contains("Dein Benutzerkonto wurde als Spammer gekennzeichnet.")) {
                JOptionPane.showMessageDialog(null, "Dieser Account wurde gesperrt.", "Login Fehler", JOptionPane.OK_CANCEL_OPTION); 
            } else {
                JOptionPane.showMessageDialog(null, "Unbekannter Login Fehler. \n\rMögliche ursachen: keine internet Verbindung oder deincraft ist derzeit offline.", "Login Fehler", JOptionPane.OK_CANCEL_OPTION); 
            }
            result = null;
            System.out.println("Fehler beim login");
            return false;
        } else {
            result = null;
            System.out.println("Erfolgreich eingeloggt");
            return true;
        }
    }
}
