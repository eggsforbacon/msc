package model;
import ui.*;

public class Song {
  private static final String[] GENRES = {"rock","hiphop","clasica","reggae","salsa","metal","indie\\"};

  private String songTitle;
  private String artist;
  private String launchDate;
  private String genre;

  /**
  *Constructor of the class.<br>
  *@param songTitle String containing the song's name. <b>Must not be <i>null or blank</i>.</b><br>
  *@param artist String containing the song's artist. <b>Must not be <i>null or blank</i>.</b><br>
  *@param launchDate String containing the song's release date. <b>Must not be <i>null or blank</i>.</b><br>
  *@param genre String containing the song's genre. <b>Must not be <i>null, blank</i> or be excluded out of the array <i>GENRES</i>.</b><br>
  */
  public Song(String songTitle, String artist, String launchDate, String genre) {
    this.songTitle = songTitle;
    this.artist = artist;
    this.launchDate = launchDate;
    this.genre = genre;
  }

  //Getters

  /**
  *@return The valid genres list.<br>
  */
  public static String[] getGENRES() {
    return GENRES;
  }

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
