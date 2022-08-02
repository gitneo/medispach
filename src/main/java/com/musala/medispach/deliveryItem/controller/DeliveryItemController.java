package com.musala.medispach.deliveryItem.controller;

import com.musala.medispach.deliveryItem.service.DeliveryItemDto;
import com.musala.medispach.deliveryItem.service.DeliveryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medispatch/api/v1")
public class DeliveryItemController {

    private final DeliveryItemService deliveryItemService;


    @Autowired
    public DeliveryItemController(DeliveryItemService deliveryItemService){
        this.deliveryItemService = deliveryItemService;
    }


    @PostMapping("/deliveryItem")
    public ResponseEntity<DeliveryItemDto> createDeliveryItem(@RequestBody DeliveryItemDto deliveryItemDto){
        DeliveryItemDto createdDeliveryItem =  this.deliveryItemService.createDelivery(deliveryItemDto);
        return new ResponseEntity<>(createdDeliveryItem, HttpStatus.CREATED);
    }


    @GetMapping("/deliveryItem/{id}")
    public ResponseEntity<DeliveryItemDto> getDeliveryItem(@PathVariable("id") long id){
        DeliveryItemDto deliveryItem = this.deliveryItemService.getDeliveryItem(id);
        return new ResponseEntity<>(deliveryItem,HttpStatus.OK);
    }


    @GetMapping("/deliveryItems")
    public ResponseEntity<List<DeliveryItemDto>> getDeliveryItems(){
        List<DeliveryItemDto> deliveryItems = this.deliveryItemService.getDeliveryItems();
        return new ResponseEntity<>(deliveryItems,HttpStatus.OK);
    }


    @PutMapping("/deliveryItem")
    public ResponseEntity<DeliveryItemDto> updatedDeliveryItem(@RequestBody DeliveryItemDto deliveryItemDto){
        DeliveryItemDto updatedDeliveryItem = this.deliveryItemService.updateDelivery(deliveryItemDto);
        return new ResponseEntity<>(updatedDeliveryItem,HttpStatus.OK);
    }


    @DeleteMapping("/deliveryItem/{id}")
    public ResponseEntity<String> deleteDeliverItem(@PathVariable long id){
        this.deliveryItemService.deleteDeliveryItem(id);
        return new ResponseEntity<>("The delivery item with id "+id+" has been deleted", HttpStatus.OK);
    }
}
