package int221luxcars.controllers;


import int221luxcars.models.Brands;
import int221luxcars.models.Products;
import int221luxcars.repositories.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "*")
public class BrandsController {
     @Autowired
    private BrandsRepository brandsRepository;

     @GetMapping("/view")
    public List<Brands> getBrandsList(){
         return this.brandsRepository.findAll();
     }
    @GetMapping("/view/{id}")
    public ResponseEntity<Brands> getBrandById(
            @PathVariable(value = "id") Long brandId) throws ResourceNotFoundException {
       Brands brand = brandsRepository.findById(brandId).orElseThrow(() -> new ResourceNotFoundException("Can not find ::" + brandId));
        return ResponseEntity.ok().body(brand);
    }


}
