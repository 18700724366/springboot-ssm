package xian.woniuxy.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String upload(MultipartFile file, String dir) throws IOException;
    void delete(String path);
}
