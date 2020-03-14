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
import cs444continuingeducationtrackingsystem.service.ProcessAccountsFileImpl;
import cs444continuingeducationtrackingsystem.service.ReportSvcImpl;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;

/**
 * MainUI is the primary user interface for viewing profile and course
 * information.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public class MainUI extends javax.swing.JFrame {

   private Account account = null;
   private int selectedIndex = 0;
   private CourseTableModel model = new CourseTableModel();
   static ProcessAccountsFileImpl fileImpl = new ProcessAccountsFileImpl();

   /**
    * Method populates fields with user's account data upon logging in.
    *
    * @param account
    */
   public void setAccount(Account account) {
      this.account = account;
      model.setCourses(account.getCourses());
      welcomeLbl.setText("Welcome, " + account.getFirstName() + " "
              + account.getLastName());
      licenseLbl.setText(account.getLicenseTitle());
      stateAndLicNumLbl.setText(account.getLicenseState() + "  "
              + "License #: "
              + account.getLicenseNumber());
      expiresOnLbl.setText("Expires on:       " + account.getExpirationDate());
      numHoursNeededLbl.setText(account.getHoursNeeded());
      sumOfHoursLbl.setText(String.valueOf(account.getTotalHours()));
   }

   /**
    * Creates new form MainUI
    */
   public MainUI() {
      initComponents();

      courseTable.setModel(model);
      courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      courseTable.getColumnModel().getColumn(0).setPreferredWidth(25);
      courseTable.getColumnModel().getColumn(1).setPreferredWidth(310);
      courseTable.getColumnModel().getColumn(2).setPreferredWidth(110);
      courseTable.getColumnModel().getColumn(3).setPreferredWidth(110);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      welcomeLbl = new javax.swing.JLabel();
      licenseLbl = new javax.swing.JLabel();
      stateAndLicNumLbl = new javax.swing.JLabel();
      sumOfHoursLbl = new javax.swing.JLabel();
      hoursCompletedLbl = new javax.swing.JLabel();
      expiresOnLbl = new javax.swing.JLabel();
      ofLbl = new javax.swing.JLabel();
      numHoursNeededLbl = new javax.swing.JLabel();
      courseListLbl = new javax.swing.JLabel();
      jSeparator1 = new javax.swing.JSeparator();
      addCourseBtn = new javax.swing.JButton();
      createReportBtn = new javax.swing.JButton();
      logOutBtn = new javax.swing.JButton();
      jSeparator2 = new javax.swing.JSeparator();
      courseSelectInstructionLbl = new javax.swing.JLabel();
      viewCourseDetailsBtn = new javax.swing.JButton();
      editCourseBtn = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      courseTable = new javax.swing.JTable();
      deleteBtn = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("CETS");
      setLocation(new java.awt.Point(350, 200));
      setMinimumSize(new java.awt.Dimension(700, 520));

      welcomeLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
      welcomeLbl.setText("Welcome, <<First-Name Last-Name>> !");

      licenseLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      licenseLbl.setText("<<License Title>>");

      stateAndLicNumLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      stateAndLicNumLbl.setText("<<State>> license # <<License Number>>");

      sumOfHoursLbl.setFont(new java.awt.Font("Engravers MT", 1, 30)); // NOI18N
      sumOfHoursLbl.setText("##");

      hoursCompletedLbl.setText("Hours Completed:");

      expiresOnLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
      expiresOnLbl.setText("Expires On: <<Expiration Date>>");

      ofLbl.setText("OF");

      numHoursNeededLbl.setFont(new java.awt.Font("Engravers MT", 1, 30)); // NOI18N
      numHoursNeededLbl.setText("##");

      courseListLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
      courseListLbl.setText("Course List");

      addCourseBtn.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
      addCourseBtn.setText("Add Course");
      addCourseBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addCourseBtnActionPerformed(evt);
         }
      });

      createReportBtn.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
      createReportBtn.setText("Create Report");
      createReportBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            createReportBtnActionPerformed(evt);
         }
      });

      logOutBtn.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
      logOutBtn.setText("Log Out");
      logOutBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            logOutBtnActionPerformed(evt);
         }
      });

      courseSelectInstructionLbl.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
      courseSelectInstructionLbl.setText("Select Course Before Clicking \"Details\", \"Edit\", or \"Delete\" Button");

      viewCourseDetailsBtn.setText("Details");
      viewCourseDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            viewCourseDetailsBtnActionPerformed(evt);
         }
      });

      editCourseBtn.setText("Edit");
      editCourseBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            editCourseBtnActionPerformed(evt);
         }
      });

      courseTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
      courseTable.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "#", "Course Title", "Completion Date", "Number of Hours"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
         };
         boolean[] canEdit = new boolean [] {
            false, false, false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      courseTable.setName(""); // NOI18N
      courseTable.setRowHeight(20);
      courseTable.setShowHorizontalLines(false);
      courseTable.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            courseTableFocusGained(evt);
         }
      });
      courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            courseTableMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(courseTable);
      if (courseTable.getColumnModel().getColumnCount() > 0) {
         courseTable.getColumnModel().getColumn(0).setResizable(false);
         courseTable.getColumnModel().getColumn(0).setPreferredWidth(30);
         courseTable.getColumnModel().getColumn(1).setResizable(false);
         courseTable.getColumnModel().getColumn(1).setPreferredWidth(310);
         courseTable.getColumnModel().getColumn(2).setPreferredWidth(100);
         courseTable.getColumnModel().getColumn(3).setPreferredWidth(100);
      }

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
         .addComponent(jSeparator1)
         .addGroup(layout.createSequentialGroup()
            .addGap(418, 418, 418)
            .addComponent(createReportBtn)
            .addGap(44, 44, 44)
            .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(48, 48, 48))
         .addComponent(jSeparator2)
         .addGroup(layout.createSequentialGroup()
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(courseSelectInstructionLbl)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(licenseLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(stateAndLicNumLbl)
                     .addComponent(welcomeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                  .addComponent(hoursCompletedLbl)
                  .addGap(18, 18, 18)
                  .addComponent(sumOfHoursLbl)
                  .addGap(18, 18, 18)
                  .addComponent(ofLbl)
                  .addGap(18, 18, 18)
                  .addComponent(numHoursNeededLbl))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(courseListLbl)
                        .addGap(43, 43, 43)
                        .addComponent(addCourseBtn))
                     .addComponent(expiresOnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 26, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(viewCourseDetailsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(editCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGap(21, 21, 21))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addComponent(welcomeLbl)
                  .addGap(15, 15, 15)
                  .addComponent(licenseLbl)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(stateAndLicNumLbl))
               .addGroup(layout.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(sumOfHoursLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(hoursCompletedLbl)
                     .addComponent(ofLbl)
                     .addComponent(numHoursNeededLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(expiresOnLbl)
            .addGap(18, 18, 18)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, 8)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(courseListLbl)
               .addComponent(addCourseBtn))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addGroup(layout.createSequentialGroup()
                  .addGap(39, 39, 39)
                  .addComponent(viewCourseDetailsBtn)
                  .addGap(18, 18, 18)
                  .addComponent(editCourseBtn)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(deleteBtn))
               .addGroup(layout.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(courseSelectInstructionLbl)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(14, 14, 14)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(createReportBtn)
               .addComponent(logOutBtn))
            .addGap(36, 36, 36))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
      fileImpl.updateFile();
      this.setVisible(false);
      LoginUI loginUI = new LoginUI();
      loginUI.setVisible(true);

   }//GEN-LAST:event_logOutBtnActionPerformed

   private void addCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseBtnActionPerformed
      Course newCourse = new Course();
      account.add(newCourse);
      this.setVisible(false);
      AddEditCourseUI addEditCourseUI = new AddEditCourseUI();
      addEditCourseUI.setAccount(account, newCourse);
      addEditCourseUI.setVisible(true);
   }//GEN-LAST:event_addCourseBtnActionPerformed

   private void viewCourseDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCourseDetailsBtnActionPerformed
      Course courseToEdit = account.getCourse(selectedIndex);
      this.setVisible(false);
      ViewCourseUI viewCourseUI = new ViewCourseUI();
      viewCourseUI.setCourse(account, courseToEdit);
      viewCourseUI.setVisible(true);
   }//GEN-LAST:event_viewCourseDetailsBtnActionPerformed

   private void editCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseBtnActionPerformed
      
      if (selectedIndex == 0) {
         JOptionPane.showMessageDialog(this, "Select A Course To Edit",
                 "Error", JOptionPane.ERROR_MESSAGE);
      } else {
         Course courseToEdit = account.getCourse(selectedIndex);
         this.setVisible(false);
         AddEditCourseUI addEditCourseUI = new AddEditCourseUI();
         addEditCourseUI.setAccount(account, courseToEdit);
         addEditCourseUI.setVisible(true);
      }
   }//GEN-LAST:event_editCourseBtnActionPerformed

   private void createReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createReportBtnActionPerformed

      String filePath = "";
      JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      jfc.setDialogTitle("Choose a directory and name the file ending in '.txt'");
      jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      int returnValue = jfc.showSaveDialog(null);

      if (returnValue == JFileChooser.APPROVE_OPTION) {
         filePath = jfc.getSelectedFile().getPath();
         ReportSvcImpl rptImpl = new ReportSvcImpl();
         rptImpl.createReport(account, account.getCourses(), filePath);

         if (rptImpl.findFile(filePath)) {
            JOptionPane.showMessageDialog(this, "Report Creation Successful!",
                    "Report Created", JOptionPane.INFORMATION_MESSAGE);
         } else {
            JOptionPane.showMessageDialog(this, "There was a problem creating your"
                    + " report. Please make sure the file path is valid and try "
                    + "again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
         }
      } else if (returnValue == JFileChooser.CANCEL_OPTION) {
         JOptionPane.showMessageDialog(this, "Return to Main Screen",
                 "Report Creation Canceled", JOptionPane.INFORMATION_MESSAGE);
      }
   }//GEN-LAST:event_createReportBtnActionPerformed

   private void courseTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseTableFocusGained
      // TODO add your handling code here:
   }//GEN-LAST:event_courseTableFocusGained

   private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
      int selectedCourse = courseTable.getSelectedRow();
      selectedIndex = selectedCourse;
   }//GEN-LAST:event_courseTableMouseClicked

   private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

      if (selectedIndex == 0) {
         JOptionPane.showMessageDialog(this, "No Course Selected",
                 "Delete Error", JOptionPane.ERROR_MESSAGE);
      } else {
         Course courseToDelete = account.getCourse(selectedIndex);
         DeleteCourseUI deleteCourseUI = new DeleteCourseUI();
         deleteCourseUI.setCourse(account, courseToDelete);
         this.setVisible(false);
         deleteCourseUI.setVisible(true);
      }
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
         java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new MainUI().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addCourseBtn;
   private javax.swing.JLabel courseListLbl;
   private javax.swing.JLabel courseSelectInstructionLbl;
   private javax.swing.JTable courseTable;
   private javax.swing.JButton createReportBtn;
   private javax.swing.JButton deleteBtn;
   private javax.swing.JButton editCourseBtn;
   private javax.swing.JLabel expiresOnLbl;
   private javax.swing.JLabel hoursCompletedLbl;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JSeparator jSeparator2;
   private javax.swing.JLabel licenseLbl;
   private javax.swing.JButton logOutBtn;
   private javax.swing.JLabel numHoursNeededLbl;
   private javax.swing.JLabel ofLbl;
   private javax.swing.JLabel stateAndLicNumLbl;
   private javax.swing.JLabel sumOfHoursLbl;
   private javax.swing.JButton viewCourseDetailsBtn;
   private javax.swing.JLabel welcomeLbl;
   // End of variables declaration//GEN-END:variables
}
