package com.spring.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomFileUtil {
    @Value("${com.spring.upload.path}")
    private String uploadPath;

    @PostConstruct
    public void init() {
        File tempFolder = new File(uploadPath);

        if (tempFolder.exists() == false) {
            tempFolder.mkdir();
        }
        uploadPath = tempFolder.getAbsolutePath();

        log.info("-------------------------------------");
        log.info(uploadPath);
    }

	/* 파일 업로드만
	public String saveFile(MultipartFile file) throws RuntimeException {
		if (file == null) { return null;}

		String savedName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path savePath = Paths.get(uploadPath, savedName);

		try {
			Files.copy(file.getInputStream(), savePath);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return savedName;
	} */

    /* 썸네일 이미지 및 파일 업로드  */
    public String saveFile(MultipartFile file) throws RuntimeException {
        if (file == null) { return null; }

        String savedName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path savePath = Paths.get(uploadPath, savedName);

        try {
            Files.copy(file.getInputStream(), savePath);
            String contentType = file.getContentType();

            // 이미지여부 확인
            if (contentType != null && contentType.startsWith("image")) {
                Path thumbnailPath = Paths.get(uploadPath, "s_" + savedName);
                Thumbnails.of(savePath.toFile()).size(200, 133).toFile(thumbnailPath.toFile());
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return savedName;
    }

    /* 업로드 파일 보여주기 위한 메서드 정의 - getFile() 추가 */

}