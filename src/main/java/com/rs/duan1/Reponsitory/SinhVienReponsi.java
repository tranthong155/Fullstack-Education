package com.rs.duan1.Reponsitory;

import com.rs.duan1.Model.KhoaHoc;
import com.rs.duan1.Model.KhoaHocChinh;
import com.rs.duan1.Model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SinhVienReponsi extends JpaRepository<SinhVien, Long> {
    public SinhVien findByUserName(String userName);


    @Query("SELECT c FROM SinhVien c WHERE c.email = :keyword")
    SinhVien SVByEmail(@Param("keyword") String keyword);


}
