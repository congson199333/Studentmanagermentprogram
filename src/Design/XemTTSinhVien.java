/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Design;

import Service.QLSVService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author hcshl
 */
public class XemTTSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form QLDSVXemDiem
     */
    QLSVService A = new QLSVService(); 
        
    public XemTTSinhVien() {
        initComponents();
        ketNoiOracle();
        setLocation(100, 100);
        hienThiThongTinSV();
        
    }
    
    public void hienThiThongTinSV(){
        txt_TT_MSSV.setText(A.AddTextField().getMssv());
        txt_TT_HoTen.setText(A.AddTextField().getTenSV());
        txt_TT_GioiTinh.setText(A.AddTextField().getGioiTinh());
        txt_TT_NgaySinh.setText(A.AddTextField().getNgaysinh());
        txt_TT_NoiSinh.setText(A.AddTextField().getNoisinh());
        txt_TT_MaLop.setText(A.AddTextField().getMaLop());
        
    }

    
    Connection conn;
    public void ketNoiOracle(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String strConn = "jdbc:oracle:thin:@localhost:1521/orcl";
            conn = DriverManager.getConnection(strConn, "HCS", "son123");
        }catch(Exception ex)
        {
            ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_TT_MSSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_TT_HoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_TT_NgaySinh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_TT_GioiTinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_TT_NoiSinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_TT_MaLop = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Nut_QuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin sinh viên");

        jPanel1.setLayout(new java.awt.GridLayout(6, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MSSV:");
        jPanel1.add(jLabel1);

        txt_TT_MSSV.setEditable(false);
        txt_TT_MSSV.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(txt_TT_MSSV);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Họ tên:");
        jPanel1.add(jLabel2);

        txt_TT_HoTen.setEditable(false);
        jPanel1.add(txt_TT_HoTen);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ngày sinh:");
        jPanel1.add(jLabel3);

        txt_TT_NgaySinh.setEditable(false);
        jPanel1.add(txt_TT_NgaySinh);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Giới tính:");
        jPanel1.add(jLabel4);

        txt_TT_GioiTinh.setEditable(false);
        jPanel1.add(txt_TT_GioiTinh);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nơi sinh:");
        jPanel1.add(jLabel5);

        txt_TT_NoiSinh.setEditable(false);
        jPanel1.add(txt_TT_NoiSinh);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mã lớp:");
        jPanel1.add(jLabel6);

        txt_TT_MaLop.setEditable(false);
        jPanel1.add(txt_TT_MaLop);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("THÔNG TIN SINH VIÊN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel3.setLayout(new java.awt.GridBagLayout());

        Nut_QuayLai.setText("Quay lại");
        Nut_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nut_QuayLaiActionPerformed(evt);
            }
        });
        jPanel3.add(Nut_QuayLai, new java.awt.GridBagConstraints());

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nut_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nut_QuayLaiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Nut_QuayLaiActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(XemTTSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemTTSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemTTSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemTTSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XemTTSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nut_QuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_TT_GioiTinh;
    private javax.swing.JTextField txt_TT_HoTen;
    private javax.swing.JTextField txt_TT_MSSV;
    private javax.swing.JTextField txt_TT_MaLop;
    private javax.swing.JTextField txt_TT_NgaySinh;
    private javax.swing.JTextField txt_TT_NoiSinh;
    // End of variables declaration//GEN-END:variables
}