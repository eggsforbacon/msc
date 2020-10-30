package model;
import java.util.*;

/**
*Class that inherits to its public, restricted and private variants.<br>
*@author Samuel Hernandez / Zac
*/
abstract class Playlist {
  private String playlistName;
  private Duration playlistDuration;
  private ArrayList<String> playlistGenres = new ArrayList<String>();
  private boolean empty = true;

  private ArrayList<Song> songs = new ArrayList<Song>();

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
  public void addSong(Song song) {
    if (empty == true) {
      playlistGenres.remove("UNKNOWN");
      empty = false;
    }
    songs.add(song);
    playlistGenres.add(song.getGenre());
    playlistDuration.updateDuration(song.getSongDuration());
  }
}
