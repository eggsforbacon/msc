package ui;
import model.*;
import java.util.*;

public class Main {

  public static final String VERSION = "0.8-pre";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Menus menu = new Menus();
    int[] userAnswers = {0,0};
    menu.welcomeLogo(8,in);
    User currentUser = menu.printLoginMenu(8,in);
    do {
      userAnswers = menu.printMainMenu(8,in,currentUser);
      userAnswers = Stream.switcherMainMenu(8,in,userAnswers);
    } while (userAnswers[0] != 0);
  }
}
