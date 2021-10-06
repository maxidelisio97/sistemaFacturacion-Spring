package ar.maxidelisio.app.jpa.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	//obtiene la ruta absoluta con el getPath, crea un UrlResource y lo devuelve
	@Override
	public Resource load(String filename) throws MalformedURLException {

		Path rootPath = getPath(filename);

		Resource resource = null;
		try {
			resource = new UrlResource(rootPath.toUri());

			if (!resource.exists() || !resource.isReadable()) {

				throw new RuntimeException("Error: no se puede cargar la imagen " + rootPath.toString());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return resource;
	}

	
	@Override
	public boolean delete(String filename) {
		
		Path rootPath = getPath(filename);
		
		File archivo = rootPath.toFile();
		
		//si el archivo existe y se puede leer = true
		if(archivo.exists() && archivo.canRead()) {
			//si el archivo fue borrado = true , si no false			
			if(archivo.delete()) {
				return true;
			}
		}

		return false;
	}

	
	@Override
	public String copy(MultipartFile file) throws IOException {		

		// Obtiene el nombre de la foto y con randomUUID genera un nombre largo para que
		// no pueda ser repetido por otra foto
		String nombreDeArchivoUnico = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

		// con el metodo getPath obtiene la ruta absoluta
		Path rootPath = getPath(nombreDeArchivoUnico);

		//copia la foto obtenida por la ruta
		Files.copy(file.getInputStream(), rootPath);

		return nombreDeArchivoUnico;
	}

	public Path getPath(String filename) {

		return Paths.get("uploads").resolve(filename).toAbsolutePath();

	}


	//Borra la carpeta "uploads"
	@Override
	public void deleteAll() {
		
		FileSystemUtils.deleteRecursively(Paths.get("uploads").toFile());
	}


	//Crea el directorio "uploads"
	@Override
	public void init() throws IOException {
		
		Files.createDirectory(Paths.get("uploads"));
		
	}

}
