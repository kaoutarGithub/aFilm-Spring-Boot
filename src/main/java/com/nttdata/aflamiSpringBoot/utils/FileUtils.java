package com.nttdata.aflamiSpringBoot.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	public static void saveFile(String uploadDir,String fileName,MultipartFile file) throws IOException {
		String userDir=Paths.get("")
				.toAbsolutePath().toString();
		Path uploadPath=Paths.get(userDir+uploadDir);
		if(!Files.exists(uploadPath))
			Files.createDirectories(uploadPath);
		
		Path filePath=uploadPath.resolve(fileName);
		System.out.println("******************************"+filePath
				+"**************************************");
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}
}
