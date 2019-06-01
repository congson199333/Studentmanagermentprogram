/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Class.DKHP;
import Class.KQHT;
import Design.DangNhapUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class DangKyLichDayService extends ConnectionOracleService{
    public ArrayList<DKHP> LayDSDKHP()
    {
    try{
        ArrayList<DKHP> arrDKHP =new ArrayList<DKHP>();
        String sql = "Select MONHOC.MAMH, MONHOC.TENMH, GIANGDAY.MALOPGD, GIANGDAY.HOCKY, GIANGDAY.NAMHOC,"
                + " GIANGDAY.THU, GIANGDAY.TIET,GIANGDAY.SISO from MONHOC,"
                + "GIANGDAY where (MONHOC.MAMH=GIANGDAY.MAMH and MAGV is null) or (MONHOC.MAMH=GIANGDAY.MAMH and MAGV=?)";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setString(1, DangNhapUI.setLayTaiKhoan());
        ResultSet rs = p.executeQuery();
        while(rs.next())
        {
            DKHP hp=new DKHP();
            hp.setMaMH(rs.getString("MAMH"));
            hp.setHocKy(rs.getString("HOCKY"));
            hp.setNamHoc(rs.getString("NAMHOC"));
            hp.setMaLopGD(rs.getString("MALOPGD"));
            hp.setTenMH(rs.getString("TENMH"));
            hp.setThu(rs.getString("THU"));
            hp.setTiet(rs.getString("TIET"));
            hp.setSiSo(rs.getInt("SISO"));
            arrDKHP.add(hp);
            
        }
        return arrDKHP;
    }catch(Exception ex){
        
        ex.printStackTrace();
        return null;
    }
}
    
    public DKHP LayTTDKLD(String MaLopGDadd)
    {
        
        
        try{
            String sql="Select MONHOC.MAMH, MONHOC.TENMH, GIANGDAY.MALOPGD, GIANGDAY.HOCKY,GIANGDAY.NAMHOC,GIANGDAY.THU,GIANGDAY.TIET,GIANGDAY.SISO "
                    + "from MONHOC, GIANGDAY where MONHOC.MAMH=GIANGDAY.MAMH and GIANGDAY.MALOPGD =?";
            
            PreparedStatement p =conn.prepareStatement(sql);
            p.setString(1, MaLopGDadd);
            
            ResultSet rs = p.executeQuery();
            
            while(rs.next())
            {
                DKHP a = new DKHP();
                a.setMaLopGD(rs.getString("MALOPGD"));
                a.setMaGV(DangNhapUI.setLayTaiKhoan());
                a.setMaMH(rs.getString("MAMH"));
                a.setTenMH(rs.getString("TENMH"));
                a.setHocKy(rs.getString("HOCKY"));
                a.setNamHoc(rs.getString("NAMHOC"));
                a.setThu(rs.getString("THU"));
                a.setTiet(rs.getString("TIET"));
                a.setSiSo(rs.getInt("SISO"));
                
                return a;
            }
            return null;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean DKLD(DKHP a)
    {       
        try{
            String sql = "update GIANGDAY set GIANGDAY.MAGV=? where MALOPGD=?";
            PreparedStatement p = conn.prepareStatement(sql);
            
            p.setString(1, a.getMaGV());
            p.setString(2, a.getMaLopGD());

            
            
            int rs = p.executeUpdate();
            
            if(rs!=0)
            {
                return true;
            }else{
                return false;
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Bạn đã đăng ký hoặc đã có người đăng ký lớp này");
            return false;
        }
    }
    
    public boolean HUYDKLD(DKHP a)
    {
        try{
            String sql = "select count(MAGV) from GIANGDAY where MALOPGD = ? ";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, a.getMaLopGD());
            ResultSet rs = p.executeQuery();
            if(rs.next())
            {
                if(rs.getInt("COUNT(MAGV)")==1){
                    try{
                        String sql1="Update GIANGDAY set MAGV=null where MALOPGD=?";
                        PreparedStatement p1 = conn.prepareStatement(sql1);
                        
                        p1.setString(1, a.getMaLopGD());
                        
                        int res = p1.executeUpdate();
                        if(res!=0)
                        {
                            return true;
                        }
                        else{
                            return false;
                        }
                    }catch(Exception ex)
                    {
                        ex.printStackTrace();
                        return false;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Bạn chưa đăng ký lớp này");
                    return false;
                }
            }
            return false;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            
            return false;
        }
    }
    
    
}