package Models;

public class GiaCa {
	private String maSP, tenSP;
	private float giaTien;
	
	public GiaCa() {
		
	}

	public GiaCa(String maSP, String tenSP, float giaTien) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaTien = giaTien;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public float getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(float giaTien) {
		this.giaTien = giaTien;
	}

	@Override
	public String toString() {
		return "GiaCa [maSP=" + maSP + ", tenSP=" + tenSP + ", giaTien=" + giaTien + "]";
	}
}
