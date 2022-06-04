package ma.fssm.testapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class FournisseurDto {
    private String userId;
    private String nom;
    private String raisonSociale;
    private int telephone;
    private String nomContact;
    private String email;

    private List<InvoiceDto> invoices;
    private List<DevisDto>  devis;
}
