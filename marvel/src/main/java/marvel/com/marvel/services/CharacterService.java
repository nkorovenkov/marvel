package marvel.com.marvel.services;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marvel.com.marvel.dto.CharacterDtoIn;
import marvel.com.marvel.entities.CharacterEntity;
import marvel.com.marvel.entities.ComicsEntity;
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

    public Page<ComicsEntity> getComicsThatHaveCharacterById(Long id, Pageable pageable) {
        return comicsRepository.findAllByCharacters(getCharacterById(id), pageable);
    }


    public CharacterEntity createNewCharacter(CharacterDtoIn characterDto) {
        return characterRepository.save(new CharacterEntity(characterDto));
    }

    public CharacterEntity changeCharacterById(Long id, CharacterDtoIn characterDto) {
        CharacterEntity characterEntity = getCharacterById(id);
        characterEntity.setName(characterDto.getName());
        characterEntity.setComics(characterDto.getComics().stream().map(comicsId -> comicsRepository.findById(comicsId)
                .orElseThrow(() -> new MarvelException(HttpStatus.NOT_FOUND, "Cannot find comics with id = " + comicsId)))
            .collect(Collectors.toList()));
        return characterRepository.save(characterEntity);
    }
}
