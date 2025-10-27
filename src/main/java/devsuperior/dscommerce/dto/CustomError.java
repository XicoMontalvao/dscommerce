package devsuperior.dscommerce.dto;

import java.time.Instant;

public class CustomError {
	
	Instant timestamp;
	Integer status; 
	String error; 
	String path;
	
	public CustomError(Instant timeInstant, Integer status, String error, String path) {
		this.timestamp = timeInstant;
		this.status = status;
		this.error = error;
		this.path = path;
		
	}

	
}
