package com.musala.medispach.delivery.service;

import com.musala.medispach.deliveryOrder.DeliveryOrder;
import com.musala.medispach.drone.Drone;
import com.musala.medispach.medication.Medication;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeliveryDto {

    private long id;
    private int serial;
    private String status;
    private long droneId;
    private long deliveryOrderId;
}
