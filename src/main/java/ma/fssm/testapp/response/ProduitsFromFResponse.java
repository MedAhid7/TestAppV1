package ma.fssm.testapp.response;

import lombok.Data;


@Data
public class ProduitsFromFResponse {
    private Long productId;
    private String reference;
    private String libelle;
    private String description;
    private float prix;
    private UserResponse client;
}
