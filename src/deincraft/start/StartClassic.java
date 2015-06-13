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
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartClassic
  extends Thread
{
  private static String username;
  private static int RAM;
  
  public void run()
  {
    try
    {
      OperatingSystem operatingSystem = OperatingSystem.getOperatingSystem();
      my.JavaApplication1.DeincraftUI.Startenabled = false;
      my.JavaApplication1.DeincraftUI.jLabel10.enable(false);
      my.JavaApplication1.Closing.canclose = false;
      if (operatingSystem.equals(OperatingSystem.OSX))
      {
        Process p = Runtime.getRuntime().exec(new String[] { "/bin/bash", "-c", "java" + ArgsClassic.getStartArgs(username, RAM) }, null, new File(Path.DCpath() + "modpacks/vanilla"));
        InputStream is = p.getInputStream();
        int i = 0;
        while ((i = is.read()) != -1) {
          System.out.print((char)i);
        }
      }
      else
      {
        Runtime runtime = Runtime.getRuntime();
        
        Process p1 = runtime.exec(OperatingSystem.getJavaDir() + ArgsClassic.getStartArgs(username, RAM), null, new File(Path.DCpath() + "modpacks/vanilla"));
        InputStream is = p1.getInputStream();
        int i = 0;
        while ((i = is.read()) != -1) {
          System.out.print((char)i);
        }
      }
    } catch (NumberFormatException|IOException e) {
        System.out.println(e);
    } catch (Exception ex) {
        Logger.getLogger(StartClassic.class.getName()).log(Level.SEVERE, null, ex);
    }
    my.JavaApplication1.DeincraftUI.Startenabled = true;
    my.JavaApplication1.DeincraftUI.jLabel10.enable(true);
    my.JavaApplication1.DeincraftUI.OptionEnabled = false;
    my.JavaApplication1.Closing.canclose = true;
  }
  
  public static void main(String[] Args)
  {
    username = Args[0];
    RAM = Integer.parseInt(Args[1]);
    StartClassic startthread = new StartClassic();
    startthread.start();
  }
}

