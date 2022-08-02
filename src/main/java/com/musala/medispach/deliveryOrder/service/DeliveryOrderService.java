package com.musala.medispach.deliveryOrder.service;

import com.musala.medispach.deliveryOrder.entity.DeliveryOrder;
import com.musala.medispach.deliveryOrder.entity.DeliveryOrderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryOrderService {

    private final DeliveryOrderRepository deliveryOrderRepository;


    public DeliveryOrderService(DeliveryOrderRepository deliveryOrderRepository){
        this.deliveryOrderRepository = deliveryOrderRepository;
    }


    public DeliveryOrderDto createDeliveryOrder(DeliveryOrderDto deliveryOrderDto){
        DeliveryOrder deliveryOrder = DeliveryOrderMapper.instance.toDeliveryOrder(deliveryOrderDto);
        DeliveryOrder createdDeliveryOrder = this.deliveryOrderRepository.save(deliveryOrder);

        return DeliveryOrderMapper.instance.toDto(createdDeliveryOrder);
    }


    public DeliveryOrderDto getDeliveryOrder(long id){
        DeliveryOrder deliveryOrder = this.deliveryOrderRepository.findById(id).orElseThrow(NoResultException::new);
        return DeliveryOrderMapper.instance.toDto(deliveryOrder);
    }


    public List<DeliveryOrderDto> getDeliveryOrders(){
        List<DeliveryOrderDto> deliveryOrderDtoList =  new ArrayList<>();

        this.deliveryOrderRepository.findAll().forEach(deliveryOrder -> {
            deliveryOrderDtoList.add(DeliveryOrderMapper.instance.toDto(deliveryOrder));
        });

        return deliveryOrderDtoList;
    }


    public DeliveryOrderDto updateDeliveryOrder(DeliveryOrderDto deliveryOrderDto){
        DeliveryOrder deliveryOrder = DeliveryOrderMapper.instance.toDeliveryOrder(deliveryOrderDto);
        DeliveryOrder updatedDeliveryOrder = this.deliveryOrderRepository.save(deliveryOrder);

        return DeliveryOrderMapper.instance.toDto(updatedDeliveryOrder);
    }


    public void deleteDeliveryOrder(long id){
        this.deliveryOrderRepository.deleteById(id);
    }

}
