package com.musala.medispach.deliveryItem;

import com.musala.medispach.delivery.Delivery;
import com.musala.medispach.medication.Medication;
import lombok.Data;

import javax.persistence.*;

@Data
public class DeliveryItemDto {
    private long id;
    private Medication medicationId;
    private Delivery deliveryId;
    private int quantity;
}
