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
package cs444continuingeducationtrackingsystem.service;

import cs444continuingeducationtrackingsystem.domain.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests Account Service Implementation class methods.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class AccountSvcCacheImplTest {

   /**
    * Empty test.
    */
   public AccountSvcCacheImplTest() {
   }

   /**
    * Test method for Account Services CRUD operations.
    */
   @Test
   public void testCRUD() {

      // AccountSvcCacheImpl impl = new AccountSvcCacheImpl();
      AccountSvcCacheImpl impl = AccountSvcCacheImpl.getInstance();
      List<Account> accounts = impl.retrieveAll();
      assertEquals(accounts.size(), 0);

      Account account = new Account();
      account.setFirstName("John");
      account.setLastName("Doe");
      Login login = new Login();
      login.setUsername("JDoe");
      login.setPassword("SecurePassword");
      account.setLogin(login);
      // test create
      account = impl.create(account);
      assertNotNull(account);
      assertEquals(account.getId(), 0);
      // test retrieveAll
      accounts = impl.retrieveAll();
      assertEquals(accounts.size(), 1);
      // test update
      account.setFirstName("Frank");
      account = impl.update(account);
      accounts = impl.retrieveAll();
      assertEquals(accounts.size(), 1);
      assertEquals(account.getFirstName(), "Frank");
      // test delete
      account = impl.delete(account);
      assertEquals(accounts.size(), 0);
      // test authenticate
      Account account1 = new Account();
      account1.setFirstName("John");
      account1.setLastName("Doe");
      Login login1 = new Login();
      login1.setUsername("JDoe");
      login1.setPassword("secretWord");
      account1.setLogin(login1);
      account1 = impl.create(account1);
      assertNotNull(account1);
      
      Account account2 = new Account();
      account2.setFirstName("Jon");
      account2.setLastName("Deer");
      Login login2 = new Login();
      login2.setUsername("Jon");
      login2.setPassword("OpenSesame");
      account2.setLogin(login2);
      account2 = impl.create(account2);
      assertNotNull(account2);
      
      Login login3 = new Login();
      login3.setUsername("Sully");
      login3.setPassword("Ilikescaringkids");
      Account authenticatedAccount = impl.authenticate(login3);
      assertNull(authenticatedAccount);
      login3.setUsername("JDoe");
      authenticatedAccount = impl.authenticate(login3);
      assertNull(authenticatedAccount);
      login3.setPassword("secretWord");
      authenticatedAccount = impl.authenticate(login3);
      assertNotNull(authenticatedAccount);
      login3.setUsername("Jon");
      authenticatedAccount = impl.authenticate(login3);
      assertNull(authenticatedAccount);
      login3.setPassword("OpenSesame");
      authenticatedAccount = impl.authenticate(login3);
      assertNotNull(authenticatedAccount);

   }

}
