/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Analytics.ControlStructureMeasure;
import Analytics.MethodMeasure;
import Analytics.SizeMeasure;
import Analytics.VariableMeasure;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rashitha
 */
public class AnalyzerForm extends javax.swing.JFrame {

    SizeMeasure scm = new SizeMeasure();
    MethodMeasure mcm = new MethodMeasure();
    VariableMeasure vcm = new VariableMeasure();
    ControlStructureMeasure Ccm = new ControlStructureMeasure();
    
    ArrayList<String> SizeMeasureList = new ArrayList<>();
    ArrayList<String> MethodMeasureList = new ArrayList<>();
    ArrayList<String> VariableMeasureList = new ArrayList<>();
    ArrayList<String> ControlStructureMeasureList = new ArrayList<>();
    
    int Cs,Wkw,Nkw,Wid,Nid,Wop,Nop,Wnv,Nnv,Wsl,Nsl;
    int Cm,Wmrt,Wpdtp,Npdtp,Wcdtp,Ncdtp;
    int Cv,Wvs,Wpdtv,Npdtv,Wcdtv,Ncdtv;
    int Ccs,Wtcs,NC,Ccspps;
    
    public AnalyzerForm() {
        initComponents();
        setSize(1050,900);
    }

     public void getDetails(int value)
    {
        TotalComplexityLable.setText(Integer.toString(value));
    }
    
    public void getCodeText(String filepath) throws IOException
    {
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        sizeTextView.read(bufferedReader, null);
        sizeTextView.requestFocus();
    }
    
    public void getSizeComplexity(String filepath) throws Exception
    {
        //SizeLabel.setText(Integer.toString(scm.SizeComplexityInitializer(br)));
        SizeMeasureList = scm.SizeComplexityInitializer(filepath);
        
        Wkw = Integer.parseInt(SizeMeasureList.get(0));
        Nkw = Integer.parseInt(SizeMeasureList.get(1));
        Wid = Integer.parseInt(SizeMeasureList.get(2));
        Nid = Integer.parseInt(SizeMeasureList.get(3));
        Wop = Integer.parseInt(SizeMeasureList.get(4));
        Nop = Integer.parseInt(SizeMeasureList.get(5));
        Wnv = Integer.parseInt(SizeMeasureList.get(6));
        Nnv = Integer.parseInt(SizeMeasureList.get(7));
        Wsl = Integer.parseInt(SizeMeasureList.get(8));
        Nsl = Integer.parseInt(SizeMeasureList.get(9));
        
        wkw.setText(Integer.toString(Wkw));
        nkw.setText(Integer.toString(Nkw));
        wid.setText(Integer.toString(Wid));
        nid.setText(Integer.toString(Nid));
        wop.setText(Integer.toString(Wop));
        nop.setText(Integer.toString(Nop));
        wnv.setText(Integer.toString(Wnv));
        nnv.setText(Integer.toString(Nnv));
        wsl.setText(Integer.toString(Wsl));
        nsl.setText(Integer.toString(Nsl));
        
        Cs=(Wkw*Nkw)+(Wid*Nid)+(Wop*Nop)+(Wnv*Nnv)+(Wsl*Nsl);
        cs.setText(Integer.toString(Cs));
    }
    
     public void getVariableComplexity(String [] str, String filepath) throws FileNotFoundException, IOException
    {
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        variableTextView.read(bufferedReader, null);
        variableTextView.requestFocus();
        
        VariableMeasureList = vcm.VariableComplexityInitializer(str);
        
        Wvs = Integer.parseInt(VariableMeasureList.get(0));
        Wpdtv = Integer.parseInt(VariableMeasureList.get(1));
        Npdtv = Integer.parseInt(VariableMeasureList.get(2));
        Wcdtv = Integer.parseInt(VariableMeasureList.get(3));
        Ncdtv = Integer.parseInt(VariableMeasureList.get(4));
        
        wvs.setText(Integer.toString(Wvs));
        wpdtv.setText(Integer.toString(Wpdtv));
        npdtv.setText(Integer.toString(Npdtv));
        wcdtv.setText(Integer.toString(Wcdtv));
        ncdtv.setText(Integer.toString(Ncdtv));
        
        Cv = Wvs * ((Wpdtv * Npdtv) + (Wcdtv * Ncdtv));
        cv.setText(Integer.toString(Cv));
    }
  
    public void getMethodComplexity(String filepath) throws FileNotFoundException, IOException
    {
        MethodMeasureList = mcm.MethodComplexityInitializer(filepath);
        
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        methodTextView.read(br, null);
        methodTextView.requestFocus();
        
        Wmrt = Integer.parseInt(MethodMeasureList.get(0));
        Wpdtp = Integer.parseInt(MethodMeasureList.get(1));
        Npdtp = Integer.parseInt(MethodMeasureList.get(2));
        Wcdtp = Integer.parseInt(MethodMeasureList.get(3));
        Ncdtp = Integer.parseInt(MethodMeasureList.get(4));
        
        wmrt.setText(Integer.toString(Wmrt));
        wpdtp.setText(Integer.toString(Wpdtp));
        npdtp.setText(Integer.toString(Npdtp));
        wcdtp.setText(Integer.toString(Wcdtp));
        ncdtp.setText(Integer.toString(Ncdtp));
        
        Cm = Wmrt + (Wpdtp * Npdtp) + (Wcdtp * Ncdtp);
        cm.setText(Integer.toString(Cm));
        
    }
    
