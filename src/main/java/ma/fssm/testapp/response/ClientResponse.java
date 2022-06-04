package ma.fssm.testapp.response;

import lombok.Data;

import java.util.List;

@Data
public class ClientResponse {
    private String userId;
    private String nom;
    private String raisonSociale;
    private int telephone;
    private String nomContact;
    private String email;
}
