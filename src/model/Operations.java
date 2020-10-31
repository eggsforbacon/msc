package model;
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

  public static User login(String userName, String password, int age) {
    User loggedUser = new User(userName,password,age);
    return loggedUser;
  }
}
