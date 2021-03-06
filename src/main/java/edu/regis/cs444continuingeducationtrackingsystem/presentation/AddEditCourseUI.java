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

import cs444continuingeducationtrackingsystem.service.*;
import cs444continuingeducationtrackingsystem.domain.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * User Interface for Add and Edit Course use cases.
 * 
 * @author Nathan Thomas
 * @version 1.0
 */
public class AddEditCourseUI extends javax.swing.JFrame {

   private Account account = null;
   private Course course = null;

   /**
    * Sets account and course values for add/edit use cases.
    *
    * @param account
    * @param course
    */
   public void setAccount(Account account, Course course) {
      this.account = account;
      this.course = course;

      courseTitleFld.setText(course.getCourseTitle());
      vendorFld.setText(course.getCourseVendor());
      courseCityFld.setText(course.getCourseCity());
      addEditCourseStateBox.setSelectedItem(course.getCourseState());

      if (course.getNumHours() == 0.0) {
         courseHoursFld.setText("");
      } else {
         courseHoursFld.setText(String.valueOf(course.getNumHours()));
      }

      if (course.getCourseTitle().equals("")) {
         addEditCourseLbl.setText("Add Course");
      } else {
         addEditCourseLbl.setText("Edit Course");
         addEditMonthBox.setSelectedItem((String) course.getCompletionDate()
                 .substring(0, 3));
         addEditDayBox.setSelectedItem((String) course.getCompletionDate()
                 .substring(4, 6));
         if (course.getCompletionDate().length() == 12) {
            addEditYearBox.setSelectedItem((String) course.getCompletionDate()
                    .substring(8));
         } else {
            addEditYearBox.setSelectedItem((String) course.getCompletionDate()
                    .substring(7));
         }
      }
   }

