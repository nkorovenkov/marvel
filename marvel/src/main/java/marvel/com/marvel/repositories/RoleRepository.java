package marvel.com.marvel.repositories;

import java.util.Optional;
import marvel.com.marvel.entities.ERole;
import marvel.com.marvel.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(ERole name);
}
