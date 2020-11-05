package model;
import java.util.*;

/**
*Class that defines the restricted playlists atributes and methods.<br>
*@author Samuel Hernandez / Zac
*/
public class RestrictedPL extends Playlist {

  private ArrayList<String> entitledUsersID = new ArrayList<>();
  private String primeUserName;
  private int BIAS = 0;

  public RestrictedPL(String playlistName, String primeUserName) {
    super(playlistName);
    this.primeUserName = primeUserName;
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
      "*Tipo de Playlist: Restringida",
      "*Nombre: " + super.getPlaylistName(),
      "*Duracion: " + super.getPlaylistDuration(),
      "*Generos: " + super.getPlaylistGenres(),
      "*Usuario Principal: " + primeUserName + "(" + (entitledUsersID.size() + BIAS) + " usuarios activos)",
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
  *Adds a user to the playlist.<br>
  *<b>Pre: </b>There are less than 5 users.<br>
  *<b>Post: </b>The user is added.<br>
  */
  public void addUser() {
    if (BIAS < 5) {
      BIAS++;
    }
  }
}
