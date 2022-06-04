package ma.fssm.testapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.ProductDto;
import ma.fssm.testapp.entities.Client;
import ma.fssm.testapp.entities.Fournisseur;
import ma.fssm.testapp.entities.Produit;
import ma.fssm.testapp.repo.ClientRepo;
import ma.fssm.testapp.repo.FournisseurRepo;
import ma.fssm.testapp.repo.ProduitRepo;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProduitServiceImpl implements ProduitService {
    private final FournisseurRepo fournisseurRepo;
    private final ProduitRepo produitRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public ProductDto  createProduct(ProductDto produitDto) throws UserNotFoundException {
        log.info("Saving new Product");
        Fournisseur fournisseur = fournisseurRepo.findById(produitDto.getFournisseur().getUserId()).orElse(null);
        if (fournisseur == null){
             throw new UserNotFoundException("User not found!");
        }
        Produit produit = modelMapper.map(produitDto, Produit.class);

        produit.setFournisseur(fournisseur);

        Produit newProduct = produitRepo.save(produit);
        ProductDto savedProduct= modelMapper.map(newProduct, ProductDto.class);
        return savedProduct;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto produitDto) throws  Exception {

        Produit produit = produitRepo.findById(id)
                .orElseThrow(()->new Exception("User not found"));
        Fournisseur fournisseur = fournisseurRepo.findById(produitDto.getFournisseur().getUserId()).orElse(null);
        produit.setFournisseur(fournisseur);
        produit = modelMapper.map(produitDto, Produit.class);
        Produit saveProduct = produitRepo.save(produit);
        log.info("update Product");
        return modelMapper.map(saveProduct, ProductDto.class);
    }


}
