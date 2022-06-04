package ma.fssm.testapp.repo;


import ma.fssm.testapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, String> {
}
