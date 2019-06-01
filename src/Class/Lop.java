package Class;

public class Lop {
private String maLop;

public String getMaLop() {
	return maLop;
}

public void setMaLop(String maLop) {
	this.maLop = maLop;
}

public String getMaGV() {
	return maGV;
}

public void setMaGV(String maGV) {
	this.maGV = maGV;
}

private String maGV;

@Override
public String toString() {
	return this.maLop;
}
}