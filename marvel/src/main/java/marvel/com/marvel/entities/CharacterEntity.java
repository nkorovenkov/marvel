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
import marvel.com.marvel.dto.CharacterDtoIn;

@Table(name = "`character`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @Exclude
    private List<ComicsEntity> comics;

    public CharacterEntity(CharacterDtoIn characterDto) {
        setName(characterDto.getName());
    }

    @Override
    public String toString() {
        return "CharacterEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", comics=" + comics +
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
        CharacterEntity that = (CharacterEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(comics,
            that.comics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, comics);
    }
}

