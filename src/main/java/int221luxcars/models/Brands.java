package int221luxcars.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brands extends AuditModel {
    @Id
    @GeneratedValue
    private int brandId;
    @Column(nullable = false)
    private String brandName;
    @OneToMany(mappedBy = "brands")
    private Set<Products> products;

    public Brands() {
    }

    public Brands(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
