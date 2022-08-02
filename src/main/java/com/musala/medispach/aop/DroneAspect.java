package com.musala.medispach.aop;

import com.musala.medispach.drone.*;
import com.musala.medispach.drone.service.DroneDto;
import com.musala.medispach.drone.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j(topic = "com.musala.medispach.drone")
public class DroneAspect {

    private static DroneService droneService;

    @Autowired
    public DroneAspect(DroneService droneService){
     this.droneService = droneService;
    }

    @AfterReturning(value = "execution(* com.musala.medispach.drone.service.DroneService.findAvailableDrone())", returning = "droneDto")
    public void droneSelectionAdvice(DroneDto droneDto){
        droneDto.setState(DroneState.LOADING);
        droneService.upDateDrone(droneDto);
        log.info("Delivery drone "+droneDto.getSerialNo()+" is available for service.");
        log.info("Drone battery capacity is at a "+droneDto.getBatteryCapacity()+"%");
        log.info("Loading drone "+droneDto.getSerialNo());
    }

//
//    @Before(value = "")
//    public void droneLoadingAdvice(){}
//
//    @After(value = "")
//    public void droneLoadedAdvice(){}
//
//    @Before(value = "")
//    public void droneDispatchAdvice(){}
}
