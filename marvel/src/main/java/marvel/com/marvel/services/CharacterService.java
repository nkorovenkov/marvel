package marvel.com.marvel.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marvel.com.marvel.dto.CharacterDtoIn;
import marvel.com.marvel.entities.CharacterEntity;
import marvel.com.marvel.entities.ComicsEntity;
import marvel.com.marvel.entities.ImageEntity;
import marvel.com.marvel.exceptions.MarvelException;
import marvel.com.marvel.repositories.CharacterRepository;
import marvel.com.marvel.repositories.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final ComicsRepository comicsRepository;


    public Page<CharacterEntity> getAllCharacters(Pageable pageable) {
        return characterRepository.findAll(pageable);
    }

    public CharacterEntity getCharacterById(Long id) {
        return characterRepository.findById(id)
            .orElseThrow(() -> new MarvelException(HttpStatus.NOT_FOUND, "Cannot find character with id = " + id));
    }

//    public CharacterEntity createCharacter(CharacterDtoIn characterDto) throws IOException {
//        CharacterEntity character = new CharacterEntity(characterDto);
//        MultipartFile file = characterDto.getImage();
//        if (file.getSize() != 0) {
//            ImageEntity image = toImageEntity(file);
//            character.setImage(image);
//        }
//        log.info("Create new character: {}", character.getName());
//        return characterRepository.save(character);
//    }
//
//    private ImageEntity toImageEntity(MultipartFile file) throws IOException {
//        ImageEntity image = new ImageEntity();
//        List<Byte> list = new ArrayList<>();
//        for (Byte one_byte : file.getBytes()) {
//            list.add(one_byte);
//        }
//        return image;
//    }

    public Page<ComicsEntity> getComicsThatHaveCharacterById(Long id, Pageable pageable) {
        return comicsRepository.findAllByCharacters(getCharacterById(id), pageable);
    }
}
