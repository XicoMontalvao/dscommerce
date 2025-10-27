package devsuperior.dscommerce.controllers;

import devsuperior.dscommerce.dto.ProductDTO;
import devsuperior.dscommerce.entities.Product;
import devsuperior.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
   private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable  Long id){
        return service.findByIdErrado(id);
    }

    @GetMapping
    public Page<ProductDTO> findByIdAll(Pageable pageable){
        return service.findByAllErrado(pageable);
    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto){
      return  service.insert(dto);
    }
}
