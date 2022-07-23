package com.musala.medispach.drone;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private BigDecimal serialNo;

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

}
