package model;
import java.util.*;

/**
*Specifies on how a the restricted variant of Playlist should behave. User verification when adding<br>
*songs is pending and will be added in future versions.<br>
*@author Samuel Hernandez / Zac<br>
*@since 0.3<br>
*@see Playlist Playlist<br>
*/
public class RestrictedPL extends Playlist {

  private ArrayList<String> entitledUsersID = new ArrayList<>();
  private String primeUserName;
  private int BIAS = 0;

  /**
  *The specific constructor of the class.<br>
  *@param playlistName The name of the playlist.<br>
  *@param primeUserName The username of the main user of the playlist. <b>Must be an <i>existing user</i>.</b><br>
  *@see Playlist#Playlist(String) Constructor in parent<br>
  */
  public RestrictedPL(String playlistName, String primeUserName) {
    super(playlistName);
    this.primeUserName = primeUserName;
  }

  /**
  *Returns specific info of the restricted playlist object
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
      "*Usuario Principal: " + primeUserName + " (" + (entitledUsersID.size() + BIAS) + " usuarios activos)",
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
  *Adds a user to the playlist. There is no current verification for wether the user is already in<br>
  *the playlist or not. The addition is also artificial, and done only with a bias that will increment<br>
  *everytime a user is called to be added.<br>
  *<b>Pre: </b>There are less than 5 users.<br>
  *<b>Post: </b>The user is added.<br>
  */
  public void addUser() {
    if (BIAS < 5) {
      BIAS++;
    }
  }
}
