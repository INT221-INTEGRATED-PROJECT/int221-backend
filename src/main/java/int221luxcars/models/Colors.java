package int221luxcars.models;

import javax.persistence.*;

@Entity
@Table(name="colors")
public class Colors  {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="colorCode") int colorCode;
    @Column(name="hexCode") private String hexCode;



    public Colors() {
    }

    public Colors(int colorCode, String hexCode) {
        this.colorCode = colorCode;
        this.hexCode = hexCode;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexcode(String hexCode) {
        this.hexCode = hexCode;
    }

//    public Products getProducts(){
//        return products;
//    }
//    public void setProducts(Products products){
//        this.products=products;
//    }

    @Override
    public String toString() {
        return "Colors{" +
                "colorCode=" + colorCode +
                ", hexCode='" + hexCode + '\'' +
                '}';
    }
}
