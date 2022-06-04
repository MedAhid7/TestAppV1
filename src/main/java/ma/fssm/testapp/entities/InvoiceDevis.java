package ma.fssm.testapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class InvoiceDevis {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;
    private Date validation;
    private Date echeance;
    private float taxe1;
    private float taxe2;
    private float remise;
    private String livraison;
}
