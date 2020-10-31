package ui;
import model.Operations;

/**
*Handles the rest of the UI stream, which are validations, switches and default methods. <br>
*@author Samuel Hernandez / Zac
*/
public class Stream {

  /**
  *Loops through a string constant and prints it with a given delay.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The given array si printed with the delay per line.<br>
  *@param millis Integer that represents the delay in ms. <b>Must be of type <i>int</i>.</b><br>
  *@param CONST String array containing the lines to be printed. <b>Must not be of length <i>0 or lower</i>.</b><br>
  */
  public static void slowPrint(int millis, String[] CONST) {
    for (String s : CONST) {
      System.out.println(s);
      Operations.queue(millis);
    }
  }
}
