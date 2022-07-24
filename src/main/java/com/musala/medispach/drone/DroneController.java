package com.musala.medispach.drone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medispatch/api/v1")
public class DroneController {

    public final DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService){
        this.droneService = droneService;
    }




    @PostMapping("/drone")
    public ResponseEntity<DroneDto> createDrone(@RequestBody DroneDto droneDto){
        DroneDto createdDrone =  this.droneService.createDrone(droneDto);
        return new ResponseEntity<>(createdDrone, HttpStatus.CREATED);
    }





    @GetMapping("/drone/{id}")
    public ResponseEntity<DroneDto> getDrone(@PathVariable("id") long id){
          DroneDto droneDto = this.droneService.getDrone(id);
          return new ResponseEntity<>(droneDto, HttpStatus.OK);
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
