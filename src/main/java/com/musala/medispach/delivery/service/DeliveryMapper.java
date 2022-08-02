package com.musala.medispach.delivery.service;

import com.musala.medispach.delivery.entity.Delivery;
import com.musala.medispach.deliveryOrder.DeliveryOrder;
import com.musala.medispach.drone.Drone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {

    DeliveryMapper instance = Mappers.getMapper(DeliveryMapper.class);

    @Mapping(target = "droneId", source = "drone")
    @Mapping(target = "deliveryOrderId", source = "deliveryOrder")
    DeliveryDto toDto(Delivery delivery);

    @Mapping(target = "drone", source = "droneId")
    @Mapping(target = "deliveryOrder", source = "deliveryOrderId")
    Delivery toDelivery(DeliveryDto deliveryDto);


    default Drone getDrone(long id){
        Drone drone = new Drone();
        drone.setId(id);
        return drone;
    }

    default long getDoneId(Drone drone){
        return drone.getId();
    }


    default DeliveryOrder getDeliveryOrder(long id){
        DeliveryOrder deliveryOrder =  new DeliveryOrder();
        deliveryOrder.setId(id);
        return deliveryOrder;
    }


    default long getDeliveryOrderId(DeliveryOrder deliveryOrder){
        return deliveryOrder.getId();
    }

}


