package com.kibalabs.productdemo;

import com.kibalabs.productdemo.Model.Product;
import com.kibalabs.productdemo.Repository.ProductRepo;
import com.kibalabs.productdemo.Services.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
    public class ProductServiceTests {

    private ProductServiceImpl subject;
    @Mock
    private ProductRepo repository;

    @BeforeEach
    public void setup() {
        subject = new ProductServiceImpl( repository );

    }

    @Test
    public void shouldAddProduct() {
     Product product = new Product("soap",345);
     Mockito.when( repository.save( product ) ).thenReturn( product );
     Product result= subject.addProduct(product);
     Assertions.assertEquals( product,result );
    }
    @Test
    public void shouldGetProduct(){
        Product product = new Product("abs",655);
        Mockito.when( repository.findAll()).thenReturn( Collections.singletonList( product ));
        List<Product> result = subject.getAllProduct();
    }
    @Test
    public void getProductByName(){
        Product product = new Product("Soap",655);
        String name = "Soap";
        Mockito.when( repository.findAllByNameContainingIgnoreCase(name)).thenReturn( Collections.singletonList( product ));
        List<Product> result = subject.getProductByName(name);
        Assertions.assertEquals(Collections.singletonList( product ),result);
    }
    @Test
    public  void shouldFindById(){
        Product product = new Product("abs",655);
        Integer id = 3;
        Mockito.when( repository.findProductById(id) ).thenReturn( product);
        Product result = subject.getProductById(id);
        Assertions.assertEquals( product,result );
    }
    @Test
    public void shouldUpdateById(){
        Product product = new Product("abs",655);
        Integer id = 1;
        Mockito.when( repository.findById( id )).thenThrow( new RuntimeException() );
        Mockito.when( repository.save( product ) ).thenReturn( product );
       Product result = subject.getProductById( id );
      Assertions.assertEquals( id,product );

    }


    @Test
    public void shouldSum() {
        int result = subject.sum( 2, 9 );
        Assertions.assertEquals( 11, result );
        org.assertj.core.api.Assertions.assertThat( result ).isEqualTo( 11 );
    }

    @Test
    public void shouldDivide() {
        int result = subject.divide( 6, 2 );
        Assertions.assertEquals( 3, result );
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo( 3 );
    }

    @Test
    public void shouldFailDivide(){
        Assertions.assertThrows(ArithmeticException.class,() -> subject.divide( 4,0 ));
    }

    @Test
    public void shouldSubtract(){
        int result = subject.sub(9,3);
        Assertions.assertEquals( 6,result );
        org.assertj.core.api.Assertions.assertThat( result ).isEqualTo( 6 );
    }
    @Test
    public void shouldMultiply(){
        int result=subject.multiply( 2,0 );
        Assertions.assertEquals( 0,result );
        org.assertj.core.api.Assertions.assertThat( result ).isEqualTo( 0);
    }

}