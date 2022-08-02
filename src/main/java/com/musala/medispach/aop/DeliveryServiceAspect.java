package com.musala.medispach.aop;

import com.musala.medispach.delivery.service.DeliveryDto;
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
@Slf4j(topic = "com.musala.medispach.delivery")
public class DeliveryServiceAspect {

    private static DroneService droneService;

    @Autowired
    public DeliveryServiceAspect(DroneService droneService){
        this.droneService =  droneService;
    }

    @AfterReturning(value = "execution(* com.musala.medispach.delivery.service.DeliveryService.createDelivery(..))", returning = "deliveryDto")
    public void deliveryDroneLoadedAdvice(DeliveryDto deliveryDto){
        long id = deliveryDto.getDroneId();
        DroneDto droneDto = this.droneService.getDrone(id);
        droneDto.setState(DroneState.LOADED);
        this.droneService.upDateDrone(droneDto);
        log.info("Delivery drone "+droneDto.getSerialNo()+" LOADED and ready for delivery.");
        log.info(droneDto.getSerialNo() +" battery capacity is at "+ droneDto.getBatteryCapacity());
    }


    @AfterReturning(value = "execution(* com.musala.medispach.delivery.service.DeliveryService.dispatchDelivery(..))", returning = "droneDto")
    public void deliveryDroneDispatchedAdvice(DroneDto droneDto){
        droneDto.setState(DroneState.DELIVERING);
        this.droneService.upDateDrone(droneDto);
        log.info(droneDto.getSerialNo()+" is DELIVERING medication items");
        log.info(droneDto.getSerialNo() +" battery capacity is at "+ droneDto.getBatteryCapacity());
    }

     // implement delivering state
//    @AfterReturning(value = "execution(* com.musala.medispach.delivery.service.DeliveryService.dispatchDelivery(..))", returning = "droneDto")
//    public void deliveryDroneCompleteDispatchAdvice(DroneDto droneDto){
//        droneDto.setState(DroneState.DELIVERED);
//        this.droneService.upDateDrone(droneDto);
//        log.info(droneDto.getSerialNo()+" has DELIVERED the medication items");
//    }



    @AfterReturning(value = "execution(* com.musala.medispach.delivery.service.DeliveryService.receiveDrone(..))", returning = "droneDto")
    public void deliveryDroneCompleteAdvice(DroneDto droneDto){
        droneDto.setState(DroneState.RETURNING);
        this.droneService.upDateDrone(droneDto);
        log.info(droneDto.getSerialNo()+ "is RETURNING.");
        log.info(droneDto.getSerialNo() +" battery capacity is at "+ droneDto.getBatteryCapacity());
    }


    @AfterReturning(value = "execution(* com.musala.medispach.delivery.service.DeliveryService.parkDeliveryDrone(..))", returning = "droneDto")
    public void deliveryDroneIdleAdvice(DroneDto droneDto){
        droneDto.setState(DroneState.IDLE);
        this.droneService.upDateDrone(droneDto);
        log.info(droneDto.getSerialNo()+ "is now IDLE and awaiting delivery dispatch request.");
        log.info(droneDto.getSerialNo() +" battery capacity is at "+ droneDto.getBatteryCapacity());
    }
}
