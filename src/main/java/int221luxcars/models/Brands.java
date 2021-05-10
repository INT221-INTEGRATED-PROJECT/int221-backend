package int221luxcars.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brands  {
    @Id
    @Column(name="brandId")
    private int brandId;
    @Column(name="brandName")
    private String brandName;
//    @OneToMany(mappedBy = "brands")
//    private Set<Products> products;

    public Brands() {
    }

    public Brands(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }
}
