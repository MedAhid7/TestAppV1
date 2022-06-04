package ma.fssm.testapp.service;

import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.ProductDto;

public interface ProduitService {

    ProductDto  createProductFromFourni(ProductDto produitDto) throws UserNotFoundException;

    ProductDto createProduct(ProductDto produitDto);

    ProductDto updateProduct(Long id, ProductDto produitDto) throws  Exception;
}
