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
  private static final String[] USER_LOGIN = {
    "************************************************",
    "*****************Iniciar Sesion*****************",
    "*Ingrese su Usuario:                           *\n",
    "*Ingrese su contrasenia:                       *\n",
    "*Ingrese su edad:                              *\n",
    "************************************************",
    "************************************************"};
  private static final String[] MAIN_MENU = {
    "************************************************",
    "*******************Bienvenido!******************",
    "************************************************",
    "************************************************",
    "*Ver perfil                                 [1]*",
    "*Aniadir una cancion                        [2]*",
    "*Ver Pool                                   [3]*",
    "*Ver Playlists Globales                     [4]*",
    "*Ver mis playlists                          [5]*",
    "************************************************",
    "*Salir                                      [0]*",
    "************************************************"};
  private static final String[] OPT1_MENU = {
    "************************************************",
    "*********************Usuario********************",
    "**Nombre de Usuario: ",
    "**Edad: ",
    "**Rango: ",
    "**Canciones compartidas: ",
    "************************************************",
    "*Cambiar de usuario                         [1]*",
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
  *Displays the login menu.<br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  */
  public User showLoginMenu(int millis, Scanner in) {
    String loggedUserName = "";
    String loggedPW = "";
    int loggedAge = 0;
    Operations.clrscm();
    for (int i = 0; i < USER_LOGIN.length; i++) {
      if (i == 3) {
        loggedUserName = in.next();
        in.nextLine();
        Operations.queue(millis);
      }
      else if (i == 4) {
        loggedPW = in.next();
        in.nextLine();
        Operations.queue(millis);
      }
      else if (i == 5) {
        loggedAge = in.nextInt();
        in.nextLine();
        Operations.queue(millis);
      }
      System.out.println(USER_LOGIN[i]);
      Operations.queue(millis);
    }
    User loggedUser = Operations.login(loggedUserName,loggedPW,loggedAge);
    msc.addToUserList(loggedUser);
    return loggedUser;
  }

  /**
  *Displays the main menu. <br>
  *<b>Pre: </b> <br>
  *<b>Post: </b>The menu is displayed.<br>
  *@param millis Integer that describes the amount of ms the console will wait per line. <b>Must be of type <i>int</i>.</b><br>
  *@param in Scanner object that receives user input. <b>Must be an already initialized <i>Scanner</i> object.</b><br>
  *@param loggedUser User object that stores the currently logged user. <b>Must be an already initialized <i>User</i> object.</b><br>
  */
  public int[] showMenu(int millis, Scanner in, User loggedUser) {
    int[] userAnswers = new int[2];
    Operations.clrscm();
    for (int i = 0; i < MAIN_MENU.length; i++) {
      if (i == 2) {
        System.out.println("Usuario: " + loggedUser.getUserName() + "\nRango: " + loggedUser.getUserRank().toUpperCase());
        Operations.queue(millis);
      }
      System.out.println(MAIN_MENU[i]);
      Operations.queue(millis);
    }
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
  *@param loggedUser User object that stores the currently logged user. <b>Must be an already initialized <i>User</i> object.</b><br>
  *@param userAnswers Integer array that allows the program to move between menus. <b>Must be an already initialized <i>integer</i> array.</b><br>
  */
  public int[] showProfileMenu(int millis,Scanner in, User loggedUser, int[] userAnswers) {
    Operations.clrscm();
    for (int i = 0; i < OPT1_MENU.length; i++) {
      if (i == 2) {
        System.out.println(OPT1_MENU[i] + loggedUser.getUserName());
      }
      else if (i == 3) {
        System.out.println(OPT1_MENU[i] + loggedUser.getAge());
      }
      else if (i == 4) {
        System.out.println(OPT1_MENU[i] + loggedUser.getUserRank().toUpperCase());
      }
      else if (i == 5) {
        System.out.println(OPT1_MENU[i] + loggedUser.getAddedSongs().size());
      }
      else {
        System.out.println(OPT1_MENU[i]);
      }
      Operations.queue(millis);
    }
    userAnswers[1] = in.nextInt();
    return userAnswers;
  }

}
