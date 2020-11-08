package ui;

/**
*This class holds the main method to be ran.<br>
*@author Samuel Hernandez / Zac<br>
*@since 0.1<br>
*@version 1.0<br>
*/
public class Main {

  public static final String VERSION = "1.0";

  public static void main(String[] args) {
    Menus menu = new Menus();
    menu.startProgram(8);
    System.out.println("Hasta pronto!");
    menu.wait(1000);
    menu.clear();
  }
}
