package ma.fssm.testapp.request;

import lombok.Data;


import java.util.Date;
@Data
public class InvoiceRequest {

    private String nom;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private Date validation;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private Date echeance;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float taxe1;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float taxe2;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float remise;
  //  @NotBlank(message = "Ce champ ne doit etre null!")
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private UserRequest client;
  //  @NotBlank(message = "Ce champ ne doit etre null!")
    private DevisAllRequest devis;
}
