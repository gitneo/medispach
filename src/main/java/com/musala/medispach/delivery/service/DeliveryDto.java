package com.musala.medispach.delivery.service;

import lombok.Data;

@Data
public class DeliveryDto {

    private long id;
    private int serial;
    private String status;
    private long droneId;
    private long deliveryOrderId;
}
