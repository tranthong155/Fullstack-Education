package com.rs.duan1.Reponsitory;

import com.rs.duan1.Model.KhoaHoc;
import com.rs.duan1.Model.KhoaHocChinh;
import com.rs.duan1.Model.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KhoaHocReponsi extends JpaRepository<KhoaHoc, Long> {
    @Query("SELECT c FROM KhoaHoc c WHERE c.khoaHocChinh = :keyword")
    List<KhoaHoc> showListKH(@Param("keyword") KhoaHocChinh keyword);

    @Query("SELECT c FROM KhoaHoc c WHERE c.tenKH LIKE %?1%")
    List<KhoaHoc> serchKhoaHocRps(String keyword);







}
