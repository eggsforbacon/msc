package model;
import java.security.SecureRandom;

/**
*Class that defines the blueprint for a User object and all its functionalities.<br>
*@author Samuel Hernandez / Zac
*/
public class User {
  private final String[] RANKS = {"Newbie","Little Contributor","Mild Contributor","Star Contributor"};

  private String userName;
  private String password;
  private String userRank;
  private int age;
  private int quantity;
  private String ID;

  /**
  *Constructor of the class.<br>
  *@param userName String containing the user name. <b>Must not contain <i>spaces, be null or blank</i>.</b><br>
  *@param password String containing the user password. <b>Must not be <i>null or blank</i>.</b><br>
  *@param age Integer containing the age of the user. <b>Must be an <i>integer</i>.</b><br>
  */
  public User(String userName, String password, int age) {
    this.userName = userName;
    this.password = password;
    this.age = age;
    userRank = RANKS[0];
    //generateID();
  }

  /**
  *Generates a unique ID for each user.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The ID is generated.<br>
  */
  private void generateID() {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();
    SecureRandom r = new SecureRandom();
    for (int i = 0; i < 4; i++) {
      int index = alphabet.length() * r.nextInt();
      sb.append(alphabet.charAt(index));
    }
    ID = sb.toString();
  }

  public String[] showInfo() {
    return new String[] {
            "************************************************",
            "**Nombre de Usuario: ",
            userName,
            "**Edad: ",
            Integer.toString(age),
            "**Rango: ",
            userRank,
            "**Canciones compartidas: ",
            Integer.toString(quantity)
    };
  }

  //Getters

  /**
  *@return The current username.<br>*/
  public String getUserName() {
    return userName;
  }

  /**
  *@return The current password.<br>
  */
  public String getPassword() {
    return password;
  }

  /**
  @return The current user's rank.<br>
  */
  public String getUserRank() {
    return userRank;
  }

  /**
  *@return The current user's age.<br>
  */
  public int getAge() {
    return age;
  }

  /**
  *@return The number of songs the user has added.<br>
  */
  public int getQuantity() {
    return quantity;
  }

  /**
  * @return The user's unique ID.<br>
  */
  public String getID() {
    return ID;
  }

//Setters

  /**
  *@param rankIndex The index of the rank to be set. <b>Must be a <i>positive integer lesser or equal to 3</i>.</b><br>
  */
  public void setUserRank(int rankIndex) {
    userRank = RANKS[rankIndex];
  }

  /**
  *@param userName The username to be set to.<br>
  */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
  *@param password The password to be set to.<br>
  */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
  *@param age The age to be set to.<br>
  */
  public boolean setAge(int age) {
    if (this.age < age) {
      this.age = age;
      return true;
    }
    else {
      return false;
    }
  }

  /**
  *Adds one to the user's song count and modifies their rank if needed.<br>
  *<b>Pre: </b><br>
  *<b>Post: </b>The user's count is modified succesfully.<br>
  */
  public void modifyRank() {
    quantity += 1;
    if (quantity >= 3 && quantity < 10) {
      userRank = RANKS[1];
    }
    else if (quantity >= 10 && quantity < 30) {
      userRank = RANKS[2];
    }
    else if (quantity == 30) {
      userRank = RANKS[3];
    }
  }
}
