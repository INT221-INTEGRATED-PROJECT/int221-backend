package int221luxcars.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import int221luxcars.models.Colors;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products  {
    @Id
    @Column(name="productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(name="productName")
    private String productName;
    @Column(name="price")
    private double price;
    @Column(name="releasedDate")
    private Date releasedDate;
    @Column(name="warranty")
    private int warranty;
    @Column(name="description")
    private String description;
    @Column(name="image")
    private String  image;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "productcolors",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "colorCode")
    )
    private List<Colors> colors;

    public Products() {
    }

    public Products(long productId, String productName, double price, Date releasedDate, int warranty, String description, String image, List<Colors> colors, Brands brands) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.releasedDate = releasedDate;
        this.warranty = warranty;
        this.description = description;
        this.image = image;
        this.colors = colors;
        this.brands = brands;
    }

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false)
    private Brands brands;

    public List<Colors> getColors() {
        return colors;
    }

}
