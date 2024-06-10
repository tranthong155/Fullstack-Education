package com.rs.duan1.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "khoahoc")
@Data
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKhoaHoc")
    private Long idKhoaHoc;
    private String tenKH;
    @Lob
    private String thongTin;
    private String img;
    private Double giaKh;
    private boolean dangKy;

    @OneToMany(mappedBy = "KhoaHoc")
    private Set<MonHoc> MonHoc;

    @ManyToOne
    @JoinColumn(name = "idKhoaHocChinh", referencedColumnName = "idKhoaHocChinh")
    private KhoaHocChinh khoaHocChinh;

    @ManyToOne
    @JoinColumn(name = "idSinhVien", referencedColumnName = "idUser")
    private SinhVien sinhVien;

    @ManyToMany(mappedBy = "courses")
    private Set<SinhVien> students = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(idKhoaHoc);
    }
    
    

	public KhoaHoc() {
		super();
	}



	public KhoaHoc(Long idKhoaHoc, String tenKH, String thongTin, String img, Double giaKh, boolean dangKy,
			Set<com.rs.duan1.Model.MonHoc> monHoc, KhoaHocChinh khoaHocChinh, SinhVien sinhVien,
			Set<SinhVien> students) {
		super();
		this.idKhoaHoc = idKhoaHoc;
		this.tenKH = tenKH;
		this.thongTin = thongTin;
		this.img = img;
		this.giaKh = giaKh;
		this.dangKy = dangKy;
		MonHoc = monHoc;
		this.khoaHocChinh = khoaHocChinh;
		this.sinhVien = sinhVien;
		this.students = students;
	}



	public Long getIdKhoaHoc() {
		return idKhoaHoc;
	}

	public void setIdKhoaHoc(Long idKhoaHoc) {
		this.idKhoaHoc = idKhoaHoc;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getGiaKh() {
		return giaKh;
	}

	public void setGiaKh(Double giaKh) {
		this.giaKh = giaKh;
	}

	public boolean isDangKy() {
		return dangKy;
	}

	public void setDangKy(boolean dangKy) {
		this.dangKy = dangKy;
	}

	public Set<MonHoc> getMonHoc() {
		return MonHoc;
	}

	public void setMonHoc(Set<MonHoc> monHoc) {
		MonHoc = monHoc;
	}

	public KhoaHocChinh getKhoaHocChinh() {
		return khoaHocChinh;
	}

	public void setKhoaHocChinh(KhoaHocChinh khoaHocChinh) {
		this.khoaHocChinh = khoaHocChinh;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public Set<SinhVien> getStudents() {
		return students;
	}

	public void setStudents(Set<SinhVien> students) {
		this.students = students;
	}
    
    
}
