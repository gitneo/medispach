package com.musala.medispach.delivery;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.net.NoRouteToHostException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository){
        this.deliveryRepository = deliveryRepository;
    }


    public DeliveryDto createDelivery(DeliveryDto deliveryDto){
        Delivery delivery = DeliveryMapper.instance.toDelivery(deliveryDto);
        Delivery createdDelivery = this.deliveryRepository.save(delivery);

        return DeliveryMapper.instance.toDto(createdDelivery);
    }




    public DeliveryDto getDelivery(long id){
        Delivery delivery = this.deliveryRepository.findById(id).orElseThrow(NoResultException::new);
        return DeliveryMapper.instance.toDto(delivery);
    }



    public List<DeliveryDto> getDeliveries(){
        List<DeliveryDto> deliveryDtoList =  new ArrayList<>();
        this.deliveryRepository.findAll().forEach(delivery -> {
            deliveryDtoList.add(DeliveryMapper.instance.toDto(delivery));
        });

        return deliveryDtoList;
    }




    public DeliveryDto updateDeliveryDto(DeliveryDto deliveryDto){
        Delivery delivery = DeliveryMapper.instance.toDelivery(deliveryDto);
        Delivery updatedDelivery =  this.deliveryRepository.save(delivery);

        return DeliveryMapper.instance.toDto(updatedDelivery);
    }



    public void deleteDelivery(long id){
        this.deliveryRepository.deleteById(id);
    }
}
