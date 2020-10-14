package ui;
import model.*;
import java.util.*;

public class Menus {

  private static int userAnswer = 0;
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
    "*Aniadir una cancion                        [1]*",
    "*Ver Pool                                   [2]*",
    "*Ver Playlists Globales                     [3]*",
    "Ver mis playlists                           [4]*",
    "Ver perfil                                  [5]*",
    "************************************************",
    "*Salir                                      [0]*",
    "************************************************"};


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
  
  public int printMainMenu(int millis, Scanner in, User loggedUser) {
    Operations.clrscm();
    for (int i = 0; i < MAIN_MENU.length; i++) {
      if (i == 2) {
        System.out.println("Usuario: " + loggedUser.getUserName() + "\nRango: " + loggedUser.getUserRank().toUpperCase());
        Operations.queue(millis);
      }
      System.out.println(MAIN_MENU[i]);
      Operations.queue(millis);
    }
    userAnswer = in.nextInt();
    in.nextLine();
    return userAnswer;
  }

  public User printLoginMenu(int millis, Scanner in) {
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
    return loggedUser;
  }
}
