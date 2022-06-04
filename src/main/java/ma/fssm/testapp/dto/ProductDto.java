package ma.fssm.testapp.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long productId;

    private String reference;
    private String libelle;
    private String description;
    private float prix;//fait reference au cervice offert
    private UserAllDto fournisseur;
}
