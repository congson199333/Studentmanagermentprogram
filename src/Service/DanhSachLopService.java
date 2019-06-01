/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Class.Lop;
import Design.DanhSachLopUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class DanhSachLopService extends ConnectionOracleService {
	
	public ArrayList<Lop> LayDanhSachLop(String magv)
	{
		ArrayList<Lop> ds =new  ArrayList<>();
		//magv=DangNhapUI.setLayTaiKhoan();
		
		try {
			String sql ="select * from giangday where magv=? ";
			PreparedStatement presta =conn.prepareStatement(sql);
			presta.setString(1, magv);
			ResultSet result =presta.executeQuery();
			while(result.next())
			{
				Lop lop=new Lop();
				lop.setMaLop(result.getString(1));
				lop.setMaGV(result.getString(3));
				ds.add(lop);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
        
        
   public boolean CheckMSSV (String MSSVadd,String MaLopadd)     
   {
       try{
                String sqlCheck = "select count(MSSV) from KETQUA where MSSV=? and MALOPGD=?";
                PreparedStatement p =conn.prepareStatement(sqlCheck);
                p.setString(1, MSSVadd);
                p.setString(2, MaLopadd);
                ResultSet rCheck=p.executeQuery();
                while(rCheck.next())
                {
                    if(rCheck.getInt("COUNT(MSSV)")!=0)
                    {
                        JOptionPane.showMessageDialog(null, "MSSV đã tồn tại");
                        return true;
                    }
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