   /**
    * Creates new form AddEditCourseUI
    */
   public AddEditCourseUI() {
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

      addEditCourseLbl = new javax.swing.JLabel();
      courseTitleLbl = new javax.swing.JLabel();
      courseTitleFld = new javax.swing.JTextField();
      completionDateLbl = new javax.swing.JLabel();
      courseHoursLbl = new javax.swing.JLabel();
      courseHoursFld = new javax.swing.JTextField();
      vendorLbl = new javax.swing.JLabel();
      vendorFld = new javax.swing.JTextField();
      locationLbl = new javax.swing.JLabel();
      courseCityLbl = new javax.swing.JLabel();
      courseCityFld = new javax.swing.JTextField();
      courseStateLbl = new javax.swing.JLabel();
      addEditSaveBtn = new javax.swing.JButton();
      addEditCancelBtn = new javax.swing.JButton();
      addEditCourseStateBox = new javax.swing.JComboBox<>();
      addEditMonthBox = new javax.swing.JComboBox<>();
      addEditDayBox = new javax.swing.JComboBox<>();
      addEditYearBox = new javax.swing.JComboBox<>();
      addEditNumHoursWarningLbl = new javax.swing.JLabel();
      addEditDateWarningLbl = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
      setTitle("CETS");
      setLocation(new java.awt.Point(450, 250));
      setMaximumSize(new java.awt.Dimension(575, 352));
      setMinimumSize(new java.awt.Dimension(575, 352));
      setPreferredSize(new java.awt.Dimension(575, 352));
      setResizable(false);

      addEditCourseLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
      addEditCourseLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      addEditCourseLbl.setText("Add / Edit Course");

      courseTitleLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      courseTitleLbl.setText("Course Title");

      courseTitleFld.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
      courseTitleFld.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            courseTitleFldActionPerformed(evt);
         }
      });

      completionDateLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      completionDateLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
      completionDateLbl.setText("Completion Date");

      courseHoursLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      courseHoursLbl.setText("Number of Hours");

      courseHoursFld.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      vendorLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      vendorLbl.setText("Course Vendor");

      vendorFld.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      locationLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      locationLbl.setText("Course Location:");

      courseCityLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      courseCityLbl.setText("City");

      courseCityFld.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

      courseStateLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      courseStateLbl.setText("State");

      addEditSaveBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
      addEditSaveBtn.setText("SAVE");
      addEditSaveBtn.setMaximumSize(new java.awt.Dimension(73, 26));
      addEditSaveBtn.setMinimumSize(new java.awt.Dimension(73, 26));
      addEditSaveBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addEditSaveBtnActionPerformed(evt);
         }
      });

      addEditCancelBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
      addEditCancelBtn.setText("Cancel");
      addEditCancelBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addEditCancelBtnActionPerformed(evt);
         }
      });

      addEditCourseStateBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "ME", "MD", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY", "USA", "AS", "FM", "GU", "MH", "MP", "PW", "PR", "VI", "Online" }));

      addEditMonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" }));

      addEditDayBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

      addEditYearBox.setEditable(true);
      addEditYearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2019", "2018", " " }));
      addEditYearBox.setMinimumSize(new java.awt.Dimension(60, 25));
      addEditYearBox.setPreferredSize(new java.awt.Dimension(60, 25));

      addEditNumHoursWarningLbl.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
      addEditNumHoursWarningLbl.setForeground(new java.awt.Color(255, 0, 51));
      addEditNumHoursWarningLbl.setText(" ");

      addEditDateWarningLbl.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
      addEditDateWarningLbl.setForeground(new java.awt.Color(255, 0, 51));
      addEditDateWarningLbl.setText(" ");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(215, 215, 215)
                  .addComponent(addEditCourseLbl))
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                     .addGap(30, 30, 30)
                     .addComponent(locationLbl)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                           .addComponent(addEditSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addGap(112, 112, 112)
                           .addComponent(addEditCancelBtn))
                        .addGroup(layout.createSequentialGroup()
                           .addComponent(courseCityLbl)
                           .addGap(11, 11, 11)
                           .addComponent(courseCityFld, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(courseStateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(addEditCourseStateBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                           .addContainerGap()
                           .addComponent(completionDateLbl)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout.createSequentialGroup()
                           .addGap(30, 30, 30)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(vendorLbl)
                              .addComponent(courseTitleLbl))
                           .addGap(23, 23, 23)))
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                 .addComponent(addEditMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(addEditDayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(addEditYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addComponent(addEditDateWarningLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(addEditNumHoursWarningLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addGroup(layout.createSequentialGroup()
                                 .addComponent(courseHoursLbl)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(courseHoursFld, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(vendorFld)
                        .addComponent(courseTitleFld)))))
            .addContainerGap(47, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(addEditCourseLbl)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(courseTitleLbl)
               .addComponent(courseTitleFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(completionDateLbl)
               .addComponent(courseHoursLbl)
               .addComponent(courseHoursFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(addEditMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(addEditDayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(addEditYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(addEditNumHoursWarningLbl)
               .addComponent(addEditDateWarningLbl))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(vendorLbl)
               .addComponent(vendorFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(locationLbl)
               .addComponent(courseCityLbl)
               .addComponent(courseCityFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(courseStateLbl)
               .addComponent(addEditCourseStateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(addEditCancelBtn)
               .addComponent(addEditSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(78, 78, 78))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void courseTitleFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseTitleFldActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_courseTitleFldActionPerformed

   private void addEditCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEditCancelBtnActionPerformed
      IAccountSvc impl = AccountSvcCacheImpl.getInstance();
      if (addEditCourseLbl.getText().equals("Add Course")) {
         account.deleteCourse(course);
         account = impl.update(account);
      }

      MainUI mainUI = new MainUI();
      mainUI.setAccount(account);
      this.setVisible(false);
      mainUI.setVisible(true);
   }//GEN-LAST:event_addEditCancelBtnActionPerformed

   private void addEditSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEditSaveBtnActionPerformed
      int currentYear = LocalDate.now().getYear();
      course.setCourseTitle(courseTitleFld.getText());
      course.setCourseVendor(vendorFld.getText());
      course.setCompletionDate(addEditMonthBox.getSelectedItem() + " " 
              + addEditDayBox.getSelectedItem() + ", " 
              + addEditYearBox.getSelectedItem());
      course.setCourseCity(courseCityFld.getText());
      course.setCourseState((String) addEditCourseStateBox.getSelectedItem());
      course.setNumHours(courseHoursFld.getText());
      addEditDateWarningLbl.setText("");
      addEditNumHoursWarningLbl.setText("");

      boolean isValid = course.validate();

      if (!isValid) {
         JOptionPane.showMessageDialog(this, "All Fields Must Be Completed "
                 + "Correctly",
                 "Error", JOptionPane.ERROR_MESSAGE);
         try {
            Double.parseDouble(courseHoursFld.getText());
            addEditNumHoursWarningLbl.setText("");
         } catch (NumberFormatException e) {
            addEditNumHoursWarningLbl.setText("Must Be Whole or Decimal Number");
         }
         try {
            int year = Integer.valueOf((String) addEditYearBox.getSelectedItem());
            if (year > currentYear) {
               addEditDateWarningLbl.setText("Cannot Be A Future Year");
            }
            if (year <= 2014) {
               addEditDateWarningLbl.setText("Years Prior To 2015 Not Accepted");
            }
         } catch (ClassCastException e) {
            addEditDateWarningLbl.setText("Enter a Valid 4-digit Year");     
         }
         try {
            int day = Integer.valueOf((String) addEditDayBox.getSelectedItem());
            if (addEditMonthBox.getSelectedItem().equals("FEB") 
                    && day > 29) {
               addEditDateWarningLbl.setText("FEB always has less than 30"
                       + " days");
            }
         } catch (ClassCastException e) {
            addEditDateWarningLbl.setText("Select a Number for the Day");
         }
         return;
      }

      IAccountSvc impl = AccountSvcCacheImpl.getInstance();
      account = impl.update(account);

      if (account == null) {
         JOptionPane.showMessageDialog(this, "Process Failed! Your Course Was "
                 + "Not Added. Please Try Again.",
                 "Error", JOptionPane.ERROR_MESSAGE);
         return;
      } else {
         JOptionPane.showMessageDialog(this, "Your Course Has Been Saved!",
                 "Success!", JOptionPane.INFORMATION_MESSAGE);
      }

      MainUI mainUI = new MainUI();
      mainUI.setAccount(account);
      this.setVisible(false);
      mainUI.setVisible(true);
   }//GEN-LAST:event_addEditSaveBtnActionPerformed

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
         java.util.logging.Logger.getLogger(AddEditCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(AddEditCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(AddEditCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(AddEditCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new AddEditCourseUI().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addEditCancelBtn;
   private javax.swing.JLabel addEditCourseLbl;
   private javax.swing.JComboBox<String> addEditCourseStateBox;
   private javax.swing.JLabel addEditDateWarningLbl;
   private javax.swing.JComboBox<String> addEditDayBox;
   private javax.swing.JComboBox<String> addEditMonthBox;
   private javax.swing.JLabel addEditNumHoursWarningLbl;
   private javax.swing.JButton addEditSaveBtn;
   private javax.swing.JComboBox<String> addEditYearBox;
   private javax.swing.JLabel completionDateLbl;
   private javax.swing.JTextField courseCityFld;
   private javax.swing.JLabel courseCityLbl;
   private javax.swing.JTextField courseHoursFld;
   private javax.swing.JLabel courseHoursLbl;
   private javax.swing.JLabel courseStateLbl;
   private javax.swing.JTextField courseTitleFld;
   private javax.swing.JLabel courseTitleLbl;
   private javax.swing.JLabel locationLbl;
   private javax.swing.JTextField vendorFld;
   private javax.swing.JLabel vendorLbl;
   // End of variables declaration//GEN-END:variables
}
