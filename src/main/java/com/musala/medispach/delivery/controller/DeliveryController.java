package com.musala.medispach.delivery.controller;

import com.musala.medispach.delivery.service.DeliveryDto;
import com.musala.medispach.delivery.service.DeliveryService;
import com.musala.medispach.deliveryItem.service.DeliveryItemDto;
import com.musala.medispach.drone.service.DroneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/medispatch/api/v1")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }


    /**
     *
     * @param orderId
     * @return load a drone with medication items;
     */
    @PostMapping("/delivery/{id}")
    public ResponseEntity<DeliveryDto>  createDelivery(@PathVariable("id") long orderId) throws Exception{
        DeliveryDto createDelivery = null;
        createDelivery = this.deliveryService.createDelivery(orderId);

        return new ResponseEntity<>(createDelivery, HttpStatus.CREATED);
    }


    /**
     *
     * @param droneId
     * @return loaded medication items for a given drone
     */
    @GetMapping("/delivery/{id}")
    public ResponseEntity<List<DeliveryItemDto>> getLoadedDeliveryItems(@PathVariable("id") long droneId) {
        List<DeliveryItemDto> deliveryItemDtoList =  this.deliveryService.getLoadedDeliveryItems(droneId);
        return new ResponseEntity<>(deliveryItemDtoList, HttpStatus.OK);
    }



    @GetMapping("/delivery/dispatch/{id}")
    public ResponseEntity<DroneDto> dispatchDelivery(@PathVariable("id") long droneId){
        DroneDto droneDto =  this.deliveryService.dispatchDelivery(droneId);
        return new ResponseEntity<>(droneDto,HttpStatus.OK);
    }

    @GetMapping("/delivery/receive/{id}")
    public ResponseEntity<DroneDto> dispatchReturn(@PathVariable("id") long deliveryId){
        DroneDto droneDto =  this.deliveryService.receiveDrone(deliveryId);
        return new ResponseEntity<>(droneDto,HttpStatus.OK);
    }

    @GetMapping("/delivery/park/{id}")
    public ResponseEntity<DroneDto> parkDeliveryDrone(@PathVariable("id") long deliveryId){
        DroneDto droneDto =  this.deliveryService.parkDeliveryDrone(deliveryId);
        return new ResponseEntity<>(droneDto,HttpStatus.OK);
    }





    @GetMapping("/deliveries")
    public ResponseEntity<List<DeliveryDto>> getDeliveries(){
        List<DeliveryDto> deliveryDtoList =  this.deliveryService.getDeliveries();

        return new ResponseEntity<>(deliveryDtoList, HttpStatus.OK);
    }



    @PutMapping("/delivery")
    public ResponseEntity<DeliveryDto> updateDelivery(@RequestBody DeliveryDto deliveryDto){
        DeliveryDto updatedDelivery =  this.deliveryService.updateDeliveryDto(deliveryDto);
        return new ResponseEntity<>(updatedDelivery,HttpStatus.OK);
    }




}
