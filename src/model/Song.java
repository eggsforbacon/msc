package model;
import ui.*;

public class Song {
  private static final String[] GENRES = {"rock","hiphop","clasica","reggae","salsa","metal","indie\\"};

  private String songTitle;
  private String artist;
  private String launchDate;
  private String genre;

  public Song(String songTitle, String artist, String launchDate, String genre) {
    this.songTitle = songTitle;
    this.artist = artist;
    this.launchDate = launchDate;
    this.genre = genre;
  }

  //Getters

  public static String[] getGENRES() {
    return GENRES;
  }

  public String getSongTitle() {
    return songTitle;
  }

  public String getArtist() {
    return artist;
  }

  public String getGenre() {
    return genre;
  }

  
}
