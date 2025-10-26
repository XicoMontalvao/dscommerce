package devsuperior.dscommerce.services;


import devsuperior.dscommerce.dto.ProductDTO;
import devsuperior.dscommerce.entities.Product;
import devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findByAllErrado(Pageable pageable){
        //List<Product> result = repository.findAll();
        //return repository.findAll().stream().map(ProductDTO::new).toList();

        Page<Product> page = repository.findAll(pageable);
        return page.map(ProductDTO::new);
    }


}
