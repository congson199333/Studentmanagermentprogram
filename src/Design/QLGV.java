/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Design;
import Class.GiangVien;
import Service.QLGVService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hcshl
 */
public class QLGV extends javax.swing.JFrame {

    /**
     * Creates new form QLGV
     */
    public QLGV() {
        initComponents();
        ketNoiOracle();
    }
        Connection conn;
        QLGVService qlgvservice = new QLGVService();
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangGV = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaGV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenGV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHocVi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayVaoLam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHeSoLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMucLuong = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        NutAddGV = new javax.swing.JButton();
        NutNhapLai = new javax.swing.JButton();
        NutUpdateGV = new javax.swing.JButton();
        NutDeleteGV = new javax.swing.JButton();
        NutFindGV = new javax.swing.JButton();
        NutListGV = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        NutThoat = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 33)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ GIẢNG VIÊN");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý điểm sinh viên");

        jPanel1.setToolTipText("");
        jPanel1.setName("QUẢN LÝ GIẢNG VIÊN"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 33)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("QUẢN LÝ GIẢNG VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BangGV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã GV", "Họ và tên", "Học vị", "Giới tính", "Ngày sinh", "Ngày vào làm", "Hệ số lương", "Mức lương"
            }
        ));
        BangGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangGVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BangGV);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        jPanel4.setLayout(new java.awt.GridLayout(8, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã GV:");
        jPanel4.add(jLabel2);
        jPanel4.add(txtMaGV);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Họ và tên:");
        jPanel4.add(jLabel3);
        jPanel4.add(txtTenGV);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Học vị:");
        jPanel4.add(jLabel4);
        jPanel4.add(txtHocVi);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Giới tính:");
        jPanel4.add(jLabel5);

        txtGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nu" }));
        jPanel4.add(txtGioiTinh);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ngày sinh:");
        jPanel4.add(jLabel6);
        jPanel4.add(txtNgaySinh);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ngày vào làm:");
        jPanel4.add(jLabel7);
        jPanel4.add(txtNgayVaoLam);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hệ số lương");
        jPanel4.add(jLabel8);
        jPanel4.add(txtHeSoLuong);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mức lương");
        jPanel4.add(jLabel9);
        jPanel4.add(txtMucLuong);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        NutAddGV.setText("Thêm");
        NutAddGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutAddGVActionPerformed(evt);
            }
        });
        jPanel5.add(NutAddGV, new java.awt.GridBagConstraints());

        NutNhapLai.setText("Nhập lại");
        NutNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutNhapLaiActionPerformed(evt);
            }
        });
        jPanel5.add(NutNhapLai, new java.awt.GridBagConstraints());

        NutUpdateGV.setText("Sửa");
        NutUpdateGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutUpdateGVActionPerformed(evt);
            }
        });
        jPanel5.add(NutUpdateGV, new java.awt.GridBagConstraints());

        NutDeleteGV.setText("Xóa");
        NutDeleteGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutDeleteGVActionPerformed(evt);
            }
        });
        jPanel5.add(NutDeleteGV, new java.awt.GridBagConstraints());

        NutFindGV.setText("Tìm giảng viên");
        NutFindGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutFindGVActionPerformed(evt);
            }
        });
        jPanel5.add(NutFindGV, new java.awt.GridBagConstraints());

        NutListGV.setText("Danh sách giảng viên");
        NutListGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutListGVActionPerformed(evt);
            }
        });
        jPanel5.add(NutListGV, new java.awt.GridBagConstraints());

        NutThoat.setBackground(new java.awt.Color(255, 0, 0));
        NutThoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NutThoat.setText("Thoát");
        NutThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NutThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NutThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NutThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_NutThoatActionPerformed

    private void BangGVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangGVMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) BangGV.getModel();
        this.txtMaGV.setText(model.getValueAt(BangGV.getSelectedRow(), 0).toString());
        this.txtTenGV.setText(model.getValueAt(BangGV.getSelectedRow(), 1).toString());
        this.txtHocVi.setText(model.getValueAt(BangGV.getSelectedRow(), 2).toString());
        this.txtGioiTinh.setSelectedItem(model.getValueAt(BangGV.getSelectedRow(), 3).toString());
        this.txtNgaySinh.setText(model.getValueAt(BangGV.getSelectedRow(), 4).toString());
        this.txtNgayVaoLam.setText(model.getValueAt(BangGV.getSelectedRow(), 5).toString());
        this.txtHeSoLuong.setText(model.getValueAt(BangGV.getSelectedRow(), 6).toString());
        this.txtMucLuong.setText(model.getValueAt(BangGV.getSelectedRow(), 7).toString());
