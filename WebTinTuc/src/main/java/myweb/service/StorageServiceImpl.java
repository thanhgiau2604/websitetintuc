package myweb.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.System;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import myweb.service.StorageService;;

@Service
public class StorageServiceImpl implements StorageService {

	private final Path rootLocation = Paths.get("src/main/resources/static/storage_image");

	InputStream stream = this.getClass().getClassLoader().
            getResourceAsStream("storage_image");
	@Override
	public void store(MultipartFile file) throws IOException {

		System.out.print("stream= "+stream);
		try
		{
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		}
		catch (Exception e)
		{
			return;
		}	
    }
}
