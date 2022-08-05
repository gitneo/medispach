package com.musala.medispach.drone.service;

import com.musala.medispach.DroneListItems;
import com.musala.medispach.deliveryItem.service.DeliveryItemDto;
import com.musala.medispach.deliveryItem.service.DeliveryItemMapper;
import com.musala.medispach.drone.DroneState;
import com.musala.medispach.drone.enitity.Drone;
import com.musala.medispach.drone.enitity.DroneRepository;
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



    /**
     *
     * @param droneDto
     * @return newly registered drone
     */
    public DroneDto createDrone(DroneDto droneDto){
        Drone drone =  DroneMapper.instance.toDrone(droneDto);
        Drone newDrone = droneRepository.save(drone);

        return DroneMapper.instance.toDto(newDrone);
    }


    /**
     *
     * @param droneId
     * @return drone
     */
    public DroneDto getDrone(long droneId) {
        Drone drone = this.droneRepository.findById(droneId).orElseThrow(NoResultException::new);
        return DroneMapper.instance.toDto(drone);
    }


    /**
     *
     * @return all registered drone
     */
    public List<DroneDto> getDrones(){
        List<DroneDto> droneList = new ArrayList<>();

        this.droneRepository.findAll().forEach(drone ->
            droneList.add(DroneMapper.instance.toDto(drone))
        );

        return droneList;
    }


    /**
     *
     * @param droneDto
     * @return updated drone
     */
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
    public List<DroneListItems> getDroneDeliveryItems(long droneId){
        List<DeliveryItemDto> deliveryItems =  new ArrayList<>();
        List<DroneListItems> droneDeliveryItems = this.droneRepository.getDroneDeliveryItems(droneId);
        return droneDeliveryItems;
    }





    /**
     *
     * @return available drones for loading
     */
    public DroneDto findAvailableDrone(){
        Drone drone = this.droneRepository
                          .getAvailableDrone(DroneState.IDLE.name())
                          .orElseThrow(NoResultException::new);
        return DroneMapper.instance.toDto(drone);
    }


    /**
     *
     * @return idle drones
     */
    public List<Drone> findIdleDrones(){
        List<Drone> listOfIdleDrones = this.droneRepository.findByState(DroneState.IDLE);
        return listOfIdleDrones;
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
