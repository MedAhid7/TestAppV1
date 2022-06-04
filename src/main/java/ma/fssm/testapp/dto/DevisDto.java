package ma.fssm.testapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DevisDto  {
    private Long id;
    private String codeDevis;
    private String nom;
    private Date creation;
    private Date validation;
    private Date echeance;
    private float taxe1;
    private float taxe2;
    private float remise;
    private UserAllDto client;
}