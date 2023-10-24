package com.arabbank.hotels.besthotel.service.service;

import com.arabbank.hotels.besthotel.service.exception.ElementNotFoundException;
import com.arabbank.hotels.besthotel.service.exception.InvalidRateException;
import com.arabbank.hotels.besthotel.service.model.dto.BestHotelRequestDto;
import com.arabbank.hotels.besthotel.service.model.dto.BestHotelResponseDto;
import com.arabbank.hotels.besthotel.service.model.dto.BestHotelUpdateDto;
import com.arabbank.hotels.besthotel.service.model.dto.PostRequestDto;
import com.arabbank.hotels.besthotel.service.model.entity.BestHotelEntity;
import com.arabbank.hotels.besthotel.service.repository.BestHotelRepo;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BestHotelService {
    @Autowired
    private BestHotelRepo bestHotelRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<BestHotelResponseDto> getBestHotelByCityDateAndNumber(String city,LocalDate fromDate,LocalDate toDate,int numberOfAdults) throws Exception {



        Query query = new Query();


        query.addCriteria(Criteria.where("fromDate").lte(Date.from(fromDate.atStartOfDay().toInstant(ZoneOffset.UTC))));
        query.addCriteria(Criteria.where("toDate").gte((Date.from(toDate.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC)))));
        query.addCriteria(Criteria.where("city").is(city));
        query.addCriteria(Criteria.where("numberOfAdults").is(numberOfAdults));


        List<BestHotelEntity> bestHotelRef = mongoTemplate.find(query, BestHotelEntity.class, "Best-Hotel-Details");
        List<BestHotelResponseDto> bestHotelResponseDtoList = new ArrayList<>();


        for (BestHotelEntity bestHotelEntity : bestHotelRef) {
            BestHotelResponseDto bestHotelResponseDto = new BestHotelResponseDto();
            bestHotelResponseDto.setHotelName(bestHotelEntity.getHotelName());
            bestHotelResponseDto.setHotelPrice(bestHotelEntity.getHotelPrice());
            bestHotelResponseDto.setHotelRatings(bestHotelEntity.getHotelRatings());
            bestHotelResponseDto.setRoomAmenities(bestHotelEntity.getRoomAmenities());
            bestHotelResponseDtoList.add(bestHotelResponseDto);

        }
        return bestHotelResponseDtoList;


    }

    public BestHotelResponseDto createHotel(PostRequestDto postRequestDto) throws Exception {
        BestHotelEntity bestHotelEntity = new BestHotelEntity();
        if (postRequestDto.getHotelRatings() < 1 || postRequestDto.getHotelRatings() > 5) {
            throw new InvalidRateException("Rating is invalid");
        }
        bestHotelEntity.setHotelName(postRequestDto.getHotelName());
        bestHotelEntity.setCity(postRequestDto.getCity());
        bestHotelEntity.setHotelRatings(postRequestDto.getHotelRatings());
        bestHotelEntity.setHotelPrice(postRequestDto.getHotelPrice());
        bestHotelEntity.setRoomAmenities(postRequestDto.getRoomAmenities());
        bestHotelEntity.setNumberOfAdults(postRequestDto.getNumberOfAdults());
        bestHotelEntity.setFromDate(postRequestDto.getFromDate());
        bestHotelEntity.setToDate(postRequestDto.getToDate());


        bestHotelRepo.save(bestHotelEntity);

        BestHotelResponseDto bestHotelResponseDto = new BestHotelResponseDto();
        bestHotelResponseDto.setHotelName(bestHotelEntity.getHotelName());
        bestHotelResponseDto.setHotelRatings(bestHotelEntity.getHotelRatings());
        bestHotelResponseDto.setHotelPrice(bestHotelEntity.getHotelPrice());
        bestHotelResponseDto.setRoomAmenities(bestHotelEntity.getRoomAmenities());

        return bestHotelResponseDto;

    }
    public String editHotel(BestHotelUpdateDto bestHotelUpdateDto)throws  Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("hotelName").is(bestHotelUpdateDto.getHotelName()));
        Update update = new Update();
        update.set("hotelPrice", bestHotelUpdateDto.getHotelPrice());
        BestHotelEntity bestHotelRef = mongoTemplate.findAndModify(query, update, BestHotelEntity.class);
        if (bestHotelRef == null) {
            throw new ElementNotFoundException("The hotel is not existing");
        }
        return "success";
    }
    public String editAllHotel(BestHotelUpdateDto bestHotelUpdateDto){
        Query query=new Query();
        query.addCriteria(Criteria.where("hotelName").is(bestHotelUpdateDto.getHotelName()));
        Update update=new Update();
        update.set("city",bestHotelUpdateDto.getCity());
        update.set("fromDate",bestHotelUpdateDto.getFromDate());
        update.set("toDate",bestHotelUpdateDto.getToDate());
        update.set("hotelRatings",bestHotelUpdateDto.getHotelRatings());
        BestHotelEntity bestHotelEntity=mongoTemplate.findAndModify(query,update,BestHotelEntity.class);
        if (bestHotelEntity==null){
            throw new ElementNotFoundException("The fields are not existing");
        }
        return "success";
    }

    public DeleteResult deleteHotel(BestHotelUpdateDto bestHotelUpdateDto)throws  Exception {
        Query query=new Query();
        query.addCriteria(Criteria.where("hotelName").is(bestHotelUpdateDto.getHotelName()));
        DeleteResult bestHotelEntity=mongoTemplate.remove(query,BestHotelEntity.class);
        if (bestHotelEntity.getDeletedCount()==0){
            throw new ElementNotFoundException("Element not found");
        }
        return bestHotelEntity;
    }
}