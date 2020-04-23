/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Analytics.ControlStructureMeasure;
import Analytics.InheritanceMeasure;
import Analytics.MethodMeasure;
import Analytics.SizeMeasure;
import Analytics.VariableMeasure;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class AnalyzerForm extends javax.swing.JFrame {

    SizeMeasure scm = new SizeMeasure();
    MethodMeasure mcm = new MethodMeasure();
    VariableMeasure vcm = new VariableMeasure();
    InheritanceMeasure icm = new InheritanceMeasure();
    ControlStructureMeasure Ccm = new ControlStructureMeasure();
    
    ArrayList<String> SizeMeasureList = new ArrayList<>();
    ArrayList<String> MethodMeasureList = new ArrayList<>();
    ArrayList<String> VariableMeasureList = new ArrayList<>();
    ArrayList<String> InheritanceMeasureList = new ArrayList<>();
    ArrayList<String> ControlStructureMeasureList = new ArrayList<>();
    
    int Cs,Wkw,Nkw,Wid,Nid,Wop,Nop,Wnv,Nnv,Wsl,Nsl;
    int Cm,Wmrt,Wpdtp,Npdtp,Wcdtp,Ncdtp;
    int Cv,Wvs,Wpdtv,Npdtv,Wcdtv,Ncdtv;
    int Ccs,Wtcs,NC,Ccspps;
    int Ci;
    int Ccp,Wr,Nr,Wmcms,Nmcms,Wmcmd,Nmcmd,Wmcrms,Nmcrms,Wmcrmd,Nmcrmd,Wrmcrms,Nrmcrms,Wrmcrmd,Nrmcrmd,Wrmcms,
            Nrmcms,Wrmcmd,Nrmcmd,Wmrgvs,Nmrgvs,Wmrgvd,Nmrgvd,Wrmrgvs,Nrmrgvs,Wrmrgvd,Nrmrgvd;
    
    public AnalyzerForm() {
        initComponents();
         setSize(1200,700);
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
    
//     Send calculated size values to the design    
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
    
   
//     Send calculated variable values to the design    
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
  
//     Send calculated method values to the design
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
    
//     Send calculated control structure values to the design
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
    
//     Send calculated inheritance values to the design
     public void SetInheritance(int value , String filepath) throws FileNotFoundException, IOException
   {
       FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        inheritanceTextArea.read(br, null);
        inheritanceTextArea.requestFocus();
        
       Ci = value;
       directIn.setText(Integer.toString(value));
       indirectIn.setText(Integer.toString(Ci));
       
       totalIn.setText((Integer.toString(Ci)));
       ci.setText(Integer.toString(Ci));
   }
     
//     Send calculated coupling values to the design
     public void setCouplingResult(ArrayList<String> rst, String filepath) throws FileNotFoundException, IOException
     {
         FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        couplingtextarea.read(bufferedReader, null);
        couplingtextarea.requestFocus();
        
         Wr = Integer.parseInt(rst.get(0));
            Nr = Integer.parseInt(rst.get(1));
            Wmcms = Integer.parseInt(rst.get(2));
            Nmcms = Integer.parseInt(rst.get(3));
            Wmcmd = Integer.parseInt(rst.get(4));
            Nmcmd = Integer.parseInt(rst.get(5));
            Wmcrms = Integer.parseInt(rst.get(6));
            Nmcrms = Integer.parseInt(rst.get(7));
            Wmcrmd = Integer.parseInt(rst.get(8));
            Nmcrmd = Integer.parseInt(rst.get(9));
            Wrmcrms = Integer.parseInt(rst.get(10));
            Nrmcrms = Integer.parseInt(rst.get(11));
            Wrmcrmd = Integer.parseInt(rst.get(12));
            Nrmcrmd = Integer.parseInt(rst.get(13));
            Wrmcms = Integer.parseInt(rst.get(14));
            Nrmcms = Integer.parseInt(rst.get(15));
            Wrmcmd = Integer.parseInt(rst.get(16));
            Nrmcmd = Integer.parseInt(rst.get(17));
            Wmrgvs = Integer.parseInt(rst.get(18));
            Nmrgvs = Integer.parseInt(rst.get(19));
            Wmrgvd = Integer.parseInt(rst.get(20));
            Nmrgvd = Integer.parseInt(rst.get(21));
            Wrmrgvs = Integer.parseInt(rst.get(22));
            Nrmrgvs = Integer.parseInt(rst.get(23));
            Wrmrgvd = Integer.parseInt(rst.get(24));
            Nrmrgvd = Integer.parseInt(rst.get(25));
            
            wr.setText(Integer.toString(Wr));
            nr.setText(Integer.toString(Nr));
            wmcms.setText(Integer.toString(Wmcms));
            nmcms.setText(Integer.toString(Nmcms));
            wmcmd.setText(Integer.toString(Wmcmd));
            nmcmd.setText(Integer.toString(Nmcmd));
            wmcrms.setText(Integer.toString(Wmcrms));
            nmcrms.setText(Integer.toString(Nmcrms));
            wmcrmd.setText(Integer.toString(Wmcrmd));
            nmcrmd.setText(Integer.toString(Nmcrmd));
            wrmcrms.setText(Integer.toString(Wrmcrms));
            nrmcrms.setText(Integer.toString(Nrmcrms));
            wrmcrmd.setText(Integer.toString(Wrmcrmd));
            nrmcrmd.setText(Integer.toString(Nrmcrmd));
            wrmcms.setText(Integer.toString(Wrmcms));
            nrmcms.setText(Integer.toString(Nrmcms));
            wrmcmd.setText(Integer.toString(Wrmcmd));
            nrmcmd.setText(Integer.toString(Nrmcmd));
            wmrgvs.setText(Integer.toString(Wmrgvs));
            nmrgvs.setText(Integer.toString(Nmrgvs));
            wmrgvd.setText(Integer.toString(Wmrgvd));
            nmrgvd.setText(Integer.toString(Nmrgvd));
            wrmrgvs.setText(Integer.toString(Wrmrgvs));
            nrmrgvs.setText(Integer.toString(Nrmrgvs));
            wrmrgvd.setText(Integer.toString(Wrmrgvd));
            nrmrgvd.setText(Integer.toString(Nrmrgvd));
            
            Ccp = (Wr * Nr) + (Wmcms * Nmcms) + (Wmcmd * Nmcmd) + (Wmcrms * Nmcrms) + (Wmcrmd * Nmcrmd) + 
                    (Wrmcrms * Nrmcrms) + (Wrmcrmd *Nrmcrmd) + (Wrmcms * Nrmcms) + (Wrmcmd * Nrmcmd) +  
                    (Wmrgvs *Nmrgvs) + (Wmrgvd * Nmrgvd) + (Wrmrgvs * Nrmrgvs) + (Wrmrgvd * Nrmrgvd);
            
            ccp.setText(Integer.toString(Ccp));
     }

   
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
        inheritanceTextArea = new javax.swing.JTextArea();
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
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        couplingtextarea = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        nr = new javax.swing.JLabel();
        nmcms = new javax.swing.JLabel();
        nmcrms = new javax.swing.JLabel();
        nmcmd = new javax.swing.JLabel();
        nmcrmd = new javax.swing.JLabel();
        nrmcrmd = new javax.swing.JLabel();
        nrmcms = new javax.swing.JLabel();
        nrmcmd = new javax.swing.JLabel();
        nmrgvs = new javax.swing.JLabel();
        nmrgvd = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        ccp = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        nrmcrms = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        nrmrgvs = new javax.swing.JLabel();
        nrmrgvd = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        wrmrgvd = new javax.swing.JLabel();
        wrmrgvs = new javax.swing.JLabel();
        wmrgvd = new javax.swing.JLabel();
        wmrgvs = new javax.swing.JLabel();
        wrmcmd = new javax.swing.JLabel();
        wrmcms = new javax.swing.JLabel();
        wrmcrmd = new javax.swing.JLabel();
        wrmcrms = new javax.swing.JLabel();
        wmcrmd = new javax.swing.JLabel();
        wmcrms = new javax.swing.JLabel();
        wmcmd = new javax.swing.JLabel();
        wmcms = new javax.swing.JLabel();
        wr = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(377, 400));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sizeTextView.setEditable(false);
        sizeTextView.setColumns(20);
        sizeTextView.setRows(5);
        jScrollPane2.setViewportView(sizeTextView);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setPreferredSize(new java.awt.Dimension(377, 400));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Wkw");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nid");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nkw");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Wid");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Wop");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nop");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nnv");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Wnv");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nsl");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Wsl");

        wkw.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wkw.setForeground(new java.awt.Color(240, 240, 240));
        wkw.setText("--");

        nkw.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nkw.setForeground(new java.awt.Color(240, 240, 240));
        nkw.setText("--");

        nid.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nid.setForeground(new java.awt.Color(255, 255, 255));
        nid.setText("--");

        wid.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wid.setForeground(new java.awt.Color(240, 240, 240));
        wid.setText("--");

        wop.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wop.setForeground(new java.awt.Color(240, 240, 240));
        wop.setText("--");

        nop.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nop.setForeground(new java.awt.Color(240, 240, 240));
        nop.setText("--");

        wnv.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wnv.setForeground(new java.awt.Color(240, 240, 240));
        wnv.setText("--");

        nnv.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nnv.setForeground(new java.awt.Color(255, 255, 255));
        nnv.setText("--");

        wsl.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wsl.setForeground(new java.awt.Color(240, 240, 240));
        wsl.setText("--");

        nsl.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nsl.setForeground(new java.awt.Color(240, 240, 240));
        nsl.setText("--");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CS");

        cs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cs.setForeground(new java.awt.Color(255, 255, 255));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cs))
                .addGap(39, 39, 39))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 400));

        jTabbedPane1.addTab("Size", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        variableTextView.setEditable(false);
        variableTextView.setColumns(20);
        variableTextView.setRows(5);
        jScrollPane6.setViewportView(variableTextView);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Wvs");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Wcdtv");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Wpdtv");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Npdtv");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ncdtv");

        wvs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wvs.setForeground(java.awt.Color.white);
        wvs.setText("--");

        wpdtv.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wpdtv.setForeground(java.awt.Color.white);
        wpdtv.setText("--");

        wcdtv.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wcdtv.setForeground(new java.awt.Color(255, 255, 255));
        wcdtv.setText("--");

        npdtv.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        npdtv.setForeground(java.awt.Color.white);
        npdtv.setText("--");

        ncdtv.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ncdtv.setForeground(new java.awt.Color(255, 255, 255));
        ncdtv.setText("--");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CV");

        cv.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cv.setForeground(new java.awt.Color(240, 240, 240));
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
                        .addComponent(cv, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 400));

        jTabbedPane1.addTab("Variable", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        methodTextView.setEditable(false);
        methodTextView.setColumns(20);
        methodTextView.setRows(5);
        jScrollPane7.setViewportView(methodTextView);

        jPanel4.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(240, 240, 240));
        jLabel26.setText("Wmrt");

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(240, 240, 240));
        jLabel27.setText("Wcdtp");

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText("Wpdtp");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(240, 240, 240));
        jLabel29.setText("Npdtp");

        wmrt.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wmrt.setForeground(new java.awt.Color(240, 240, 240));
        wmrt.setText("--");

        wpdtp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wpdtp.setForeground(new java.awt.Color(240, 240, 240));
        wpdtp.setText("--");

        wcdtp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wcdtp.setForeground(new java.awt.Color(240, 240, 240));
        wcdtp.setText("--");

        npdtp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        npdtp.setForeground(new java.awt.Color(240, 240, 240));
        npdtp.setText("--");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("CM");

        cm.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cm.setForeground(new java.awt.Color(240, 240, 240));
        cm.setText("--");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(240, 240, 240));
        jLabel30.setText("Ncdtp");

        ncdtp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ncdtp.setForeground(new java.awt.Color(240, 240, 240));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cm))
                .addGap(39, 39, 39))
        );

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 413));

        jTabbedPane1.addTab("Method", jPanel4);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inheritanceTextArea.setEditable(false);
        inheritanceTextArea.setColumns(20);
        inheritanceTextArea.setRows(5);
        jScrollPane8.setViewportView(inheritanceTextArea);

        jPanel5.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("No of direct");

        jLabel39.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("No of indirect  ");

        jLabel40.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Total inheritances ");

        directIn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        directIn.setForeground(new java.awt.Color(255, 255, 255));
        directIn.setText("--");

        indirectIn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        indirectIn.setForeground(new java.awt.Color(255, 255, 255));
        indirectIn.setText("--");

        jLabel46.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("CI");

        ci.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ci.setForeground(new java.awt.Color(255, 255, 255));
        ci.setText("--");

        jLabel58.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("inheritances");

        jLabel59.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("inheritances");

        totalIn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        totalIn.setForeground(new java.awt.Color(255, 255, 255));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
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

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        couplingtextarea.setEditable(false);
        couplingtextarea.setColumns(20);
        couplingtextarea.setRows(5);
        jScrollPane3.setViewportView(couplingtextarea);

        jPanel13.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setPreferredSize(new java.awt.Dimension(377, 400));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("Nr");

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(240, 240, 240));
        jLabel22.setText("Nmcrms");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("Nmcms");

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(240, 240, 240));
        jLabel24.setText("Nmcmd");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(240, 240, 240));
        jLabel25.setText("Nmcrmd");

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(240, 240, 240));
        jLabel31.setText("Nrmcrmd");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(240, 240, 240));
        jLabel32.setText("Nrmcmd");

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("Nrmcms");

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Nmrgvd");

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Nmrgvs");

        nr.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nr.setForeground(new java.awt.Color(240, 240, 240));
        nr.setText("--");

        nmcms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nmcms.setForeground(new java.awt.Color(240, 240, 240));
        nmcms.setText("--");

        nmcrms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nmcrms.setForeground(new java.awt.Color(240, 240, 240));
        nmcrms.setText("--");

        nmcmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nmcmd.setForeground(new java.awt.Color(240, 240, 240));
        nmcmd.setText("--");

        nmcrmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nmcrmd.setForeground(new java.awt.Color(240, 240, 240));
        nmcrmd.setText("--");

        nrmcrmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nrmcrmd.setForeground(new java.awt.Color(240, 240, 240));
        nrmcrmd.setText("--");

        nrmcms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nrmcms.setForeground(new java.awt.Color(240, 240, 240));
        nrmcms.setText("--");

        nrmcmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nrmcmd.setForeground(new java.awt.Color(240, 240, 240));
        nrmcmd.setText("--");

        nmrgvs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nmrgvs.setForeground(new java.awt.Color(240, 240, 240));
        nmrgvs.setText("--");

        nmrgvd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nmrgvd.setForeground(new java.awt.Color(240, 240, 240));
        nmrgvd.setText("--");

        jLabel37.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(240, 240, 240));
        jLabel37.setText("CCP");

        ccp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ccp.setForeground(new java.awt.Color(240, 240, 240));
        ccp.setText("--");

        jLabel38.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(240, 240, 240));
        jLabel38.setText("Nrmcrms");

        nrmcrms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nrmcrms.setForeground(new java.awt.Color(240, 240, 240));
        nrmcrms.setText("--");

        jLabel41.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(240, 240, 240));
        jLabel41.setText("Nrmrgvs");

        jLabel42.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(240, 240, 240));
        jLabel42.setText("Nrmrgvd");

        nrmrgvs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nrmrgvs.setForeground(new java.awt.Color(240, 240, 240));
        nrmrgvs.setText("--");

        nrmrgvd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nrmrgvd.setForeground(new java.awt.Color(240, 240, 240));
        nrmrgvd.setText("--");

        jLabel43.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(240, 240, 240));
        jLabel43.setText("Wr");

        jLabel44.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(240, 240, 240));
        jLabel44.setText("Wmcms");

        jLabel45.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(240, 240, 240));
        jLabel45.setText("Wmcmd");

        jLabel48.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(240, 240, 240));
        jLabel48.setText("Wmcrms");

        jLabel51.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(240, 240, 240));
        jLabel51.setText("Wmcrmd");

        jLabel52.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(240, 240, 240));
        jLabel52.setText("Wrmcrms");

        jLabel53.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(240, 240, 240));
        jLabel53.setText("Wrmcrmd");

        jLabel54.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(240, 240, 240));
        jLabel54.setText("Wrmcms");

        jLabel55.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(240, 240, 240));
        jLabel55.setText("Wrmcmd");

        jLabel56.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(240, 240, 240));
        jLabel56.setText("Wmrgvs");

        jLabel60.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(240, 240, 240));
        jLabel60.setText("Wmrgvd");

        jLabel61.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(240, 240, 240));
        jLabel61.setText("Wrmrgvs");

        jLabel62.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(240, 240, 240));
        jLabel62.setText("Wrmrgvd");

        wrmrgvd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wrmrgvd.setForeground(new java.awt.Color(240, 240, 240));
        wrmrgvd.setText("--");

        wrmrgvs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wrmrgvs.setForeground(new java.awt.Color(240, 240, 240));
        wrmrgvs.setText("--");

        wmrgvd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wmrgvd.setForeground(new java.awt.Color(240, 240, 240));
        wmrgvd.setText("--");

        wmrgvs.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wmrgvs.setForeground(new java.awt.Color(240, 240, 240));
        wmrgvs.setText("--");

        wrmcmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wrmcmd.setForeground(new java.awt.Color(240, 240, 240));
        wrmcmd.setText("--");

        wrmcms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wrmcms.setForeground(new java.awt.Color(240, 240, 240));
        wrmcms.setText("--");

        wrmcrmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wrmcrmd.setForeground(new java.awt.Color(240, 240, 240));
        wrmcrmd.setText("--");

        wrmcrms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wrmcrms.setForeground(new java.awt.Color(240, 240, 240));
        wrmcrms.setText("--");

        wmcrmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wmcrmd.setForeground(new java.awt.Color(240, 240, 240));
        wmcrmd.setText("--");

        wmcrms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wmcrms.setForeground(new java.awt.Color(240, 240, 240));
        wmcrms.setText("--");

        wmcmd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wmcmd.setForeground(new java.awt.Color(240, 240, 240));
        wmcmd.setText("--");

        wmcms.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wmcms.setForeground(new java.awt.Color(240, 240, 240));
        wmcms.setText("--");

        wr.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        wr.setForeground(new java.awt.Color(240, 240, 240));
        wr.setText("--");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ccp, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel51)
                            .addComponent(jLabel56)
                            .addComponent(jLabel60)
                            .addComponent(jLabel45)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(wmrgvs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(wrmcmd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wrmcms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wrmcrmd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wrmcrms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wmcrmd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wmcrms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wmcmd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wmrgvd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wrmrgvd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wrmrgvs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(wr, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(wmcms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nrmrgvd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nrmrgvs, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25)
                            .addComponent(jLabel38)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nmcrmd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nmrgvd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(nmrgvs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nrmcmd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nrmcms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nrmcrmd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nrmcrms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nmcrms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nmcmd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nmcms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nr, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(nr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(nmcms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(nmcmd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(nmcrms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(nmcrmd))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(nrmcrms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(nrmcrmd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(nrmcms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(nrmcmd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(nmrgvs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nmrgvd)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nrmrgvs, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(nrmrgvd)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(wr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(wmcms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(wmcmd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(wmcrms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(wmcrmd))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(wrmcrms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(wrmcrmd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(wrmcms))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(wrmcmd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(wmrgvs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wmrgvd)
                            .addComponent(jLabel60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(wrmrgvs)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(wrmrgvd))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(ccp))
                .addContainerGap())
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 400));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Coupling", jPanel12);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CcSVariableView.setEditable(false);
        CcSVariableView.setColumns(20);
        CcSVariableView.setRows(5);
        jScrollPane9.setViewportView(CcSVariableView);

        jPanel6.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 470, 413));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        jLabel47.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(240, 240, 240));
        jLabel47.setText("Wtcs");

        jLabel49.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(240, 240, 240));
        jLabel49.setText("Nc");

        jLabel50.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(240, 240, 240));
        jLabel50.setText("Ccspps");

        wtcs.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        wtcs.setForeground(new java.awt.Color(240, 240, 240));
        wtcs.setText("--");

        nc.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        nc.setForeground(new java.awt.Color(240, 240, 240));
        nc.setText("--");

        ccspps.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ccspps.setForeground(new java.awt.Color(240, 240, 240));
        ccspps.setText("--");

        nsl4.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        nsl4.setText("--");

        jLabel57.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(240, 240, 240));
        jLabel57.setText("CCS");

        ccs.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ccs.setForeground(new java.awt.Color(240, 240, 240));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(ccs))
                .addGap(39, 39, 39))
        );

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 299, 413));

        jTabbedPane1.addTab("Control Structure", jPanel6);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("CODE COMPLEXITY :");

        TotalComplexityLable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalComplexityLable.setForeground(new java.awt.Color(240, 240, 240));
        TotalComplexityLable.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalComplexityLable)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
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
                .addContainerGap())
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
    private javax.swing.JLabel ccp;
    private javax.swing.JLabel ccs;
    private javax.swing.JLabel ccspps;
    private javax.swing.JLabel ci;
    private javax.swing.JLabel cm;
    private javax.swing.JTextArea couplingtextarea;
    private javax.swing.JLabel cs;
    private javax.swing.JLabel cv;
    private javax.swing.JLabel directIn;
    private javax.swing.JLabel indirectIn;
    private javax.swing.JTextArea inheritanceTextArea;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea methodTextView;
    private javax.swing.JLabel nc;
    private javax.swing.JLabel ncdtp;
    private javax.swing.JLabel ncdtv;
    private javax.swing.JLabel nid;
    private javax.swing.JLabel nkw;
    private javax.swing.JLabel nmcmd;
    private javax.swing.JLabel nmcms;
    private javax.swing.JLabel nmcrmd;
    private javax.swing.JLabel nmcrms;
    private javax.swing.JLabel nmrgvd;
    private javax.swing.JLabel nmrgvs;
    private javax.swing.JLabel nnv;
    private javax.swing.JLabel nop;
    private javax.swing.JLabel npdtp;
    private javax.swing.JLabel npdtv;
    private javax.swing.JLabel nr;
    private javax.swing.JLabel nrmcmd;
    private javax.swing.JLabel nrmcms;
    private javax.swing.JLabel nrmcrmd;
    private javax.swing.JLabel nrmcrms;
    private javax.swing.JLabel nrmrgvd;
    private javax.swing.JLabel nrmrgvs;
    private javax.swing.JLabel nsl;
    private javax.swing.JLabel nsl4;
    private javax.swing.JTextArea sizeTextView;
    private javax.swing.JLabel totalIn;
    private javax.swing.JTextArea variableTextView;
    private javax.swing.JLabel wcdtp;
    private javax.swing.JLabel wcdtv;
    private javax.swing.JLabel wid;
    private javax.swing.JLabel wkw;
    private javax.swing.JLabel wmcmd;
    private javax.swing.JLabel wmcms;
    private javax.swing.JLabel wmcrmd;
    private javax.swing.JLabel wmcrms;
    private javax.swing.JLabel wmrgvd;
    private javax.swing.JLabel wmrgvs;
    private javax.swing.JLabel wmrt;
    private javax.swing.JLabel wnv;
    private javax.swing.JLabel wop;
    private javax.swing.JLabel wpdtp;
    private javax.swing.JLabel wpdtv;
    private javax.swing.JLabel wr;
    private javax.swing.JLabel wrmcmd;
    private javax.swing.JLabel wrmcms;
    private javax.swing.JLabel wrmcrmd;
    private javax.swing.JLabel wrmcrms;
    private javax.swing.JLabel wrmrgvd;
    private javax.swing.JLabel wrmrgvs;
    private javax.swing.JLabel wsl;
    private javax.swing.JLabel wtcs;
    private javax.swing.JLabel wvs;
    // End of variables declaration//GEN-END:variables
}
