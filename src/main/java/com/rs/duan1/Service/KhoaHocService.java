package com.rs.duan1.Service;

import com.rs.duan1.Model.*;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.Set;

public interface KhoaHocService {
    List<KhoaHoc> getAll();
    KhoaHoc findByKhoaHocId(Long khoaHocId);
    KhoaHoc luuKhoaHoc(KhoaHoc khoaHoc);

    List<KhoaHocChinh> getAllKhoaHocChinh();
    KhoaHocChinh findIdKHC(Long idKHC);


    Boolean create(KhoaHoc khoaHoc);


    Boolean update(KhoaHoc khoaHoc);

    Boolean delete(Long id);

    void DANGKYKhoaHoc(Long idKhoaHoc, Long idSinhVien);

    Set<KhoaHoc> getKhoaHocsBySinhVienId(Long idSinhVien);
    void HUYKhoaHoc(Long idKhoaHoc, Long idSinhVien);
    boolean isDangKyKhoaHoc(Long idKhoaHoc, Long idSinhVien);

    List<KhoaHoc> serchKhoaHoc(String keyword);
    Page<KhoaHoc> serchKhoaHocPage(String keyword, Integer pageNo);
    Page<KhoaHoc> getAllKH(Integer pageNo);



}
