package model;
import java.util.*;

/**
*Class that stores the Song Pool, User list, and playlists.<br>
*@author Samuel Hernandez / Zac
*/
public class App {

  private ArrayList<User> userList = new ArrayList<>();
  private ArrayList<Song> pool = new ArrayList<>();
  private ArrayList<Playlist> playlists = new ArrayList<>();
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
  @return The Playlists.<br>
  */
  public ArrayList<Playlist> getPlaylists() {
    return playlists;
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
      for (int s = 0; s < pool.size() && !exists; s++) {
        exists = song.getSongTitle().equals(pool.get(s).getSongTitle());
        if (exists) {
          exists = song.getArtist().equals(pool.get(s).getArtist());
        }
      }
      if (!exists) {
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
  *Adds a playlist to the playlists.<br>
  *@param playlist Playlist object to be added. <b>Must be <i>previously initialized</i>.</b><br>
  */
  public boolean addToPlaylists(Playlist playlist) {
    if (playlists.size() < 20) {
      playlists.add(playlist);
      return true;
    }
    else {
      return false;
    }
  }
}
