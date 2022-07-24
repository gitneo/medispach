package com.musala.medispach.drone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.NoResultException;
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
}
