package com.musala.medispach.delivery.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.musala.medispach.deliveryOrder.entity.DeliveryOrder;
import com.musala.medispach.drone.enitity.Drone;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="DELIVERY")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "del_code")
    private long id;

    @Column(name = "del_serial", nullable = false)
    private int serial;


    @Column(name = "del_status", nullable = false)
    private String status;

    @ManyToOne()
    @JoinColumn(name = "del_dr_code")
    @JsonBackReference
    private Drone drone;

    @OneToOne()
    @JoinColumn(name = "del_do_id", referencedColumnName = "do_id")
    private DeliveryOrder deliveryOrder;
}
