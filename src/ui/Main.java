package ui;
import model.*;
import java.util.*;

public class Main {

  public static final String VERSION = "0.5.4-pre";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int userAnswer = 0;
    Menus.welcomeLogo(8,in);
    do {
      userAnswer = Menus.printMainMenu(8,in);
      userAnswer = Stream.switcherMainMenu(userAnswer,8,in);
    } while (userAnswer != 0);
  }
}
