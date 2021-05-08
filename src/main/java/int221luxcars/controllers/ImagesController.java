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

@RestController
@RequestMapping("/imgs")
@CrossOrigin("*")
public class ImagesController {

    @Autowired
    private ProductsRepository productsRepository;
    private static final String img_path = "./public/images";

    @GetMapping("/get/{productId:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable long productId) throws IOException {
        try {
            FileInputStream file = new FileInputStream(img_path + productId);
            byte[] image = file.readAllBytes();
            file.close();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);

        } catch (Exception e) {
            throw new RemoteException("Image not found");
        }
    }

    @PostMapping("/add/{productID}")
    public ResponseEntity<Object> uploadImage(@RequestParam MultipartFile file, @PathVariable long productId) {
        try {
            File myFile = new File(img_path + productId + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
            myFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(myFile);
            fos.write(file.getBytes());
            fos.close();
            return new ResponseEntity<>("The File Uploaded Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/edit/{productID}")
    public ResponseEntity<Object> changeImage(@RequestParam MultipartFile file, @PathVariable long productId) {
        try {
//                String productIDString[] = productID.split("\\.(?=[^\\.]+$)");
//                int hasId = productId.intValue();
            if (hasFoundId(productId)) {
                FileOutputStream fos = new FileOutputStream(img_path + productId + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
                fos.write(file.getBytes());
                fos.close();
                return new ResponseEntity<>("The File Change Successfully", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/delete/{productID:.+}")
    public ResponseEntity<Object> deleteImage(@PathVariable long productId) {
        try {
            File myFile = new File(+productId + ".png");
            myFile.delete();
            return new ResponseEntity<>("The Delete Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean hasFoundId(long productID) {
        List<Products> products = productsRepository.findAll();
        if (products.isEmpty()) {
            return false;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productID) {
                return true;
            }
        }
        return false;
    }
}









