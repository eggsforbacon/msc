package model;
import java.util.*;

/**
*Specifies on how a the public variant of Playlist should behave.<br>
*@author Samuel Hernandez / Zac<br>
*@since 0.3<br>
*@see Playlist Playlist<br>
*/
public class PublicPL extends Playlist {

  private ArrayList<Double> scores = new ArrayList<>();
  private double score;

  /**
  *The specific constructor of the class.<br>
  *@param playlistName The name of the playlist.<br>
  *@see model.Playlist#Playlist(String) Constructor in parent<br>
  */
  public PublicPL(String playlistName) {
    super(playlistName);
    score = 0.00;
  }

  /**
  *Returns specific info of the public playlist object.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The information is returned.<br>
  */
  @Override
  public String[] showInfo() {
    String[] info = {
      "************************************************",
      "************************************************",
      "*Tipo de Playlist: Publica",
      "*Nombre: " + super.getPlaylistName(),
      "*Duracion: " + super.getPlaylistDuration(),
      "*Generos: " + super.getPlaylistGenres(),
      "*Rating: " + Double.toString(score),
      "************************************************",
      "*******************Canciones********************"};
      for(Song s : getSongs()) {
        info = Arrays.copyOf(info,info.length + 1);
        info[info.length - 1] = "*" + s.getSongTitle() + "\n";
      }
      if (getSongs().size() == 0) {
        info = Arrays.copyOf(info,info.length + 1);
        info[info.length - 1] = "***********No hay canciones todavia*************";
      }
    return info;
  }

  /**
  *Modifies the score of the playlist.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The score is modified.<br>
  *@param newScore Double that represents the score to be added to the average score. <b>Must be between <i>1 and 5</i>.</b><br>
  */
  public String modifyScore(double newScore) {
    double temp = score;
    score = 0;
    if (newScore <= 5 && newScore >= 1) {
      scores.add(newScore);
      for (double d: scores) {
        score += d;
      }
      score /= scores.size();
      return "************Puntaje aniadido con exito**********";
    }
    else {
      score = temp;
      return "********************Error***********************";
    }
  }

  //Getters

  /**
  *@return The score of the playlist.<br>
  */
  public double getScore() {
    return score;
  }
}
