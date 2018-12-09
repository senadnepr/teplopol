package ua.senadnepr.teplopol;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Building {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date calculateAt;

    @NotNull
    @Size(min=5, message="Name of Building must be at least 5 characters long")
    private String name;

    private Integer square;

    @ManyToMany(targetEntity=Material.class)
    private List<String> materials;

    @PrePersist
    void calculateAt() {
        this.calculateAt = new Date();
    }
}
