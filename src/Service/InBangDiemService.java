/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class InBangDiemService extends ConnectionOracleService{
    
    
    public boolean KiemTraMSSV(String MSSVadd)
    {
        if("".equals(MSSVadd)||MSSVadd==null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập MSSV");
            return false;
        }
        
        if(MSSVadd != null){
            try{
                String sqlCheck = "select count(MSSV) from SINHVIEN where MSSV=?";
                PreparedStatement p =conn.prepareStatement(sqlCheck);
                p.setString(1, MSSVadd);
                ResultSet rCheck=p.executeQuery();
                while(rCheck.next())
                {
                    if(rCheck.getInt("COUNT(MSSV)")!=0)
                    {
                        return true;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "MSSV không tồn tại");
                        return false;
                    
                    }
                }
                return false;
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "MSSV không tồn tại");
                ex.printStackTrace();
                
                return false;
            }
    }
        return false;
    }
}