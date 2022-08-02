package com.musala.medispach.deliveryItem;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryItemDto {
    private long id;
    private long medicationId;
    private long deliverOrderId;
    private BigDecimal quantity;
}
