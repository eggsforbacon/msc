package ui;
import model.*;
import java.util.*;

/**
*Handles the rest of the UI stream, which are validations, switches and default methods. <br>
*@author Samuel Hernandez / Zac
*/
public class Stream {

  static Menus menu = new Menus();

  /**
  *Switches between the outcomes according to user input. <br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The corresponding outcome is ran.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  *@param userAnswers Integer array that allows the program to move between menus. <b>Must be an already initialized <i>integer</i> array.</b><br>
  */
  public static int[] switcherMainMenu(int millis, Scanner in, int[] userAnswers) {
    switch (userAnswers[0]) {
      case 0:
        break;
      case 1:
        menu.showAddUserMenu(millis,in);
        break;
      case 2:
        menu.showProfilesMenu(millis,in);
        break;
      case 3:
        menu.showAddSongMenu(millis,in);
        break;
      case 4:
        menu.showPoolMenu(millis,in);
        break;
      case 5:
        break;
      case 6:
        break;
      default:
        break;
    }
    return userAnswers;
  }

  //Validations and deaults

  /**
  *Loops through a string constant and prints it with a given delay.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The given array si printed with the delay per line.<br>
  *@param millis Integer that represents the delay in ms. <b>Must be of type <i>int</i>.</b><br>
  *@param CONST String array containing the lines to be printed. <b>Must not be of length <i>0 or lower</i>.</b><br>
  */
  public static void slowPrint(int millis, String[] CONST) {
    for (int i = 0; i < CONST.length; i++) {
      System.out.println(CONST[i]);
      Operations.queue(millis);
    }
  }

  /**
  *Checks if the genre is valid for a given song.<br>
  *<b>Pre: </b>There has been an attempt of <b>creating</b> a new song.<br>
  *<b>Post: </b>The new genre inputed is returned.<br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  public static String addSongValid(Scanner in) {
    System.out.println("El genero ingresado no es valido, por favor intente de nuevo:\n");
    String genre = in.next();
    in.nextLine();
    return genre;
  }
}
