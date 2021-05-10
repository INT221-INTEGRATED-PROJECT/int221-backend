package int221luxcars.controllers;


import int221luxcars.models.Products;
import int221luxcars.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/imgs")
@CrossOrigin("*")
public class ImagesController {

    @Autowired
    private ProductsRepository productsRepository;
    private static final String img_path = "./public/images/";

    @GetMapping("/view/{productImgName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String productImgName) throws IOException {
        try {
            FileInputStream file = new FileInputStream(img_path +productImgName);
            byte[] image = file.readAllBytes();
            file.close();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);

        } catch (Exception e) {
            throw new RemoteException("Image not found");
        }
    }

    @PostMapping("/add/{productImgName}")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable String productImgName) {
        try {
            File myFile = new File(img_path + productImgName);
            myFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(myFile);
            fos.write(file.getBytes());
            fos.close();
            return  new ResponseEntity<>("The File Uploaded Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @DeleteMapping("/delete/{productImgName}")
    public ResponseEntity<Object> deleteImage(@PathVariable String productImgName) {
        try {
            File myFile = new File(img_path+ productImgName);
            myFile.delete();
            return new ResponseEntity<>("The Delete Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean hasFoundImg(String productImgName) {
        List<Products> products = productsRepository.findAll();
        if (products.isEmpty()) {
            return false;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getImage() == productImgName) {
                return true;
            }
        }
        return false;
    }
}









