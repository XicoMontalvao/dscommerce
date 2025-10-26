package devsuperior.dscommerce.dto;

import devsuperior.dscommerce.entities.Category;
import devsuperior.dscommerce.entities.OrderItem;
import devsuperior.dscommerce.entities.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    //private Set<Category> categories = new HashSet<>();
    //private Set<OrderItem> items = new HashSet<>();

    public ProductDTO(){}
    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }
    public ProductDTO(Product entity){
        id= entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
