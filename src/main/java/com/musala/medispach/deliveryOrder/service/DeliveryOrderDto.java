package com.musala.medispach.deliveryOrder.service;

import com.musala.medispach.deliveryItem.entity.DeliveryItem;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class DeliveryOrderDto {

    private long id;
    @Pattern(regexp = "ORD-[0-9]+")
    private String serial;
    private String location;
    private List<DeliveryItem> deliveryItemList;

}
