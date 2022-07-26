package com.musala.medispach.delivery;

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




    @PostMapping("/delivery")
    public ResponseEntity<DeliveryDto>  createDelivery(@RequestBody DeliveryDto deliveryDto){
        DeliveryDto createDelivery =  this.deliveryService.createDelivery(deliveryDto);
        return new ResponseEntity<>(createDelivery, HttpStatus.CREATED);
    }





    @GetMapping("/delivery/{id}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable("id") long id) {
        DeliveryDto deliveryDto =  this.deliveryService.getDelivery(id);
        return new ResponseEntity<>(deliveryDto, HttpStatus.OK);
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





    @DeleteMapping("/delivery/{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable("id") long id){
        this.deliveryService.deleteDelivery(id);
        return new ResponseEntity<>("Delivery with ID "+ id + " has been deleted.",HttpStatus.OK);
    }

}
