package com.musala.medispach.deliveryItem.service;

import com.musala.medispach.deliveryItem.entity.DeliveryItem;
import com.musala.medispach.deliveryItem.entity.DeliveryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryItemService {

    private final DeliveryItemRepository deliveryItemRepository;


    @Autowired
    public DeliveryItemService(DeliveryItemRepository deliveryItemRepository){
        this.deliveryItemRepository = deliveryItemRepository;
    }


    public DeliveryItemDto createDelivery(DeliveryItemDto deliveryItemDto){
        DeliveryItem deliveryItem = DeliveryItemMapper.instance.toDeliveryItem(deliveryItemDto);
        DeliveryItem createdDeliveryItem = this.deliveryItemRepository.save(deliveryItem);

        return DeliveryItemMapper.instance.toDto(createdDeliveryItem);
    }




    public DeliveryItemDto getDeliveryItem(long id){
        DeliveryItem deliveryItem =  this.deliveryItemRepository.findById(id).orElseThrow(NoResultException::new);
        return DeliveryItemMapper.instance.toDto(deliveryItem);
    }




    public List<DeliveryItemDto> getDeliveryItems(){
        List<DeliveryItemDto> deliveryItemDtoList =  new ArrayList<>();
        this.deliveryItemRepository.findAll().forEach(deliveryItem -> {
            deliveryItemDtoList.add(DeliveryItemMapper.instance.toDto(deliveryItem));
        });

        return deliveryItemDtoList;
    }



    public DeliveryItemDto updateDelivery(DeliveryItemDto deliveryItemDto){
        DeliveryItem deliveryItem =  DeliveryItemMapper.instance.toDeliveryItem(deliveryItemDto);
        DeliveryItem updatedDeliveryItem =  this.deliveryItemRepository.save(deliveryItem);

        return DeliveryItemMapper.instance.toDto(updatedDeliveryItem);
    }



    public void deleteDeliveryItem(long id){
        this.deliveryItemRepository.deleteById(id);
    }
}
