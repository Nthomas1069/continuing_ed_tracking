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

import java.io.*;
import java.util.*;
import cs444continuingeducationtrackingsystem.domain.*;

/**
 * Class implements Report Service interface for report creation. The default
 * file path for the report product is the Output folder of the project package.
 * {@link IReportSvc}
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class ReportSvcImpl implements IReportSvc {

   private String outputFile = "output/Report.txt";

   /**
    * Method converts Account and associated Courses data into a formatted .txt
    * file. User must specify ".txt" file type during naming/saving, else select
    * the appropriate text file application when opening the new file.
    *
    * @param account
    * @param courses
    * @param filePath
    */
   @Override
   public void createReport(Account account, List<Course> courses,
           String filePath) {

      if (!filePath.equals("")) {
         outputFile = filePath;
      }

      File outFile = new File(outputFile);
      PrintWriter fileWrite;

      try {
         fileWrite = new PrintWriter(outFile);
         fileWrite.print("************************ License Holder *************"
                 + "************\n\n");
         fileWrite.print(account.getFirstName() + " "
                 + account.getLastName() + "\n");
         fileWrite.print(account.getLicenseTitle() + "\n");
         fileWrite.print(account.getLicenseState() + " License Number:    "
                 + account.getLicenseNumber() + "\n");
         fileWrite.print("Originally issued on: " + account.getIssuedDate()
                 + "\n");
         fileWrite.print("Expires on:           " + account.getExpirationDate()
                 + "\n\n");
         fileWrite.print("The following report details " + account.getTotalHours()
                 + " of the " + account.getHoursNeeded() + " continuing "
                 + "education\nhours required for license renewal.\n\n");
         fileWrite.print("*********************** Courses Completed ***********"
                 + "************\n\n");

         for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            fileWrite.print((i + 1) + " " + course.getCourseTitle() + "\n");
            fileWrite.print("\tPresented by: " + course.getCourseVendor()
                    + " on " + course.getCompletionDate() + "\n");
            fileWrite.print("\t" + course.getCourseCity() + ", "
                    + course.getCourseState() + "\n");
            fileWrite.print("\tApproved for " + course.getNumHours() + " hours "
                    + "of CE credit.\n\n");
         }

         fileWrite.close();
      } catch (IOException except) {
         System.out.println("Caught IOException " + except.getMessage());
      }
   }

   /**
    * Verifies report creation by locating file using input file path.
    *
    * @param file
    * @return found
    */
   public boolean findFile(String file) {
      boolean found = true;
      Scanner fileScanner = null;
      File inputFile;

      if (!file.equals("")) {
         inputFile = new File(file);
      } else {
         inputFile = new File(outputFile);
      }

      try {
         fileScanner = new Scanner(inputFile);
      } catch (FileNotFoundException e) {
         System.out.println("ERROR: File not found exception for file \""
                 + inputFile + "\"");
         System.exit(1);
      }

      if (fileScanner == null) {
         found = false;
      }

      return found;
   }
}
