package com.musala.medispach.deliveryOrder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.musala.medispach.delivery.entity.Delivery;
import com.musala.medispach.deliveryItem.entity.DeliveryItem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "delivery_order")
@Data
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="do_id")
    private long id;

    @Column(name = "do_serial", nullable = false)
    private String serial;

    @Column(name="do_location", nullable = false)
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_do_id")
    @JsonManagedReference(value="deliveryItemListRef")
    private List<DeliveryItem> deliveryItemList;

    @OneToOne(mappedBy = "deliveryOrder")
    @JsonBackReference(value="deliveryIdRef")
    private Delivery deliveryId;
}

