package com.musala.medispach.drone;

import com.musala.medispach.delivery.Delivery;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class DroneDto {
    private long id;

    @NotNull private int serialNo;
    @NotNull private DroneModel model;
    @NotNull private BigDecimal weightLimit;
    @NotNull private BigDecimal batteryCapacity;
    @NotNull private DroneState state;
    @NotNull private List<Delivery> deliveryList =  new ArrayList<>();
}
