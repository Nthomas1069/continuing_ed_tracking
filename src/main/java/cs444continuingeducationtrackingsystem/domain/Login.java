/*
 * The Continuing Education Tracking System, "CETS," is a professional education
 * tracking application for state and federally licensed individuals who have to
 * complete and document their required continuing education credits ("CEU's")
 * in order to be eligible for periodic license renewal. The application allows
 * users to create their own account and document education courses with an
 * automated sum of hours completed for easy reference. If required by an audit,
 * or to fulfill workplace requirements, the app also support a completed
 * education summary report in a text file.
 */
package cs444continuingeducationtrackingsystem.domain;

/**
 * The Login class creates the user's account username and password credentials
 * used to access their own education course data. The username and password for
 * each account is a string. The password must be no less than 8 characters in
 * length. Additionally, the class maintains a short list of common weak
 * passwords. The class includes methods to validate format and check against
 * common password list.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class Login {

   private String username = "";
   private String password = "";
   final private int REQUIRED_LENGTH = 8;
   final private String[] COMMON_PASSWORDS = {"Password",
      "12345678",
      "87654321",
      "qwerty1234",
      "11111111",
      "12341234",
      "12344321",
      "qwertyuiop",
      "asdfghjk",
      "abcdefgh",
      "PASSWORD",
      "password",
      "password1234"};

   /**
    * Default Constructor
    */
   public Login() {
   }

   /**
    * Constructor requiring username and password strings as arguments.
    *
    * @param username
    * @param password
    */
   public Login(String username, String password) {
      this.username = username;
      this.password = password;
   }

   /**
    * Gets Username
    *
    * @return username
    */
   public String getUsername() {
      return username;
   }

   /**
    * Sets Username
    *
    * @param username
    */
   public void setUsername(String username) {
      this.username = username;
   }

   /**
    * Gets password
    *
    * @return password
    */
   public String getPassword() {
      return password;
   }

   /**
    * Sets password
    *
    * @param password
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * Method validates login attributes to ensure fields are not empty or null.
    * Also validates password length and enforces common weak password
    * restrictions.
    *
    * @return validated
    */
   public boolean validate() {
      boolean validated = true;

      if (username == null || username.equals("")) {
         validated = false;
      }

      if (password == null || password.equals("") || password.equals(username)
              || checkCommonality()) {
         validated = false;
      }

      if (password.length() < REQUIRED_LENGTH) {
         validated = false;
      }

      return validated;
   }

   /**
    * Method checks if user's password input is in common password list. Returns
    * true if password is in list.
    *
    * @return boolean
    */
   public boolean checkCommonality() {

      for (int i = 0; i < COMMON_PASSWORDS.length; i++) {
         if (password.equals(COMMON_PASSWORDS[i])) {
            return true;
         }
      }

      return false;
   }

   /**
    * Method overrides equals(). Verifies user login is associated with valid
    * account in existing instance.
    *
    * @param obj
    * @return boolean
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof Login)) {
         return false;
      }
      Login login = (Login) obj;
      if (!this.username.equals(login.getUsername())) {
         return false;
      }
      if (!this.password.equals(login.getPassword())) {
         return false;
      }
      return true;
   }

   /**
    * Method used to construct persistent data file of accounts.
    *
    * @return
    */
   @Override
   public String toString() {
      return username + "/" + password;
   }

}
