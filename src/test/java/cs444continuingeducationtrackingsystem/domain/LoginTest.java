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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Performs validation and password requirement testing on Login class methods.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class LoginTest {

   /**
    * Empty Test.
    */
   public LoginTest() {
   }

   /**
    * Tests validate method to ensure login attributes are not empty or null,
    * and enforcement of password requirements.
    */
   @Test
   public void testValidate() {
      Login login = new Login();         // Test empty Login
      boolean result = login.validate();
      assertFalse(result);
      login.setUsername("JohnDoe");      // Test absent password
      result = login.validate();
      assertFalse(result);
      login.setPassword("JohnDoe");      // Test password same as username
      result = login.validate();
      assertFalse(result);
      login.setPassword("abc");          // Test password too short
      result = login.validate();
      assertFalse(result);
      login.setPassword("password1234"); // Password in Common Password list
      result = login.validate();
      assertFalse(result);
      login.setPassword("ks4LisH");      // Password one character short
      result = login.validate();
      assertFalse(result);
      login.setPassword("K38diHsoII");  // Password valid
      result = login.validate();
      assertTrue(result);
   }

   /**
    * Tests equals() method used to validate user login.
    */
   @Test
   public void testEquals() {
      Login login1 = new Login();
      login1.setUsername("JohnDoe");
      login1.setPassword("secretWord");

      Login login2 = new Login();
      login2.setUsername("JaneDoe");
      login2.setPassword("MyNewPassword");

      assertFalse(login1.equals(login2));
      login2.setUsername("JohnDoe");
      assertFalse(login1.equals(login2));
      login2.setPassword("secretWord");
      assertTrue(login1.equals(login2));
   }

}
