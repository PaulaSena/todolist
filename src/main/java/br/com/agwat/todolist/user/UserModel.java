package br.com.agwat.todolist.user;

//classe modelo de usuário UserController.

public class UserModel {
   private String username;
   private String name;
   private String passwordString;
   
//gets seter
   public void setUsername(String username) {
      this.username = username;
   }

   public String getUsername() {
      return username;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setPasswordString(String passwordString) {
      this.passwordString = passwordString;
   }

   public String getPasswordString() {
      return passwordString;
   }
}
