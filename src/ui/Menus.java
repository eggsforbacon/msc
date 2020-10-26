package ui;
import model.*;
import java.util.*;

/**
*Handles most of the user interface, which are the menus displayed.<br>
*@author Samuel Hernandez / Zac
*/
public class Menus {

  private App msc = new App();
  private static final String[] LOGO = {
    "(((((((((((((((((((((((((((((((((((((((((((((((((",
    "((((((((((((((((/((((((((((((((((((((((((((((((((",
    "(((/  .(((((((*  .((((((*        (((((/      /(((",
    "(((/   .((((((.  .(((((   ,((((((((((*  .((((((((",
    "(((/    /((((/   .((((/  ,(((((((((((.  /((((((((",
    "(((/     ((((*   .((((*  ,(((((((((((/   ((((((((",
    "(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((",
    "(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((",
    "(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((",
    "(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((",
    "(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((",
    "(((/  .((    ((   /((((  .(((((((((((((((((.  /((",
    "(((/  .((.  .((.  *((((,  *((((((((((((((((   /((",
    "(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((",
    "(((/  .((((((((.  *((((((.        *((   .   .((((",
    "(((((((((((((((/*/((((((((((///(((((((////(((((((",
    "(((((((((((((((((((((((((((((((((((((((((((((((((",
    "(((((((((((//MUSIC COLLECT & SHARE//(((((((((((((\n",
    "              ./(###((///((###(*",
    "           *#(,                   *((,",
    "        ,#/                           ((",
    "      .#*          .**/////*,.          ((",
    "     *(.      .//////////////////*       *#",
    "    .#,     *///////////////////////,     /(",
    "    /(    *///////////////////////////    .#.",
    "  ,/////,*/////////////////////////////,*////*.",
    "  /////////////////////////*,...,/////////////,",
    "  //////*,,,********,,.............,,,,,//////,",
    "  //////*.........//*........//*.......,//////,",
    "  //////*.........,,.........,,........,//////,",
    "  //////*..............................,//////,",
    "   *///*  ........,/.........**.......  .*///,",
    "            .......,/*.....,/*.......",
    "               ........,,,,.......",
    "                    .........",
    "\n*************************************************"};
  private static final String[] MAIN_MENU = {
    "************************************************",
    "*******************Bienvenido!******************",
    "************************************************",
    "************************************************",
    "*Aniadir un usuario                         [1]*",
    "*Ver perfiles                               [2]*",
    "*Aniadir una cancion                        [3]*",
    "*Ver Pool                                   [4]*",
    "*Aniadir playlist                           [5]*",
    "*Ver Playlists                              [6]*",
    "************************************************",
    "*Salir                                      [0]*",
    "************************************************"};
  private static final String[] ADD_USER_MENU = {
    "************************************************",
    "******************Nuevo usuario*****************",
    "*Nombre de usuario:                            *\n",
    "*Contrasenia:                                  *\n",
    "*Edad:                                         *\n",
    "************************************************",
    "***********Usuario creado con exito!************",
    "************************************************"};
  private static final String[] SEE_PROFILES_MENU = {
    "************************************************",
    "************************************************",
    "**Nombre de Usuario: ",
    "**Edad: ",
    "**Rango: ",
    "**Canciones compartidas: ",
    "************************************************",
    "*Volver                                [ANYKEY]*",
    "************************************************"};
  private static final String[] ADD_SONG_MENU = {
    "************************************************",
    "*******************Nueva cancion****************",
    "*Nombre de la cancion:                         *\n",
    "*Artista:                                      *\n",
    "*Album:                                        *\n",
    "*Fecha de lanzamiento [DD/MM/AAAA]:            *\n",
    "*Duracion [MM:SS]:                             *\n",
    "*********************Generos********************",
    "*Introduzca el numero correspondiente al genero*",
    "*de la cancion:                                *\n",
    "*Escoger un usuario que aniadira la cancion:   *\n",
    "************************************************",
    "************Cancion creada con exito!***********",
    "************************************************"};
  private static final String[] SEE_POOL_MENU = {
    "************************************************",
    "************************************************",
    "**Titulo: ",
    "**Artista: ",
    "**Album: ",
    "**Fecha de Lanzamiento: ",
    "**Duracion: ",
    "**Genero: ",
    "************************************************",
    "*Volver                                [ANYKEY]*",
    "************************************************"};

  /**
  *Displays the welcome logo on screen. <br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  public void welcomeLogo(int millis, Scanner in) {
    Operations.clrscm();
    System.out.println("(Version " + Main.VERSION + ")");
    Stream.slowPrint(millis,LOGO);
    System.out.println("(Presionar cualquier tecla y [ENTER] para continuar...)");
    in.next();
    System.out.println("Iniciando...");
    Operations.queue(1000);
    Operations.clrscm();
  }

  /**
  *Displays the main menu. <br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  public int[] showMenu(int millis, Scanner in) {
    int[] userAnswers = new int[2];
    Operations.clrscm();
    Stream.slowPrint(millis,MAIN_MENU);
    userAnswers[0] = in.nextInt();
    in.nextLine();
    return userAnswers;
  }

  /**
  *Shows the menu when first option is selected in main menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  public void showAddUserMenu(int millis, Scanner in) {
    Operations.clrscm();
    String newUserName = "";
    String newPassword = "";
    int newAge = 0;
    User newUser;
    for (int i = 0; i < ADD_USER_MENU.length; i++) {
      System.out.println(ADD_USER_MENU[i]);
      switch (i) {
        case 2:
          newUserName = in.next();
          in.nextLine();
          break;
        case 3:
          newPassword = in.nextLine();
          break;
        case 4:
          newAge = in.nextInt();
          in.nextLine();
          break;
        case 5:
          newUser = new User(newUserName,newPassword,newAge);
          msc.addToUserList(newUser);
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
  public void showProfilesMenu(int millis,Scanner in) {
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
    in.next();
  }

  /**
  *Shows the menu when third option is selected in main menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  public void showAddSongMenu(int millis, Scanner in) {
    Operations.clrscm();
    String newSongTitle = "";
    String newArtist = "";
    String newAlbum = "";
    String newReleaseDate = "";
    String newDurationStr = "";
    Duration newDurationObj = new Duration();
    int newGenreIndex = 0;
    Genre[] genres = Genre.values();
    for (int i = 0; i < ADD_SONG_MENU.length; i++) {
      System.out.println(ADD_SONG_MENU[i]);
      switch (i) {
        case 2:
          newSongTitle = in.nextLine();
          break;
        case 3:
          newArtist = in.nextLine();
          break;
        case 4:
          newAlbum = in.nextLine();
          break;
        case 5:
          newReleaseDate = in.nextLine();
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
          newGenreIndex = in.nextInt();
          in.nextLine();
          break;
        case 10:
          int k = 1;
          for (User u : msc.getUserList()) {
            System.out.println("**[" + k + "] " + u.getUserName());
            k++;
          }
          k = in.nextInt();
          in.nextLine();
          msc.getUserList().get(k).modifyRank();
        default:
          break;
      }
    }
    Song newSong = new Song(newSongTitle,newArtist,newAlbum,newReleaseDate,newDurationObj,newGenreIndex);
    msc.addToPool(newSong);
    Operations.queue(1000);
  }
}
