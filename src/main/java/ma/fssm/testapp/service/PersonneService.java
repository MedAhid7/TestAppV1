package ma.fssm.testapp.service;



import ma.fssm.testapp.dto.ClientDto;
import ma.fssm.testapp.dto.FournisseurDto;

import java.util.List;


public interface PersonneService {

    ClientDto createCli(ClientDto client);

    FournisseurDto createFournisseur(FournisseurDto fournisseurDto);
}
