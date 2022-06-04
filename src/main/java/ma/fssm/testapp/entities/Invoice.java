package ma.fssm.testapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Invoice extends Devis{

    private String codeInvoice;

   

    @OneToOne
    private Devis devis;
    @ManyToOne
    private Client client;
}
