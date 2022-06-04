package ma.fssm.testapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Invoice extends InvoiceDevis{
    private String invoiceId;

    @OneToOne
    private Devis devis;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Fournisseur fournisseur;
}
