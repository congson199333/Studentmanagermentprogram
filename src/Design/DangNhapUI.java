/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Design;
import Class.DangNhap;
import Service.DangNhapService;
import Ui.DocLuuTaiKhoan;
import Design.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class DangNhapUI extends javax.swing.JFrame {
    Connection conn;
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
     * Creates new form Login
     */

    public DangNhapUI() {
        initComponents();
        setLocation(350, 180);
        this.getRootPane().setDefaultButton(Nut_login);
        xuLiLuuThongTinDangNhap();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        Nut_exit = new javax.swing.JButton();
        Nut_login = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        chkLuuTTDangNhap = new javax.swing.JCheckBox();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Form");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Users-Name-icon.png"))); // NOI18N
        jLabel2.setText("Username:");
        jPanel2.add(jLabel2);
        jPanel2.add(txtUsername);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Security-Password-2-icon.png"))); // NOI18N
        jLabel3.setText("Password: ");
        jPanel2.add(jLabel3);
        jPanel2.add(txtPassword);

        Nut_exit.setMnemonic('C');
        Nut_exit.setText("Exit");
        Nut_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nut_exitActionPerformed(evt);
            }
        });

        Nut_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Login-in-icon.png"))); // NOI18N
        Nut_login.setMnemonic('L');
        Nut_login.setText("Login");
        Nut_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nut_loginActionPerformed(evt);
            }
        });

        chkLuuTTDangNhap.setText("Lưu thông tin đăng nhập");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(chkLuuTTDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chkLuuTTDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Nut_login, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Nut_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nut_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nut_login, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nut_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nut_loginActionPerformed
        // Code xu ly khi nhan vao nut login
       if(txtUsername.getText().equals("")||txtPassword.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Chưa nhập tài khoản hoặc mật khẩu");
       }else {
                    DangNhapService dnService =new DangNhapService();
                    DangNhap dn = dnService.Login(txtUsername.getText(), txtPassword.getText());
                    
                    if(dn!=null) 
                    {
                        if(chkLuuTTDangNhap.isSelected())
					{
						DocLuuTaiKhoan.LuuFile("TaiKhoan.data", dn);
						
					}
					else 
					{
						DocLuuTaiKhoan.LuuFile("TaiKhoan.data", null);
					}
                           
                            if((dnService.layLoaiTaiKhoan(txtUsername.getText(), txtPassword.getText()).compareTo("SV")==0))
                            {
                                    dispose();
                                    MainSV A = new MainSV();
                                    A.setVisible(true);
                            }else
                                if(dnService.layLoaiTaiKhoan(txtUsername.getText(), txtPassword.getText()).compareTo("GV")==0)
                               {
                                       dispose();
                                       MainGV gv =new MainGV();
                                       gv.setVisible(true);
                               }else
                                if(dnService.layLoaiTaiKhoan(txtUsername.getText(), txtPassword.getText()).compareTo("NV")==0)
                                {
                                        dispose();
                                        MainNVPDT nv =new MainNVPDT();
                                        nv.setVisible(true);
                                }else 
                    {
                        JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
                        txtUsername.setText("");
                        txtPassword.setText("");
                        txtUsername.requestFocus();
                    }
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
                        txtUsername.setText("");
                        txtPassword.setText("");
                        txtUsername.requestFocus();
                    }
       }
    }//GEN-LAST:event_Nut_loginActionPerformed
public static  String setLayTaiKhoan()
	{
		String TenDN ;
		TenDN = txtUsername.getText();
		return TenDN ;
	}
public static  String setLayMatKhau()
	{
		String mk ;
		mk = txtPassword.getText();
		return mk ;
	}
    
    private void Nut_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nut_exitActionPerformed
        // Code xu ly khi nhan vao nut exit        
        this.dispose();
    }//GEN-LAST:event_Nut_exitActionPerformed

    private void xuLiLuuThongTinDangNhap() {
		
				File f =new File("TaiKhoan.data");
				if(f.exists())
				{
					Object data =DocLuuTaiKhoan.DocFile("TaiKhoan.data");
					if(data!=null)
					{
						DangNhap dn=(DangNhap)data;
						txtUsername.setText(dn.getTenDangNhap());
						txtPassword.setText(dn.getMatKhau());
						//txtLoaiTK.setText(dn.getLoaiTaiKhoan());
						chkLuuTTDangNhap.setSelected(true);
					}
				}
			
	}
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
            java.util.logging.Logger.getLogger(DangNhapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nut_exit;
    private javax.swing.JButton Nut_login;
    private javax.swing.JCheckBox chkLuuTTDangNhap;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPasswordField txtPassword;
    public static javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}