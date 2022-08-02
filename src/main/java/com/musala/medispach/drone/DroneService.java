package com.musala.medispach.drone;

import com.musala.medispach.deliveryItem.DeliveryItemDto;
import com.musala.medispach.deliveryItem.DeliveryItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DroneService {

    public DroneRepository droneRepository;

    @Autowired
    public DroneService(DroneRepository droneRepository){
        this.droneRepository =  droneRepository;
    }


    public DroneDto createDrone(DroneDto droneDto){
        Drone drone =  DroneMapper.instance.toDrone(droneDto);
        Drone newDrone = droneRepository.save(drone);

        return DroneMapper.instance.toDto(newDrone);
    }



    public DroneDto getDrone(long id) {
        Drone drone = this.droneRepository.findById(id).orElseThrow(NoResultException::new);
        return DroneMapper.instance.toDto(drone);
    }



    public List<DroneDto> getDrones(){
        List<DroneDto> droneList = new ArrayList<>();

        this.droneRepository.findAll().forEach(drone ->
            droneList.add(DroneMapper.instance.toDto(drone))
        );

        return droneList;
    }


    public DroneDto upDateDrone(DroneDto droneDto){
         Drone drone =  DroneMapper.instance.toDrone(droneDto);
         Drone updatedDrone = this.droneRepository.save(drone);

         return DroneMapper.instance.toDto(updatedDrone);
    }



    public void deleteDrone(long id){
        this.droneRepository.deleteById(id);
    }





    /**
     *
     * @param droneId
     * @return loaded medication items for a given drone
     */
    public List<DeliveryItemDto> getDroneDeliveryItems(long droneId){
        List<DeliveryItemDto> deliveryItems =  new ArrayList<>();
        this.droneRepository.getDroneDeliveryItems(droneId).forEach(deliveryItem -> {
            deliveryItems.add(DeliveryItemMapper.instance.toDto(deliveryItem));
        });

        return deliveryItems;
    }





    /**
     *
     * @return available drones for loading
     */
    public DroneDto findAvailableDrone(){
        Drone drone = this.droneRepository.getAvailableDrone("IDLE").orElseThrow(NoResultException::new);
        this.upDateDrone(DroneMapper.instance.toDto(drone));

        return DroneMapper.instance.toDto(drone);
    }




    /**
     *
     * @param droneId
     * @return check battery level for a given drone;
     */
    public BigDecimal getDroneBatteryCapacity(long droneId){
        return this.getDrone(droneId).getBatteryCapacity();
    }


}
