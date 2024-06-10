package com.rs.duan1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "monhoc")
@Data
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMonHoc;
    private String tenMH;
    private String chiTiet;
    private String videos;

    @ManyToOne
    @JoinColumn(name = "KhoaHoc",referencedColumnName = "idKhoaHoc")
    private KhoaHoc KhoaHoc;

	public MonHoc(Long idMonHoc, String tenMH, String chiTiet, String videos, com.rs.duan1.Model.KhoaHoc khoaHoc) {
		super();
		this.idMonHoc = idMonHoc;
		this.tenMH = tenMH;
		this.chiTiet = chiTiet;
		this.videos = videos;
		KhoaHoc = khoaHoc;
	}


    public MonHoc() {
		// TODO Auto-generated constructor stub
	}


	public Long getIdMonHoc() {
		return idMonHoc;
	}


	public void setIdMonHoc(Long idMonHoc) {
		this.idMonHoc = idMonHoc;
	}


	public String getTenMH() {
		return tenMH;
	}


	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}


	public String getChiTiet() {
		return chiTiet;
	}


	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}


	public String getVideos() {
		return videos;
	}


	public void setVideos(String videos) {
		this.videos = videos;
	}


	public KhoaHoc getKhoaHoc() {
		return KhoaHoc;
	}


	public void setKhoaHoc(KhoaHoc khoaHoc) {
		KhoaHoc = khoaHoc;
	}
    

}
