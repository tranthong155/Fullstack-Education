package com.rs.duan1.Service;

import com.rs.duan1.Model.MonHoc;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface MonHocService {
    List<MonHoc> getAllMonHoc();
    MonHoc findByMonHocId(Long khoaHocId);
    Boolean create(MonHoc monHoc);


    Boolean update(MonHoc monHoc);
    Boolean delete(Long id);

    MonHoc uploadVideo(String path, MultipartFile file) throws IOException;

    InputStream getResource(String path, String fileName , int id) throws FileNotFoundException;
}
