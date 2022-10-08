package marvel.com.marvel.repositories;

import java.util.Optional;

import marvel.com.marvel.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
    Optional<Privilege> findByName(String name);
}
