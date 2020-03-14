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

import java.util.*;

/**
 * The Account class creates an account object for each user detailing personal
 * profile/license information. Each account includes one Login object for
 * secure access.
 *
 * @author Nathan Thomas
 * @version 1.0
 * @see Login
 */
public class Account {

   private List<Course> courses = new LinkedList<Course>();
   private int id = 0;
   private double totalHours = 0;
   private Login login = null;
   private String firstName = "";
   private String lastName = "";
   private String licenseTitle = "";
   private String licenseNumber = "";
   private String licenseState = "";
   private String issuedDate = "";
   private String expirationDate = "";
   private String hoursNeeded = "";

   /**
    * Default Constructor
    */
   public Account() {
   }

   /**
    * Constructor corresponds to UI form inputs and set login credentials.
    *
    * @see CreateAccount
    * @param login
    * @param firstName
    * @param lastName
    * @param licenseTitle
    * @param licenseNumber
    * @param licenseState
    * @param issuedDate
    * @param expirationDate
    * @param hoursNeeded
    */
   public Account(Login login, String firstName,
           String lastName, String licenseTitle, String licenseState,
           String licenseNumber, String issuedDate, String expirationDate,
           String hoursNeeded) {

      this.login = login;
      this.firstName = firstName;
      this.lastName = lastName;
      this.licenseTitle = licenseTitle;
      this.licenseNumber = licenseNumber;
      this.licenseState = licenseState;
      this.issuedDate = issuedDate;
      this.expirationDate = expirationDate;
      this.hoursNeeded = hoursNeeded;
   }

   /**
    * This constructor is used to initialize account cache from previous session
    * via .csv file.
    *
    * @param login login object
    * @param details String array from ProcessAccountsFileImpl class
    */
   public Account(Login login, String[] details) {
      this.login = login;
      this.firstName = details[3];
      this.lastName = details[4];
      this.licenseTitle = details[5];
      this.licenseNumber = details[6];
      this.licenseState = details[7];
      this.issuedDate = details[8];
      this.expirationDate = details[9];
      this.hoursNeeded = details[10];
   }

   /**
    *
    * @return id
    */
   public int getId() {
      return id;
   }

   /**
    * ID number associating account object with account arrayList index.
    *
    * @param id
    */
   public void setId(int id) {
      this.id = id;
   }

   /**
    * Method iterates through account courses list and sums all course hours.
    *
    * @return double totalHours
    */
   public double getTotalHours() {
      totalHours = 0;

      for (int i = 0; i < courses.size(); i++) {
         totalHours += courses.get(i).getNumHours();
      }
      return totalHours;
   }

   /**
    *
    * @param hours
    */
   public void addHours(double hours) {
      this.totalHours += hours;
   }

   /**
    *
    * @return login - Login class object
    */
   public Login getLogin() {
      return login;
   }

   /**
    *
    * @param login
    */
   public void setLogin(Login login) {
      this.login = login;
   }

   /**
    *
    * @return firstName
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    *
    * @param firstName
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    *
    * @return lastName
    */
   public String getLastName() {
      return lastName;
   }

   /**
    *
    * @param lastName
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    *
    * @return licenseTitle
    */
   public String getLicenseTitle() {
      return licenseTitle;
   }

   /**
    *
    * @param licenseTitle
    */
   public void setLicenseTitle(String licenseTitle) {
      this.licenseTitle = licenseTitle;
   }

   /**
    *
    * @return licenseNumber
    */
   public String getLicenseNumber() {
      return licenseNumber;
   }

   /**
    *
    * @param licenseNumber
    */
   public void setLicenseNumber(String licenseNumber) {
      this.licenseNumber = licenseNumber;
   }

   /**
    *
    * @return licenseState
    */
   public String getLicenseState() {
      return licenseState;
   }

   /**
    *
    * @param licenseState
    */
   public void setLicenseState(String licenseState) {
      this.licenseState = licenseState;
   }

   /**
    *
    * @return issuedDate
    */
   public String getIssuedDate() {
      return issuedDate;
   }

   /**
    *
    * @param issuedDate
    */
   public void setIssuedDate(String issuedDate) {
      this.issuedDate = issuedDate;
   }

   /**
    *
    * @return expirationDate
    */
   public String getExpirationDate() {
      return expirationDate;
   }

   /**
    *
    * @param expirationDate
    */
   public void setExpirationDate(String expirationDate) {
      this.expirationDate = expirationDate;
   }

   /**
    *
    * @return hoursNeeded
    */
   public String getHoursNeeded() {
      return hoursNeeded;
   }

   /**
    *
    * @param hoursNeeded
    */
   public void setHoursNeeded(String hoursNeeded) {
      this.hoursNeeded = hoursNeeded;
   }

   /**
    * Method used to construct persistent data file of accounts.
    *
    * @return String
    */
   @Override
   public String toString() {
      String loginString = login.toString();
      return "ACCOUNT/"
              + loginString + "/"
              + firstName + "/"
              + lastName + "/"
              + licenseTitle + "/"
              + licenseState + "/"
              + licenseNumber + "/"
              + issuedDate + "/"
              + expirationDate + "/"
              + hoursNeeded;
   }

   /**
    * Method validates account attributes as not empty or null. Uses
    * {@link Login} validate method to validate account Login object.
    *
    * @return validated
    */
   public boolean validate() {
      boolean validated = true;

      if (login == null) {
         validated = false;
      } else if (login.validate() == false) {
         validated = false;
      }

      if (firstName == null || firstName.equals("")) {
         validated = false;
      }

      if (lastName == null || lastName.equals("")) {
         validated = false;
      }

      if (licenseTitle == null || licenseTitle.equals("")) {
         validated = false;
      }

      if (licenseNumber == null || licenseNumber.equals("")
              || !integerCheck(licenseNumber)) {
         validated = false;
      }

      if (licenseState == null || licenseState.equals("")) {
         validated = false;
      }

      if (issuedDate == null || issuedDate.equals("")) {
         validated = false;
      }

      if (expirationDate == null || expirationDate.equals("")) {
         validated = false;
      }

      if (issuedDate.equals(expirationDate)) {
         validated = false;
      }

      if (hoursNeeded == null || hoursNeeded.equals("")
              || !integerCheck(hoursNeeded)
              || Integer.valueOf(hoursNeeded) <= 0) {
         validated = false;
      }

      return validated;
   }

   private boolean integerCheck(String s) {
      boolean isInteger = false;

      try {
         Integer.parseInt(s);
         isInteger = true;
      } catch (NumberFormatException e) {
      }

      return isInteger;
   }

   /**
    * Adds Course Object to Accounts LinkedList of courses.
    *
    * @param course
    * @return
    */
   public Course add(Course course) {
      course.setIndexId(courses.size());
      courses.add(course);
      return course;
   }

   /**
    * Return list of account courses.
    *
    * @return List courses
    */
   public List<Course> getCourses() {
      return courses;
   }

   /**
    * Retrieve Course by index in List of Courses.
    *
    * @param index
    * @return
    */
   public Course getCourse(int index) {
      return courses.get(index);
   }

   /**
    * Deletes course from account's courses list and reassigns course indexID's
    * to remaining courses according new location(s) in LinkedList.
    *
    * @param course
    */
   public void deleteCourse(Course course) {
      for (int i = 0; i < courses.size(); i++) {
         if (course.equals(courses.get(i))) {
            courses.remove(course.getIndexId());
         }
      }

      for (int i = 0; i < courses.size(); i++) {
         courses.get(i).setIndexId(i);
      }
   }

}
