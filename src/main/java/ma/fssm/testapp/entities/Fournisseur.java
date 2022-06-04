package ma.fssm.testapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("FOR")
public class Fournisseur extends Personne{
    @OneToMany(mappedBy = "fournisseur")
    private List<Invoice>  invoices;

}
