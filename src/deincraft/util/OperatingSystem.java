/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deincraft.util;

/**
 *
 * @author Florian
 */
import java.io.File;
import java.util.Locale;
import deincraft.util.Path;

public enum OperatingSystem
{
  LINUX("linux", new String[] { "linux", "unix" }),  WINDOWS("windows", new String[] { "win" }),  OSX("osx", new String[] { "mac" }),  UNKNOWN("unknown", new String[0]);
  
  private static OperatingSystem operatingSystem;
  private final String name;
  private final String[] aliases;
  
  private OperatingSystem(String name, String[] aliases)
  {
    this.name = name;
    this.aliases = aliases;
  }
  
  public static String getJavaDir()
  {
    String separator = System.getProperty("file.separator");
    String path = System.getProperty("java.home") + separator + "bin" + separator;
    File ownRT = new File(Path.DCpath() + "runtime/jre-x64/1.8.0_25/bin/javaw.exe");
    System.out.println(path);
    if ((getOperatingSystem() == WINDOWS) && (ownRT.exists()))
    {
        System.out.println("Starte mit eigener Runtime");
        return Path.DCpath() + "runtime/jre-x64/1.8.0_25/bin/javaw.exe";
    } else if ((getOperatingSystem() == WINDOWS) && (new File(path + "javaw.exe").isFile())) {
      return path + "javaw.exe";
    }
    return path + "java";
  }
  
  public static OperatingSystem getOperatingSystem()
  {
    if (operatingSystem != null) {
      return operatingSystem;
    }
    String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    for (OperatingSystem operatingSystem : values()) {
      for (String alias : operatingSystem.getAliases()) {
        if (osName.contains(alias))
        {
          operatingSystem = operatingSystem;
          return operatingSystem;
        }
      }
    }
    return UNKNOWN;
  }
  
  public String[] getAliases()
  {
    return this.aliases;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isSupported()
  {
    return this != UNKNOWN;
  }
}

