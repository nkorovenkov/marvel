package marvel.com.marvel.mapper;


import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class DtoConverter {

    private final ModelMapper modelMapper;

    public <T> T simpleConvert(Object obj, Class<T> clazz) {
        return modelMapper.map(obj, clazz);
    }

    public <T> List<T> simpleConvert(List<?> entitiesList, Class<T> clazz) {
        return entitiesList.stream().map(x -> simpleConvert(x, clazz)).collect(Collectors.toList());
    }

    public <T> Page<T> simpleConvert(Page<?> entitiesList, Class<T> clazz) {
        return new PageImpl<>(entitiesList.stream().map(x -> simpleConvert(x, clazz)).collect(Collectors.toList()));
    }
}
