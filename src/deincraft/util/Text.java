/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Florian
 */
public class Text {
        public static String read(String Path) throws FileNotFoundException, IOException {
        File File = new File(Path);
        String Text = null;
        if (!File.exists()) {

        } else if (File.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(Path));
            Text = reader.readLine();
        }
        return Text;

    }

    public static void write(String Path, String Text) throws IOException {
        FileWriter fw = new FileWriter(Path);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(Text);
        pw.flush();
        pw.close();
    }
}
