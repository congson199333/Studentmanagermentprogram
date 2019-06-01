package Class;

public class SinhVien {
	private String mssv;
	private String tenSV ;
        private String ngaySinh;
        private String noiSinh;   
	private String maLop ;
	private String gioiTinh;
	//private String maKhoa;
        
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/*public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}*/
        public String getNgaysinh(){
            return ngaySinh;
        }
        public void setNgaysinh(String ngaysinh){
            this.ngaySinh=ngaysinh;
        }
        public String getNoisinh(){
            return this.noiSinh;
        }
        public void setNoisinh(String noisinh)
        {
            this.noiSinh=noisinh;
        }
        private float diemQT;
	private float diemTH;
	private float diemGK;
	private float diemCK;
	
	private float diemTB ;
	public float getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}
	public float getDiemQT() {
		return diemQT;
	}
	public void setDiemQT(float diemQT) {
		this.diemQT = diemQT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	public float getDiemGK() {
		return diemGK;
	}
	public void setDiemGK(float diemGK) {
		this.diemGK = diemGK;
	}
	public float getDiemCK() {
		return diemCK;
	}
	public void setDiemCK(float diemCK) {
		this.diemCK = diemCK;
	}
	
	public SinhVien() {
		super();
	}

	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	
}