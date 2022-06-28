package mx.com.ids.practice.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import mx.com.ids.practice.entity.Product;
import mx.com.ids.practice.model.ProductRequest;
import mx.com.ids.practice.model.ProductResponse;
import mx.com.ids.practice.repository.ProductRepository;
import mx.com.ids.practice.service.ProductService;

/**
 * 
 * @author joel.rubio
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Collection<ProductResponse> getAll() {
		
		return productRepository.findAll()
				.stream()
				.map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
				.collect(Collectors.toList());
	}

	@Override
	public ProductResponse getById(int id) {
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("The product doesn't exist"));
	
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	@Override
	public void add(ProductRequest productRequest) {

		Product product = new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());
		
		productRepository.save(product);
	}

	@Override
	public void updateById(int id, ProductRequest product) {
		
		Product savedProduct = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("The product doesn't exist"));
		
		savedProduct.setName(product.getName());
		savedProduct.setDescription(product.getDescription());
		savedProduct.setPrice(product.getPrice());
		
		productRepository.save(savedProduct);
	}

	@Override
	public void deleteById(int id) {

		Product savedProduct = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("The product doesn't exist"));
		
		productRepository.delete(savedProduct);
	}
}
