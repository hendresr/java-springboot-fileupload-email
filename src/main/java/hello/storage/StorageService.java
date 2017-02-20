package hello.storage;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();
	
	Stream<Path> loadAll();
	
	void store(MultipartFile file);
	
	Path load(String filename);

    Resource loadAsResource(String filename);

	void deleteAll();
}
