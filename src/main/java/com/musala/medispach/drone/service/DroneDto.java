package com.musala.medispach.drone.service;

import com.musala.medispach.delivery.entity.Delivery;
import com.musala.medispach.drone.DroneModel;
import com.musala.medispach.drone.DroneState;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class DroneDto {
    private long id;

    @NotNull
    @Max(value = 100,message = "Maximum number of characters(100) exceeded")
    private String serialNo;
    @NotNull private DroneModel model;
    @NotNull final private BigDecimal weightLimit = new BigDecimal("500");
    @NotNull private BigDecimal batteryCapacity;
    @NotNull private DroneState state;
    @NotNull private List<Delivery> deliveryList =  new ArrayList<>();
}
