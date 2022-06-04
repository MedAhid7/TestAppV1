package ma.fssm.testapp.repo;

import ma.fssm.testapp.entities.Client;
import ma.fssm.testapp.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository<Fournisseur, String> {
    Fournisseur findByUserId(String userId);

}
