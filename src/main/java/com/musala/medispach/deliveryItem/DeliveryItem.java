package com.musala.medispach.deliveryItem;

import com.musala.medispach.delivery.Delivery;
import com.musala.medispach.medication.Medication;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "delivery_item")
@Data
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;

    @ManyToOne()
    @JoinColumn(name = "item_med_id", nullable = false)
    private Medication medicationId;

    @ManyToOne()
    @JoinColumn(name = "item_del_id", nullable = false)
    private Delivery deliveryId;


    @Column(name = "item_quantity" , nullable = false)
    private int quantity;
}
