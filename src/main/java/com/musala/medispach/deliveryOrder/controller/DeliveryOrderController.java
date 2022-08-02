package com.musala.medispach.deliveryOrder.controller;


import com.musala.medispach.deliveryOrder.service.DeliveryOrderDto;
import com.musala.medispach.deliveryOrder.service.DeliveryOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medispatch/api/v1")
public class DeliveryOrderController {


    private final DeliveryOrderService deliveryOrderService;

    public DeliveryOrderController(DeliveryOrderService deliveryOrderService){
        this.deliveryOrderService =deliveryOrderService;
    }


    @PostMapping("/deliveryOrder")
    public ResponseEntity<DeliveryOrderDto> createDeliveryOrder(@Valid @RequestBody DeliveryOrderDto deliveryOrderDto){
        DeliveryOrderDto deliveryOrder = this.deliveryOrderService.createDeliveryOrder(deliveryOrderDto);
        return new ResponseEntity<>(deliveryOrder, HttpStatus.CREATED);
    }


    @GetMapping("/deliveryOrder/{id}")
    public ResponseEntity<DeliveryOrderDto> getDeliveryOrder(@PathVariable("id") long id){
        DeliveryOrderDto deliveryOrder = this.deliveryOrderService.getDeliveryOrder(id);
        return new ResponseEntity<>(deliveryOrder, HttpStatus.OK);
    }


    @GetMapping("/deliveryOrders")
    public ResponseEntity<List<DeliveryOrderDto>> getDeliveryOrders(){
        List<DeliveryOrderDto> deliveryOrderDtoList =  this.deliveryOrderService.getDeliveryOrders();
        return new ResponseEntity<>(deliveryOrderDtoList,HttpStatus.OK);
    }


    @PutMapping("/deliveryOrder")
    public ResponseEntity<DeliveryOrderDto> updateDeliveryOrder(@RequestBody DeliveryOrderDto deliveryOrderDto){
        DeliveryOrderDto deliveryOrder = this.deliveryOrderService.updateDeliveryOrder(deliveryOrderDto);
        return new ResponseEntity<>(deliveryOrder,HttpStatus.OK);
    }



    @DeleteMapping("/deliveryOrder/{id}")
    public ResponseEntity<String> deleteDeliveryOrder(@PathVariable("id") long id){
        this.deliveryOrderService.deleteDeliveryOrder(id);
        return new ResponseEntity<>("The order with id "+ id + " has been deleted",HttpStatus.OK );
    }
}
