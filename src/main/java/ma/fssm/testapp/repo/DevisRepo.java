package ma.fssm.testapp.repo;

import ma.fssm.testapp.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepo extends JpaRepository<Devis, Long> {
    Devis findByCodeDevis(String codeDevis);
}