    public void getControlStructureConplexity(String filepath) throws FileNotFoundException, IOException
    {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        CcSVariableView.read(br, null);
        CcSVariableView.requestFocus();
        
        ControlStructureMeasureList = Ccm.ControlComplexityInitializer(filepath);
        
        Wtcs = Integer.parseInt(ControlStructureMeasureList.get(0));
        NC = Integer.parseInt(ControlStructureMeasureList.get(1));
        Ccspps = Integer.parseInt(ControlStructureMeasureList.get(2));
        
        wtcs.setText(Integer.toString(Wtcs));
        nc.setText(Integer.toString(NC));
        ccspps.setText(Integer.toString(Ccspps));
        
        Ccs = (Wtcs * NC) + Ccspps;
        ccs.setText(Integer.toString(Ccs));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sizeTextView = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        wkw = new javax.swing.JLabel();
        nkw = new javax.swing.JLabel();
        nid = new javax.swing.JLabel();
        wid = new javax.swing.JLabel();
        wop = new javax.swing.JLabel();
        nop = new javax.swing.JLabel();
        wnv = new javax.swing.JLabel();
        nnv = new javax.swing.JLabel();
        wsl = new javax.swing.JLabel();
        nsl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cs = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        variableTextView = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        wvs = new javax.swing.JLabel();
        wpdtv = new javax.swing.JLabel();
        wcdtv = new javax.swing.JLabel();
        npdtv = new javax.swing.JLabel();
        ncdtv = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cv = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        methodTextView = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        wmrt = new javax.swing.JLabel();
        wpdtp = new javax.swing.JLabel();
        wcdtp = new javax.swing.JLabel();
        npdtp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cm = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        ncdtp = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        sizeTextView4 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        directIn = new javax.swing.JLabel();
        indirectIn = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        ci = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        totalIn = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        CcSVariableView = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        wtcs = new javax.swing.JLabel();
        nc = new javax.swing.JLabel();
        ccspps = new javax.swing.JLabel();
        nsl4 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        ccs = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TotalComplexityLable = new javax.swing.JLabel();

        jLabel20.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel20.setText("--");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(377, 400));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sizeTextView.setEditable(false);
        sizeTextView.setColumns(20);
        sizeTextView.setRows(5);
        jScrollPane2.setViewportView(sizeTextView);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setPreferredSize(new java.awt.Dimension(377, 400));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel5.setText("Wkw");

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel6.setText("Nid");

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel7.setText("Nkw");

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel8.setText("Wid");

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel9.setText("Wop");

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel10.setText("Nop");

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel11.setText("Nnv");

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel12.setText("Wnv");

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel13.setText("Nsl");

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel14.setText("Wsl");

        wkw.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wkw.setText("--");

        nkw.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nkw.setText("--");

        nid.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nid.setText("--");

        wid.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wid.setText("--");

        wop.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wop.setText("--");

        nop.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nop.setText("--");

        wnv.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wnv.setText("--");

        nnv.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nnv.setText("--");

        wsl.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wsl.setText("--");

        nsl.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nsl.setText("--");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel2.setText("CS");

