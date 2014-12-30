/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Florian
 */
public class linkToString {
    public static String download(String addr) throws IOException{
        URL url = new URL(addr);
        URLConnection urlConnection = url.openConnection();
	urlConnection.setConnectTimeout(5000);
	urlConnection.setReadTimeout(5000);
	BufferedReader breader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	StringBuilder stringBuilder = new StringBuilder();
	String line;
	while((line = breader.readLine()) != null) {
		stringBuilder.append(line);
	}
        return stringBuilder.toString();
    }
}
