package Class;

import java.io.Serializable;

public class GiangVien implements Serializable {
	private String maGV;
	private String tenGV;
        private String HocVi;
        private String NgaySinh;
        private String NgayVL;
        private String Gioitinh;
        private String HeSoLuong;
        private String MucLuong;

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public void setHocVi(String HocVi) {
        this.HocVi = HocVi;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setNgayVL(String NgayVL) {
        this.NgayVL = NgayVL;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public void setHeSoLuong(String HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }

    public void setMucLuong(String MucLuong) {
        this.MucLuong = MucLuong;
    }

    public String getMaGV() {
        return maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public String getHocVi() {
        return HocVi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getNgayVL() {
        return NgayVL;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public String getHeSoLuong() {
        return HeSoLuong;
    }

    public String getMucLuong() {
        return MucLuong;
    }
}