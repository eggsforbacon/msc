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
  public static void welcomeLogo(int millis, Scanner in) {
    Operations.clrscm();
    System.out.println("(Version " + Main.VERSION + ")");
    Stream.slowPrint(millis,LOGO);
    System.out.println("(Presionar cualquier tecla y [ENTER] para continuar...)");
    in.next();
    System.out.println("Proceeding...");
    Operations.queue(1000);
    Operations.clrscm();
  }

  private static final String[] MAIN_MENU = {
    "************************************************",
    "*******************Bienvenido!******************",
    "************************************************",
    "************************************************",
    "*Iniciar Sesion                             [1]*",
    "*Ver Pool                                   [2]*",
    "*Ver Playlists Globales                     [3]*",
    "************************************************",
    "*Salir                                      [0]*",
    "************************************************"};
  public static int printMainMenu(int millis, Scanner in) {
    Stream.slowPrint(millis,MAIN_MENU);
    userAnswer = in.nextInt();
    in.nextLine();
    return userAnswer;
  }

  private static final String[] USER_CONTEXT = {
    "************************************************",
    "****************Sesion Iniciada!****************",
    "*Aniadir una cancion                        [1]*",
    "*Mis playlists                              [2]*",
    "*Perfil                                     [3]*",
    "************************************************",
    "*Salir                                      [0]*",
    "************************************************"};
  public static int printUserMenu(int millis, Scanner in) {
    System.out.println("Ingrese su Usuario:\n");
    String loggedUserName = in.next();
    System.out.println("Ingrese su contrasenia:\n");
    String loggedPW = in.nextLine();
    in.nextLine();
    System.out.println("Ingrese su edad:\n");
    int loggedAge = in.nextInt();
    in.nextLine();
    User loggedUser = Operations.login(loggedUserName,loggedPW,loggedAge);
    for (int i = 0; i < USER_CONTEXT.length; i++) {
      if (i == 2) {
        System.out.println("Usuario: " + loggedUser.getUserName() + "\nRango: " + loggedUser.getUserRank().toUpperCase());
        Operations.queue(millis);
      }
      System.out.println(USER_CONTEXT[i]);
      Operations.queue(millis);
    }
    userAnswer = in.nextInt();
    in.nextLine();
    return userAnswer;
  }
}
