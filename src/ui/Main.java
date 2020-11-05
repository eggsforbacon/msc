package ui;

public class Main {

  public static final String VERSION = "0.16.2-pre";

  public static void main(String[] args) {
    Menus menu = new Menus();
    menu.startProgram(8);
    System.out.println("Hasta pronto!");
    menu.wait(1000);
    menu.clear();
  }
}
