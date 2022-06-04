package ma.fssm.testapp.web;

import lombok.RequiredArgsConstructor;
import ma.fssm.testapp.UserNotFoundException;
import ma.fssm.testapp.dto.ProductDto;
import ma.fssm.testapp.request.ProduitRequest;
import ma.fssm.testapp.response.ProduitsResponse;
import ma.fssm.testapp.service.ProduitService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;
    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProduitsResponse> saveProduct (@RequestBody ProduitRequest request) throws UserNotFoundException {
        ProductDto produit= modelMapper.map(request, ProductDto.class);
        ProductDto createProduit = produitService.createProduct(produit);
        ProduitsResponse response = modelMapper.map(createProduit, ProduitsResponse.class);
        return new ResponseEntity<ProduitsResponse>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProduitsResponse> updateProduct(@PathVariable Long id, @RequestBody ProductDto product) throws  Exception {
        product.setProductId(id);
        ProductDto updateProduct = produitService.updateProduct(id, product);
        ProduitsResponse response = modelMapper.map(updateProduct, ProduitsResponse.class);
        return new ResponseEntity<ProduitsResponse>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/fromFourni/{id}")
    public ResponseEntity<ProduitsResponse> updateProductFromFourni(@PathVariable Long id, @RequestBody ProductDto product) throws  Exception {
        product.setProductId(id);
        ProductDto updateProduct = produitService.updateProduct(id, product);
        ProduitsResponse response = modelMapper.map(updateProduct, ProduitsResponse.class);
        return new ResponseEntity<ProduitsResponse>(response, HttpStatus.ACCEPTED);
    }

}
