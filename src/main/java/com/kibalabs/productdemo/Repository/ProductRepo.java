package com.kibalabs.productdemo.Repository;

import com.kibalabs.productdemo.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findAllByNameContainingIgnoreCase(String name);

    @Query(value = "Select p from Product p WHERE p.quantity <= :quantity")
    List<Product> findAllProductByQuantity(Integer quantity);

    Page<Product> findAllByNameContainingIgnoreCase(String searchByName, Pageable pageable);

    @Query(value = "Select p from Product p where p.id = :id")
    Product findProductById(Integer id);

   // Object findAll(Product product);
}
