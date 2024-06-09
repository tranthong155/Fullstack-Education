package com.rs.duan1.ServiceImpl;

import com.rs.duan1.Model.MonHoc;
import com.rs.duan1.Reponsitory.MonHocReponsi;
import com.rs.duan1.Service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class MonHocImpl implements MonHocService {
    @Autowired
    private MonHocReponsi monHocReponsi;

    @Override
    public List<MonHoc> getAllMonHoc() {
        return this.monHocReponsi.findAll();
    }

    @Override
    public MonHoc findByMonHocId(Long khoaHocId) {
        return this.monHocReponsi.findById(khoaHocId).orElse(null);
    }

    @Override
    public Boolean create(MonHoc monHoc) {
        try {
            this.monHocReponsi.save(monHoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(MonHoc monHoc) {
        try {

            this.monHocReponsi.save(monHoc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.monHocReponsi.delete(findByMonHocId(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public MonHoc uploadVideo(String path, MultipartFile file) throws IOException {
        MonHoc fileModel = new MonHoc();
        //Fetch file original name .
        String fileName = file.getOriginalFilename();
        //try to generate random file name .
        String randomId = UUID.randomUUID().toString();
        String finalName = randomId.concat(fileName.substring(fileName.indexOf(".")));

        //File full path .
        String filePath = path + File.separator + finalName ;

        //Create folder to store file .you can create any where you want .
        File f = new File(path);
        if(!f.exists()) {
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));

        fileModel.setVideos(finalName);

        return fileModel;
    }

    @Override
    public InputStream getResource(String path, String fileName, int id) throws FileNotFoundException {
        String fullPath = path+File.separator+fileName ;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream ;
    }

}
