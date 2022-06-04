package ma.fssm.testapp.response;

import lombok.Data;

import java.util.Date;

@Data
public class InvoiceAllResponse {
    private Long id;
    private String nom;
    private Date creation;
    private Date validation;
    private Date echeance;
    //private Status statut;
}
