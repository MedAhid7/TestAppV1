package ma.fssm.testapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.ProductDto;
import ma.fssm.testapp.entities.Client;
import ma.fssm.testapp.entities.Produit;
import ma.fssm.testapp.repo.ClientRepo;
import ma.fssm.testapp.repo.ProduitRepo;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProduitServiceImpl implements ProduitService {
    private final ClientRepo clientRepo;
    private final ProduitRepo produitRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public ProductDto  createProductFromFourni(ProductDto produitDto) throws UserNotFoundException {
        log.info("Saving new Product");
        Client user = clientRepo.findById(produitDto.getClient().getUserId()).orElse(null);
        if (user == null){
             throw new UserNotFoundException("User not found!");
        }
        Produit produit = modelMapper.map(produitDto, Produit.class);

        produit.setClient(user);

        Produit newProduct = produitRepo.save(produit);
        ProductDto savedProduct= modelMapper.map(newProduct, ProductDto.class);
        return savedProduct;
    }

    @Override
    public ProductDto  createProduct(ProductDto produitDto) {

        Produit produit = modelMapper.map(produitDto, Produit.class);
        Produit newProduct = produitRepo.save(produit);
        ProductDto savedProduct= modelMapper.map(newProduct, ProductDto.class);
        log.info("Saving new Product");
        return savedProduct;
    }
    @Override
    public ProductDto updateProduct(Long id, ProductDto produitDto) throws  Exception {
        log.info("update Product");
        Produit produit = produitRepo.findById(id)
                .orElseThrow(()->new Exception("User not found"));
        Client fournisseur = clientRepo.findById(produitDto.getClient().getUserId()).orElse(null);
        produit.setClient(fournisseur);
        produit = modelMapper.map(produitDto, Produit.class);
        Produit saveProduct = produitRepo.save(produit);
        return modelMapper.map(saveProduct, ProductDto.class);
    }


}
