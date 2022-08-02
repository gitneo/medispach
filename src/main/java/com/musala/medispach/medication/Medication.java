package com.musala.medispach.medication;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.musala.medispach.deliveryItem.entity.DeliveryItem;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "medication")
@Data
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_id")
    private long id;

    @Column(name = "med_code" , nullable = false)
    private String code;

    @Column(name = "med_name", nullable = false)
    private String name;

    @Column(name="med_weight", nullable = false)
    private BigDecimal weight;

    @Column(name = "med_image")
    private String image;

    @OneToMany(mappedBy = "medication")
    @JsonManagedReference(value = "medicationRef")
    private List<DeliveryItem> deliveryItem;

}

