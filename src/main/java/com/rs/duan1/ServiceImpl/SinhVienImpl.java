package com.rs.duan1.ServiceImpl;

import com.rs.duan1.Model.SinhVien;
import com.rs.duan1.Reponsitory.SinhVienReponsi;
import com.rs.duan1.Service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class SinhVienImpl implements SinhVienService {
    @Autowired
    private SinhVienReponsi sinhVienReponsi;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public SinhVien saveUser(SinhVien sinhVien) {

//        sinhVien.setChucVu("ROLE_USER");
        sinhVien.setMatKhauCu(sinhVien.getPassword());
        String encodePassword = passwordEncoder.encode(sinhVien.getPassword());
        sinhVien.setPassword(encodePassword);
        SinhVien saveUser = sinhVienReponsi.save(sinhVien);
        return saveUser;
    }

    @Override
    public SinhVien findBySVId(Long khoaHocId) {
        return this.sinhVienReponsi.findById(khoaHocId).orElse(null);
    }

    @Override
    public Boolean updateMK(SinhVien sinhVien) {
        try {
            this.sinhVienReponsi.save(sinhVien);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
