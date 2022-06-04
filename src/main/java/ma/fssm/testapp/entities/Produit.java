package ma.fssm.testapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @ManyToOne
    private Fournisseur fournisseur;
    private String reference;
    private String libelle;
    private String description;
    private float prix;//fait reference au cervice offert
}
