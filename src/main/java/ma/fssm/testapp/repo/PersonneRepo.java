package ma.fssm.testapp.repo;


import ma.fssm.testapp.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepo extends JpaRepository<Personne, String> {
}
