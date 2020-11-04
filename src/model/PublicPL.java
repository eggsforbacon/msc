package model;
import java.util.*;

/**
*Class that specifies the public playlists atributes and methods.<br>
*@author Samuel Hernandez / Zac
*/
public class PublicPL extends Playlist {

  private ArrayList<Double> scores = new ArrayList<>();
  private double score;

  public PublicPL(String playlistName) {
    super(playlistName);
    score = 0.00;
  }

  /**
  *Returns specific info of the playlist object
  *<b>Pre: </b><br>
  *<b>Post: </b>The information is returned.<br>
  */
  @Override
  public String[] showInfo() {
    String[] info = {
      "************************************************",
      "************************************************",
      "*Nombre:                                       *",
      super.getPlaylistName(),
      "*Duracion:                                     *",
      super.getPlaylistDuration(),
      "*Generos:                                      *",
      super.getPlaylistGenres(),
      "*Rating:                                       *",
      Double.toString(score),
      "************************************************",
      "*******************Canciones********************"};
      for(Song s : getSongs()) {
        info = Arrays.copyOf(info,info.length + 1);
        info[info.length - 1] = "*" + s.getSongTitle() + "\n";
      }
    return info;
  }

  /**
  *Modifies the score of the playlist.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The score is modified.<br>
  *@param newScore Double that carries the score to be added to the average score. <b>Must be between <i>1 and 5</i>.</b><br>
  */
  public boolean modifyScore(double newScore) {
    if (newScore <= 5 && newScore >= 1) {
      scores.add(newScore);
      for (double d: scores) {
        score += d;
      }
      score /= scores.size();
      return true;
    }
    else return false;
  }

  //Getters

  public double getScore() {
    return score;
  }
}
