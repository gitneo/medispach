package com.musala.medispach.delivery.service;

import com.musala.medispach.delivery.entity.Delivery;
import com.musala.medispach.delivery.entity.DeliveryRepository;
import com.musala.medispach.deliveryItem.service.DeliveryItemDto;
import com.musala.medispach.deliveryItem.service.DeliveryItemMapper;
import com.musala.medispach.deliveryOrder.entity.DeliveryOrder;
import com.musala.medispach.deliveryOrder.service.DeliveryOrderDto;
import com.musala.medispach.deliveryOrder.service.DeliveryOrderMapper;
import com.musala.medispach.deliveryOrder.service.DeliveryOrderService;
import com.musala.medispach.drone.*;
import com.musala.medispach.drone.enitity.Drone;
import com.musala.medispach.drone.service.DroneDto;
import com.musala.medispach.drone.service.DroneMapper;
import com.musala.medispach.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DroneService droneService;
    private final DeliveryOrderService deliveryOrderService;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, DroneService droneService, DeliveryOrderService deliveryOrderService){
        this.deliveryRepository = deliveryRepository;
        this.droneService = droneService;
        this.deliveryOrderService = deliveryOrderService;
    }




    /**
     *
     * @param orderId
     * @return load a drone with medication items;
     * @throws Exception
     */
    public DeliveryDto createDelivery(long orderId) throws Exception {

        //Search for available drones
        DroneDto droneDto = this.droneService.findAvailableDrone();
        Drone drone = DroneMapper.instance.toDrone(droneDto);

        //Get the order to be delivered
        DeliveryOrderDto deliveryOrderdto = this.deliveryOrderService.getDeliveryOrder(orderId);
        DeliveryOrder deliveryOrder = DeliveryOrderMapper.instance.toDeliveryOrder(deliveryOrderdto);


        //Check weight of order
        if (isOrderWeightOk(deliveryOrder,drone))
            throw new Exception("too heavy");


        //Create a new delivery to be dispatched
        Delivery delivery =  new Delivery();
        delivery.setSerial(UUID.randomUUID().hashCode());
        delivery.setStatus("READY");
        delivery.setDeliveryOrder(deliveryOrder);
        delivery.setDrone(drone);
        Delivery createdDelivery = this.deliveryRepository.save(delivery);

        //review
        drone.setState(DroneState.LOADED);
        this.droneService.upDateDrone(DroneMapper.instance.toDto(drone));

        return DeliveryMapper.instance.toDto(createdDelivery);
    }




    /**
     *
     * @param droneId
     * @return loaded medication items for a given drone
     */
    public List<DeliveryItemDto> getLoadedDeliveryItems(long droneId){
        return
        this.droneService
                .getDrone(droneId)
                .getDeliveryList()
                .get(0)
                .getDeliveryOrder()
                .getDeliveryItemList()
                .stream()
                .map(item -> DeliveryItemMapper.instance.toDto(item))
                .collect(Collectors.toList());
    }







    public DroneDto dispatchDelivery(long id){
        DeliveryDto deliveryDto = this.getDelivery(id);
        DroneDto droneDto =  this.droneService.getDrone(deliveryDto.getDroneId());

        return droneDto;
    }


    public DroneDto receiveDrone(long id){
        DeliveryDto deliveryDto = this.getDelivery(id);
        DroneDto droneDto =  this.droneService.getDrone(deliveryDto.getDroneId());

        return droneDto;
    }


    public DroneDto parkDeliveryDrone(long id){
        DeliveryDto deliveryDto = this.getDelivery(id);
        DroneDto droneDto =  this.droneService.getDrone(deliveryDto.getDroneId());

        return droneDto;
    }



    public boolean isOrderWeightOk(DeliveryOrder order, Drone drone){
        return
            order.getDeliveryItemList()
                    .stream()
                    .map(item-> item.getMedication().getWeight().multiply(item.getQuantity()))
                    .reduce(BigDecimal::add)
                    .get().compareTo(drone.getWeightLimit()) >= 0;

    }



    public DeliveryDto getDelivery(long id){
        Delivery delivery = this.deliveryRepository.findById(id). orElseThrow(NoResultException::new);
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

}
