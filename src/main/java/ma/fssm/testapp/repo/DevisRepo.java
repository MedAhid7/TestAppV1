package ma.fssm.testapp.repo;

import ma.fssm.testapp.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevisRepo extends JpaRepository<Devis, Long> {
    Devis findByIdDevis(String idDevis);
}
