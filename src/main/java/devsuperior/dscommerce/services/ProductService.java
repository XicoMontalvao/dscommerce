package devsuperior.dscommerce.services;


import devsuperior.dscommerce.dto.ProductDTO;
import devsuperior.dscommerce.entities.Product;
import devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;

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

    @Transactional()
    public ProductDTO insert(ProductDTO dto){
        Product product = new Product(dto);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional()
    public ProductDTO update(Long id, ProductDTO dto){
        Product product = repository.getReferenceById(id);
        copyProductDTOtoProduct(dto, product);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    private void copyProductDTOtoProduct(ProductDTO dto, Product product) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setImgUrl(dto.imgUrl());
    }


}
