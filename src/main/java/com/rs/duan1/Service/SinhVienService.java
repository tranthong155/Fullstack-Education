package com.rs.duan1.Service;

import com.rs.duan1.Model.MonHoc;
import com.rs.duan1.Model.SinhVien;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface SinhVienService {
    SinhVien saveUser(SinhVien sinhVien);
    SinhVien findBySVId(Long khoaHocId);
    Boolean updateMK(SinhVien sinhVien);



}
