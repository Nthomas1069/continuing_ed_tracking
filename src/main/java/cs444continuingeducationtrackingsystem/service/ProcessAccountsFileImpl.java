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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * Class handles account and associated courses persistence by reading from and
 * updating "/" delimited .txt file.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class ProcessAccountsFileImpl implements IProcessAccountsFile {

   static AccountSvcCacheImpl impl = AccountSvcCacheImpl.getInstance();
   private final String ACCOUNTS_FILE = "input/accounts.txt";
   private Account classAccount;

   /**
    * Method used to fill Accounts cache and Courses List for each account upon
    * application start-up. Txt file in input folder is read and added to cache
    * via private helper methods.
    *
    */
   @Override
   public void processFile() {
      File inputFile = new File(ACCOUNTS_FILE);
      Scanner fileScanner = null;
      try {
         fileScanner = new Scanner(inputFile);
      } catch (FileNotFoundException e) {
         System.out.println("ERROR: File not found exception for file \""
                 + inputFile + "\"");
      }
      while (fileScanner.hasNext()) {
         String singleLine = fileScanner.nextLine();
         String[] splitLine = singleLine.split("/");

         if (splitLine[0].equals("ACCOUNT")) {
            addAccount(splitLine);
         } else if (splitLine[0].equals("COURSE")) {
            addCourse(splitLine);
         }
      }
      fileScanner.close();
   }

   /**
    * Method updates Accounts.txt file with any changes made to Accounts cache
    * and each account's Courses list when user logs out of the system,
    * providing account and courses persistence between application uses.
    */
   @Override
   public void updateFile() {
      File outFile = new File(ACCOUNTS_FILE);
      PrintWriter fileWrite;
      AccountSvcCacheImpl impl = AccountSvcCacheImpl.getInstance();
      List<Account> accounts = impl.retrieveAll();
      List<Course> courses;

      try {
         fileWrite = new PrintWriter(outFile);

         for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            fileWrite.print(account.toString() + "\n");
            courses = account.getCourses();
            for (int j = 0; j < courses.size(); j++) {
               Course course = courses.get(j);
               fileWrite.print(course.toString() + "\n");
            }
         }

         fileWrite.close();
      } catch (IOException except) {
         System.out.println("Caught IOException " + except.getMessage());
      }

   }

   private void addAccount(String[] details) {
      Login login = new Login(details[1], details[2]);
      Account account = new Account(login, details);
      classAccount = account;
      impl.create(account);
   }

   private void addCourse(String[] details) {
      Course course = new Course(details);
      classAccount.add(course);
      impl.update(classAccount);
   }
}
