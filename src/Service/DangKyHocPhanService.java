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
public class DangKyHocPhanService extends ConnectionOracleService{
    public ArrayList<DKHP> LayDSDKHP()
    {
    try{
        ArrayList<DKHP> arrDKHP =new ArrayList<DKHP>();
        String sql = "Select MONHOC.MAMH,MONHOC.TENMH,GIANGDAY.MALOPGD,GIANGVIEN.TENGV, GIANGDAY.THU, GIANGDAY.TIET from MONHOC,"
                + "GIANGDAY,GIANGVIEN where MONHOC.MAMH=GIANGDAY.MAMH and GIANGDAY.MAGV=GIANGVIEN.MAGV";
        PreparedStatement p = conn.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        while(rs.next())
        {
            DKHP hp=new DKHP();
            hp.setMaMH(rs.getString(1));
            hp.setMaGV(rs.getString(4));
            hp.setMaLopGD(rs.getString(3));
            hp.setTenMH(rs.getString(2));
            hp.setThu(rs.getString("THU"));
            hp.setTiet(rs.getString("TIET"));
            arrDKHP.add(hp);
            
        }
        return arrDKHP;
    }catch(Exception ex){
        
        ex.printStackTrace();
        return null;
    }
}
    
    public KQHT LayTTDKHP(String TenGVadd, String MaLopGDadd)
    {
        
        
        try{
            String sql="Select MONHOC.MAMH, GIANGDAY.MALOPGD, GIANGVIEN.MAGV from MONHOC, GIANGDAY, GIANGVIEN where GIANGVIEN.TENGV=? and MONHOC.MAMH=GIANGDAY.MAMH and GIANGDAY.MAGV=GIANGVIEN.MAGV and GIANGDAY.MALOPGD =?";
            PreparedStatement p =conn.prepareStatement(sql);
            p.setString(1, TenGVadd);
            p.setString(2, MaLopGDadd);
            ResultSet rs = p.executeQuery();
            while(rs.next())
            {
                KQHT a = new KQHT();
                a.setMALOPGD(rs.getString("MALOPGD"));
                a.setMSSV(DangNhapUI.setLayTaiKhoan());
                a.setMAGV(rs.getString("MAGV"));
                a.setMAMH(rs.getString("MAMH"));
                a.setDIEMCHU(null);
                a.setDIEMCK(0);
                a.setDIEMGK(0);
                a.setDIEMQT(0);
                a.setDIEMTB(0);
                a.setDIEMTH(0);
                return a;
            }
            return null;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean DKHP(KQHT a)
    {
       
        try{
            String sql = "insert into KETQUA values(?,?,?,?,null,null,null,null,null,null)";
            PreparedStatement p = conn.prepareStatement(sql);
            
            p.setString(1, a.getMSSV());
            p.setString(2, a.getMAMH());
            p.setString(3, a.getMAGV());
            p.setString(4, a.getMALOPGD());
            
            int rs = p.executeUpdate();
            
            if(rs!=0)
            {
                return true;
            }else{
                return false;
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Bạn đã đăng ký hoặc đang học lớp này");
            return false;
        }
    }
    
    public boolean HUYDKHP(KQHT a)
    {
        try{
            String sql = "select count(MSSV) from KETQUA where MALOPGD = ? ";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, a.getMALOPGD());
            ResultSet rs = p.executeQuery();
            if(rs.next())
            {
                if(rs.getInt("COUNT(MSSV)")==1){
                    try{
                        String sql1="Delete from KETQUA where MSSV = ? and MALOPGD= ?";
                        PreparedStatement p1 = conn.prepareStatement(sql1);
                        p1.setString(1, a.getMSSV());
                        p1.setString(2, a.getMALOPGD());
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