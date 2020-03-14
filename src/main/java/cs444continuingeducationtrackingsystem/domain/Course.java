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

import java.time.LocalDate;

/**
 * The Course class creates continuing education course objects, which stores
 * education course details for display and use in MainUI list, ViewCourseUI,
 * and report creation.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class Course {

   private final int CURRENT_YEAR = LocalDate.now().getYear();
   ;
   private String courseTitle = "";
   private String courseVendor = "";
   private String completionDate = "";
   private String courseCity = "";
   private String courseState = "";
   private Double numHours = 0.0;
   private int indexId = 0;

   /**
    * Default Constructor
    */
   public Course() {
   }

   /**
    * Constructor
    *
    * @param courseTitle
    * @param courseVendor
    * @param completionDate
    * @param courseCity
    * @param courseState
    * @param numHours
    */
   public Course(String courseTitle, String completionDate, String numHours,
           String courseVendor, String courseCity, String courseState) {

      this.courseTitle = courseTitle;
      this.courseVendor = courseVendor;
      this.completionDate = completionDate;
      this.courseCity = courseCity;
      this.courseState = courseState;
      this.numHours = Double.valueOf(numHours);
   }

   /**
    * Constructor used to initialize persistent account courses from previous
    * sessions via .csv file.
    *
    * @param details
    */
   public Course(String[] details) {
      this.courseTitle = details[1];
      this.completionDate = details[2];
      this.numHours = Double.valueOf(details[3]);
      this.courseVendor = details[4];
      this.courseCity = details[5];
      this.courseState = details[6];
   }

   /**
    *
    * @return String courseTitle
    */
   public String getCourseTitle() {
      return courseTitle;
   }

   /**
    *
    * @param courseTitle
    */
   public void setCourseTitle(String courseTitle) {
      this.courseTitle = courseTitle;
   }

   /**
    *
    * @return String courseVendor
    */
   public String getCourseVendor() {
      return courseVendor;
   }

   /**
    *
    * @param courseVendor
    */
   public void setCourseVendor(String courseVendor) {
      this.courseVendor = courseVendor;
   }

   /**
    *
    * @return String completionDate
    */
   public String getCompletionDate() {
      return completionDate;
   }

   /**
    *
    * @param completionDate
    */
   public void setCompletionDate(String completionDate) {
      this.completionDate = completionDate;
   }

   /**
    *
    * @return String courseCity
    */
   public String getCourseCity() {
      return courseCity;
   }

   /**
    *
    * @param courseCity
    */
   public void setCourseCity(String courseCity) {
      this.courseCity = courseCity;
   }

   /**
    *
    * @return String courseState
    */
   public String getCourseState() {
      return courseState;
   }

   /**
    *
    * @param courseState
    */
   public void setCourseState(String courseState) {
      this.courseState = courseState;
   }

   /**
    *
    * @return double numHours
    */
   public double getNumHours() {
      return numHours;
   }

   /**
    *
    * @param numHours
    */
   public void setNumHours(String numHours) {
      if (doubleCheck(numHours)) {
         this.numHours = Double.valueOf(numHours);
      }
   }

   /**
    *
    * @return int indexId
    */
   public int getIndexId() {
      return indexId;
   }

   /**
    *
    * @param indexId
    */
   public void setIndexId(int indexId) {
      this.indexId = indexId;
   }

   /**
    * Method checks each Course object attribute value from user for existence
    * and formatting.
    *
    * @return boolean
    */
   public boolean validate() {
      boolean validated = true;
      int courseYear = 0;

      if (!completionDate.equals("")) {
         try {
            courseYear = Integer.valueOf(completionDate.substring(8));
            if (courseYear < 100) {
               courseYear += 2000;
            } else if (courseYear < 1000) {
               courseYear += 1000;
            }
         } catch (StringIndexOutOfBoundsException e) {
            validated = false;
         }
      }

      if (courseTitle == null || courseTitle.equals("")) {
         validated = false;
      }

      if (courseVendor == null || courseVendor.equals("")) {
         validated = false;
      }

      if (completionDate == null || completionDate.equals("")) {
         validated = false;
      }

      if (courseYear < 2015 || courseYear > CURRENT_YEAR) {
         validated = false;
      }

      if (courseCity == null || courseCity.equals("")) {
         validated = false;
      }

      if (courseState == null || courseState.equals("")) {
         validated = false;
      }

      if (!doubleCheck(String.valueOf(numHours))
              || numHours <= 0) {
         validated = false;
      }

      return validated;
   }

   private boolean doubleCheck(String s) {
      boolean isDouble = false;

      try {
         Double.parseDouble(s);
         isDouble = true;
      } catch (NumberFormatException e) {
      }

      return isDouble;
   }

   /**
    * Method used to construct persistent data file of courses.
    *
    * @return
    */
   @Override
   public String toString() {
      return "COURSE/"
              + courseTitle + "/"
              + completionDate + "/"
              + numHours + "/"
              + courseVendor + "/"
              + courseCity + "/"
              + courseState;
   }

}
