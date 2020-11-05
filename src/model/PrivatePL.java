package model;
import java.util.*;

/**
*Class that defines the private playlist specifications.<br>
*@author Samuel Hernandez / Zac
*/
public class PrivatePL extends Playlist {

  private String primeUserName;

  public PrivatePL(String playlistName, String primeUserName) {
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
      "*Tipo de Playlist: Privada",
      "*Nombre: " + super.getPlaylistName(),
      "*Duracion: " + super.getPlaylistDuration(),
      "*Generos: " + super.getPlaylistGenres(),
      "*Usuario Principal: " + primeUserName,
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
}
