package ma.fssm.testapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Devis extends InvoiceDevis{
   // @GeneratedValue(generator = "UUID2")
   // @GenericGenerator(name="UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    private String idDevis;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Fournisseur fournisseur;

}
