package ui;
import model.*;
import java.util.*;

public class Main {

  public static final String VERSION = "0.14-pre";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Menu menu = new Menu();
    int[] userAnswers = {0,0};
    menu.welcomeLogo(8,in);
    do {
      userAnswers = menu.showMenu(8,in);
      userAnswers = Stream.switcherMainMenu(8,in,userAnswers);
    } while (userAnswers[0] != 0);
    System.out.println("Hasta pronto!");
    Operations.queue(1000);
    Operations.clrscm();
  }
}
