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
 * Test for report creation class methods.
 * 
 * @author Nathan Thomas
 * @version 1.0
 */
public class ReportSvcImplTest {
   
   /**
    * Empty Test.
    */
   public ReportSvcImplTest() {
   }

   /**
    * Tests method for FileWrite output to default folder.
    */
   @Test
   public void testCreateReport() {
      // String fileName = "C:\\Users\\nthom\\Desktop\\Report.txt";
      String fileName = "";                     // Tests Default File Location
      ReportSvcImpl impl = new ReportSvcImpl();
      Account account = new Account();
      Course course = new Course();
      account.setFirstName("John");
      account.setLastName("Doe");
      course.setCourseTitle("Topic");
      account.add(course);
      List<Course> courses = account.getCourses();
      impl.createReport(account, courses, fileName);
      
      boolean fileExists = impl.findFile(fileName);
      assertNotNull(fileExists);
   }
   
}
