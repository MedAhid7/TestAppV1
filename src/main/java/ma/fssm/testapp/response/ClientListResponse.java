package ma.fssm.testapp.response;

import lombok.Data;

import java.util.List;

@Data
public class ClientListResponse {
    private String userId;
    private String nom;
    private String raisonSociale;
    private int telephone;
    private String nomContact;
    private String email;
    private List<InvoiceAllResponse> invoices;
    private List<InvoiceAllResponse>  devis;
}
