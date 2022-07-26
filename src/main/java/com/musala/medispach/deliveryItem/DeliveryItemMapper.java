package com.musala.medispach.deliveryItem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryItemMapper {

    DeliveryItemMapper instance = Mappers.getMapper(DeliveryItemMapper.class);

    DeliveryItemDto toDto(DeliveryItem deliveryItem);
    DeliveryItem toDeliveryItem(DeliveryItemDto deliveryItemDto);
}
