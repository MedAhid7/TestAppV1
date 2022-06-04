package ma.fssm.testapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ma.fssm.testapp.dto.ClientDto;
import ma.fssm.testapp.dto.FournisseurDto;
import ma.fssm.testapp.entities.Client;
import ma.fssm.testapp.entities.Fournisseur;
import ma.fssm.testapp.repo.ClientRepo;
import ma.fssm.testapp.repo.FournisseurRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PersonneServiceImpl implements PersonneService {
    private final ModelMapper dtoMapper = new ModelMapper();
    private final ClientRepo clientRepo;
    private final FournisseurRepo fournisseurRepo;

    @Override
    public ClientDto createCli(ClientDto clientDto) {
        Client client = dtoMapper.map(clientDto, Client.class);

        client.setUserId(UUID.randomUUID().toString());
        Client newClient = clientRepo.save(client);
        ClientDto savedClient= dtoMapper.map(newClient, ClientDto.class);
       
        log.info("Saving new Client");
        return savedClient;
    }

    @Override
    public FournisseurDto createFournisseur(FournisseurDto fournisseurDto) {
        Fournisseur personne = dtoMapper.map(fournisseurDto, Fournisseur.class);

        personne.setUserId(UUID.randomUUID().toString());
        Fournisseur newPersonne = fournisseurRepo.save(personne);
        FournisseurDto savedFourni= dtoMapper.map(newPersonne, FournisseurDto.class);
        log.info("Saving new Fournisseur");
        return savedFourni;
    }
}
