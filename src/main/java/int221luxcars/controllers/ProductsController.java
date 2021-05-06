package int221luxcars.controllers;


import int221luxcars.models.Products;
import int221luxcars.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    // Getmapping using vue views route ?
    //return "redirect ?
    @GetMapping("/view")
    public List<Products> getProductsList() {
        return this.productsRepository.findAll();
    }



//    @GetMapping("/products/{id}")
//    public Products show(@PathVariable Long id){
////        int productId = Integer.parseInt(id);
//        return productsRepository.findById(id);
//    }

//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<Products> getProductById(
//            @PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
//        Products products = productsRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Can not find ::" + productId));
//        return ResponseEntity.ok().body(products);
//    }

//    @PostMapping("/products")
//    public Products createProducts(@Validated @RequestBody Products products) {
//        return productsRepository.save(products);
//    }
//
//    @PutMapping("/products/{id}")
//    public ResponseEntity<Products> updateProduct(
//            @PathVariable(value = "id") Long productId,
//            @Validated @RequestBody Products productDetails) throws ResourceNotFoundException {
//        Products products = productsRepository.findById(productId).orElseThrow(
//                () -> new ResourceNotFoundException("Products not found ::" + productId)
//        );
//        products.setProductName(productDetails.getProductName());
//        products.setPrice((productDetails.getPrice()));
//        products.setReleaseDate(productDetails.getReleaseDate());
//        products.setWarranty(productDetails.getWarranty());
//        products.setDescription(productDetails.getDescription());
//        products.setImg(productDetails.getImg());
//        final Products updatedProduct = productsRepository.save(products);
//        return ResponseEntity.ok(updatedProduct);
//
//    }
//
//    @DeleteMapping("/products/{id}")
//    public Map<String, Boolean> deleteProduct(
//            @PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
//        Products product = productsRepository.findById(productId).orElseThrow(
//                () -> new ResourceNotFoundException("Product not found ::" + productId));
//        productsRepository.delete(product);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("delete", Boolean.TRUE);
//        return response;
//
//    }


}
