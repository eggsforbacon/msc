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
  private String album;
  private String releaseDate;
  private Duration songDuration;
  private String genre;

  /**
  *Constructor of the class.<br>
  *@param songTitle String containing the song's name. <b>Must not be <i>null or blank</i>.</b><br>
  *@param artist String containing the song's artist. <b>Must not be <i>null or blank</i>.</b><br>
  *@param album String containing the song's album. <b>Must not be <i>null or blank</i>.</b><br>
  *@param releaseDate String containing the song's release date. <b>Must not be <i>null or blank</i>.</b><br>
  *@param index Integer containing the genre's index. <b>Must be <i>positive</i> and less than the length of the array <i>GENRES</i>.</b><br>
  */
  public Song(String songTitle, String artist, String album, String releaseDate, Duration songDuration, int index) {
    this.songTitle = songTitle;
    this.artist = artist;
    this.album = album;
    this.releaseDate = releaseDate;
    this.songDuration = songDuration;
    genre = genres[index].name();
  }

  public String[] showInfo() {
    return new String[] {
      "************************************************",
      "**Titulo: ",
      songTitle,
      "**Artista: ",
      artist,
      "**Album: ",
      album,
      "**Fecha de Lanzamiento: ",
      releaseDate,
      "**Duracion: ",
      songDuration.toString(),
      "**Genero: ",
      genre,
      "************************************************",
      "*Aniadir a un playlist                      [1]*",
      "*Volver                                 [ENTER]*",
      "************************************************"};
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
  *@return The song's album.<br>
  */
  public String getAlbum() {
    return album;
  }

  /**
  *@return The song's release date.<br>
  */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
  *@return The song's duration as a string.<br>
  */
  public String getStringDuration() {
    return songDuration.toString();
  }

  /**
  *@return The song's duration.<br>
  */
  public Duration getSongDuration() {
    return songDuration;
  }

  /**
  *@return The song's genre.<br>*/
  public String getGenre() {
    return genre;
  }
}
