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
}
