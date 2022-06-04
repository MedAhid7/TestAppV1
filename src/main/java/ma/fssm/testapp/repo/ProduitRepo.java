package ma.fssm.testapp.repo;

import ma.fssm.testapp.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Long> {

}
