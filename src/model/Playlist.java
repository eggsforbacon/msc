package model;
import java.util.*;

/**
*Class that inherits to its public, restricted and private variants.<br>
*@author Samuel Hernandez / Zac
*/
abstract public class Playlist {
  private String playlistName;
  private Duration playlistDuration;
  private ArrayList<String> playlistGenres = new ArrayList<>();
  private boolean empty = true;

  private ArrayList<Song> songs = new ArrayList<>();

  Genre[] genres = Genre.values();

  /**
  *General constructor.<br>
  */
  public Playlist(String playlistName) {
    this.playlistName = playlistName;
    playlistDuration = new Duration();
    playlistGenres.add("UNKNOWN");
  }

  /**
  *Adds a song to the playlist.<br>
  *<b>Pre: </b>The song is part of the pool.<br>
  *<b>Post: </b>The song is added to the playlist.<br>
  *@param song Song to be added to the playlist.<br>
  */
  public boolean addSong(Song song) {
    if (empty) {
      playlistGenres.remove("UNKNOWN");
      empty = false;
    }
    boolean found = false;
    for (int i = 0; i < songs.size() && !found; i++) {
      found = songs.get(i).getSongTitle().equals(song.getSongTitle());
      if (found) {
        found = songs.get(i).getArtist().equals(song.getArtist());
      }
    }
    if (!found) {
      songs.add(song);
      playlistGenres.add(song.getGenre());
      playlistDuration.updateDuration(song.getSongDuration());
    }
    return !found;
  }

  /**
  *Returns specific info of the playlist object
  *<b>Pre: </b><br>
  *<b>Post: </b>The information is returned.<br>
  */
  abstract public String[] showInfo();

  //Getters

  public String getPlaylistName() {
    return playlistName;
  }

  public String getPlaylistDuration() {
    return playlistDuration.toString();
  }

  public String getPlaylistGenres() {
    StringBuilder ret = new StringBuilder();
    for (String s : playlistGenres) {
      ret.append(s.toUpperCase()).append(",");
    }
    return ret.toString();
  }

  public ArrayList<Song> getSongs() {
    return songs;
  }
}
