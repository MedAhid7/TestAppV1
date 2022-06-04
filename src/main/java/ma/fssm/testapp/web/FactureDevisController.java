package ma.fssm.testapp.web;

import lombok.RequiredArgsConstructor;
import ma.fssm.testapp.DevisNotFoundException;
import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.DevisDto;
import ma.fssm.testapp.dto.InvoiceDto;
import ma.fssm.testapp.request.DevisClientRequest;
import ma.fssm.testapp.request.InvoiceRequest;
import ma.fssm.testapp.response.DevisResponse;
import ma.fssm.testapp.response.InvoiceResponse;
import ma.fssm.testapp.service.FactureDevisServise;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FactureDevisController {
    private final ModelMapper dtoMaper = new ModelMapper();
    private final FactureDevisServise factureDevisServise;

    @PostMapping(value = "/invoice/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<InvoiceResponse> saveFacture (@RequestBody InvoiceRequest request) throws UserNotFoundException, DevisNotFoundException {
        InvoiceDto newInvoice = dtoMaper.map(request, InvoiceDto.class);
        InvoiceDto createInvoice = factureDevisServise.createInvoice(newInvoice);
        InvoiceResponse savedInvoice = dtoMaper.map(createInvoice, InvoiceResponse.class);
        return new ResponseEntity<InvoiceResponse>(savedInvoice, HttpStatus.CREATED);
    }

    @PostMapping(value = "/devis/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DevisResponse> saveDevis(@RequestBody DevisClientRequest request) throws UserNotFoundException {
        DevisDto createDevis = dtoMaper.map(request, DevisDto.class);
        DevisDto newDevis = factureDevisServise.createDevis(createDevis);
        DevisResponse savedDevis = dtoMaper.map(newDevis, DevisResponse.class);
        BeanUtils.copyProperties(newDevis, savedDevis);
        return new ResponseEntity<DevisResponse>(savedDevis, HttpStatus.CREATED);
    }

    @PutMapping("/devis/update/{id}")
    public ResponseEntity<DevisResponse> updateDevis(@PathVariable Long id, @RequestBody  DevisDto request) throws DevisNotFoundException {
        request.setId(id);
        DevisDto updateDevis = factureDevisServise.updateDevis(id, request);
        DevisResponse savedDevis = dtoMaper.map(updateDevis, DevisResponse.class);
        return new ResponseEntity<DevisResponse>(savedDevis, HttpStatus.ACCEPTED);
    }
}