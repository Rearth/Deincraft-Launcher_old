/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Florian
 */
public class createMD5 {
    
    //geht noch nicht!!!!!!
    public static String file(String path) throws FileNotFoundException, IOException, NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
            try (InputStream is = Files.newInputStream(Paths.get(path))) {
                DigestInputStream dis = new DigestInputStream(is, md);
                /* Read stream to EOF as normal... */
            }
        byte[] digest = md.digest();
        return Arrays.toString(digest);
    }
}
