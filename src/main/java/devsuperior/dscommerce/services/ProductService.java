package devsuperior.dscommerce.services;


import devsuperior.dscommerce.dto.ProductDTO;
import devsuperior.dscommerce.entities.Product;
import devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Optional<ProductDTO> findById(Long id){
        Optional<Product> result = repository.findById(id);
        return result.map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public ProductDTO findByIdErrado(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }


}
