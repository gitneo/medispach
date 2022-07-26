package com.musala.medispach.delivery;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {

    DeliveryMapper instance = Mappers.getMapper(DeliveryMapper.class);

    DeliveryDto toDto(Delivery delivery);
    Delivery toDelivery(DeliveryDto deliveryDto);
}
