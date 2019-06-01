/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

/**
 *
 * @author hcshl
 */
public class QLDSVService extends ConnectionOracleService{
    public float hienThiDiemTrungBinhChung(String mssv) {
		try {
			String sql="{call SP_TINHDIEMTBHOCKY(?, ?)}";
			CallableStatement call=conn.prepareCall(sql);
			call.setString(1, mssv);
			call.registerOutParameter(2, java.sql.Types.FLOAT);
			call.executeQuery();
			float a=call.getFloat(2);
			
			System.out.println(a);
                        return a;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
                        return 0;
		}
}
    	public int hienThiTongTinChi(String mssv) {
		try {
			String sql="{call SP_TOngSoTinChi(?, ?)}";
			CallableStatement call=conn.prepareCall(sql);
			call.setString(1, mssv);
			call.registerOutParameter(2, java.sql.Types.INTEGER);
			call.executeQuery();
			int a=call.getInt(2);
			
			System.out.println(a);
                        return a;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
                        return 0;
		}
		
	}

    public void AddDIEMTB(String MSSV, Float A, int B)
    {
        try
        {
            String sql="insert into DIEMTB values(?,?,?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, MSSV);
            p.setInt(2, B);
            p.setFloat(3, A);
            int rs=p.executeUpdate();
            if(rs!=0){
                System.out.println("OK");
                return;
            }
        }catch(Exception Ex){
            Ex.printStackTrace();
        }
    }
    
    
}