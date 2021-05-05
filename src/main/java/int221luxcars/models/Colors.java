package int221luxcars.models;

import javax.persistence.*;

@Entity
@Table(name="colors")
public class Colors extends AuditModel {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int colorCode;
    private String hexcode;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Products products;
    public Colors() {
    }

    public Colors(int colorCode, String hexcode) {
        this.colorCode = colorCode;
        this.hexcode = hexcode;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public String getHexcode() {
        return hexcode;
    }

    public void setHexcode(String hexcode) {
        this.hexcode = hexcode;
    }

    public Products getProducts(){
        return products;
    }
    public void setProducts(Products products){
        this.products=products;
    }

    @Override
    public String toString() {
        return "Colors{" +
                "colorCode=" + colorCode +
                ", hexcode='" + hexcode + '\'' +
                '}';
    }
}
