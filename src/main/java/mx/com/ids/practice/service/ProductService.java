package mx.com.ids.practice.service;

import java.util.Collection;

import mx.com.ids.practice.model.ProductRequest;
import mx.com.ids.practice.model.ProductResponse;

/**
 * 
 * @author joel.rubio
 *
 */
public interface ProductService {

	Collection<ProductResponse> getAll();
	ProductResponse getById(int id);
	void add(ProductRequest product);
	void updateById(int id, ProductRequest product);
	void deleteById(int id);
}
