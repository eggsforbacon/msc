package model;
import java.util.*;

/**
*Allows dinamic durations and operations with them.<br>
*@author Samuel Hernandez / Zac
*/
public class Duration {
  private int hours;
  private int minutes;
  private int seconds;
  private String format;

  /**
  *Constructor 1 of the class.<br>
  */
  public Duration() {
    hours = 0;
    minutes = 0;
    seconds = 0;
  }

  /**
  *Constructor 2 of the class.<br>
  *@param h Integer that represents the hours to be set to. <br>
  *@param m Integer that represents the minutes to be set to. <br>
  *@param s Integer that represents the seconds to be set to. <br>
  */
  public Duration(int h, int m, int s) {
    hours = h;
    minutes = m;
    seconds = s;
  }

  /**
  *Converts a string to the correct format.<br>
  *@param string String to be converted.<br>
  */
  public void toIntFormat(String string) {
    int count = string.length() - string.replaceAll(":","").length();
    String[] tempArr = string.split(":");
    switch (count) {
      case 1:
        hours = 0;
        minutes = Integer.parseInt(tempArr[0]);
        seconds = Integer.parseInt(tempArr[1]);
        break;
      case 2:
        hours = Integer.parseInt(tempArr[0]);
        minutes = Integer.parseInt(tempArr[1]);
        seconds = Integer.parseInt(tempArr[2]);
        break;
      default:
        break;
    }
  }

  /**
  *Converts the class atributes to one string.<br>
  */
  public String toString() {
    if (hours != 0) {
      format += hours + ":" + minutes + ":" + seconds;
    }
    else if (minutes != 0) {
      format += minutes + ":" + seconds;
    }
    else {
      format += seconds;
    }
    return format;
  }
}
