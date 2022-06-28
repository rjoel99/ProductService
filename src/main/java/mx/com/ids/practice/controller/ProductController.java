package mx.com.ids.practice.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ids.practice.model.ProductRequest;
import mx.com.ids.practice.model.ProductResponse;
import mx.com.ids.practice.service.ProductService;

/**
 * 
 * @author joel.rubio
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping
	public ResponseEntity<Collection<ProductResponse>> getAll() {
		
		Collection<ProductResponse> products = productService.getAll();
		
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getById(@PathVariable int id) {
		
		ProductResponse product = productService.getById(id);
		
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public ResponseEntity<Object> add(@RequestBody ProductRequest product) {
		
		productService.add(product);
		
		Map<String, String> response = new HashMap<>();
		
		response.put("message", "Product created");
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateById(@PathVariable int id, @RequestBody ProductRequest product) {
		
		productService.updateById(id, product);
		
		Map<String, String> response = new HashMap<>();
		
		response.put("message", "Product updated");
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
		
		productService.deleteById(id);
		
		Map<String, String> response = new HashMap<>();
		
		response.put("message", "Product deleted");
		
		return ResponseEntity.ok(response);
	}
}
