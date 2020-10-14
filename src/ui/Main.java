package ui;
import model.*;
import java.util.*;

public class Main {

  public static final String VERSION = "0.2.2.6-pre";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Menus menu = new Menus();
    int userAnswer = 0;
    menu.welcomeLogo(8,in);
    User currentUser = menu.printLoginMenu(8,in);
    do {
      userAnswer = menu.printMainMenu(8,in,currentUser);
      userAnswer = Stream.switcherMainMenu(8,in,userAnswer);
    } while (userAnswer != 0);
  }
}