//        this.txtMaKhoa.setText(model.getValueAt(BangGV.getSelectedRow(), 8).toString());
    }//GEN-LAST:event_BangGVMouseClicked

    private void NutListGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutListGVActionPerformed
        // TODO add your handling code here:
                DefaultTableModel model = (DefaultTableModel) BangGV.getModel();
        int rowCounts = model.getRowCount();
        for(int i = rowCounts - 1; i >= 0 ;i--){
            model.removeRow(i);
        }
        model.setRowCount(0);
        
        
        ArrayList<GiangVien> arrListSV=new ArrayList<GiangVien>();
        arrListSV=qlgvservice.ListDL();
        for(GiangVien a: arrListSV)
        {
            Vector<Object> vec =new Vector<Object>();
            vec.add(a.getMaGV());
            vec.add(a.getTenGV());
            vec.add(a.getHocVi());
            vec.add(a.getGioitinh());
            vec.add(a.getNgaySinh());
            vec.add(a.getNgayVL());
            vec.add(a.getHeSoLuong());
            vec.add(a.getMucLuong());
            model.addRow(vec);
            
        }
    }//GEN-LAST:event_NutListGVActionPerformed

    private void NutFindGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutFindGVActionPerformed
        // TODO add your handling code here:
        String A = "";
        A = JOptionPane.showInputDialog("Nhập MAGV của giảng viên cần tìm: ");
        
        DefaultTableModel model = (DefaultTableModel) BangGV.getModel();
        
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        model.setRowCount(0);
        
        if(qlgvservice.FindDLGV(A)==null){
            JOptionPane.showMessageDialog(null, "Không tìm thấy giảng viên!");
        }else{
            model.addRow(qlgvservice.FindDLGV(A));
        }
    }//GEN-LAST:event_NutFindGVActionPerformed

    private void NutAddGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutAddGVActionPerformed
        // TODO add your handling code here:
        if(txtMaGV.getText().equals("")||txtTenGV.getText().equals("")||txtNgaySinh.getText().equals("")||
                txtHeSoLuong.getText().equals("")||txtHocVi.getText().equals("")||txtMucLuong.equals("")||txtNgayVaoLam.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường!!!");
        }
        else {               
                
            
                
            DefaultTableModel model = (DefaultTableModel) BangGV.getModel();
            
            if(qlgvservice.ThemDL(txtMaGV.getText(), txtTenGV.getText(),txtHocVi.getText(),
                    txtGioiTinh.getSelectedItem().toString(), txtNgaySinh.getText(),
                    txtNgayVaoLam.getText(), txtHeSoLuong.getText(), txtMucLuong.getText())==true)
            {
                JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công");
                model.addRow(new Object[]{txtMaGV.getText(),txtTenGV.getText(),txtHocVi.getText(),
                                txtGioiTinh.getSelectedItem(),txtNgaySinh.getText(),txtNgayVaoLam.getText(),
                                txtHeSoLuong.getText(), txtMucLuong.getText()});
            }else{
                JOptionPane.showMessageDialog(null, "Thêm dữ liệu không thành công");
            }
          

                
        }
    }//GEN-LAST:event_NutAddGVActionPerformed

    private void NutDeleteGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutDeleteGVActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) BangGV.getModel();
        if(BangGV.getSelectedRow()==-1)
        {
            if(BangGV.getRowCount()==0){
                JOptionPane.showMessageDialog(this, "Không có trường nào trong bảng");
                }else{
                JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 giảng viên");
            }
        }else{
            //Delete Oracle
            int click = JOptionPane.showConfirmDialog(this, "Xóa giảng viên?","Question",JOptionPane.YES_NO_OPTION);
            if(click==JOptionPane.YES_OPTION)
            {
            String MAGVX = model.getValueAt(BangGV.getSelectedRow(), 0).toString();
            
            if(qlgvservice.XoaDL(MAGVX)==true)
            {
                JOptionPane.showMessageDialog(this, "Xóa dữ liệu thành công");
                    model.removeRow(BangGV.getSelectedRow());
                    this.txtMaGV.setText(null);
                    this.txtTenGV.setText(null);
                    this.txtNgaySinh.setText(null);
                    this.txtHocVi.setText(null);
                    this.txtNgayVaoLam.setText(null);    
                    this.txtHeSoLuong.setText(null);  
                    this.txtMucLuong.setText(null);  
            }else{
                JOptionPane.showMessageDialog(this, "Xóa dữ liệu không thành công");
            }
        }else{
                return;
            }
    } 
    }//GEN-LAST:event_NutDeleteGVActionPerformed

    private void NutNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutNhapLaiActionPerformed
        // TODO add your handling code here:
        this.txtMaGV.setText(null);
        this.txtTenGV.setText(null);
        this.txtNgaySinh.setText(null);
        this.txtHocVi.setText(null);
        this.txtHeSoLuong.setText(null);
        this.txtMucLuong.setText(null);
        this.txtNgayVaoLam.setText(null);
    }//GEN-LAST:event_NutNhapLaiActionPerformed

    private void NutUpdateGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutUpdateGVActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) BangGV.getModel();
        if(BangGV.getSelectedRow()==-1)
        {
            if(BangGV.getRowCount()==0){
                JOptionPane.showMessageDialog(this, "Không có trường nào trong bảng");
                }else{
                JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 giảng viên");
            }
        }else{
            
            //update Oracle
            if(txtMaGV.getText().equals("")||txtTenGV.getText().equals("")||
                    txtHocVi.getText().equals("")||txtNgaySinh.getText().equals("")||
                txtNgayVaoLam.getText().equals("")||txtHeSoLuong.getText().equals("")||
                    txtMucLuong.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường!!!");
        }
        else {            
            
            String MAGVX = model.getValueAt(BangGV.getSelectedRow(), 0).toString();
            

            if(qlgvservice.SuaDL(txtMaGV.getText(), txtTenGV.getText(),txtHocVi.getText(),
                    txtGioiTinh.getSelectedItem().toString(), txtNgaySinh.getText(),
                    txtNgayVaoLam.getText(), txtHeSoLuong.getText(), txtMucLuong.getText())==true)
            {
                JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");   
                model.setValueAt(txtMaGV.getText(), BangGV.getSelectedRow(), 0);
                model.setValueAt(txtTenGV.getText(), BangGV.getSelectedRow(), 1);
                model.setValueAt(txtHocVi.getText(), BangGV.getSelectedRow(), 2);
                model.setValueAt(txtGioiTinh.getSelectedItem().toString(), BangGV.getSelectedRow(), 3);
                model.setValueAt(txtNgaySinh.getText(), BangGV.getSelectedRow(), 4);
                model.setValueAt(txtNgayVaoLam.getText(), BangGV.getSelectedRow(), 5);
                model.setValueAt(txtHeSoLuong.getText(), BangGV.getSelectedRow(), 6);
                model.setValueAt(txtMucLuong.getText(), BangGV.getSelectedRow(), 7);
            }else {
                JOptionPane.showMessageDialog(this, "Sửa dữ liệu không thành công");
            }
            
            } 
        }
    }//GEN-LAST:event_NutUpdateGVActionPerformed

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
            java.util.logging.Logger.getLogger(QLGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLGV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangGV;
    private javax.swing.JButton NutAddGV;
    private javax.swing.JButton NutDeleteGV;
    private javax.swing.JButton NutFindGV;
    private javax.swing.JButton NutListGV;
    private javax.swing.JButton NutNhapLai;
    private javax.swing.JButton NutThoat;
    private javax.swing.JButton NutUpdateGV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox txtGioiTinh;
    private javax.swing.JTextField txtHeSoLuong;
    private javax.swing.JTextField txtHocVi;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JTextField txtMucLuong;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JTextField txtTenGV;
    // End of variables declaration//GEN-END:variables
}