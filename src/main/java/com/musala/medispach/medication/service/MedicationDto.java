package com.musala.medispach.medication.service;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
public class MedicationDto {
    private long id;
    @Pattern(regexp = "[0-9A-Z_]+", message = "The medication code format is incorrect")
    private String code;
    @Pattern(regexp = "[0-9A-Za-z_-]+", message = "The medication name format is incorrect")
    private String name;
    private BigDecimal weight;
    private String image;
}
