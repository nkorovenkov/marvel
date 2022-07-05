package marvel.com.marvel.controllers;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import marvel.com.marvel.entities.ImageEntity;
import marvel.com.marvel.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ImageController {

    private final ImageRepository imageRepository;

    @PostMapping
    public Long uploadImage(@RequestParam MultipartFile multipartImage) throws IOException {
        ImageEntity image = new ImageEntity();
        image.setName(multipartImage.getName());
        image.setBites(multipartImage.getBytes());
        return imageRepository.save(image).getId();
    }

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ByteArrayResource downloadImage(@PathVariable Long imageId) {
        byte[] image = imageRepository.findById(imageId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getBites();
        return new ByteArrayResource(image);
    }
}
