package ma.fssm.testapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Devis {
   // @GeneratedValue(generator = "UUID2")
   // @GenericGenerator(name="UUID2", strategy = "org.hibernate.id.UUIDGenerator")
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

    private String codeDevis;
    @ManyToOne
    private Client client;
}
