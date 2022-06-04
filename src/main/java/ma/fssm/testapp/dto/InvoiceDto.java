package ma.fssm.testapp.dto;

import lombok.Data;


import java.util.Date;
@Data
public class InvoiceDto{
    private Long id;
    private String invoiceId;
    private String nom;
    private Date creation;
    private Date validation;
    private Date echeance;
    private float taxe1;
    private float taxe2;
    private float remise;

    private String livraison;
    private DevisAllDto devis;
    private UserAllDto client;
    private UserAllDto fournisseur;

}
