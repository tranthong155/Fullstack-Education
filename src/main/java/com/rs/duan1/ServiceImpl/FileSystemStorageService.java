package com.rs.duan1.ServiceImpl;

import com.rs.duan1.Service.StorageSevrice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService  implements StorageSevrice {

    private final Path rootLocation ;

    public FileSystemStorageService() {
        this.rootLocation = Paths.get("src/main/resources/static/upload/hinhAnh");
    }


    @Override
    public void init() {
        // TODO Auto-generated method stub
        try {
            Files.createDirectories(rootLocation);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile , StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
