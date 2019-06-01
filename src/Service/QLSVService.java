/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

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
public class QLSVService extends ConnectionOracleService {
    //Xét mã lớp có tồn tại không?
    public boolean xetMaLop(String MaLop)
    {
        String sqlCheckLop = "select count(MALOP) from LOP where MALOP=?";
        
                try {
                    PreparedStatement pCheckLop = conn.prepareStatement(sqlCheckLop);
                    pCheckLop.setString(1, MaLop);
                    ResultSet rCheckLop = pCheckLop.executeQuery();
                    while(rCheckLop.next())
                    {
                        if(rCheckLop.getInt("COUNT(MALOP)")==0)
                        { 
                            return false;
                        }else return true;
                    }
                    return false;
                } 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không tồn tại mã lớp tương ứng");
                    
                    ex.printStackTrace();
                    return false;
                }
    }
    
    public boolean ThemDL(String MSSVadd,String Tenadd,String NgaySinhadd,String GioiTinhadd, String DiaChiadd, String MaLopadd)
    {
        
            try{
                String sqlCheck = "select count(MSSV) from SINHVIEN where MSSV=?";
                PreparedStatement p =conn.prepareStatement(sqlCheck);
                p.setString(1, MSSVadd);
                ResultSet rCheck=p.executeQuery();
                while(rCheck.next())
                {
                    if(rCheck.getInt("COUNT(MSSV)")!=0)
                    {
                        JOptionPane.showMessageDialog(null, "MSSV đã tồn tại");
                    }else{
                                    //Add Oracle
                            try{
                                String sql = "insert into SINHVIEN values(?, ?, to_date(?, 'DD/MM/YYYY'), ?, ?, ?)";
                                
                                PreparedStatement presta;
                                presta = conn.prepareStatement(sql);
                                presta.setString(1, MSSVadd);
                                presta.setString(2, Tenadd);
                                presta.setString(3, NgaySinhadd);
                                presta.setString(4, GioiTinhadd);
                                presta.setString(5, DiaChiadd);
                                presta.setString(6, MaLopadd);
                                
                                Random rd= new Random();
                                String sql1 = "insert into TAIKHOANDANGNHAP values(?, '"+1+"', 'SV')";
                                
                                PreparedStatement presta1;
                                presta1= conn.prepareStatement(sql1);
                                presta1.setString(1, MSSVadd);
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
    
    public boolean SuaDL (String MSSVadd,String Tenadd,String NgaySinhadd,String GioiTinhadd, String DiaChiadd, String MaLopadd)
    {
        try{
                String sql = "update SINHVIEN set TENSV =?, NGSINH = to_date(?,'DD/MM/YYYY'), GIOITINH = ?, NOISINH = ?, MALOP = ? where MSSV =?";
                
                PreparedStatement p;
                p = conn.prepareStatement(sql);  
                p.setString(1, Tenadd);
                p.setString(2, NgaySinhadd);
                p.setString(3, GioiTinhadd);
                p.setString(4, DiaChiadd);
                p.setString(5, MaLopadd);
                p.setString(6, MSSVadd);
                
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
    
    public boolean XoaDL (String MSSVadd)
    {
        try{
                String sql = "delete from SINHVIEN where MSSV=?";
                String sql4= "delete from TAIKHOANDANGNHAP where TENDANGNHAP= ?";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setString(1, MSSVadd);
                PreparedStatement p4= conn.prepareStatement(sql4);
                p4.setString(1, MSSVadd);
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

    public Object[] FindDL(String MSSVadd)
    {
        try{
            String sql = "select * from SINHVIEN where MSSV=?";                    
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, MSSVadd);
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
                Object arr[] = {
                    rs.getString("MSSV"),rs.getString("TENSV"),B,rs.getString("GIOITINH"),
                    rs.getString("NOISINH"),rs.getString("MALOP")
                };
                return arr;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<SinhVien> ListDL()
    {
        try{
            ArrayList<SinhVien> arrListSV =new ArrayList<SinhVien>();
            String sqlList = "select * from SINHVIEN";
            PreparedStatement pstm = conn.prepareStatement(sqlList);
            ResultSet res = pstm.executeQuery();            
            while(res.next()){
                java.util.Date date = res.getDate("NGSINH");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Object A = sdf.format(date);
                SinhVien sv=new SinhVien();
                sv.setMssv(res.getString("MSSV"));
                sv.setTenSV(res.getString("TENSV"));
                sv.setGioiTinh(res.getString("GIOITINH"));
                sv.setNgaysinh(A.toString());
                sv.setNoisinh(res.getString("NOISINH"));
                sv.setMaLop(res.getString("MALOP"));
                arrListSV.add(sv);
            }
            return arrListSV;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }        
    }
    
    public SinhVien AddTextField(){
        SinhVien A = new SinhVien();
        
        A.setMssv(DangNhapUI.setLayTaiKhoan());
        
        try{
            String sql = "select * from SINHVIEN where MSSV='"+DangNhapUI.setLayTaiKhoan()+"'";
            
            PreparedStatement p = conn.prepareStatement(sql);

            
            ResultSet rs = p.executeQuery();

            
            if(rs.next())
            {
                A.setTenSV(rs.getString("TENSV"));
                A.setGioiTinh(rs.getString("GIOITINH"));
                A.setMaLop(rs.getString("MALOP"));
                A.setNoisinh(rs.getString("NOISINH"));
                Calendar cal = Calendar.getInstance();    
                Date date = rs.getDate("NGSINH");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                A.setNgaysinh(sdf.format(date).toString());
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