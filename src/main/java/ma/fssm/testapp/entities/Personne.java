package ma.fssm.testapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 3)
public abstract class Personne {
    @Id
    private String userId;
    private String nom;
    private int telephone;
    private String nomContact;
    private String email;
    private String raisonSociale;

}
