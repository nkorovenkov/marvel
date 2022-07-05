package marvel.com.marvel.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @Lob
    private byte[] bites;
    @OneToOne(mappedBy = "image")
    private CharacterEntity character;

    public ImageEntity(String location, byte[] bites, String name) {
        setBites(bites);
        setLocation(location);
        setName(name);
    }
}
