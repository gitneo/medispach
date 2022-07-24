package com.musala.medispach.delivery;

import com.musala.medispach.drone.Drone;
import com.musala.medispach.medication.Medication;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne()
    @JoinColumn(name = "del_dr_code")
    private Drone drone;

    @OneToMany(mappedBy = "delivery")
    List<Medication> listOfMedications = new ArrayList<>();
}
