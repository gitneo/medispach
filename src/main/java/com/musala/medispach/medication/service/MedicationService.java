package com.musala.medispach.medication.service;

import com.musala.medispach.medication.entity.Medication;
import com.musala.medispach.medication.entity.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;


    @Autowired
    public MedicationService(MedicationRepository medicationRepository){
        this.medicationRepository = medicationRepository;
    }




    public MedicationDto createMedication(MedicationDto medicationDto){
        Medication medication =  MedicationMapper.medicationMapper.toMedication(medicationDto);
        Medication createdMedication =  this.medicationRepository.save(medication);

        return MedicationMapper.medicationMapper.toDto(createdMedication);
    }





    public MedicationDto getMedication(long id){
        Medication medication =  this.medicationRepository.findById(id).orElseThrow(NoResultException::new);
        return MedicationMapper.medicationMapper.toDto(medication);
    }





    public List<MedicationDto> getMedications(){
        List<MedicationDto> medicationDtoList =  new ArrayList<>();
        this.medicationRepository.findAll().forEach(meds -> {
            medicationDtoList.add(MedicationMapper.medicationMapper.toDto(meds));
        });

        return medicationDtoList;
    }





    public MedicationDto updateMedication(MedicationDto medicationDto){
            Medication medication =  MedicationMapper.medicationMapper.toMedication(medicationDto);
            Medication updatedMeds =  this.medicationRepository.save(medication);

            return MedicationMapper.medicationMapper.toDto(updatedMeds);
    }




    public void DeleteMedication(long id){
        this.medicationRepository.deleteById(id);
    }
}
