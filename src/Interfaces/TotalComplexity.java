package Interfaces;

public class TotalComplexity extends javax.swing.JFrame {

    int Cc = 0;
    int Kw = 0;
    int Cs = 0;
    int Cm = 0;
    int Cv = 0;
    int Ci = 0;
    int Ccs = 0;
    int Ccp = 0;
    long TCps = 0;

    public void SetValues(int prCc, int prKw, int prCs, int prCm, int prcv, int prci, int prCcs, int prCcp, long prTCps) {
        Cc = prCc;
        Kw = prKw;
        Cs = prCs;
        Cm = prCm;
        Cv = prcv;
        Ci = prci;
        Ccs = prCcs;
        Ccp = prCcp;
        TCps = prTCps;

        totcodecomplxity.setText(Integer.toString(Cc));

        totsize.setText(Integer.toString(Cs));
        totmethod.setText(Integer.toString(Cm));
        totveriable.setText(Integer.toString(Cv));
        totinheritance.setText(Integer.toString(Ci));
        totcontralstru.setText(Integer.toString(Ccs));
        totcoupling.setText(Integer.toString(Ccp));

        totalTCps.setText(Long.toString(TCps));
    }

    public TotalComplexity() {
        initComponents();
        setSize(1200, 700);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totcodecomplxity = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        totalTCps = new javax.swing.JLabel();
        totcoupling = new javax.swing.JLabel();
        totinheritance = new javax.swing.JLabel();
        totcontralstru = new javax.swing.JLabel();
        totveriable = new javax.swing.JLabel();
        totmethod = new javax.swing.JLabel();
        totsize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(1213, 556));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("MEASURING TOTAL COMPLEXITY OF A PROGRAM STATEMENT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        totcodecomplxity.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totcodecomplxity.setForeground(new java.awt.Color(255, 0, 0));
        totcodecomplxity.setText("--");
        jPanel1.add(totcodecomplxity, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CODE COMPLEXITY");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Size Complexity :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Method Complexity :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Variable Complexity :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Control Structure Complexity :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Inheritance Complexity :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Coupling Complexity :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, -1, -1));

        jLabel68.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Total complexity of a program statement");
        jPanel1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 630, -1));

        totalTCps.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totalTCps.setForeground(new java.awt.Color(255, 0, 0));
        totalTCps.setText("--");
        jPanel1.add(totalTCps, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, -1, -1));

        totcoupling.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totcoupling.setForeground(new java.awt.Color(255, 255, 255));
        totcoupling.setText("--");
        jPanel1.add(totcoupling, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 430, -1, -1));

        totinheritance.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totinheritance.setForeground(new java.awt.Color(255, 255, 255));
        totinheritance.setText("--");
        jPanel1.add(totinheritance, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 370, -1, -1));

        totcontralstru.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totcontralstru.setForeground(new java.awt.Color(255, 255, 255));
        totcontralstru.setText("--");
        jPanel1.add(totcontralstru, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 300, -1, -1));

        totveriable.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totveriable.setForeground(new java.awt.Color(255, 255, 255));
        totveriable.setText("--");
        jPanel1.add(totveriable, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        totmethod.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totmethod.setForeground(new java.awt.Color(255, 255, 255));
        totmethod.setText("--");
        jPanel1.add(totmethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        totsize.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        totsize.setForeground(new java.awt.Color(255, 255, 255));
        totsize.setText("--");
        jPanel1.add(totsize, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(TotalComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TotalComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TotalComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TotalComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TotalComplexity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel totalTCps;
    private javax.swing.JLabel totcodecomplxity;
    private javax.swing.JLabel totcontralstru;
    private javax.swing.JLabel totcoupling;
    private javax.swing.JLabel totinheritance;
    private javax.swing.JLabel totmethod;
    private javax.swing.JLabel totsize;
    private javax.swing.JLabel totveriable;
    // End of variables declaration//GEN-END:variables
}
