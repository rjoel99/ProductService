package mx.com.ids.practice.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author joel.rubio
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class ProductResponse {

	private int id;
	private String name;
	private String description;
	private BigDecimal price;
}
