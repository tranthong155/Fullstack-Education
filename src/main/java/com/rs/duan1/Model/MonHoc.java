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





}
