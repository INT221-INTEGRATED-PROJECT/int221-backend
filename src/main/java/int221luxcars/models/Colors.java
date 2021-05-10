package int221luxcars.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="colors")
public class Colors  {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="colorCode") long colorCode;
    @Column(name="hexCode") private String hexCode;




}
