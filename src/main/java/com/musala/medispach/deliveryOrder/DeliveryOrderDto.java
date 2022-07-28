package com.musala.medispach.deliveryOrder;

import com.musala.medispach.deliveryItem.DeliveryItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class DeliveryOrderDto {

    private long id;
    private int serial;
    private String status;
    private List<DeliveryItem> deliveryItemList;

}
