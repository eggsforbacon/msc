package model;
import ui.*;
import java.util.*;

public class User {
  private final String[] RANKS = {"Newbie","Mild Contributor","Little Contributor","Star Contributor"};

  private String userName;
  private String password;
  private String userRank;
  private int age;
  private ArrayList<Song> addedSongs = new ArrayList<Song>();

  /**
  *Constructor of the class.<br>
  *@param userName String containing the user name. <b>Must not contain <i>spaces, be null or blank</i>.</b><br>
  *@param password String containing the user password. <b>Must not be <i>null or blank</i>.</b><br>
  *@param age Integer containing the age of the user. <b>Must be an <i>integer</i>.</b><br>
  */
  public User(String userName, String password, int age) {
    this.userName = userName;
    this.password = password;
    this.age = age;
    userRank = RANKS[0];
  }

  /**
  *Adds a song to the songs the user has added.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The song is added to the User's song's arraylist.<br>
  *@param newSong Song object holding the song to be added. <b>Must be previously <i>initialized</i>.</b><br>
  *@param msc App object in which all the app's info is stored. <b>Must be the <i>current app and not a new object</i>.</b><br>
  */
  public App addSong(Song newSong, App msc) {
    return msc;
  }

  //Getters

  /**
  *@return The current username.<br>*/
  public String getUserName() {
    return userName;
  }

  /**
  *@return The current password.<br>
  */
  public String getPassword() {
    return password;
  }

  /**
  @return The current user's rank.<br>
  */
  public String getUserRank() {
    return userRank;
  }

  /**
  *@return The current user's age.<br>
  */
  public int getAge() {
    return age;
  }

  /**
  *@return The number of songs the user has added.<br>
  */
  public int getAddedSongs() {
    return addedSongs.size();
  }

  //Setters

  /**
  *@param rankIndex The index of the rank to be set. <b>Must be a <i>positive integer lesser or equal to 3</i>.</b><br>
  */
  public void setUserRank(int rankIndex) {
    userRank = RANKS[rankIndex];
  }

  /**
  *@param userName The username to be set to.<br>
  */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
  *@param password The password to be set to.<br>
  */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
  *@param age The age to be set to.<br>
  */
  public boolean setAge(int age) {
    if (this.age < age) {
      this.age = age;
      return true;
    }
    else {
      return false;
    }
  }
}
