package ma.fssm.testapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("CLI")
public class Client extends Personne{
    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;

}
