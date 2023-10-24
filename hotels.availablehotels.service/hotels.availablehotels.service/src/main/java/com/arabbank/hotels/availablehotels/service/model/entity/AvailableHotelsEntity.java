package com.arabbank.hotels.availablehotels.service.model.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class AvailableHotelsEntity {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String city;
    private int numberOfAdults;

}
