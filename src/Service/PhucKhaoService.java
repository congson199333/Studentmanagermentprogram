/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Class.BangPhucKhao;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class PhucKhaoService extends ConnectionOracleService {
    
    
 public void luuDanhSachPhucKhao(BangPhucKhao pk )
	{
		/*try {
			String sql="insert into PhucKhao values (?,?,'N')";
			PreparedStatement preSta=conn.prepareStatement(sql);
			preSta.setString(1, pk.getMssv());
			preSta.setString(2, pk.getMalopGD());
			
			if(preSta.executeUpdate()>0)
				JOptionPane.showMessageDialog(null, "Gửi phúc khảo thành công");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Gửi phúc khảo thất bại" );
			ex.printStackTrace();
		}
		*/
		
		try {
			
			String sql="{call sp_KiemTraPhucKhao(?, ?, ?)}";
			CallableStatement call=conn.prepareCall(sql);
			call.setString(1, pk.getMssv());
			call.setString(2, pk.getMalopGD());
			call.registerOutParameter(3, java.sql.Types.INTEGER);
			
			call.executeUpdate();
			int a =call.getInt(3);
			System.out.println(a);
			if(a==1) {
					try {
					
					String sql1="{call sp_PhucKhao(?, ?)}";
					CallableStatement call1=conn.prepareCall(sql1);
					call1.setString(1, pk.getMssv());
					call1.setString(2, pk.getMalopGD());
					call1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Gửi phúc khảo thành công " );
					
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Mã lớp đã được phúc khảo " );
					
						ex.printStackTrace();
					}
			}
			else {
				JOptionPane.showMessageDialog(null, "Mã Lớp không tồn tại" );
			}
		}
		catch (Exception ex )
		{
			JOptionPane.showMessageDialog(null, "Gửi phúc khảo thất bại" );
			ex.printStackTrace();
		}
	}   
    
//    public void luuDanhSachPhucKhao(BangPhucKhao pk )
//	{
//		try {
//			String sql="insert into PhucKhao values (?,?,'N')";
//			PreparedStatement preSta=conn.prepareStatement(sql);
//			preSta.setString(1, pk.getMssv());
//			preSta.setString(2, pk.getMalopGD());
//			
//			if(preSta.executeUpdate()>0)
//			JOptionPane.showMessageDialog(null, "Gửi phúc khảo thành công");
//		}
//		catch(Exception ex)
//		{
//			JOptionPane.showMessageDialog(null, "Gửi phúc khảo thất bại" );
//			ex.printStackTrace();
//		}
//	}
        public ArrayList<BangPhucKhao> giangVienDocDanhSachPhucKhao(String magv)
	{
		ArrayList<BangPhucKhao> arrpk =new ArrayList<BangPhucKhao>();
		try {
			String sql ="select * from PhucKhao , giangday where magv=? and giangday.malopgd=phuckhao.malopgd ";
			PreparedStatement preSta=conn.prepareStatement(sql);
			preSta.setString(1, magv );
			ResultSet result =preSta.executeQuery();
			while (result.next())
			{
				BangPhucKhao pk =new BangPhucKhao();
				pk.setMssv(result.getString(1));
				pk.setMalopGD(result.getString(2));
				pk.setTrangThai(result.getString(3));
				arrpk.add(pk);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return arrpk;
	}
 
 
 
 
	public ArrayList<BangPhucKhao> docDanhSachPhucKhao()
	{
		ArrayList<BangPhucKhao> arrpk =new ArrayList<BangPhucKhao>();
		try {
			String sql ="select * from PhucKhao ";
			PreparedStatement preSta=conn.prepareStatement(sql);
			ResultSet result =preSta.executeQuery();
			while (result.next())
			{
				BangPhucKhao pk =new BangPhucKhao();
				pk.setMssv(result.getString(1));
				pk.setMalopGD(result.getString(2));
				pk.setTrangThai(result.getString(3));
				arrpk.add(pk);
			}
		}
		catch(Exception ex)
		{
                        JOptionPane.showMessageDialog(null, "..................");
			ex.printStackTrace();
		}
		return arrpk;
	}
	
	public boolean CapNhatPhucKhaoDaXuLy(BangPhucKhao pk) {
		try {
			String sql="Update PhucKhao set trangthai='Y' where MSSV=? and MaLopGD=?";
			PreparedStatement preSta =conn.prepareStatement(sql);
			preSta.setString(1, pk.getMssv());
			preSta.setString(2, pk.getMalopGD());
			int a=preSta.executeUpdate();
			if(a>0)
			{
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                                return true;
			}else{
                            return false;
                        }
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
			ex.printStackTrace();
                        return false;
			
		}
		
	}
        
        
public int KiemTraPhucKhao(String mssv, String malop)
	{
		try {
			String sql="select * from ketqua where mssv=?";
			PreparedStatement preSta =conn.prepareStatement(sql);
			preSta.setString(1, mssv);
			ResultSet result =preSta.executeQuery();
			while(result.next())
			{
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 1;
	}
}