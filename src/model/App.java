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
    if (pool.size() < 30) {
      boolean exists = false;
      for (int s = 0; s < pool.size() && exists == false; s++) {
        exists = song.getSongTitle().equals(pool.get(s).getSongTitle());
        if (exists == true) exists = song.getArtist().equals(pool.get(s).getArtist());
      }
      if (exists == false) {
        pool.add(song);
        return true;
      }
      else {
        return false;
      }
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
