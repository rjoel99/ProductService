package mx.com.ids.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.ids.practice.entity.Product;

/**
 * 
 * @author joel.rubio
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
