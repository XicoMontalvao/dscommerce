package devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{
	
	public ValidationError(Instant timeInstant, Integer status, String error, String path) {
		super(timeInstant, status, error, path);
	}
	private final List<FieldMessage> errors = new ArrayList<>();

	public List<FieldMessage> getErros(){
		return errors;
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
