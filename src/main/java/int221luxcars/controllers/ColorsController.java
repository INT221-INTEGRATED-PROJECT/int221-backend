package int221luxcars.controllers;


import int221luxcars.models.Colors;
import int221luxcars.models.Products;
import int221luxcars.repositories.ColorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
@CrossOrigin(origins = "*")
public class ColorsController {

    @Autowired
    private ColorsRepository colorsRepository;

    @GetMapping("/view")
    public List<Colors> getColorsList(){
        return this.colorsRepository.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Colors> getColorById(
            @PathVariable(value = "id") Long colorCode) throws ResourceNotFoundException {
        Colors colors = colorsRepository.findById(colorCode).orElseThrow(() -> new ResourceNotFoundException("Can not find ::" + colorCode));
        return ResponseEntity.ok().body(colors);
    }



}
