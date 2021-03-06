/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Design;

import Service.DangNhapService;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class DoiMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form DoiMatKhau
     */
    public DoiMatKhau() {
        initComponents();
        this.getRootPane().setDefaultButton(DoiPassWord);
        setLocation(350, 180);

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
        txtOldPassWord = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtNewPassWord = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        DoiPassWord = new javax.swing.JButton();
        Thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đổi mật khẩu");

        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mật khẩu cũ");
        jPanel1.add(jLabel1);
        jPanel1.add(txtOldPassWord);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mật khẩu mới");
        jPanel1.add(jLabel2);
        jPanel1.add(txtNewPassWord);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        DoiPassWord.setText("Save");
        DoiPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiPassWordActionPerformed(evt);
            }
        });
        jPanel2.add(DoiPassWord);

        Thoat.setText("Cancel");
        Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThoatActionPerformed(evt);
            }
        });
        jPanel2.add(Thoat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoiPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiPassWordActionPerformed
        // TODO add your handling code here:
        if(txtNewPassWord.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Nhập nhật khẩu mới");
        }else{
        if(txtOldPassWord.getText().compareTo(DangNhapUI.setLayMatKhau())==0)
        {
            DangNhapService dnService = new DangNhapService();
            dnService.DoiMatKhauMoi(txtNewPassWord.getText(), DangNhapUI.setLayTaiKhoan(), txtOldPassWord.getText());
            this.setVisible(false);
            DangNhapUI A = new DangNhapUI();
            A.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng!!!");
        }}
    }//GEN-LAST:event_DoiPassWordActionPerformed

    private void ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThoatActionPerformed
        // TODO add your handling code here:
        
        DangNhapService dn=new DangNhapService();
        
        if(dn.layLoaiTaiKhoan(DangNhapUI.setLayTaiKhoan(), DangNhapUI.setLayMatKhau()).equals("SV")==true)
        {
            MainSV A = new MainSV();
            A.setVisible(true);
        }else if(dn.layLoaiTaiKhoan(DangNhapUI.setLayTaiKhoan(), DangNhapUI.setLayMatKhau()).equals("GV")==true)
        {
            MainGV B= new MainGV();
            B.setVisible(true);
        }else{
            MainNVPDT C=new MainNVPDT();
            C.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_ThoatActionPerformed

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
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoiPassWord;
    private javax.swing.JButton Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtNewPassWord;
    private javax.swing.JPasswordField txtOldPassWord;
    // End of variables declaration//GEN-END:variables
}