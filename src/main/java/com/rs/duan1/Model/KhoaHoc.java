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
}
