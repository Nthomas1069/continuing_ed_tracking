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

import java.util.*;
import cs444continuingeducationtrackingsystem.domain.*;

/**
 * Class implements Account Services Interface for account object CRUD
 * operations.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class AccountSvcCacheImpl implements IAccountSvc {

   private List<Account> cache = new ArrayList<>();
   private int nextID = 0;

   private AccountSvcCacheImpl() {
   }

   private static AccountSvcCacheImpl instance = new AccountSvcCacheImpl();

   /**
    * Singleton Design Pattern object access
    * 
    * @return instance
    */
   public static AccountSvcCacheImpl getInstance() {
      return instance;
   }

   /**
    * Method assigns ID value to account object and adds account to account
    * ArrayList at index value of ID.
    *
    * @param account
    * @return account
    */
   @Override
   public Account create(Account account) {
      account.setId(nextID);
      cache.add(account);
      nextID++;
      return account;
   }

   /**
    * Returns all account objects in account ArrayList cache.
    *
    * @return cache
    */
   @Override
   public List<Account> retrieveAll() {
      return cache;
   }

   /**
    * Method updates Account in cache with parameter Account object by over-
    * writing previous Account object with the same Id number.
    *
    * @param account
    * @return account
    */
   @Override
   public Account update(Account account) {
      for (int i = 0; i < cache.size(); i++) {
         Account next = cache.get(i);
         if (next.getId() == account.getId()) {
            cache.set(i, account);
            break;
         }
      }
      return account;
   }

   /**
    * Method deletes specified Account from Account cache.
    *
    * @param account
    * @return account
    */
   @Override
   public Account delete(Account account) {
      for (int i = 0; i < cache.size(); i++) {
         Account next = cache.get(i);
         if (next.getId() == account.getId()) {
            cache.remove(i);
            break;
         }
      }
      return account;
   }

   /**
    * Method accepts Login object and returns associated account if valid.
    * Returns null if Login is not associated with any Account object.
    *
    * @param login
    * @return account
    */
   @Override
   public Account authenticate(Login login) {
      Account account = null;

      for (int i = 0; i < cache.size(); i++) {
         account = cache.get(i);
         Login accountLogin = account.getLogin();
         if (login.equals(accountLogin)) {
            return account;
         }
      }
      return null;
   }

   /**
    * Method searches through existing Account usernames to prevent identical
    * Login objects from being created.
    *
    * @param username
    * @return boolean
    */
   public boolean usernameIsAvailable(String username) {
      Account account = null;

      for (int i = 0; i < cache.size(); i++) {
         account = cache.get(i);
         String existingName = account.getLogin().getUsername();
         if (username.equals(existingName)) {
            return false;
         }
      }
      return true;
   }

}
