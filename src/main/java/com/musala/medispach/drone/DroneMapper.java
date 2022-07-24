package com.musala.medispach.drone;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DroneMapper {
    DroneMapper instance = Mappers.getMapper(DroneMapper.class);

    DroneDto toDto( Drone drone);
    Drone toDrone(DroneDto droneDto);
}
