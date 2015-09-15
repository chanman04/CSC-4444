package csc4330.mike.dreamlink.components;

/**
 * Created by Mike on 9/11/15.
 */
public class Contact {

   private String  userName;
   private  String password;
   private  String userEmail;

    public Contact(){

    }

    public Contact(String uName, String pWord, String uEmail){

        userName = uName;
        password = pWord;
        userEmail = uEmail;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserEmail() {
        return userName;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }
    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String userPass) {
        this.password= userPass;
    }



}
