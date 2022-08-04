package com.musala.medispach.drone.controller;

import com.musala.medispach.DroneListItems;
import com.musala.medispach.deliveryItem.service.DeliveryItemDto;
import com.musala.medispach.drone.service.DroneDto;
import com.musala.medispach.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/medispatch/api/v1")
public class DroneController {

    public final DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService){
        this.droneService = droneService;
    }




    /**
     *
     * @param droneDto
     * @return registered drone
     */

    @PostMapping("/drone")
    public ResponseEntity<DroneDto> createDrone(@RequestBody DroneDto droneDto){
        DroneDto createdDrone =  this.droneService.createDrone(droneDto);
        return new ResponseEntity<>(createdDrone, HttpStatus.CREATED);
    }





    /**
     *
     * @return available drone for delivery
     */
    @GetMapping("/drone")
    public ResponseEntity<DroneDto> getDrone(){
          DroneDto droneDto = this.droneService.findAvailableDrone();
          return new ResponseEntity<>(droneDto, HttpStatus.OK);
    }






    /**
     *
     * @param droneId
     * @return drone battery capacity
     */
    @GetMapping("/drone/battery/{id}")
    public ResponseEntity<BigDecimal> getDroneBatteryCapacity(@PathVariable("id") long droneId){
        BigDecimal batteryCapacity = this.droneService.getDroneBatteryCapacity(droneId);
        return new ResponseEntity<>(batteryCapacity,HttpStatus.OK);
    };





    /**
     *
     * @param droneId
     * @return list of items to be delivered by the drone
     */
    @GetMapping("/drone/items/{id}")
    public ResponseEntity<List<DroneListItems>> getDroneDeliveryItems(@PathVariable("id") long droneId){
        List<DroneListItems> deliveryItemDtoList =  this.droneService.getDroneDeliveryItems(droneId);
        return new ResponseEntity<>(deliveryItemDtoList,HttpStatus.OK);
    }







    @GetMapping("/drones")
    public ResponseEntity<List<DroneDto>> getDrones(){
        List<DroneDto> droneList = this.droneService.getDrones();
        return new ResponseEntity<>(droneList,HttpStatus.OK);
    }





    @PutMapping("/drone")
        public ResponseEntity<DroneDto> updateDrone(@RequestBody DroneDto droneDto){
        DroneDto updatedDrone =  this.droneService.createDrone(droneDto);
        return new ResponseEntity<>(droneDto,HttpStatus.OK);
    }




    @DeleteMapping("/drone/{id}")
    public ResponseEntity<String> deleteDrone(@PathVariable("id") long id){
        this.droneService.deleteDrone(id);
        return new ResponseEntity<>("Drone with id "+ id+" deleted", HttpStatus.OK);
    }

}
