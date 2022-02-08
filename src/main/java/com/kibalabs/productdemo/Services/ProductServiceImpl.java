package com.kibalabs.productdemo.Services;

import com.kibalabs.productdemo.Exception.EmptyInputException;
import com.kibalabs.productdemo.Exception.ResourceAlreadyExistException;
import com.kibalabs.productdemo.Exception.ResourceNotFoundException;
import com.kibalabs.productdemo.Model.Product;
import com.kibalabs.productdemo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServices {

    private ProductRepo repository;

    @Autowired
    public ProductServiceImpl(ProductRepo repository){
        this.repository=repository;
    }


    public Product addProduct(@Valid Product product)  {
        Optional<Product> p = repository.findById( product.getId() );
        if (!p.isPresent()) {
            return repository.save( product );
        }
        if (product.getName().isEmpty())
        {
            throw new EmptyInputException( "d" );
        }
        if (product.getQuantity().equals( null ))
        {
            throw new EmptyInputException( "d" );
        }
        else {
            throw new ResourceAlreadyExistException("s");
        }
    }

    public List<Product> getAllProduct() {
        return repository.findAll();
    }
    public List<Product> getProductByName(String name) {
        List<Product> p1 = repository.findAllByNameContainingIgnoreCase( name );
        if (!p1.isEmpty()) {
            return repository.findAllByNameContainingIgnoreCase( name );
        }
        throw new ResourceNotFoundException( "a" );
    }

    public Product updateProductById(Integer id,Product product) {
       Optional<Product> p = ( repository.findById( id ) );
        if (p.isEmpty()){
            throw new ResourceNotFoundException( "a" );
        }
        else {
            return repository.save( product );
        }
        }

    public String DeleteProductById(Integer id) {
        Optional<Product> p = repository.findById( id );
        if (!p.isPresent()) {
            throw new ResourceNotFoundException( "a" );
        } else {
            repository.deleteById( id );
            return "deleted";
        }
    }


    public Page<Product> getAllProductPage(Integer pageNo, Integer recordPerPage ,String searchByName) {
        Pageable pageable = PageRequest.of( pageNo-1,recordPerPage );
        if (StringUtils.hasText( searchByName )){
            return repository.findAllByNameContainingIgnoreCase(searchByName,pageable);
        }
        return repository.findAll(pageable );
    }

    public List<Product> getProductByQuantity(Integer quantity) {
        Optional<Product> p = repository.findById( quantity );
        if (!p.isEmpty()) {
            return repository.findAllProductByQuantity( quantity );
        } else {
            throw new ResourceNotFoundException( "a" );
        }
    }

    public Product getProductById(Integer id) {
        if (repository.existsById( id )){
        return repository.findProductById(id);
   }
        else {
            throw new ResourceNotFoundException( "a" );
        }
    }





   public int sum(int a, int b){
        return a+b;
   }
   public int divide(int i , int j){
        return i/j;
   }
   public int sub(int c, int d){
        return c-d;
   }

   public int multiply(int a, int b){
        return a * b;
   }
}

