package marvel.com.marvel.services;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import marvel.com.marvel.dto.ComicsDtoIn;
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
public class ComicsService {

    private final ComicsRepository comicsRepository;
    private final CharacterRepository characterRepository;

    public Page<ComicsEntity> getAllComics(Pageable pageable) {
        return comicsRepository.findAll(pageable);
    }

    public ComicsEntity getComicsById(Long id) {
        return comicsRepository.findById(id)
            .orElseThrow(() -> new MarvelException(HttpStatus.NOT_FOUND, "Cannot find comics with id = " + id));
    }

    public Page<CharacterEntity> getCharactersThatHaveComicsById(Long id, Pageable pageable) {
        return characterRepository.findAllByComics(getComicsById(id), pageable);
    }

    public ComicsEntity createNewComics(ComicsDtoIn comicsDto) {
        return comicsRepository.save(new ComicsEntity(comicsDto));
    }

    public ComicsEntity changeComicsById(Long id, ComicsDtoIn comicsDto) {
        ComicsEntity comics = getComicsById(id);
        comics.setTitle(comicsDto.getTitle());
        comics.setCharacters(comicsDto.getCharacters().stream().map(characterId -> characterRepository.findById(characterId).orElseThrow(
            () -> new MarvelException(HttpStatus.NOT_FOUND, "Cannot find character with id = " + id))).collect(Collectors.toList()));
        return comicsRepository.save(comics);
    }
}
