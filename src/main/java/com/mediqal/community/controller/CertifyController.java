package com.mediqal.community.controller;

import com.mediqal.community.domain.vo.CertifyVO;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/certify/*")
public class CertifyController {
    @PostMapping("/upload")
    public List<CertifyVO> upload(List<MultipartFile> upload) throws IOException {
        String rootPath = "C:/upload/certify";
        String uploadPath = getUploadPath();
        List<CertifyVO> files = new ArrayList<>();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        for(MultipartFile multipartFile : upload){
            CertifyVO certifyVO = new CertifyVO();
            UUID uuid = UUID.randomUUID();
            String fileName = multipartFile.getOriginalFilename();
            String uploadFileName = uuid.toString() + "_" + fileName;

            certifyVO.setCertifyName(fileName);
            certifyVO.setCertifyUuid(uuid.toString());
            certifyVO.setCertifyUploadPath(getUploadPath());
            certifyVO.setCertifySize(multipartFile.getSize());

            File fullPath = new File(uploadFullPath, uploadFileName);
            multipartFile.transferTo(fullPath);

            if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), out, 100, 100);
                out.close();
                certifyVO.setCertifyImageCheck(true);
            }

            files.add(certifyVO);
        }
        return files;
    }

    @GetMapping("/display")
    public byte[] display(String certifyName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/certify", certifyName));
    }

    @PostMapping("/delete")
    public void delete(CertifyVO certifyVO) {
        File file = new File("C:/upload/certify", certifyVO.getCertifyUploadPath() + "/" + certifyVO.getCertifyName());
        if(file.exists()){
            file.delete();
        }
        if(certifyVO.isCertifyImageCheck()){
            file = new File("C:/upload/certify", certifyVO.getCertifyUploadPath() + "/s_" + certifyVO.getCertifyName());
            if(file.exists()){
                file.delete();
            }
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String certifyName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/certify/" + certifyName);
        HttpHeaders header = new HttpHeaders();
        String name = resource.getFilename();
        name = name.substring(name.indexOf("_") + 1);
        header.add("Content-Disposition", "attachment;filename=" + new String(name.getBytes(), "UTF-8"));
        return new ResponseEntity<>(resource, header, HttpStatus.OK);
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
