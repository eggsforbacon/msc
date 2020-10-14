package ui;
import model.*;
import java.util.*;

public class Stream {

  static Menus menu = new Menus();

  public static int switcherMainMenu(int millis, Scanner in, int userAnswer) {
    switch (userAnswer) {
      case 0:
        break;
      case 1:
        break;
      case 2:
        break;
      case 3:
        break;
      default:
        break;
    }
    return userAnswer;
  }

  //Validations and loops

  public static void slowPrint(int millis, String[] CONST) {
    for (int i = 0; i < CONST.length; i++) {
      System.out.println(CONST[i]);
      Operations.queue(millis);
    }
  }

  public static String addSongValid(Scanner in) {
    System.out.println("El genero ingresado no es valido, por favor intente de nuevo:\n");
    String genre = in.next();
    in.nextLine();
    return genre;
  }
}
