package com.musala.medispach.medication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medispatch/api/v1")
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService){
        this.medicationService = medicationService;
    }


    @PostMapping("/medication")
    public ResponseEntity<MedicationDto> createMedication(@Valid @RequestBody MedicationDto medicationDto){
        MedicationDto createdMedication =  this.medicationService.createMedication(medicationDto);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }



    @GetMapping("/medication/{id}")
    public ResponseEntity<MedicationDto> getMedication(@PathVariable("id") long id){
        MedicationDto medicationDto =  this.medicationService.getMedication(id);

        return new ResponseEntity<>(medicationDto,HttpStatus.OK);
    }




    @GetMapping("/medications")
    public ResponseEntity<List<MedicationDto>> getMedications(){
        List<MedicationDto> medicationDtoList =  this.medicationService.getMedications();
        return new ResponseEntity<>(medicationDtoList,HttpStatus.OK);
    }



    @PutMapping("/medication")
    public ResponseEntity<MedicationDto> updateMedication(@RequestBody MedicationDto medicationDto){
        MedicationDto updatedMedication =  this.medicationService.updateMedication(medicationDto);
        return new ResponseEntity<>(updatedMedication,HttpStatus.OK);
    }



    @DeleteMapping("/medication/{id}")
    public ResponseEntity<String> deleteMedication(@PathVariable("id") long id){
        this.medicationService.DeleteMedication(id);
        return new ResponseEntity<>("Medication with ID "+ id +"has been deleted", HttpStatus.OK);
    }

}
