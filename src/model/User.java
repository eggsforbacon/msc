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
  *@param songTitle String containing the song's name. <b>Must not be <i>null or blank</i>.</b><br>
  *@param artist String containing the song's artist. <b>Must not be <i>null or blank</i>.</b><br>
  *@param launchDate String containing the song's release date. <b>Must not be <i>null or blank</i>.</b><br>
  *@param genre String containing the song's genre. <b>Must not be <i>null, blank</i> or be excluded out of the array <i>GENRES</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>*/
  public int addSong(String songTitle, String artist, String launchDate, String genre, Scanner in) {
    return 0;
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
  *@return The current songs the user has added.<br>
  */
  public ArrayList<Song> getAddedSongs() {
    return addedSongs;
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
