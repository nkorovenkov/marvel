package marvel.com.marvel.controllers;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import marvel.com.marvel.dto.CharacterDto;
import marvel.com.marvel.dto.CharacterDtoIn;
import marvel.com.marvel.dto.ComicsDto;
import marvel.com.marvel.mapper.DtoConverter;
import marvel.com.marvel.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CharacterController {

    private final CharacterService characterService;
    private final DtoConverter dtoConverter;


    @GetMapping
    public Page<CharacterDto> getAllCharacters(Pageable pageable) {
        return dtoConverter.simpleConvert(characterService.getAllCharacters(pageable), CharacterDto.class);
    }

    @GetMapping("/{id}")
    public CharacterDto getCharacterById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(characterService.getCharacterById(id), CharacterDto.class);
    }

    @GetMapping("/{id}/comics")
    public Page<ComicsDto> getComicsThatHaveCharacterById(@PathVariable Long id, Pageable pageable) {
        return dtoConverter.simpleConvert(characterService.getComicsThatHaveCharacterById(id, pageable), ComicsDto.class);
    }

//    @PostMapping
//    public CharacterDto createCharacter(@RequestBody CharacterDtoIn characterDto) throws IOException {
//        return dtoConverter.simpleConvert(characterService.createCharacter(characterDto), CharacterDto.class);
//    }
}
