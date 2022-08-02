package com.musala.medispach.drone.service;

import com.musala.medispach.drone.enitity.Drone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DroneMapper {
    DroneMapper instance = Mappers.getMapper(DroneMapper.class);

    DroneDto toDto( Drone drone);
    Drone toDrone(DroneDto droneDto);
}
