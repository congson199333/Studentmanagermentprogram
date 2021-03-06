/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Design;
import Design.DangNhapUI;
import Class.DKHP;
import Class.KQHT;
import Service.DangKyHocPhanService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hcshl
 */
public class DangKyHocPhan extends javax.swing.JFrame {

       int dem=0;
       Connection conn;
       DKHP dkhp;
       ArrayList<DKHP> arrdkhp ;
       DangKyHocPhanService dkService ;
    public void ketNoiOracle(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String strConn = "jdbc:oracle:thin:@localhost:1521/orcl";
            conn=DriverManager.getConnection(strConn, "HCS", "son123");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /**
     * Creates new form DangKyHocPhan
     */
    public DangKyHocPhan() {
        initComponents();
        ketNoiOracle();
        hienThiDSDKHP();
        
    }
    public void hienThiDSDKHP(){
        dem=0;
        DefaultTableModel model = (DefaultTableModel)tbDKHP.getModel();
        arrdkhp=new ArrayList<DKHP>();
        dkService=new DangKyHocPhanService();
        arrdkhp=dkService.LayDSDKHP();
        for(DKHP a: arrdkhp)
        {
            Vector<Object> vec =new Vector<Object>();
            vec.add(false);
            vec.add(a.getMaMH());
            vec.add(a.getTenMH());
            vec.add(a.getMaLopGD());
            vec.add(a.getMaGV());
            vec.add(a.getThu());
            vec.add(a.getTiet());
            model.addRow(vec);
            dem++;
        }
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDKHP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btconfirm = new javax.swing.JButton();
        btcancel = new javax.swing.JButton();
        btback = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý điểm sinh viên");

        tbDKHP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Mã môn học", "Tên môn học", "Mã Lớp", "Tên GV", "Thứ", "Tiết"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDKHP);
        if (tbDKHP.getColumnModel().getColumnCount() > 0) {
            tbDKHP.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbDKHP.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        btconfirm.setText("Xác nhận");
        btconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconfirmActionPerformed(evt);
            }
        });
        jPanel3.add(btconfirm);

        btcancel.setText("Hủy đăng ký");
        btcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelActionPerformed(evt);
            }
        });
        jPanel3.add(btcancel);

        btback.setText("Quay lại");
        btback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbackActionPerformed(evt);
            }
        });
        jPanel3.add(btback);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 33)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ HỌC PHẦN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconfirmActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tbDKHP.getModel();
        
        Boolean check = false;
        
        for(int i = 0;i<dem;i++)
        {

            Boolean chk = Boolean.valueOf(tbDKHP.getValueAt(i, 0).toString());
            if(chk)
            {                
                KQHT A = dkService.LayTTDKHP(tbDKHP.getValueAt(i, 4).toString(), tbDKHP.getValueAt(i, 3).toString());
                if(dkService.DKHP(A)==true)
                {
                    check=true;
                }
                else
                {
                    check=false;
                }
            }
            
        }
        if(check){
            JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
            for(int i = 0;i<dem;i++)
            {
                tbDKHP.setValueAt(false, i, 0);
            }
        }
        else{
                JOptionPane.showMessageDialog(this, "Đăng ký không thành công!");
                
            }
        
    }//GEN-LAST:event_btconfirmActionPerformed

    private void btbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btbackActionPerformed

    private void btcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tbDKHP.getModel();
        
        Boolean check = false;
        
        for(int i = 0;i<dem;i++)
        {

            Boolean chk = Boolean.valueOf(tbDKHP.getValueAt(i, 0).toString());
            if(chk)
            {                
                KQHT A = dkService.LayTTDKHP(tbDKHP.getValueAt(i, 4).toString(), tbDKHP.getValueAt(i, 3).toString());
                if(dkService.HUYDKHP(A)==true)
                {
                    check=true;
                }
                else
                {
                    check=false;
                }
            }
            
        }
        if(check){
            JOptionPane.showMessageDialog(this, "Hủy đăng ký thành công!");
            for(int i = 0;i<dem;i++)
            {
                tbDKHP.setValueAt(false, i, 0);
            }
        }
        else{
                JOptionPane.showMessageDialog(this, "Hủy Đăng ký không thành công!");
                
            }
    }//GEN-LAST:event_btcancelActionPerformed

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
            java.util.logging.Logger.getLogger(DangKyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyHocPhan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btback;
    private javax.swing.JButton btcancel;
    private javax.swing.JButton btconfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDKHP;
    // End of variables declaration//GEN-END:variables
}