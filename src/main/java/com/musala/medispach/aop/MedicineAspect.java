package com.musala.medispach.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;


@Aspect
@Slf4j(topic = "com.musala.medispach.medication")
@Configuration
public class MedicineAspect {

    @Before(value = "execution(* com.musala.medispach.medication.MedicationController.createMedication(..))")
    public void logMedicineCreationAdvice(JoinPoint joinPoint){
        log.info("Creating new medicine");
    }
}
