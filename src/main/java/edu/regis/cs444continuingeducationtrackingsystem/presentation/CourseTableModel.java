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
package edu.regis.cs444continuingeducationtrackingsystem.presentation;

import javax.swing.table.AbstractTableModel;
import cs444continuingeducationtrackingsystem.domain.*;
import java.util.*;

/**
 * Method extends abstract class for TableModel to set course table in MainUI.
 * 
 * @author Nathan Thomas
 * @version 1.0
 */
public class CourseTableModel extends AbstractTableModel {

   private String[] columnNames = {"#", "Course Title", "Completion Date",
      "Number of Hours"};
   private List<Course> courses = new LinkedList<Course>();

   /**
    * Sets table course List.
    * 
    * @param courses
    */
   public void setCourses(List<Course> courses) {
      this.courses = courses;
   }

   @Override
   public int getRowCount() {
      return courses.size();
   }

   @Override
   public int getColumnCount() {
      return columnNames.length;
   }

   @Override
   public Object getValueAt(int row, int column) {
      Course course = courses.get(row);
      switch (column) {
         case 0:
            return course.getIndexId() + 1;
         case 1:
            return course.getCourseTitle();
         case 2:
            return course.getCompletionDate();
         case 3:
            return course.getNumHours();
      }
      return "";
   }

   @Override
   public String getColumnName(int column) {
      return columnNames[column];
   }
}
