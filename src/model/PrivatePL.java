package model;
import java.util.*;

/**
*Specifies on how a the private variant of Playlist should behave. User verification when adding songs<br>
*is pending and will be added in future versions.<br>
*@author Samuel Hernandez / Zac<br>
*@since 0.3<br>
*@see Playlist Playlist<br>
*/
public class PrivatePL extends Playlist {

  private String primeUserName;

  /**
  *The specific constructor of the class.<br>
  *@param playlistName The name of the playlist.<br>
  *@see model.Playlist#Playlist(String) Constructor in parent<br>
  */
  public PrivatePL(String playlistName, String primeUserName) {
    super(playlistName);
    this.primeUserName = primeUserName;
  }

  /**
  *Returns specific info of the private playlist object.<br>
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
