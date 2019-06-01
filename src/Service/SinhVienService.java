/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Class.DiemHocTap;
import Class.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class SinhVienService extends ConnectionOracleService {
	
	public ArrayList<DiemHocTap> layDanhSachSinhVienTheoLop(String malop)
	{	
		/*ArrayList<DiemHocTap> dsSV =new ArrayList<DiemHocTap>();
		try {
			String sql="select * from  DiemHocTap where MaLopGD=? "; 
			PreparedStatement presta =conn.prepareStatement(sql);
			presta.setString(1, malop);
			ResultSet resul =presta.executeQuery();
			while(resul.next())
			{
				DiemHocTap sinhvienhoctap =new DiemHocTap();
				
				sinhvienhoctap.setMssv(resul.getString(1));
				sinhvienhoctap.setTensv(resul.getString(2));
				sinhvienhoctap.setDiemqt(resul.getFloat(3));
				sinhvienhoctap.setDiemth(resul.getFloat(4));
				sinhvienhoctap.setDiemgk(resul.getFloat(5));
				sinhvienhoctap.setDiemck(resul.getFloat(6));
				sinhvienhoctap.setDiemtb(resul.getFloat(7));
				
				sinhvienhoctap.setMalopGD(malop);
					dsSV.add(sinhvienhoctap);
					

			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;*/
		
		ArrayList<DiemHocTap> dsSV =new ArrayList<DiemHocTap>();
		try {
			String sql="select * from  KetQua , SinhVien where MaLopGD=? and KetQua.MSSV=SinhVien.MSSV "; 
			PreparedStatement presta =conn.prepareStatement(sql);
			presta.setString(1, malop);
			ResultSet resul =presta.executeQuery();
			while(resul.next())
			{
				DiemHocTap sinhvienhoctap =new DiemHocTap();
				
				sinhvienhoctap.setMssv(resul.getString(1));
				sinhvienhoctap.setTensv(resul.getString(12));
				sinhvienhoctap.setDiemqt(resul.getFloat(5));
				sinhvienhoctap.setDiemth(resul.getFloat(7));
				sinhvienhoctap.setDiemgk(resul.getFloat(6));
				sinhvienhoctap.setDiemck(resul.getFloat(8));
				sinhvienhoctap.setDiemtb(resul.getFloat(9));
				
				sinhvienhoctap.setMalopGD(malop);
					dsSV.add(sinhvienhoctap);
					

			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
		
		
	}
	public int capNhatDiemSinhVien(DiemHocTap x)
	{
	
		//x=new DiemHocTap();
		/*try {
			String sql="Update DiemHocTap set Diemqt=?, diemth=? , diemgk=? , diemck=? , diemtb=?  where MSSV=? and MaLopGD=?";
			PreparedStatement preSta= conn.prepareStatement(sql);
			preSta.setFloat(1, x.getDiemqt());
			preSta.setFloat(2,  x.getDiemth());
			preSta.setFloat(3, x.getDiemgk());
			preSta.setFloat(4, x.getDiemck());
			preSta.setFloat(5, x.getDiemtb());
			preSta.setString(6, x.getMssv());
			preSta.setString(7, x.getMalopGD());
			
			return preSta.executeUpdate();	
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, " cập nhật Thất bại");
			ex.printStackTrace();
		}
		return -1;*/
		try {
			String sql="Update KetQua set Diemqt=?, diemth=? , diemgk=? , diemck=? , diemtb=?  where MSSV=? and MaLopGD=?";
			PreparedStatement preSta= conn.prepareStatement(sql);
			preSta.setFloat(1, x.getDiemqt());
			preSta.setFloat(2,  x.getDiemth());
			preSta.setFloat(3, x.getDiemgk());
			preSta.setFloat(4, x.getDiemck());
			preSta.setFloat(5, x.getDiemtb());
			preSta.setString(6, x.getMssv());
			preSta.setString(7, x.getMalopGD());
			
			return preSta.executeUpdate();	
			
		}
		catch(Exception ex)
		{
			if( Float.parseFloat(x.getDiemqt().toString()) <0 || Float.parseFloat(x.getDiemqt().toString())>10 ||
								Float.parseFloat(x.getDiemth().toString())<0 ||Float.parseFloat(x.getDiemth().toString())>10 
								|| Float.parseFloat(x.getDiemgk().toString())<0 || Float.parseFloat(x.getDiemgk().toString())>10
								||Float.parseFloat(x.getDiemck().toString()) <0 ||Float.parseFloat(x.getDiemck().toString())>10 )
						{
							JOptionPane.showMessageDialog(null, "Điểm phải từ 0->10");
						}
			ex.printStackTrace();
		}
		return -1;
	}
	public boolean xoaDiemSinhVien(DiemHocTap diem)
	{
		/*int a=0;
		
		try {
			String sql="delete  from DiemHocTap where mssv=? and malopgd=?";
			PreparedStatement preSta =conn.prepareStatement(sql);
			preSta.setString(1, diem.getMssv());
			preSta.setString(2, diem.getMalopGD());
			a=preSta.executeUpdate();
			if(a>0)
			{
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
			ex.printStackTrace();
		}*/
		int a=0;
		
		try {
			String sql="delete  from KetQua where mssv=? and malopgd=?";
			PreparedStatement preSta =conn.prepareStatement(sql);
			preSta.setString(1, diem.getMssv());
			preSta.setString(2, diem.getMalopGD());
			a=preSta.executeUpdate();
			if(a>0)
			{
                            
				
                                return true;
			}
                        return false;
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
                        return false;
		}
	}
		
}