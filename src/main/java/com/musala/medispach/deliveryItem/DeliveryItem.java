package com.musala.medispach.deliveryItem;

import com.musala.medispach.delivery.Delivery;
import com.musala.medispach.deliveryOrder.DeliveryOrder;
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


    @Column(name = "item_quantity" , nullable = false)
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "item_med_id")
    private Medication medicationId;

    @ManyToOne()
    @JoinColumn(name = "item_do_id")
    private DeliveryOrder deliverOrderId;

}
