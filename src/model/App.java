package model;
import ui.*;
import java.util.*;

/**
*Class that stores the Song Pool, User list, and playlists.<br>
*@author Samuel Hernandez / Zac
*/
public class App {

  private ArrayList<User> userList = new ArrayList<User>();
  private ArrayList<Song> pool = new ArrayList<Song>();
  private ArrayList<PublicPL> publicPlaylists = new ArrayList<PublicPL>();
  private ArrayList<PrivatePL> privatePlaylists = new ArrayList<PrivatePL>();
  private ArrayList<RestrictedPL> restrictedPlaylists = new ArrayList<RestrictedPL>();
  private int totPlaylists = 0;

  /**
  *Changes data of the currentUser.<br>
  *<b>Pre: </b>A user has been previously created.<br>
  *<b>Post: </b>The user's data is succesfully modified.<br>
  *@param user User object to be changed.<br>
  */
  public User editCurrentUser(User user, String newUsername, String newPassword, int newAge) {
    boolean flag = false;
    for (int i = 0; i < userList.size() && !flag ; i++) {
      boolean condition = user.getUserName().equals(userList.get(i).getUserName());
      if (condition == true) {
        userList.get(i).setUserName(user.getUserName());
        userList.get(i).setAge(user.getAge());
        userList.get(i).setPassword(user.getPassword());
        flag = true;
      }
    }
    return user;
  }

  //Getters

  /**
  *@return The current users registered in the app.<br>
  */
  public ArrayList<User> getUserList() {
    return userList;
  }

  /**
  @return The song pool.<br>
  */
  public ArrayList<Song> getPool() {
    return pool;
  }

  /**
  @return The public Playlists.<br>
  */
  public ArrayList<PublicPL> getPublicPlaylists() {
    return publicPlaylists;
  }

  /**
  @return The restricted Playlists.<br>
  */
  public ArrayList<RestrictedPL> getRestrictedPlaylists() {
    return restrictedPlaylists;
  }

  /**
  @return The private Playlists.<br>
  */
  public ArrayList<PrivatePL> getPrivatePlaylists() {
    return privatePlaylists;
  }

  //Adders

  /**
  *Adds a User.<br>
  *@param user User object to be added. <b>Must be <i>previously initialized</i>.</b><br>
  */
  public boolean addToUserList(User user) {
    if (userList.size() < 10) {
      userList.add(user);
      return true;
    }
    else {
      return false;
    }
  }

  /**
  *Adds a Song.<br>
  *@param song Song object to be added. <b>Must be <i>previously initialized</i>.</b><br>
  */
  public boolean addToPool(Song song) {
    boolean cond2 = false;
    boolean cond1 = false;
    for (int i = 0; i < pool.size() && !cond1; i++) {
      Song compareTo = pool.get(i);
      cond1 = (compareTo.getSongTitle().equals(song.getSongTitle()) == true) && (compareTo.getArtist().equals(song.getArtist()) == true);
    }
    cond2 = pool.size() < 30;
    if (cond1 && cond2 == false) {
      pool.add(song);
      return true;
    }
    else {
      return false;
    }
  }

  /**
  *Adds a public playlist.<br>
  *@param pbPl PublicPL object to be added. <b>Must be <i>previously initialized</i>.</b><br>
  */
  public boolean addToPublicPlaylists(PublicPL pbPl) {
    if (totPlaylists < 20) {
      publicPlaylists.add(pbPl);
      totPlaylists += 1;
      return true;
    }
    else {
      return false;
    }
  }

  /**
  *Adds a private playlist.<br>
  *@param prPl PrivatePL object to be added. <b>Must be <i>previously initialized</i>.</b><br>
  */
  public boolean addToPrivatePlaylists(PrivatePL prPl) {
    if (totPlaylists < 20) {
      privatePlaylists.add(prPl);
      totPlaylists += 1;
      return true;
    }
    else {
      return false;
    }
  }

  /**
  *Adds a restricted playlist.<br>
  *@param rsPl RestrictedPL object to be added. <b>Must be <i>previously initialized</i>.</b><br>
  */
  public boolean addToRestrictedPlaylists(RestrictedPL rsPl) {
    if (totPlaylists < 20) {
      restrictedPlaylists.add(rsPl);
      totPlaylists += 1;
      return true;
    }
    else {
      return false;
    }
  }
}
