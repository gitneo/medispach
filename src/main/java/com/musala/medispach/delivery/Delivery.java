package com.musala.medispach.delivery;

import com.musala.medispach.drone.Drone;
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

    @Column(name="del_location", nullable = false)
    private String location;
    //private Package package;
    //private Drone deliverer;
}
