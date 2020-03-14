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

import cs444continuingeducationtrackingsystem.domain.Account;
import cs444continuingeducationtrackingsystem.domain.Course;
import cs444continuingeducationtrackingsystem.service.AccountSvcCacheImpl;
import cs444continuingeducationtrackingsystem.service.IAccountSvc;

/**
 * User Interface for performing delete operation on Course object.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class DeleteCourseUI extends javax.swing.JFrame {

   private Account account = null;
   private Course course = null;

   /**
    * Sets Course Title in Label to confirm before deletion, and course to be
    * deleted if user confirms.
    *
    * @param account
    * @param course
    */
   public void setCourse(Account account, Course course) {
      this.account = account;
      this.course = course;

      courseToDeleteLbl.setText(course.getCourseTitle());
   }

   /**
    * Creates new form DeleteCourseUI
    */
   public DeleteCourseUI() {
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

      deleteCourseLbl = new javax.swing.JLabel();
      deleteCourseWarningLbl = new javax.swing.JLabel();
      deleteCourseMessage1Lbl = new javax.swing.JLabel();
      deleteCourseMessage2Lbl = new javax.swing.JLabel();
      continueQuestionLbl = new javax.swing.JLabel();
      confirmDeleteBtn = new javax.swing.JButton();
      cancelDeleteBtn = new javax.swing.JButton();
      courseToDeleteLbl = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
      setTitle("CETS");
      setLocation(new java.awt.Point(500, 250));
      setMinimumSize(new java.awt.Dimension(400, 300));
      setPreferredSize(new java.awt.Dimension(400, 320));
      setResizable(false);

      deleteCourseLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
      deleteCourseLbl.setText("Delete Course");

      deleteCourseWarningLbl.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
      deleteCourseWarningLbl.setForeground(new java.awt.Color(204, 0, 0));
      deleteCourseWarningLbl.setText("WARNING!");

      deleteCourseMessage1Lbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      deleteCourseMessage1Lbl.setText("You have chosen to delete a course record!");

      deleteCourseMessage2Lbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      deleteCourseMessage2Lbl.setText("This will result in PERMANENT loss of the record!");

      continueQuestionLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      continueQuestionLbl.setText("Do you wish to continue?");

      confirmDeleteBtn.setForeground(new java.awt.Color(255, 0, 0));
      confirmDeleteBtn.setText("Yes, DELETE");
      confirmDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            confirmDeleteBtnActionPerformed(evt);
         }
      });

      cancelDeleteBtn.setText("No, CANCEL");
      cancelDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelDeleteBtnActionPerformed(evt);
         }
      });

      courseToDeleteLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      courseToDeleteLbl.setText("<<Course Title>>");
      courseToDeleteLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteCourseMessage1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(47, 47, 47))
         .addGroup(layout.createSequentialGroup()
            .addGap(44, 44, 44)
            .addComponent(confirmDeleteBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cancelDeleteBtn)
            .addGap(44, 44, 44))
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(137, 137, 137)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(deleteCourseLbl)
                     .addComponent(deleteCourseWarningLbl)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(114, 114, 114)
                  .addComponent(continueQuestionLbl))
               .addGroup(layout.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(courseToDeleteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(deleteCourseMessage2Lbl))))
            .addContainerGap(29, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap(21, Short.MAX_VALUE)
            .addComponent(deleteCourseLbl)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
            .addComponent(courseToDeleteLbl)
            .addGap(18, 18, 18)
            .addComponent(deleteCourseWarningLbl)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(deleteCourseMessage1Lbl)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(deleteCourseMessage2Lbl)
            .addGap(18, 18, 18)
            .addComponent(continueQuestionLbl)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(confirmDeleteBtn)
               .addComponent(cancelDeleteBtn))
            .addContainerGap(40, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void cancelDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDeleteBtnActionPerformed
      this.setVisible(false);
      MainUI MainUI = new MainUI();
      MainUI.setAccount(account);
      MainUI.setVisible(true);
   }//GEN-LAST:event_cancelDeleteBtnActionPerformed

   private void confirmDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmDeleteBtnActionPerformed
      IAccountSvc impl = AccountSvcCacheImpl.getInstance();
      account.deleteCourse(course);
      account = impl.update(account);
      MainUI mainUI = new MainUI();
      mainUI.setAccount(account);
      this.setVisible(false);
      mainUI.setVisible(true);
   }//GEN-LAST:event_confirmDeleteBtnActionPerformed

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
         java.util.logging.Logger.getLogger(DeleteCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(DeleteCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(DeleteCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(DeleteCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new DeleteCourseUI().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton cancelDeleteBtn;
   private javax.swing.JButton confirmDeleteBtn;
   private javax.swing.JLabel continueQuestionLbl;
   private javax.swing.JLabel courseToDeleteLbl;
   private javax.swing.JLabel deleteCourseLbl;
   private javax.swing.JLabel deleteCourseMessage1Lbl;
   private javax.swing.JLabel deleteCourseMessage2Lbl;
   private javax.swing.JLabel deleteCourseWarningLbl;
   // End of variables declaration//GEN-END:variables
}
