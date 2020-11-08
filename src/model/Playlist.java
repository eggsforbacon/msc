package model;
import java.util.*;

/**
*Represents the general atributes and abilities a playlist object has in the project context.<br>
*This class inherits its Public, Restricted and Private variants.<br>
*@author Samuel Hernandez / Zac<br>
*@since 0.3<br>
*@see PublicPL • Public Playlist<br>
*@see RestrictedPL Restricted Playlist<br>
*@see PublicPL Public Playlist<br>
*/
abstract public class Playlist {
  private String playlistName;
  private Duration playlistDuration;
  private ArrayList<String> playlistGenres = new ArrayList<>();
  private boolean empty = true;
  private String identity;

  private ArrayList<Song> songs = new ArrayList<>();

  /**
  *General constructor.<br>
  *@param playlistName The name of the playlist.<br>
  */
  public Playlist(String playlistName) {
    this.playlistName = playlistName;
    playlistDuration = new Duration();
    playlistGenres.add("UNKNOWN");
    identity = "";
    initID();
  }

  /**
  *Adds a song to the playlist.<br>
  *<b>Pre: </b>The song is part of the pool.<br>
  *<b>Post: </b>The song is added to the playlist.<br>
  *@param song Song to be added to the playlist.<br>
  *@see App#addToPool(String[],Duration) addToPool method in class App<br>
  */
  public boolean addSong(Song song) {
    if (empty) {
      playlistGenres.remove("UNKNOWN");
      empty = false;
    }
    boolean found = false;
    for (int i = 0; i < songs.size() && !found; i++) {
      found = (songs.get(i).getSongTitle().equals(song.getSongTitle())) && (songs.get(i).getArtist().equals(song.getArtist()));
      if (found) {
        found = songs.get(i).getArtist().equals(song.getArtist());
      }
    }
    if (!found) {
      songs.add(song);
      playlistGenres.add(song.getGenre());
      playlistDuration.updateDuration(song.getSongDuration());
    }
    return found;
  }

  /**
  *Returns specific info of the playlist object.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The information is returned.<br>
  */
  abstract public String[] showInfo();

  /**
  *Generates a uniquue 10 digit alphanumeric ID for the playlist.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The ID is generated.<br>
  */
  private void initID() {
    Random ran = new Random();
    char[] alphabeth = {
      'A','B','C','D','E','F','G','H','I','J','K','L','M',
      'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    for (int i = 0; i < 2; i++) {
      identity += alphabeth[ran.nextInt(26)];
      identity += Integer.toString(ran.nextInt(10));
    }
  }

  //Getters

  /**
  *@return The playlist name.<br>
  */
  public String getPlaylistName() {
    return playlistName;
  }

  /**
  *@return The playlist formated duration.<br>
  */
  public String getPlaylistDuration() {
    return playlistDuration.toString();
  }

  /**
  *@return The genres of the playlist.<br>
  */
  public String getPlaylistGenres() {
    StringBuilder ret = new StringBuilder();
    for (String s : playlistGenres) {
      ret.append(s.toUpperCase());
      if (playlistGenres.size() != 1) ret.append(", ");
    }
    return ret.toString();
  }

  /**
  *@return The songs in the playlist.<br>
  */
  public ArrayList<Song> getSongs() {
    return songs;
  }

  /**
  *@return The playlist Identity.<br>
  */
  public String getIdentity() {
    return identity;
  }
}
