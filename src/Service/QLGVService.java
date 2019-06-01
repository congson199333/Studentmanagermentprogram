/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Class.GiangVien;
import Class.SinhVien;
import Design.DangNhapUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author hcshl
 */
public class QLGVService extends ConnectionOracleService {
        public Object[] FindDLGV(String MAGVadd)
    {
        try{
            String sql = "select * from GIANGVIEN where MAGV=?";                    
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, MAGVadd);
            ResultSet rs = p.executeQuery();
            
            if(rs.next()==false) 
                {
                    return null;
                }
            else
            {
                java.util.Date date = rs.getDate("NGSINH");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Object B = sdf.format(date);
                
                java.util.Date date1 = rs.getDate("NGVL");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                Object B1 = sdf1.format(date1);
                
                Object arr[] = {
                    rs.getString("MAGV"),rs.getString("TENGV"),rs.getString("HOCVI"),rs.getString("GIOITINH"),B,B1,
                    rs.getString("HESOLUONG"),rs.getString("MUCLUONG")
                };
                return arr;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
        
        
            public boolean ThemDL(String MAGVadd,String TenGVadd,String HocViadd,String GioiTinhGVadd,String NgaySinhGVadd, String NgayVLadd, String HeSoLuongadd,String MucLuongAdd)
    {
        
            try{
                String sqlCheck = "select count(MAGV) from GIANGVIEN where MAGV=?";
                PreparedStatement p =conn.prepareStatement(sqlCheck);
                p.setString(1, MAGVadd);
                ResultSet rCheck=p.executeQuery();
                while(rCheck.next())
                {
                    if(rCheck.getInt("COUNT(MAGV)")!=0)
                    {
                        JOptionPane.showMessageDialog(null, "MAGV đã tồn tại");
                    }else{
                                    //Add Oracle
                            try{
                                String sql = "insert into GIANGVIEN values(?, ?, ?, ?, to_date(?, 'DD/MM/YYYY'), to_date(?, 'DD/MM/YYYY'), ?, ?)";
                                
                                PreparedStatement presta;
                                presta = conn.prepareStatement(sql);
                                presta.setString(1, MAGVadd);
                                presta.setString(2, TenGVadd);
                                presta.setString(3, HocViadd);
                                presta.setString(4, GioiTinhGVadd);
                                presta.setString(5, NgaySinhGVadd);
                                presta.setString(6, NgayVLadd);
                                presta.setString(7, HeSoLuongadd);
                                presta.setString(8, MucLuongAdd);
                                
                                Random rd= new Random();
                                String sql1 = "insert into TAIKHOANDANGNHAP values(?, '"+String.valueOf(1000+ rd.nextInt(9000))+"', 'GV')";
                                
                                PreparedStatement presta1;
                                presta1= conn.prepareStatement(sql1);
                                presta1.setString(1, MAGVadd);
                                int rs = presta.executeUpdate();
                                int rs1= presta1.executeUpdate();
                                if(rs != 0 && rs1!=0)               
                                {                                
                                   return true;
                                }else{
                                    
                                    return false;
                                }
                            }catch(Exception ex){
                                
                                ex.printStackTrace();
                                return false;
                            }}}}
                            catch(Exception ex){
                                ex.printStackTrace();
                                return false;
                            }
    
       return false;         
}
            
                public boolean XoaDL (String MAGVadd)
    {
        try{
                String sql = "delete from GIANGVIEN where MAGV=?";
                String sql4= "delete from TAIKHOANDANGNHAP where TENDANGNHAP= ?";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setString(1, MAGVadd);
                PreparedStatement p4= conn.prepareStatement(sql4);
                p4.setString(1, MAGVadd);
                int rs = p.executeUpdate();

                int rs4= p4.executeUpdate();
                if(rs!=0 && rs4!=0){
                    return true;
                }else
                {
                    return false;
                }
            }catch(Exception ex){
                ex.printStackTrace();
                return false;
            }
    }

           public boolean SuaDL (String MAGVadd,String TenGVadd,String HocViadd,String GioiTinhGVadd,String NgaySinhGVadd, String NgayVLadd, String HeSoLuongadd,String MucLuongAdd)
    {
        try{
                String sql = "update GIANGVIEN set TENGV =?, HOCVI=?, GIOITINH = ?, NGSINH = to_date(?,'DD/MM/YYYY'), NGVL = to_date(?,'DD/MM/YYYY'), HESOLUONG = ?, MUCLUONG = ? where MAGV =?";
                
                PreparedStatement p;
                p = conn.prepareStatement(sql);  
                p.setString(1, TenGVadd);
                p.setString(2, HocViadd);
                p.setString(3, GioiTinhGVadd);
                p.setString(4, NgaySinhGVadd);
                p.setString(5, NgayVLadd);
                p.setString(6, HeSoLuongadd);
                p.setString(7, MucLuongAdd);
                p.setString(8, MAGVadd);
                
                int rs = p.executeUpdate();
                if(rs != 0)               
                {      
                   return true;
                }else{
                    return false;
                }
            }catch(Exception ex){
                ex.printStackTrace();
                return false;
            }
    }     


    public ArrayList<GiangVien> ListDL()
    {
        try{
            ArrayList<GiangVien> arrListGV =new ArrayList<GiangVien>();
            String sqlList = "select * from GIANGVIEN";
            PreparedStatement pstm = conn.prepareStatement(sqlList);
            ResultSet res = pstm.executeQuery();            
            while(res.next()){
                java.util.Date date = res.getDate("NGSINH");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Object A = sdf.format(date);
                java.util.Date date1 = res.getDate("NGVL");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                Object B = sdf1.format(date1); 
                
                GiangVien gv=new GiangVien();
                gv.setMaGV(res.getString("MAGV"));
                gv.setTenGV(res.getString("TENGV"));
                gv.setHocVi(res.getString("HOCVI"));
                gv.setGioitinh(res.getString("GIOITINH"));
                gv.setNgaySinh(A.toString());
                gv.setNgayVL(B.toString());
                gv.setHeSoLuong(res.getString("HESOLUONG"));
                gv.setMucLuong(res.getString("MUCLUONG"));
                arrListGV.add(gv);
            }
            return arrListGV;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }        
    }

    
    public GiangVien AddTextField(){
        GiangVien A = new GiangVien();
        
        A.setMaGV(DangNhapUI.setLayTaiKhoan());
        
        try{
            String sql = "select * from GIANGVIEN where MAGV='"+DangNhapUI.setLayTaiKhoan()+"'";
            
            PreparedStatement p = conn.prepareStatement(sql);

            
            ResultSet rs = p.executeQuery();

            
            if(rs.next())
            {
                A.setTenGV(rs.getString("TENGV"));
                A.setGioitinh(rs.getString("GIOITINH"));
                A.setHeSoLuong(rs.getString("HESOLUONG"));
                A.setHocVi(rs.getString("HOCVI"));
                A.setMucLuong(rs.getString("MUCLUONG"));
                
                Date date = rs.getDate("NGSINH");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                A.setNgaySinh(sdf.format(date).toString());
                Date date1 = rs.getDate("NGVL");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                A.setNgayVL(sdf1.format(date1).toString());
                //System.out.println("Thời sau khi định dạng là " + sdf.format(date));
            }
            return A;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    
}