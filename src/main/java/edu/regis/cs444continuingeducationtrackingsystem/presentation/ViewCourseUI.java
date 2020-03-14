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

import cs444continuingeducationtrackingsystem.domain.*;
import java.util.LinkedList;

/**
 * User Interface for viewing course details. Forward and Backward arrow buttons
 * allow user to cycle through their course list to view each one's details
 * sequentially.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class ViewCourseUI extends javax.swing.JFrame {

   private Account account = null;
   private Course course = null;
   private int courseIndex;
   private LinkedList<Course> courseList;

   /**
    * Populates the view's fields with course details.
    *
    * @param account
    * @param course
    */
   public void setCourse(Account account, Course course) {
      this.account = account;
      this.course = course;
      this.courseList = (LinkedList<Course>) account.getCourses();

      if (!courseList.isEmpty()) {
         this.courseIndex = course.getIndexId();
      }

      displayCourseTitle.setText(course.getCourseTitle());
      displayCompletionDate.setText(course.getCompletionDate());
      displayCourseVendorLbl.setText(course.getCourseVendor());
      displayCourseLocationLbl.setText(course.getCourseCity() + ", "
              + course.getCourseState());
      displayCourseHoursLbl.setText(String.valueOf(course.getNumHours()));
   }

   /**
    * Creates new form ViewCourseUI
    */
   public ViewCourseUI() {
      initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      viewCourseLbl = new javax.swing.JLabel();
      viewCourseTitleLbl = new javax.swing.JLabel();
      displayCourseTitle = new javax.swing.JLabel();
      viewCompletionDateLbl = new javax.swing.JLabel();
      viewCourseVendorLbl = new javax.swing.JLabel();
      viewCourseLocationLbl = new javax.swing.JLabel();
      displayCompletionDate = new javax.swing.JLabel();
      viewCourseHoursLbl = new javax.swing.JLabel();
      displayCourseHoursLbl = new javax.swing.JLabel();
      displayCourseVendorLbl = new javax.swing.JLabel();
      displayCourseLocationLbl = new javax.swing.JLabel();
      previousCourseBtn = new javax.swing.JButton();
      nextCourseBtn = new javax.swing.JButton();
      closeBtn = new javax.swing.JButton();
      editBtn = new javax.swing.JButton();
      deleteBtn = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
      setTitle("CETS");
      setLocation(new java.awt.Point(450, 250));
      setMinimumSize(new java.awt.Dimension(745, 375));
      setPreferredSize(new java.awt.Dimension(745, 375));

      viewCourseLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
      viewCourseLbl.setText("View Course Details");

      viewCourseTitleLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      viewCourseTitleLbl.setText("Course Title:");

      displayCourseTitle.setBackground(new java.awt.Color(255, 255, 255));
      displayCourseTitle.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      viewCompletionDateLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      viewCompletionDateLbl.setText("Completion Date:");

      viewCourseVendorLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      viewCourseVendorLbl.setText("Course Vendor:");

      viewCourseLocationLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      viewCourseLocationLbl.setText("Course Location:");

      displayCompletionDate.setBackground(new java.awt.Color(255, 255, 255));
      displayCompletionDate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      viewCourseHoursLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      viewCourseHoursLbl.setText("Number of Hours:");

      displayCourseHoursLbl.setBackground(new java.awt.Color(255, 255, 255));
      displayCourseHoursLbl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      displayCourseVendorLbl.setBackground(new java.awt.Color(255, 255, 255));
      displayCourseVendorLbl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      displayCourseLocationLbl.setBackground(new java.awt.Color(255, 255, 255));
      displayCourseLocationLbl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      previousCourseBtn.setText("<");
      previousCourseBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            previousCourseBtnActionPerformed(evt);
         }
      });

      nextCourseBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
      nextCourseBtn.setText(">");
      nextCourseBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            nextCourseBtnActionPerformed(evt);
         }
      });

      closeBtn.setText("Close");
      closeBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            closeBtnActionPerformed(evt);
         }
      });

      editBtn.setText("Edit");
      editBtn.setMaximumSize(new java.awt.Dimension(67, 26));
      editBtn.setMinimumSize(new java.awt.Dimension(67, 26));
      editBtn.setPreferredSize(new java.awt.Dimension(67, 26));
      editBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            editBtnActionPerformed(evt);
         }
      });

      deleteBtn.setText("Delete");
      deleteBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteBtnActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(23, 23, 23)
                  .addComponent(previousCourseBtn)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(viewCourseLocationLbl)
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(28, 28, 28)
                              .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                              .addGap(20, 20, 20)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(viewCourseTitleLbl)
                                 .addComponent(viewCompletionDateLbl)
                                 .addComponent(viewCourseVendorLbl)))
                           .addGroup(layout.createSequentialGroup()
                              .addGap(18, 18, 18)
                              .addComponent(viewCourseHoursLbl)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                              .addGap(48, 48, 48)
                              .addComponent(displayCourseHoursLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGroup(layout.createSequentialGroup()
                              .addGap(45, 45, 45)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                 .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(displayCompletionDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(displayCourseTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                 .addComponent(displayCourseVendorLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addComponent(displayCourseLocationLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(nextCourseBtn))
               .addGroup(layout.createSequentialGroup()
                  .addGap(290, 290, 290)
                  .addComponent(viewCourseLbl)))
            .addContainerGap(75, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(viewCourseLbl)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                     .addComponent(displayCourseTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(viewCourseTitleLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(viewCompletionDateLbl)
                     .addComponent(displayCompletionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(20, 20, 20)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(viewCourseVendorLbl)
                     .addComponent(displayCourseVendorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(displayCourseLocationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(viewCourseLocationLbl))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(displayCourseHoursLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(viewCourseHoursLbl))))
               .addComponent(previousCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(nextCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(70, 70, 70)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(deleteBtn)
               .addComponent(closeBtn))
            .addContainerGap(90, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
      MainUI mainUI = new MainUI();
      mainUI.setAccount(account);
      this.setVisible(false);
      mainUI.setVisible(true);
   }//GEN-LAST:event_closeBtnActionPerformed

   private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
      this.setVisible(false);
      AddEditCourseUI addEditCourseUI = new AddEditCourseUI();
      addEditCourseUI.setAccount(account, course);
      addEditCourseUI.setVisible(true);
   }//GEN-LAST:event_editBtnActionPerformed

   private void previousCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousCourseBtnActionPerformed
      if (courseIndex > 0) {
         courseIndex--;
         this.setCourse(account, courseList.get(courseIndex));
      } else {
         courseIndex = courseList.size() - 1;
         this.setCourse(account, courseList.get(courseIndex));
      }
   }//GEN-LAST:event_previousCourseBtnActionPerformed

   private void nextCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextCourseBtnActionPerformed
      if (courseIndex + 1 < courseList.size()) {
         courseIndex++;
         this.setCourse(account, courseList.get(courseIndex));
      } else {
         courseIndex = 0;
         this.setCourse(account, courseList.get(courseIndex));
      }
   }//GEN-LAST:event_nextCourseBtnActionPerformed

   private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
      DeleteCourseUI deleteCourseUI = new DeleteCourseUI();
      deleteCourseUI.setCourse(account, course);
      this.setVisible(false);
      deleteCourseUI.setVisible(true);
   }//GEN-LAST:event_deleteBtnActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(ViewCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(ViewCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(ViewCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(ViewCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new ViewCourseUI().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton closeBtn;
   private javax.swing.JButton deleteBtn;
   private javax.swing.JLabel displayCompletionDate;
   private javax.swing.JLabel displayCourseHoursLbl;
   private javax.swing.JLabel displayCourseLocationLbl;
   private javax.swing.JLabel displayCourseTitle;
   private javax.swing.JLabel displayCourseVendorLbl;
   private javax.swing.JButton editBtn;
   private javax.swing.JButton nextCourseBtn;
   private javax.swing.JButton previousCourseBtn;
   private javax.swing.JLabel viewCompletionDateLbl;
   private javax.swing.JLabel viewCourseHoursLbl;
   private javax.swing.JLabel viewCourseLbl;
   private javax.swing.JLabel viewCourseLocationLbl;
   private javax.swing.JLabel viewCourseTitleLbl;
   private javax.swing.JLabel viewCourseVendorLbl;
   // End of variables declaration//GEN-END:variables
}
