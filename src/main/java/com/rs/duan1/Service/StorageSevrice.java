package com.rs.duan1.Service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageSevrice {
    void init();
    void  store(MultipartFile file);
}
