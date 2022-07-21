package marvel.com.marvel.entities;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;
import marvel.com.marvel.dto.ComicsDtoIn;

@Table(name = "comics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ComicsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "comics")
    @Exclude
    private List<CharacterEntity> characters;

    public ComicsEntity(ComicsDtoIn comicsDto) {
        setTitle(comicsDto.getTitle());
    }

    @Override
    public String toString() {
        return "ComicsEntity{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", characters=" + characters +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComicsEntity comics = (ComicsEntity) o;
        return Objects.equals(id, comics.id) && Objects.equals(title, comics.title) && Objects.equals(characters,
            comics.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, characters);
    }
}
