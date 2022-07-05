package marvel.com.marvel.repositories;

import marvel.com.marvel.entities.CharacterEntity;
import marvel.com.marvel.entities.ComicsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicsRepository extends JpaRepository<ComicsEntity, Long> {

    Page<ComicsEntity> findAllByCharacters(CharacterEntity character, Pageable pageable);
}
