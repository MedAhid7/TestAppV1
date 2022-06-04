package ma.fssm.testapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ma.fssm.testapp.dto.ClientDto;
import ma.fssm.testapp.dto.FournisseurDto;
import ma.fssm.testapp.entities.Client;
import ma.fssm.testapp.entities.Fournisseur;
import ma.fssm.testapp.repo.ClientRepo;
import ma.fssm.testapp.repo.FournisseurRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PersonneServiceImpl implements PersonneService {
    private final ClientRepo clientRepo;
    private final FournisseurRepo fournisseurRepo;

    @Override
    public ClientDto createCli(ClientDto client) {
        log.info("Saving new Client");

        Client personne = new Client();
        BeanUtils.copyProperties(client, personne);
        personne.setUserId(UUID.randomUUID().toString());

        Client newPersonne = clientRepo.save(personne);
        ClientDto savedClient= new ClientDto();
        BeanUtils.copyProperties(newPersonne, savedClient);
        return savedClient;
    }

    @Override
    public FournisseurDto createFournisseur(FournisseurDto fournisseurDto) {
        log.info("Saving new Fournisseur");

        Fournisseur personne = new Fournisseur();
        BeanUtils.copyProperties(fournisseurDto, personne);
        personne.setUserId(UUID.randomUUID().toString());

        Fournisseur newPersonne = fournisseurRepo.save(personne);
        FournisseurDto savedFourni= new FournisseurDto();
        BeanUtils.copyProperties(newPersonne, savedFourni);
        return savedFourni;
    }
}
