package com.jcraft.jsch;

public class ResourceUtil {
  public static String getResourceFile(Class<?> clazz, String fileName) {
    String path = clazz.getClassLoader().getResource(fileName).getPath();
    // Workaround for paths on Windows which come in form: /D:/some/path/<file>
    if (path.startsWith("/") && path.indexOf(":") == 2 && path.length() > 4 && path.charAt(3) == '/') {
      path = path.substring(1);
    }
    return path;
  }
}
