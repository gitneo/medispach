package com.musala.medispach.medication;

import com.musala.medispach.delivery.Delivery;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @ManyToOne()
    @JoinColumn(name = "med_del_code")
    private Delivery delivery;

}
