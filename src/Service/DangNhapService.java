/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Class.DangNhap;
import Design.DangNhapUI;
import javax.swing.JOptionPane;


/**
 *
 * @author hcshl
 */

public class DangNhapService extends ConnectionOracleService{
	public String layLoaiTaiKhoan(String tenDN, String matKhau)
	{
		String loaitk = null;
		try {
			String sql ="select * from TaiKhoanDangNhap where tendangnhap=? and matkhau=? ";
			PreparedStatement presta = conn.prepareStatement(sql);
			presta.setString(1, tenDN);
			presta.setString(2, matKhau);
	
			ResultSet result =presta.executeQuery();
			if(result.next())
			{
				loaitk=result.getString(3);
			}
			}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		
		return loaitk;
	}
	public DangNhap Login(String tenDN, String matKhau)
	{	
		DangNhap tk = null;
		try {
			
			String sql ="select * from TaiKhoanDangNhap where tendangnhap=? and matkhau=?";
			PreparedStatement presta = conn.prepareStatement(sql);
			presta.setString(1, tenDN);
			presta.setString(2, matKhau);
			ResultSet result =presta.executeQuery();
			if(result.next())
			{				
				tk=new DangNhap();
				tk.setTenDangNhap(tenDN);
				tk.setMatKhau(matKhau);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		return tk;
	}
	public DangNhap doiMatKhau(String passCu)
	{
		//String passcu =txtOldPassWord.getText();
		//String passmoi=txtNewPassWord.getText();
		DangNhap tkdn=null;
		try {
			String sql="select* from Taikhoandangnhap  where matkhau=? where tendangnhap=?";
			PreparedStatement presta=conn.prepareStatement(sql);
			presta.setString(1, passCu);
			presta.setString(2, DangNhapUI.setLayTaiKhoan());
			ResultSet resul = presta.executeQuery();
			if(resul.next())
			{
				tkdn =new DangNhap();
				tkdn.setMatKhau(passCu);
				tkdn.setLoaiTaiKhoan(resul.getString(3));
				tkdn.setTenDangNhap(resul.getString(1));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return tkdn;
	}
	public void  DoiMatKhauMoi(String passMoi , String tendn, String passCu)
	{
		//String passcu =txtOldPassWord.getText();
		//String passmoi=txtNewPassWord.getText();
                int a=0;
		try {
			String sql="update Taikhoandangnhap set matkhau=? where tendangnhap=? and matkhau=?";
			PreparedStatement presta=conn.prepareStatement(sql);
			presta.setString(1, passMoi);
			presta.setString(2, tendn);
			presta.setString(3, passCu);
			 a= presta.executeUpdate();
			
			if(a>0)
			{
                            JOptionPane.showMessageDialog(null, "Đổi thành công\nVui lòng đăng nhập lại");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		//return a;


	}
	
}
