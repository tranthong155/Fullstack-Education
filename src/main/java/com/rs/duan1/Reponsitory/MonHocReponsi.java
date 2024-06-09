package com.rs.duan1.Reponsitory;

import com.rs.duan1.Model.KhoaHoc;
import com.rs.duan1.Model.MonHoc;
import com.rs.duan1.Model.SinhVien;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MonHocReponsi extends JpaRepository<MonHoc, Long> {
    @Query("SELECT c FROM MonHoc c WHERE c.KhoaHoc = :keyword")
    List<MonHoc> showList(@Param("keyword") KhoaHoc keyword);


    @Modifying
    @Transactional
    @Query("DELETE FROM MonHoc Mh WHERE Mh.KhoaHoc.idKhoaHoc = :keyword")
    void deleteByKhoaHocId(@Param("keyword") Long keyword);












}
