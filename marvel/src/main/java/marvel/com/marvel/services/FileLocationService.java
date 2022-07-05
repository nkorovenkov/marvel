package marvel.com.marvel.services;

import lombok.RequiredArgsConstructor;
import marvel.com.marvel.entities.ImageEntity;
import marvel.com.marvel.repositories.FileSystemRepository;
import marvel.com.marvel.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FileLocationService {

    private final FileSystemRepository fileSystemRepository;
    private final ImageRepository imageDbRepository;

    public Long createImage(byte[] bytes, String imageName) throws Exception {
        String location = fileSystemRepository.save(bytes, imageName);
        return imageDbRepository.save(new ImageEntity(location, bytes, imageName)).getId();
    }

   public FileSystemResource getImageById(Long imageId) {
        ImageEntity image = imageDbRepository.findById(imageId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return fileSystemRepository.findInFileSystem(image.getLocation());
    }
}