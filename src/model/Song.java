package model;
import ui.*;

/**
*Class that defines the blueprint of a Song object and all its functionalities.<br>
*@author Samuel Hernandez / Zac
*/
public class Song {
  private Genre[] genres = Genre.values();

  private String songTitle;
  private String artist;
  private String releaseDate;
  private Duration songDuration;
  private String genre;

  /**
  *Constructor of the class.<br>
  *@param songTitle String containing the song's name. <b>Must not be <i>null or blank</i>.</b><br>
  *@param artist String containing the song's artist. <b>Must not be <i>null or blank</i>.</b><br>
  *@param releaseDate String containing the song's release date. <b>Must not be <i>null or blank</i>.</b><br>
  *@param index Integer containing the genre's index. <b>Must be <i>positive</i> and less than the length of the array <i>GENRES</i>.</b><br>
  */
  public Song(String songTitle, String artist, String releaseDate, Duration songDuration, int index) {
    this.songTitle = songTitle;
    this.artist = artist;
    this.releaseDate = releaseDate;
    this.songDuration = songDuration;
    genre = genres[index].name();
  }

  //Getters

  /**
  *@return The song's title.<br>
  */
  public String getSongTitle() {
    return songTitle;
  }

  /**
  *@return The song's artist.<br>
  */
  public String getArtist() {
    return artist;
  }

  /**
  *@return The song's genre.<br>*/
  public String getGenre() {
    return genre;
  }
}
