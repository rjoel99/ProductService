package mx.com.ids.practice.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author joel.rubio
 *
 */
@Getter
@Setter
public class ProductRequest {

	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	private String description;
	
	@NotNull
	@NotEmpty
	private BigDecimal price;
}
