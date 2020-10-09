package model;
import ui.*;
import java.util.*;

public class User {
  private final String[] RANKS = {"Newbie","Mild Contributor","Little Contributor","Star Contributor"};

  private String userName;
  private String password;
  private String userRank;
  private int age;
  private ArrayList<Song> addedSongs = new ArrayList<Song>();

  public User(String userName, String password, int age) {
    this.userName = userName;
    this.password = password;
    this.age = age;
    userRank = RANKS[0];
  }

  //Getters

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getUserRank() {
    return userRank;
  }

  public int getAge() {
    return age;
  }

  public ArrayList<Song> getAddedSongs() {
    return addedSongs;
  }

  //Setters

  public void setUserRank(int rankIndex) {
    userRank = RANKS[rankIndex];
  }

  public int addSong(String songTitle, String artist, String launchDate, String genre, Scanner in) {
    boolean contains = Arrays.asList(Song.getGENRES()).contains(genre.toLowerCase());

    while (contains == false) {
      genre = Stream.addSongValid(in);
      contains = Arrays.asList(Song.getGENRES()).contains(genre.toLowerCase());
    }
    Song song = new Song(songTitle,artist,launchDate,genre);
    addedSongs.add(song);

    return addedSongs.size();
  }
}
