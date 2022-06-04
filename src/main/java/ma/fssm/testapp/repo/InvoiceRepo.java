package ma.fssm.testapp.repo;


import ma.fssm.testapp.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
    Invoice findByCodeInvoice(String codeInvoice);
}
