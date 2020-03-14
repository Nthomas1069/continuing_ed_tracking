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
 * Test for Course class objects.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class CourseTest {

   /**
    * Empty Test.
    */
   public CourseTest() {
   }

   /**
    * Tests testValidate method to ensure Course attributes are not empty or
    * null. Also tests private method for validation of NumHours double value.
    */
   @Test
   public void testValidate() {
      Course course = new Course();
      boolean result = course.validate();
      assertFalse(result);
      course.setCourseTitle("Spinal Manipulation Made Easy");
      result = course.validate();
      assertFalse(result);
      course.setCourseVendor("Spine Man, Inc.");
      result = course.validate();
      assertFalse(result);
      course.setCompletionDate("DEC 23, 2019");
      result = course.validate();
      assertFalse(result);
      course.setCourseCity("St Louis");
      result = course.validate();
      assertFalse(result);
      course.setCourseState("Missouri");
      result = course.validate();
      assertFalse(result);
      course.setNumHours("2.5");
      result = course.validate();
      assertTrue(result);                     // Test all attributes valid

      course.setNumHours("-2.5");            // Test non-negative validation
      result = course.validate();
      assertFalse(result);
      course.setNumHours("0");               // Test not-zero validation
      result = course.validate();
      assertFalse(result);
      course.setNumHours("Five");            // Test not-digit validation
      result = course.validate();
      assertFalse(result);
      course.setNumHours("2.5");
      result = course.validate();
      assertTrue(result);
   }

}
