package com.musala.medispach.deliveryOrder;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryOrderMapper {

    DeliveryOrderMapper instance = Mappers.getMapper(DeliveryOrderMapper.class);

    DeliveryOrderDto toDto(DeliveryOrder deliveryOrder);
    DeliveryOrder toDeliveryOrder(DeliveryOrderDto deliveryOrderDto);
}
