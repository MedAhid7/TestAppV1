package ma.fssm.testapp.service;

import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.ProductDto;

public interface ProduitService {


    ProductDto createProduct(ProductDto produitDto) throws UserNotFoundException;

    ProductDto updateProduct(Long id, ProductDto produitDto) throws  Exception;
}
