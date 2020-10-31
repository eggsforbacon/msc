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
  *@param userInfo The information for a user object to be added. <b>Must be of size <i>3</i>.</b><br>
  */
  public boolean addToUserList(String[] userInfo) {
    User newUser = new User(userInfo[0],userInfo[1],Integer.parseInt(userInfo[2]));
    if (userList.size() < 10) {
      userList.add(newUser);
      return true;
    }
    else {
      return false;
    }
  }

  /**
  *Adds a Song.<br>
  *@param songInfo String array with the info of the new song. <b>Must be of size <i>4</i>.</b><br>
  *@param songDuration Duration object that is the duration of the song. <b>Must be <i>previously initialized</i>.</b><br>
  */
  public boolean addToPool(String[] songInfo, Duration songDuration) {
    if (pool.size() < 30) {
      Song newSong = new Song(songInfo[0],songInfo[1],songInfo[2],songInfo[3],songDuration, Integer.parseInt(songInfo[4]));
      boolean exists = false;
      for (int s = 0; s < pool.size() && !exists; s++) {
        exists = newSong.getSongTitle().equals(pool.get(s).getSongTitle());
        if (exists) {
          exists = newSong.getArtist().equals(pool.get(s).getArtist());
        }
      }
      if (!exists) {
        pool.add(newSong);
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
