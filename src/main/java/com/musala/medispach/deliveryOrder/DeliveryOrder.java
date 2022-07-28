package com.musala.medispach.deliveryOrder;

import com.musala.medispach.deliveryItem.DeliveryItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
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
    private int serial;

    @Column(name="do_status", nullable = false)
    private String status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_do_id")
    private List<DeliveryItem> deliveryItemList;


}

