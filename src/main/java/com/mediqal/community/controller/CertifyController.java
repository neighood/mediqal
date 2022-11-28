package com.mediqal.community.controller;

import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/certify/*")
public class CertifyController {
    /*@PostMapping("/upload")
    public List<FileVO> upload(List<MultipartFile> upload) throws IOException {
        String rootPath = "C:/upload";
        String uploadPath = getUploadPath();
        List<FileVO> files = new ArrayList<>();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        for(MultipartFile multipartFile : upload){
            FileVO fileVO = new FileVO();
            UUID uuid = UUID.randomUUID();
            String fileName = multipartFile.getOriginalFilename();
            String uploadFileName = uuid.toString() + "_" + fileName;

            fileVO.setFileName(fileName);
            fileVO.setFileUuid(uuid.toString());
            fileVO.setFileUploadPath(getUploadPath());
            fileVO.setFileSize(multipartFile.getSize());

            File fullPath = new File(uploadFullPath, uploadFileName);
            multipartFile.transferTo(fullPath);

            if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), out, 100, 100);
                out.close();
                fileVO.setFileImageCheck(true);
            }

            files.add(fileVO);
        }
        return files;
    }*/
}
