package ma.fssm.testapp.web;

import lombok.RequiredArgsConstructor;

import ma.fssm.testapp.dto.ClientDto;
import ma.fssm.testapp.dto.FournisseurDto;
import ma.fssm.testapp.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class PersonneController {
    private final PersonneService personneService;

    @PostMapping(value = "/client/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ClientDto> createClient (@RequestBody  ClientDto request)   {
        ClientDto createClient = personneService.createCli(request);
        return new ResponseEntity<ClientDto>(createClient, HttpStatus.CREATED) ;
    }


    @PostMapping("/fournisseur/create")
    public ResponseEntity<FournisseurDto> createFour (@RequestBody FournisseurDto request)  {

        FournisseurDto createUser = personneService.createFournisseur(request);

        return new ResponseEntity<FournisseurDto>(createUser, HttpStatus.CREATED) ;
    }
}
