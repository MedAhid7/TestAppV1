package ma.fssm.testapp.response;

import lombok.Data;


import java.util.Date;

@Data
public class InvoiceResponse {
    private String codeInvoice;
    private String nom;
    private Date creation;
    private Date validation;
    private Date echeance;
    private float taxe1;
    private float taxe2;
    private float remise;

    private String livraison;
    private UserResponse client;
    private DevisAllResponse devis;
}
