package com.musala.medispach.medication;

import com.musala.medispach.delivery.Delivery;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
public class MedicationDto {

    private long id;
    private String code;
    private String name;
    private BigDecimal weight;
    private String image;
    private Delivery delivery;

}
