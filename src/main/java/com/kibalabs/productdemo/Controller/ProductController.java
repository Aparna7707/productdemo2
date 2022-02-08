package com.kibalabs.productdemo.Controller;

import com.kibalabs.productdemo.Model.Product;
import com.kibalabs.productdemo.Model.ProductRequest;
import com.kibalabs.productdemo.Services.ProductServiceImpl;
import com.kibalabs.productdemo.Services.ProductServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
 @RequestMapping(value = "product")
 public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @Operation(summary = "Add Product",description = "Add Product To The Stock.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully added.")})
    @PostMapping(value = "/")
    public Product addProduct( @RequestBody @Valid Product product){
    return productService.addProduct(product);
}

    @Operation(summary = "Get All Product",description = "Get All Product From Stock .")
    @ApiResponses(value = {@ApiResponse(responseCode ="200",description = "Ok Success")})
    @GetMapping(value = "/")
     public List<Product>getAllProduct(){
    return productService.getAllProduct();
     }


    @Operation(summary = "Get All Product By Name",description = "Get All Product From Stock By Name .")
    @ApiResponses(value = {@ApiResponse(responseCode ="200",description = "Ok Success")})
    @GetMapping(value = "{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }


    @Operation(summary = "Update All Product",description = "Update Product In Stock By Id.")
    @ApiResponses(value = {@ApiResponse(responseCode ="200",description = "Ok Success"),
            @ApiResponse(responseCode ="404",description = "Not Found")})
    @PutMapping(value = "{id}")
    public Product updateProductById(@PathVariable Integer id,@RequestBody Product product ){
        return productService.updateProductById(id ,product);
    }


    @Operation(summary = "Delete Product",description = "Delete Product In Stock By Id.")
    @ApiResponses(value = {@ApiResponse(responseCode ="404",description = "Deleted")})
    @DeleteMapping(value = "{id}")
    public String DeleteProductById(@PathVariable Integer id){
        return productService.DeleteProductById(id);
    }

     @Operation(summary = "Get Page",description = "Get Product By Page.")
    @GetMapping(value = "/page/")
    public Page<Product> getAllProductPage(@RequestParam (required = false, defaultValue = "1") Integer pageNo,
                                           @RequestParam(required = false, defaultValue = "2") Integer recordPerPage,
                                            @RequestParam(required = false) String searchByName)
    {
        return productService.getAllProductPage(pageNo,recordPerPage,searchByName);

    }
     @Operation(summary = "Get Product By Quantity.",description = "Get All Product By Quantity.")
    @GetMapping(value = "/quantity/")
    public List <Product> getProductByQuantity(@RequestParam Integer quantity){
        return productService.getProductByQuantity(quantity);
    }


    @GetMapping(value = "/product/{id}")
    public Product getProductById(@PathVariable  Integer id){
        return productService.getProductById(id);
    }
    }

