package com.mediqal.community.controller;

import com.mediqal.community.domain.vo.UserImgVO;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/userImg/*")
public class UserImgController {
    @PostMapping("/upload")
    public List<UserImgVO> upload(List<MultipartFile> upload) throws IOException {
        String rootPath = "C:/upload";
        String uploadPath = getUploadPath();
        List<UserImgVO> files = new ArrayList<>();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        for(MultipartFile multipartFile : upload){
            UserImgVO userImgVO = new UserImgVO();
            UUID uuid = UUID.randomUUID();
            String fileName = multipartFile.getOriginalFilename();
            String uploadFileName = uuid.toString() + "_" + fileName;

            userImgVO.setUserImgName(fileName);
            userImgVO.setUserImgUuid(uuid.toString());
            userImgVO.setUserImgUploadPath(getUploadPath());
            userImgVO.setUserImgSize(multipartFile.getSize());

            File fullPath = new File(uploadFullPath, uploadFileName);
            multipartFile.transferTo(fullPath);

            if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), out, 100, 100);
                out.close();
                userImgVO.setUserImgImageCheck(true);
            }

            files.add(userImgVO);
        }
        return files;
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload", fileName));
    }

    @PostMapping("/delete")
    public void delete(UserImgVO userImgVO) {
        File file = new File("C:/upload", userImgVO.getUserImgUploadPath() + "/" + userImgVO.getUserImgName());
        if(file.exists()){
            file.delete();
        }
        if(userImgVO.isUserImgImageCheck()){
            file = new File("C:/upload", userImgVO.getUserImgUploadPath() + "/s_" + userImgVO.getUserImgName());
            if(file.exists()){
                file.delete();
            }
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
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
