/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Analytics.Controller;
import Analytics.FileAnalyzer;
import Analytics.InheritanceMeasure;
import Coupling.CouplingMain;
import Coupling.CustomFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public static String filepath;
    public String fileName;
    public FileAnalyzer fileAnalyzer = new FileAnalyzer();
    AnalyzerForm analyzerForm = new AnalyzerForm();
    InheritanceMeasure inheritMeasure;
    Controller controller = new Controller();
    FileReader fileReader;
    BufferedReader bufferedReader;
    File file;
    ArrayList<CustomFile> fileList = new ArrayList<>();
    String[] InheritanceArray;
    CouplingMain couplMain = new CouplingMain();
    CustomFile csFile1, csFile2;
    ArrayList<String> resultsCp = new ArrayList<>();

    public Main() {
        initComponents();
        setSize(1500, 900);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        FileBrowseButton = new javax.swing.JButton();
        selectedFilePathField = new javax.swing.JLabel();
        fileNameField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FileTypeLabel = new javax.swing.JLabel();
        NumOfLines = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CodeViewer = new javax.swing.JTextArea();
        measureBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1202, 670));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Code Complexity Measuring Tool");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 34, 446, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select your source file");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 50));

        FileBrowseButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        FileBrowseButton.setText("UPLOAD");
        FileBrowseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FileBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileBrowseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(FileBrowseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 140, 41));

        selectedFilePathField.setFont(new java.awt.Font("Sitka Subheading", 0, 18)); // NOI18N
        selectedFilePathField.setForeground(new java.awt.Color(255, 255, 255));
        selectedFilePathField.setText("                                                  File Path");
        selectedFilePathField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(selectedFilePathField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 219, 570, 40));

        fileNameField.setFont(new java.awt.Font("Sitka Subheading", 0, 18)); // NOI18N
        fileNameField.setForeground(new java.awt.Color(255, 255, 255));
        fileNameField.setText("                                                 File Name");
        fileNameField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(fileNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 315, 570, 41));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Program Language : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 382, 190, 36));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Number of Lines :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        FileTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FileTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        FileTypeLabel.setText("--");
        jPanel1.add(FileTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        NumOfLines.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NumOfLines.setForeground(new java.awt.Color(255, 255, 255));
        NumOfLines.setText("--");
        jPanel1.add(NumOfLines, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, -1, -1));

        CodeViewer.setEditable(false);
        CodeViewer.setColumns(20);
        CodeViewer.setRows(5);
        CodeViewer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CodeViewer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(CodeViewer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 108, 504, 626));

        measureBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        measureBtn.setText("MEASURE");
        measureBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        measureBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        measureBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                measureBtnActionPerformed(evt);
            }
        });
        jPanel1.add(measureBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 128, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FileBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileBrowseButtonActionPerformed

        //Selecting the file from file explorer
        JFileChooser choose = new JFileChooser();
        File workingDir = new File(System.getProperty("user.dir"));
        choose.setCurrentDirectory((workingDir));
        choose.showOpenDialog(null);

        //Getting the absolute file path and file name to display
        file = choose.getSelectedFile();
        filepath = file.getAbsolutePath();
        String flname = file.getName();
        selectedFilePathField.setText((filepath));
        fileNameField.setText(flname);

        if (filepath.toLowerCase().endsWith(".java")) {
            FileTypeLabel.setText("Java");
        } else if (filepath.toLowerCase().endsWith(".cpp")) {
            FileTypeLabel.setText("C++");
        }

        //Viewing the code in the text area
        try {
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);
            CodeViewer.read(bufferedReader, null);
            //br.close();
            CodeViewer.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try {
            int lineCount;
            lineCount = fileAnalyzer.LineCounter(filepath);
            NumOfLines.setText(Integer.toString(lineCount));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        //Control Structure Complexity
        try {
            analyzerForm.getControlStructureConplexity(filepath);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_FileBrowseButtonActionPerformed

    //implement the measuring button
    private void measureBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_measureBtnActionPerformed

        //Adding the code to arraylist
        controller.setStrArr(CodeViewer.getText().split("\\n"));

        try {
            //Passing the code to Analyzeform Text Area
            analyzerForm.getCodeText(filepath);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Calculating the complexity
        analyzerForm.setVisible(true);

        //Calculating Code Complexity
        analyzerForm.getDetails(controller.CodeAnalyzer(controller.getStrArr()));

        //Calculating Size Complexity
        try {
            analyzerForm.getSizeComplexity(filepath);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        //Calculating Variable Complexity
        try {
            analyzerForm.getVariableComplexity(controller.getStrArr(), filepath);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //Calculating Method Complexity
            analyzerForm.getMethodComplexity(filepath);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Calculating Inheritance Complexity
        InheritanceArray = controller.getStrArr();
        InheritanceMeasure inheritanceMeasure = new InheritanceMeasure();
        try {
            analyzerForm.SetInheritance(inheritanceMeasure.InheritanceAnalyzer(InheritanceArray), filepath);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        //Coupling complexity
        String filename = file.getName();
        System.out.println(filename);
        csFile1 = new CustomFile(filename);
        csFile1.setFilePath(filepath);

        csFile2 = new CustomFile("Coupling.java");

        fileList.add(csFile1);

        couplMain.setFileList(fileList);
        couplMain.setFileType("java");
        couplMain.Start();

        resultsCp = couplMain.getCouplingResults();

        try {
            analyzerForm.setCouplingResult(resultsCp, filepath);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_measureBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CodeViewer;
    private javax.swing.JButton FileBrowseButton;
    private javax.swing.JLabel FileTypeLabel;
    private javax.swing.JLabel NumOfLines;
    private javax.swing.JLabel fileNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton measureBtn;
    private javax.swing.JLabel selectedFilePathField;
    // End of variables declaration//GEN-END:variables
}
