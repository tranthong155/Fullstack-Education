package com.rs.duan1.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "khoahocchinh")
@Data
public class KhoaHocChinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKhoaHocChinh;
    private String tenKHC;

    @OneToMany(mappedBy = "khoaHocChinh")  // khớp với tên thuộc tính trong KhoaHoc
    private Set<KhoaHoc> khoaHocs;

	public KhoaHocChinh(Long idKhoaHocChinh, String tenKHC, Set<KhoaHoc> khoaHocs) {
		super();
		this.idKhoaHocChinh = idKhoaHocChinh;
		this.tenKHC = tenKHC;
		this.khoaHocs = khoaHocs;
	}

	public KhoaHocChinh() {
		super();
	}

	public Long getIdKhoaHocChinh() {
		return idKhoaHocChinh;
	}

	public void setIdKhoaHocChinh(Long idKhoaHocChinh) {
		this.idKhoaHocChinh = idKhoaHocChinh;
	}

	public String getTenKHC() {
		return tenKHC;
	}

	public void setTenKHC(String tenKHC) {
		this.tenKHC = tenKHC;
	}

	public Set<KhoaHoc> getKhoaHocs() {
		return khoaHocs;
	}

	public void setKhoaHocs(Set<KhoaHoc> khoaHocs) {
		this.khoaHocs = khoaHocs;
	}
    
    
    
    
}
