package com.arabbank.hotels.availablehotels.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AvailableHotelService {
    @Autowired
    private BestHotelService bestHotelService;
    @Autowired
    private  CrazyHotelService crazyHotelService;
    public List getBestHotels(String fromDate,String toDate,String city,int numberOfAdults){
        List finalResponse=bestHotelService.BestHotels(fromDate,toDate,city,numberOfAdults);
        List finalResponses=crazyHotelService.CrazyHotels(fromDate,toDate,city,numberOfAdults);
        finalResponse.addAll(finalResponses);
        return finalResponse;
    }
}
