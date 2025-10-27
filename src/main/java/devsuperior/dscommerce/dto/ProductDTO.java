package devsuperior.dscommerce.dto;

import devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDTO(
		Long id,
		
		@NotBlank(message = "Campo requerido") @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres") 
		String name,

		@NotBlank(message = "Campo requerido") @Size(min = 3, message = "Descricao precisa ter no minimo 10 caracteres") 
		String description,

		@Positive(message = "Preco deve ser positivo")
		Double price, 
		
		String imgUrl
		) {

	public ProductDTO(Product entity) {
		this(entity.getId(), 
			entity.getName(), entity.getDescription(), entity.getPrice(), entity.getImgUrl());
	}
}
