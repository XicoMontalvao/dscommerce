package devsuperior.dscommerce.services;


import devsuperior.dscommerce.dto.ProductDTO;
import devsuperior.dscommerce.entities.Product;
import devsuperior.dscommerce.repositories.ProductRepository;
import devsuperior.dscommerce.services.exceptions.DatabaseException;
import devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product result = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Product not found. ID: %d", id)));
        return new ProductDTO(result);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findByAllErrado(Pageable pageable){
        Page<Product> page = repository.findAll(pageable);
        return page.map(ProductDTO::new);
    }

    @Transactional()
    public ProductDTO insert(ProductDTO dto){
        Product product = new Product(dto);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
       try {
           Product product = repository.getReferenceById(id);
           copyProductDTOtoProduct(dto, product);
           product = repository.save(product);
           return new ProductDTO(product);
       }catch (EntityNotFoundException e){
           throw new ResourceNotFoundException("Id not found");
       }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException(("Id not exist"));
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("referential integrity failure");
        }
        repository.deleteById(id);
    }

    private void copyProductDTOtoProduct(ProductDTO dto, Product product) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setImgUrl(dto.imgUrl());
    }
}
