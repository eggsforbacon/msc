package ui;
import model.*;

public class Main {

  public static final String VERSION = "0.15.1-pre";

  public static void main(String[] args) {
    Menus menu = new Menus();
    menu.startProgram(8);
    System.out.println("Hasta pronto!");
    menu.queue(1000);
    menu.clrscm();
  }
}
