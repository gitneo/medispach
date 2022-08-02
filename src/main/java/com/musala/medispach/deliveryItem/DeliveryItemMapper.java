package com.musala.medispach.deliveryItem;

import com.musala.medispach.deliveryItem.entity.DeliveryItem;
import com.musala.medispach.deliveryOrder.DeliveryOrder;
import com.musala.medispach.medication.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryItemMapper {

    DeliveryItemMapper instance = Mappers.getMapper(DeliveryItemMapper.class);

    @Mapping(target = "medicationId", source = "medication")
    @Mapping(target = "deliverOrderId", source = "deliverOrder")
    DeliveryItemDto toDto(DeliveryItem deliveryItem);

    @Mapping(target = "medication", source = "medicationId")
    @Mapping(target = "deliverOrder", source = "deliverOrderId")
    DeliveryItem toDeliveryItem(DeliveryItemDto deliveryItemDto);


    default long getMedicationId(Medication medication){
        return medication.getId();
    }

    default Medication getMedication(long id){
        Medication medication =  new Medication();
        medication.setId(id);

        return medication;
    }


    default long getDeliverOrderId( DeliveryOrder deliveryOrder){
        return deliveryOrder.getId();
    }


    default DeliveryOrder getDeliveryOrder( long id){
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setId(id);

        return deliveryOrder;
    }
}
