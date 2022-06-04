package ma.fssm.testapp.request;

import lombok.Data;

import java.util.Date;
@Data
public class DevisClientRequest {
    private String nom;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private Date validation;

    private UserRequest client;
}
