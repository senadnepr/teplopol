package ua.senadnepr.teplopol;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Building_Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date dateOrder;

    //end::allButValidation[]
    @NotBlank(message = "Name is required")
    //tag::allButValidation[]
    private String name;
    //end::allButValidation[]

    @NotBlank(message = "Street is required")
    //tag::allButValidation[]
    private String street;
    //end::allButValidation[]

    @NotBlank(message = "City is required")
    //tag::allButValidation[]
    private String city;
    //end::allButValidation[]

    @ManyToMany(targetEntity=Building.class)
    private List<Building> tacos = new ArrayList<>();

    public void addBuilding(Building building) {
        this.tacos.add(building);
    }

    @PrePersist
    void placedAt() {
        this.dateOrder = new Date();
    }
}