package xian.woniuxy.service.impl;


import xian.woniuxy.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class LocalFileServiceImpl implements FileService {

    @Override
    public String upload(MultipartFile file, String dir) throws IOException {
        File dirFile = mkdir(dir);
        String newFileName = getNewFileName(file);
        doupload(file, dirFile, newFileName);
        return newFileName;
    }

    @Override
    public void delete(String path) {
        File file = new File(path);
        file.delete();
    }

    private static void doupload(MultipartFile file, File dirFile, String newFileName) throws IOException {
        file.transferTo(new File(dirFile, newFileName));
    }

    private static String getNewFileName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        int lastDotIndex = originalFilename.lastIndexOf('.');
        String ext = originalFilename.substring(lastDotIndex);
        String newFileName = UUID.randomUUID().toString() + ext;
        return newFileName;
    }

    private static File mkdir(String dir) {
        File dirFile = new File(dir);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        return dirFile;
    }
}
