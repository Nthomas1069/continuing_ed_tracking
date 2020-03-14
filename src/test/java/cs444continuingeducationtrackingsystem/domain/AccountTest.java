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
 * Performs tests on account class object methods.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class AccountTest {

   /**
    * Empty Test
    */
   public AccountTest() {
   }

   /**
    * Tests validate method to ensure account attributes are not empty or null.
    * Also tests validation of login object through Login class validation
    * method.
    */
   @Test
   public void testValidate() {
      Account account = new Account();
      boolean result = account.validate();
      assertFalse(result);
      Login login = new Login();
      login.setUsername("JohnDoe");
      login.setPassword("1234");
      account.setLogin(login);
      result = account.validate();
      assertFalse(result);
      account.setFirstName("John");
      result = account.validate();
      assertFalse(result);
      account.setLastName("Doe");
      result = account.validate();
      assertFalse(result);
      account.setLicenseTitle("Doctor of Medicine");
      result = account.validate();
      assertFalse(result);
      account.setLicenseNumber("123456789");
      result = account.validate();
      assertFalse(result);
      account.setLicenseState("MO");
      result = account.validate();
      assertFalse(result);
      account.setIssuedDate("JUN 25, 2016");
      result = account.validate();
      assertFalse(result);
      account.setExpirationDate("JAN 31, 2022");
      result = account.validate();
      assertFalse(result);
      account.setHoursNeeded("30");
      result = account.validate();
      assertFalse(result);
      login.setPassword("87654321"); // Test common password restriction
      account.setLogin(login);
      result = account.validate();
      assertFalse(result);
      login.setPassword("ThisIsMyPassword");
      account.setLogin(login);
      result = account.validate();
      assertTrue(result);
      account.setHoursNeeded("Thirty"); // Testing int check
      result = account.validate();
      assertFalse(result);
      account.setHoursNeeded("-30"); // Testing non-negative int validation
      result = account.validate();
      assertFalse(result);
      account.setHoursNeeded("0"); // Testing not zero validation
      result = account.validate();
      assertFalse(result);
      account.setHoursNeeded("30");
      result = account.validate();
      assertTrue(result);
      account.setLicenseNumber("A2345Z789"); // Testing Lic# int check
      result = account.validate();
      assertFalse(result);
      account.setLicenseNumber("123456789");
      result = account.validate();
      assertTrue(result);
      Course course = new Course();
      account.add(course);                          // Test Course add
      assertEquals(1, account.getCourses().size());
      account.deleteCourse(course);                // Test Course delete
      assertEquals(0, account.getCourses().size()); 
      
   }

}
