package ma.fssm.testapp.request;

import lombok.Data;

@Data
public class FournisseurRequest {
    private String nom;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private String raisonSociale;
  //  @NotBlank(message = "Ce champ ne doit etre null!")
    private int telephone;
    //@NotBlank(message = "Ce champ ne doit etre null!")
    private String nomContact;
    //@NotBlank(message = "Ce champ ne doit etre null!")
    private String email;
   // @NotBlank(message = "Ce champ ne doit etre null!")

}
