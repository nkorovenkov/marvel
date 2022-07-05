package marvel.com.marvel.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
    @OneToOne(cascade = CascadeType.ALL)
    private ImageEntity image;

    public CharacterEntity(CharacterDtoIn characterDto) {
        setName(characterDto.getName());
    }
}

