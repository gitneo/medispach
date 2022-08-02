package com.musala.medispach.deliveryItem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.musala.medispach.deliveryOrder.DeliveryOrder;
import com.musala.medispach.medication.Medication;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "delivery_item")
@Data
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;


    @Column(name = "item_quantity" , nullable = false)
    private BigDecimal quantity;

    @ManyToOne()
    @JoinColumn(name = "item_med_id")
    @JsonBackReference(value = "medicationRef")
    private Medication medication;

    @ManyToOne()
    @JoinColumn(name = "item_do_id")
    @JsonBackReference(value = "deliveryItemListRef")
    private DeliveryOrder deliverOrder;

}
