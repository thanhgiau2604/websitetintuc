package myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbtintuc")
public class TinTuc {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matintuc", nullable = false)
	private String matintuc;
	
	@Column(name = "tieude")
	private String tieude;
	
	@Column(name = "anh")
	private String anh;
	
	@Column(name = "noidung")
	private String noidung;
	
	
	@Column(name = "ngay")
	private String ngay;
	
	@Column(name = "tacgia")
	private String tacgia;

	@Column(name = "luotxem")
	private int luotxem;
	
	public TinTuc() {
	}

	public TinTuc(String matintuc, String tieude, String anh, String noidung, String ngay,
			String tacgia, int luotxem) {
		super();
		this.matintuc = matintuc;
		this.tieude = tieude;
		this.anh = anh;
		this.noidung = noidung;
		this.ngay = ngay;
		this.tacgia = tacgia;
		this.luotxem = luotxem;
	}

	public String getMatintuc() {
		return matintuc;
	}

	public void setMatintuc(String matintuc) {
		this.matintuc = matintuc;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public int getLuotxem() {
		return luotxem;
	}

	public void setLuotxem(int luotxem) {
		this.luotxem = luotxem;
	}

	
}
