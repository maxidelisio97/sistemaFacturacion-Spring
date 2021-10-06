package ar.maxidelisio.app.jpa.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Resource load(String filename) throws MalformedURLException;
	
	public boolean delete(String filename);
	
	public String copy(MultipartFile file) throws IOException;
	
	public void deleteAll();
	
	public void init() throws IOException;
	
}
