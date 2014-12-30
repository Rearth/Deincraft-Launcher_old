/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.functions;

import java.io.IOException;

/**
 *
 * @author Florian
 */
public class Changelog {
    public static String main() throws IOException{
        String changelog = (linkToString.download("https://www.dropbox.com/s/h9umo5a0yurqyf0/changelog.txt?dl=1"));
        return ("<html><body>" + changelog + "</body></html>");
    }
}
