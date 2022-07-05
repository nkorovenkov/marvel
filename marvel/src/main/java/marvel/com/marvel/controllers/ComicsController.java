package marvel.com.marvel.controllers;


import lombok.RequiredArgsConstructor;
import marvel.com.marvel.dto.CharacterDto;
import marvel.com.marvel.dto.ComicsDto;
import marvel.com.marvel.mapper.DtoConverter;
import marvel.com.marvel.services.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comics")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ComicsController {

    private final ComicsService comicsService;
    private final DtoConverter dtoConverter;

    @GetMapping
    public Page<ComicsDto> getAllComics(Pageable pageable) {
        return dtoConverter.simpleConvert(comicsService.getAllComics(pageable), ComicsDto.class);
    }

    @GetMapping("/{id}")
    public ComicsDto getComicsById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(comicsService.getComicsById(id), ComicsDto.class);
    }

    @GetMapping("/{id}/characters")
    public Page<CharacterDto> getCharactersThatHaveComicsById(@PathVariable Long id, Pageable pageable) {
        return dtoConverter.simpleConvert(comicsService.getCharactersThatHaveComicsById(id, pageable), CharacterDto.class);
    }
}
