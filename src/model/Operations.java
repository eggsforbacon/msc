package model;
import ui.*;
import java.io.IOException;

public class Operations {

  public static void clrscm() {
    try {
      final String OS = System.getProperty("os.name");

        if (OS.contains("Windows")) {
          new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        else {
          Runtime.getRuntime().exec("clear");
        }
    }catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void queue(int millis) {
    try {
      Thread.sleep(millis);
    }catch (Exception e) {
      System.out.println(e);
    }
  }
}
