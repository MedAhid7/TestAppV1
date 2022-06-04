package ma.fssm.testapp.repo;


import ma.fssm.testapp.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
    Invoice findByInvoiceId(String invoiceId);
}
