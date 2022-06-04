package ma.fssm.testapp.service;

import ma.fssm.testapp.DevisNotFoundException;
import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.DevisDto;
import ma.fssm.testapp.dto.InvoiceDto;

public interface FactureDevisServise {

    //Ctree Facture
    InvoiceDto createInvoice(InvoiceDto invoiceDto) throws UserNotFoundException, DevisNotFoundException;

    DevisDto createDevis(DevisDto devisDto) throws UserNotFoundException;

    DevisDto updateDevis(Long id, DevisDto devisDto) throws DevisNotFoundException;
}
