package Models;

public class LichSan {
	private String hoVaTen, ngay, thoiGianDa, thoiGianKetThuc;
	
	public LichSan() {
		
	}

	public LichSan(String hoVaTen, String ngay, String thoiGianDa, String thoiGianKetThuc) {
		this.hoVaTen = hoVaTen;
		this.ngay = ngay;
		this.thoiGianDa = thoiGianDa;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getThoiGianDa() {
		return thoiGianDa;
	}

	public void setThoiGianDa(String thoiGianDa) {
		this.thoiGianDa = thoiGianDa;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	@Override
	public String toString() {
		return "LichSan [hoVaTen=" + hoVaTen + ", thoiGianDa=" + thoiGianDa + ", thoiGianKetThuc=" + thoiGianKetThuc
				+ ", ngay=" + ngay + "]";
	}
}
