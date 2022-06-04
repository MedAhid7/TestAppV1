package ma.fssm.testapp.dto;

import lombok.Data;
import ma.fssm.testapp.entities.Client;
import ma.fssm.testapp.entities.Fournisseur;
import org.apache.catalina.User;


import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class DevisDto  {
    private Long id;
    private String idDevis;
    private String nom;
    private Date creation;
    private Date validation;
    private Date echeance;
    private float taxe1;
    private float taxe2;
    private float remise;
    private InvoiceDto invoice;
    private UserAllDto client;
    private UserAllDto fournisseur;
}