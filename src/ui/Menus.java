package ui;
import model.*;
import java.util.*;

/**
*Handles most of the user interface, which are the menus displayed.<br>
*@author Samuel Hernandez / Zac
*/
public class Menus implements UIs {

  private final int ADD_USER = 1;
  private final int SHOW_USERS = 2;
  private final int ADD_SONG = 3;
  private final int SHOW_POOL = 4;
  private final int ADD_PLAYLIST = 5;
  private final int SHOW_PLAYLISTS = 6;
  private boolean exit = false;
  private App msc = new App();

  /**
  *Displays the welcome logo on screen. <br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  private void welcomeLogo(int millis, Scanner in) {
    Operations.clrscm();
    System.out.println("(Version " + Main.VERSION + ")");
    Stream.slowPrint(millis,LOGO);
    System.out.println("(Presionar [ENTER] para continuar...)");
    in.nextLine();
    System.out.println("Iniciando...");
    Operations.queue(1000);
    Operations.clrscm();
  }

  /**
  *Starts the program.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The program is started succesfully.<br>
  */
  public void startProgram(int millis) {
    Scanner in = new Scanner(System.in);
    welcomeLogo(millis,in);
    do {
      showMenu(millis,in);
    }while (!exit);
  }

  /**
  *Displays the main menu. <br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  private void showMenu(int millis, Scanner in) {
    Operations.clrscm();
    Stream.slowPrint(millis,MAIN_MENU);
    switchMainMenu(in.nextInt(),in,millis);
  }

  /**
  *Shows a menu or another depending on user input in the main menu.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The correct menu is called and showed.<br>
  *@param answer Integer that handles the decision of the user.<br>
  *@param  in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  *@param  millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  */
  private void switchMainMenu(int answer, Scanner in, int millis) {
    switch (answer) {
      case 0:
        exit = true;
        break;
      case ADD_USER:
        showAddUserMenu(in);
        break;
      case SHOW_USERS:
        showProfilesMenu(millis,in);
        break;
      case ADD_SONG:
        showAddSongMenu(in);
        break;
      case SHOW_POOL:
        showPoolMenu(millis,in);
        break;
      case ADD_PLAYLIST:
        showAddPlaylistsMenu(millis,in);
        break;
      case SHOW_PLAYLISTS:
        break;
      default:
        throw new IllegalStateException("Valor inesperado: " + answer);
    }
  }

  /**
  *Shows the menu when first option is selected in main menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  private void showAddUserMenu(Scanner in) {
    Operations.clrscm();
    String[] newUserInfo = new String[3];
    for (int i = 0; i < ADD_USER_MENU.length; i++) {
      System.out.println(ADD_USER_MENU[i]);
      switch (i) {
        case 2:
          newUserInfo[0] = in.next();
          in.nextLine();
          break;
        case 3:
          newUserInfo[1] = in.nextLine();
          break;
        case 4:
          newUserInfo[2] = in.nextLine();
          break;
        case 5:
          msc.addToUserList(newUserInfo);
        default:
          break;
      }
    }
    Operations.queue(1500);
  }

  /**
  *Shows the menu when second option is selected in main menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  private void showProfilesMenu(int millis,Scanner in) {
    Operations.clrscm();
    ArrayList<User> userList = msc.getUserList();
    for (User i : userList) {
      for (int j = 0; j < 6; j++) {
        switch (j) {
          case 2:
            System.out.println(SEE_PROFILES_MENU[j] + i.getUserName());
            break;
          case 3:
            System.out.println(SEE_PROFILES_MENU[j] + i.getAge());
            break;
          case 4:
            System.out.println(SEE_PROFILES_MENU[j] + i.getUserRank());
            break;
          case 5:
            System.out.println(SEE_PROFILES_MENU[j] + i.getQuantity());
            break;
          default:
            System.out.println(SEE_PROFILES_MENU[j]);
            break;
        }
        Operations.queue(millis);
      }
    }
    for (int k = 6; k < 9; k++) {
      System.out.println(SEE_PROFILES_MENU[k]);
      Operations.queue(millis);
    }
    in.nextLine();
  }

  /**
  *Shows the menu when third option is selected in main menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  private void showAddSongMenu(Scanner in) {
    Operations.clrscm();
    String[] newSongInfo = new String[4];
    String newDurationStr;
    Duration newDurationObj = new Duration();
    Genre[] genres = Genre.values();
    int k = 1;
    for (int i = 0; i < ADD_SONG_MENU.length; i++) {
      System.out.println(ADD_SONG_MENU[i]);
      switch (i) {
        case 2:
          newSongInfo[0] = in.nextLine();
          break;
        case 3:
          newSongInfo[1] = in.nextLine();
          break;
        case 4:
          newSongInfo[2] = in.nextLine();
          break;
        case 5:
          newSongInfo[3] = in.nextLine();
          break;
        case 6:
          newDurationStr = in.nextLine();
          newDurationObj.toIntFormat(newDurationStr);
          break;
        case 7:
          int j = 0;
          for (Genre g : genres) {
            System.out.println("**[" + j + "] " + g );
            j++;
          }
          break;
        case 9:
          newSongInfo[4] = in.nextLine();
          break;
        case 10:
          for (User u : msc.getUserList()) {
            System.out.println("**[" + k + "] " + u.getUserName());
            k++;
          }
          k = in.nextInt() - 1;
          in.nextLine();
        default:
          break;
      }
    }
    if (msc.addToPool(newSongInfo,newDurationObj)) {
      msc.getUserList().get(k).modifyRank();
    }
    Operations.queue(1000);
  }

  /**
  *Shows the menu when fourth option is selected in main menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  private void showPoolMenu(int millis, Scanner in) {
    Operations.clrscm();
    ArrayList<Song> pool = msc.getPool();
    for (Song song : pool) {
      for (int i = 0; i < 8; i++) {
        switch (i) {
          case 2:
            System.out.println(SEE_POOL_MENU[i] + song.getSongTitle());
            break;
          case 3:
            System.out.println(SEE_POOL_MENU[i] + song.getArtist());
            break;
          case 4:
            System.out.println(SEE_POOL_MENU[i] + song.getAlbum());
            break;
          case 5:
            System.out.println(SEE_POOL_MENU[i] + song.getReleaseDate());
            break;
          case 6:
            System.out.println(SEE_POOL_MENU[i] + song.getStringDuration());
            break;
          case 7:
            System.out.println(SEE_POOL_MENU[i] + song.getGenre());
          default:
            System.out.println(SEE_POOL_MENU[i]);
            break;
        }
        Operations.queue(millis);
      }
    }
    for (int k = 8; k < 11; k++) {
      System.out.println(SEE_POOL_MENU[k]);
      Operations.queue(millis);
    }
    in.nextLine();
  }

  /**
  *Shows the menu when fifth option is selected in main menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
   * @param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
   * @param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br> */
  private void showAddPlaylistsMenu(int millis, Scanner in) {


  }
}
