package com.musala.medispach.drone;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.musala.medispach.delivery.entity.Delivery;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The Drone entity class
 */
@Entity
@Table(name = "DRONE")
@Data
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drn_code")
    private long id;

    @Column(name = "drn_serial", nullable = false)
    private String serialNo;

    @Column(name = "drn_model", nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneModel model;

    @Column(name = "drn_weight_limit", nullable = false)
    private BigDecimal weightLimit;

    @Column(name = "drn_batt_capcity" , nullable = false)
    private BigDecimal batteryCapacity;


    @Column(name = "drn_state" , nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneState state;

    @OneToMany(mappedBy = "drone")
    @JsonManagedReference
    private List<Delivery> deliveryList =  new ArrayList<>();

    public void addDelivery(Delivery delivery){
        deliveryList.add(delivery);
        delivery.setDrone(this);
    }
}
