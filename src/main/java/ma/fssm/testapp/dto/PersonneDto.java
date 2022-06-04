package ma.fssm.testapp.dto;

import lombok.Data;
import ma.fssm.testapp.entities.Devis;
import ma.fssm.testapp.entities.Invoice;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class PersonneDto {
    private String userId;
    private String nom;
    private String raisonSociale;
    private int telephone;
    private String nomContact;
    private String email;

    private List<InvoiceDto> invoices;
    private List<DevisDto>  devis;
}
