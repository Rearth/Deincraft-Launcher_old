/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.start;

/**
 *
 * @author Florian
 */

import deincraft.util.OperatingSystem;
import deincraft.util.Path;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Start
  extends Thread
{
  private static String username;
  private static int RAM;
  
  public void run()
  {
    try
    {
      OperatingSystem operatingSystem = OperatingSystem.getOperatingSystem();
      if (operatingSystem.equals(OperatingSystem.OSX))
      {
        Process p = Runtime.getRuntime().exec(new String[] { "/bin/bash", "-c", "java" + startargs.getStartArgs(username, RAM) }, null, new File(Path.DCpath() + "modpacks/tekkitmain"));
        InputStream is = p.getInputStream();
        int i = 0;
        while ((i = is.read()) != -1) {
          System.out.print((char)i);
        }
      }
      else
      {
        Runtime runtime = Runtime.getRuntime();
        
        Process p1 = runtime.exec(OperatingSystem.getJavaDir() + startargs.getStartArgs(username, RAM), null, new File(Path.DCpath() + "modpacks/tekkitmain"));
        InputStream is = p1.getInputStream();
        int i = 0;
        while ((i = is.read()) != -1) {
          System.out.print((char)i);
        }
      }
    }
    catch (NumberFormatException|IOException e)
    {
      System.out.println(e);
    }
  }
  
  public static void main(String[] Args)
  {
    username = Args[0];
    RAM = Integer.parseInt(Args[1]);
    Start startthread = new Start();
    startthread.start();
  }
}

