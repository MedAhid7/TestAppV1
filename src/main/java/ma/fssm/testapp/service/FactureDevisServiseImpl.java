package ma.fssm.testapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fssm.testapp.DevisNotFoundException;
import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.DevisDto;
import ma.fssm.testapp.dto.InvoiceDto;

import ma.fssm.testapp.entities.Client;
import ma.fssm.testapp.entities.Devis;
import ma.fssm.testapp.entities.Invoice;
import ma.fssm.testapp.repo.*;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import java.util.UUID;

@Service
@Slf4j @RequiredArgsConstructor
@Transactional
public class FactureDevisServiseImpl implements FactureDevisServise {
    private final FournisseurRepo fournisseurRepo;
    private final DevisRepo devisRepo;
    private final ClientRepo clientRepo;
    private final InvoiceRepo invoiceRepo;
    private final ModelMapper dtoMaper = new ModelMapper();

    //Ctree Facture
    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) throws UserNotFoundException, DevisNotFoundException {
        log.info("Saving new Invoice");
        Client client = clientRepo.findById(invoiceDto.getClient().getUserId()).orElse(null);

        if (client ==null){
            throw new UserNotFoundException("User not found");
        }

        Devis devis = devisRepo.findById(invoiceDto.getDevis().getId()).orElse(null);
        if (devis == null){
            throw new DevisNotFoundException("Devis not found");
        }

        Invoice invoice = dtoMaper.map(invoiceDto, Invoice.class);

        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setCreation(new Date());
        invoice.setDevis(devis);

        invoice.setClient(client);

        Invoice newInvoice = invoiceRepo.save(invoice);
        InvoiceDto savedFacture = dtoMaper.map(newInvoice, InvoiceDto.class);

        return savedFacture;
    }
    @Override
    public DevisDto createDevis(DevisDto devisDto) throws UserNotFoundException {
        log.info("Saving new Devis");
        Client client = clientRepo.findById(devisDto.getClient().getUserId()).orElse(null);
        //Fournisseur fournisseur = fournisseurRepo.findByUserId(devisDto.getFournisseur().getUserId()).orElse(new Fournisseur());
        if (client == null){
            throw new UserNotFoundException("User not found");
        }

        Devis devis = dtoMaper.map(devisDto, Devis.class);
        devis.setIdDevis(UUID.randomUUID().toString());
        devis.setCreation(new Date());

        devis.setClient(client);


        Devis newDevis = devisRepo.save(devis);
        DevisDto savedDevis = dtoMaper.map(newDevis, DevisDto.class);
        return savedDevis;
    }

    @Override
    public DevisDto updateDevis(Long id, DevisDto devisDto) throws DevisNotFoundException {
        log.info("update devis");
        Devis devis = devisRepo.findById(id)
                .orElseThrow(()->new DevisNotFoundException("Devis not found"));
        Client client = clientRepo.findById(devisDto.getClient().getUserId()).orElse(null);
        devis.setClient(client);
        //Optional<Fournisseur> user =  fournisseurRepo.findById(devisDto.getUser().getUserId());
        //Fournisseur fournisseur = user.get();
        // devis.setUser(fournisseur);

        devis = dtoMaper.map(devisDto, Devis.class);
        Devis updateDevis = devisRepo.save(devis);
        return dtoMaper.map(updateDevis, DevisDto.class);
    }
    /*@Override
    public InvoiceDto updateInvoice(String id, InvoiceDto invoiceDto) throws InvoiceNotFoundException {
        log.info("update invoice");
        Invoice invoice = invoiceRepo.findById(id)
                .orElseThrow(()->new InvoiceNotFoundException("Invoice not found"));
        Client client = clientRepo.findById(invoiceDto.getClient().getUserId()).orElse(null);

        invoice.setClient(client);

        invoice = dtoMapper.fromInvoiceDTO(invoiceDto);
        Invoice savedInvoice = invoiceRepo.save(invoice);
        return dtoMapper.fromInvoice(savedInvoice);
    }
*/

}
