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
  *Constructor of the class.<br>
  */
  public Duration() {
    hours = 0;
    minutes = 0;
    seconds = 0;
  }

  /**
  *Converts a string to the correct format.<br>
  *<b>Pre: </b>The string is correctly formated.<br>
  *<b>Post: </b>The string is stored as sepatrate integer values.<br>
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
  *<b>Pre: </b><br>
  *<b>Post: </b>The formated string is returned.<br>
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
    if (seconds == 0) format += "0";
    return format;
  }

  /**
  *Adds another Duration to the class' atributes.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The duration is updated.<br>
  *@param duration Duration object to be added. <b>Must be <i>initialized</i>.</b><br>
  */
  public void updateDuration(Duration duration) {
    int aux = 0;
    seconds += duration.getSeconds();
    minutes += duration.getMinutes();
    hours += duration.getHours();

    if (seconds >= 60) {
      seconds %= 60;
      aux = 1;
    }
    minutes += aux--;
    if (minutes >= 60) {
      minutes %= 60;
      aux = 1;
    }
    hours += aux;
  }

  //Getters

  /**
  *@return The hour atribute.<br>
  */
  public int getHours() {
    return hours;
  }

  /**
  *@return The minutes atribute.<br>
  */
  public int getMinutes() {
    return minutes;
  }

  /**
  *@return The seconds atribute.<br>
  */
  public int getSeconds() {
    return seconds;
  }
}
