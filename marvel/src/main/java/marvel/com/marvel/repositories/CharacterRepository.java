package marvel.com.marvel.repositories;


import marvel.com.marvel.entities.CharacterEntity;

import marvel.com.marvel.entities.ComicsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends PagingAndSortingRepository<CharacterEntity,Long> {
    Page<CharacterEntity> findAllByComics(ComicsEntity comics, Pageable pageable);
}
