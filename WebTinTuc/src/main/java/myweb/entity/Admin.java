package myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "dbadmin")
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tendangnhap", nullable = false)
    private String tendangnhap;
	
	@Column(name = "matkhau")
    private String matkhau;
	
	@Column(name = "hoten")
    private String hoten;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "sdt")
    private String sdt;
	
	@Column(name = "diachi")
    private String diachi;

	public Admin() {

	}

	public Admin(String tendangnhap, String matkhau, String hoten, String email, String sdt, String diachi) {
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.hoten = hoten;
		this.email = email;
		this.sdt = sdt;
		this.diachi = diachi;
	}

	public String gettendangnhap() {
		return tendangnhap;
	}

	public void settendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getmatkhau() {
		return matkhau;
	}

	public void setmatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String gethoten() {
		return hoten;
	}

	public void sethoten(String hoten) {
		this.hoten = hoten;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getsdt() {
		return sdt;
	}

	public void setsdt(String sdt) {
		this.sdt = sdt;
	}

	public String getdiachi() {
		return diachi;
	}

	public void setdiachi(String diachi) {
		diachi = diachi;
	}
}
