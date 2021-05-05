package int221luxcars.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import int221luxcars.models.Colors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products extends AuditModel {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long productId;
     @Column(nullable = false)
    String productName;
     @Column(nullable = false)
    double price;
    @Column(nullable = false)
    Date releaseDate;
     @Column(nullable = false)
    int warranty;
     @Column(nullable = false)
    String description;
    String img;
    @OneToMany(mappedBy = "colors", cascade = {CascadeType.ALL})
    List<Colors> colors;

    public Products() {
    }

    public Products(long productId, String productName, double price, Date relaeasrDate, int warranty, String description, String img) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.releaseDate = relaeasrDate;
        this.warranty = warranty;
        this.description = description;
        this.img = img;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public List <Colors> getColors(){
        return colors;
    }

    public void setColors(List<Colors> colors) {
        this.colors = colors;
    }
}
