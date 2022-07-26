package com.musala.medispach.medication;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicationMapper {

    MedicationMapper medicationMapper = Mappers.getMapper(MedicationMapper.class);

    MedicationDto toDto(Medication medication);
    Medication toMedication(MedicationDto medicationDto);
}
