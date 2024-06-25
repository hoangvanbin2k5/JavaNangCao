package Models;

public class KhachHang {
	private String maKh, tenKh, diaChi;
	
	public KhachHang() {
		
	}

	public KhachHang(String maKh, String tenKh, String diaChi) {
		this.maKh = maKh;
		this.tenKh = tenKh;
		this.diaChi = diaChi;
	}

	public String getMaKh() {
		return maKh;
	}

	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "KhachHang [maKh=" + maKh + ", tenKh=" + tenKh + ", diaChi=" + diaChi + "]";
	}
}