        cs.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        cs.setText("--");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nnv, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nop, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wid, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wop, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wkw, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nid, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wnv, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nkw, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wsl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nsl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cs, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(wkw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nkw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(wid))
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(wop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(wnv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nnv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(wsl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nsl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cs))
                .addGap(39, 39, 39))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 400));

        jTabbedPane1.addTab("Size", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        variableTextView.setEditable(false);
        variableTextView.setColumns(20);
        variableTextView.setRows(5);
        jScrollPane6.setViewportView(variableTextView);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel15.setText("Wvs");

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel16.setText("Wcdtv");

        jLabel17.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel17.setText("Wpdtv");

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel18.setText("Npdtv");

        jLabel19.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel19.setText("Ncdtv");

        wvs.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wvs.setText("--");

        wpdtv.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wpdtv.setText("--");

        wcdtv.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wcdtv.setText("--");

        npdtv.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        npdtv.setText("--");

        ncdtv.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        ncdtv.setText("--");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel3.setText("CV");

        cv.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        cv.setText("--");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cv, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(npdtv, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ncdtv, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wvs, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wcdtv, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wpdtv, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(wvs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(wpdtv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(npdtv))
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(wcdtv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(ncdtv))
                .addGap(49, 49, 49)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cv))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 400));

        jTabbedPane1.addTab("Variable", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        methodTextView.setEditable(false);
        methodTextView.setColumns(20);
        methodTextView.setRows(5);
        jScrollPane7.setViewportView(methodTextView);

        jPanel4.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel26.setText("Wmrt");

        jLabel27.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel27.setText("Wcdtp");

        jLabel28.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel28.setText("Wpdtp");

        jLabel29.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel29.setText("Npdtp");

        wmrt.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wmrt.setText("--");

        wpdtp.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wpdtp.setText("--");

        wcdtp.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wcdtp.setText("--");

        npdtp.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        npdtp.setText("--");

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel4.setText("CM");

        cm.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        cm.setText("--");

        jLabel30.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel30.setText("Ncdtp");

        ncdtp.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        ncdtp.setText("--");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ncdtp, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(npdtp, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wmrt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wcdtp, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wpdtp, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(cm, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(wmrt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(wpdtp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(npdtp))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(wcdtp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(ncdtp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cm))
                .addGap(39, 39, 39))
        );

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 413));

        jTabbedPane1.addTab("Method", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sizeTextView4.setEditable(false);
        sizeTextView4.setColumns(20);
        sizeTextView4.setRows(5);
        jScrollPane8.setViewportView(sizeTextView4);

        jPanel5.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel36.setText("No of direct");

        jLabel39.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel39.setText("No of indirect  ");

        jLabel40.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel40.setText("Total inheritances ");

        directIn.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        directIn.setText("--");

        indirectIn.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        indirectIn.setText("--");

        jLabel46.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel46.setText("CI");

        ci.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        ci.setText("--");

        jLabel58.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel58.setText("inheritances");

        jLabel59.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel59.setText("inheritances");

        totalIn.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        totalIn.setText("--");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(indirectIn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(ci, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalIn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directIn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(directIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59)
                .addGap(33, 33, 33)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(indirectIn)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(totalIn))
                .addGap(93, 93, 93)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(ci))
                .addGap(39, 39, 39))
        );

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 413));

        jTabbedPane1.addTab("Inheritance", jPanel5);
        jTabbedPane1.addTab("Coupling", jTabbedPane2);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CcSVariableView.setEditable(false);
        CcSVariableView.setColumns(20);
        CcSVariableView.setRows(5);
        jScrollPane9.setViewportView(CcSVariableView);

        jPanel6.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel47.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel47.setText("Wtcs");

        jLabel49.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel49.setText("Nc");

        jLabel50.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel50.setText("Ccspps");

        wtcs.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        wtcs.setText("--");

        nc.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nc.setText("--");

        ccspps.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        ccspps.setText("--");

        nsl4.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nsl4.setText("--");

        jLabel57.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel57.setText("CCS");

        ccs.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        ccs.setText("--");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccspps, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wtcs, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nc, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(ccs, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(nsl4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(wtcs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(nc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(ccspps))
                .addGap(171, 171, 171)
                .addComponent(nsl4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(ccs))
                .addGap(39, 39, 39))
        );

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 413));

        jTabbedPane1.addTab("Control Structure", jPanel6);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel1.setText("TOTAL COMPLEXITY :");

        TotalComplexityLable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalComplexityLable.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TotalComplexityLable)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalComplexityLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalyzerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CcSVariableView;
    private javax.swing.JLabel TotalComplexityLable;
    private javax.swing.JLabel ccs;
    private javax.swing.JLabel ccspps;
    private javax.swing.JLabel ci;
    private javax.swing.JLabel cm;
    private javax.swing.JLabel cs;
    private javax.swing.JLabel cv;
    private javax.swing.JLabel directIn;
    private javax.swing.JLabel indirectIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea methodTextView;
    private javax.swing.JLabel nc;
    private javax.swing.JLabel ncdtp;
    private javax.swing.JLabel ncdtv;
    private javax.swing.JLabel nid;
    private javax.swing.JLabel nkw;
    private javax.swing.JLabel nnv;
    private javax.swing.JLabel nop;
    private javax.swing.JLabel npdtp;
    private javax.swing.JLabel npdtv;
    private javax.swing.JLabel nsl;
    private javax.swing.JLabel nsl4;
    private javax.swing.JTextArea sizeTextView;
    private javax.swing.JTextArea sizeTextView4;
    private javax.swing.JLabel totalIn;
    private javax.swing.JTextArea variableTextView;
    private javax.swing.JLabel wcdtp;
    private javax.swing.JLabel wcdtv;
    private javax.swing.JLabel wid;
    private javax.swing.JLabel wkw;
    private javax.swing.JLabel wmrt;
    private javax.swing.JLabel wnv;
    private javax.swing.JLabel wop;
    private javax.swing.JLabel wpdtp;
    private javax.swing.JLabel wpdtv;
    private javax.swing.JLabel wsl;
    private javax.swing.JLabel wtcs;
    private javax.swing.JLabel wvs;
    // End of variables declaration//GEN-END:variables
}
