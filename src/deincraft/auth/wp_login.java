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
            System.out.println("Fehler beim login");
            return false;
        } else {
            System.out.println("Erfolgreich eingeloggt");
            return true;
        }
    }
}
