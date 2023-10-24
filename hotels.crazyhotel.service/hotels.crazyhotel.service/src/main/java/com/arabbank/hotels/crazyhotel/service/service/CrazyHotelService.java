package com.arabbank.hotels.crazyhotel.service.service;

import com.arabbank.hotels.crazyhotel.service.exception.ElementNotFoundException;
import com.arabbank.hotels.crazyhotel.service.exception.InvalidRateException;
import com.arabbank.hotels.crazyhotel.service.model.dto.CrazyHotelRequestDto;
import com.arabbank.hotels.crazyhotel.service.model.dto.CrazyHotelResponseDto;
import com.arabbank.hotels.crazyhotel.service.model.dto.CrazyHotelUpdateDto;
import com.arabbank.hotels.crazyhotel.service.model.dto.PostRequestDto;
import com.arabbank.hotels.crazyhotel.service.model.entity.CrazyHotelEntity;
import com.arabbank.hotels.crazyhotel.service.repository.CrazyHotelRepo;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CrazyHotelService {
    @Autowired
    private CrazyHotelRepo crazyHotelRepo;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<CrazyHotelResponseDto> getCrazyHotelByCityDateAndNumber( String city,  LocalDate fromDate,  LocalDate toDate,  int numberOfAdults)throws Exception{
        Query query=new Query();



        query.addCriteria(Criteria.where("fromDate").lte(Date.from(fromDate.atStartOfDay().toInstant(ZoneOffset.UTC))));
        query.addCriteria(Criteria.where("toDate").gte((Date.from(toDate.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC)))));
        query.addCriteria(Criteria.where("city").is(city));
        query.addCriteria(Criteria.where("numberOfAdults").is(numberOfAdults));


        List<CrazyHotelEntity> bestHotelRef=mongoTemplate.find(query,CrazyHotelEntity.class,"Crazy-Hotel-Details");
        List<CrazyHotelResponseDto> crazyHotelResponseDtoList=new ArrayList<>();


        for(CrazyHotelEntity bestHotelEntity:bestHotelRef){
            CrazyHotelResponseDto crazyHotelResponseDto=new CrazyHotelResponseDto();
            crazyHotelResponseDto.setHotelName(bestHotelEntity.getHotelName());
            crazyHotelResponseDto.setHotelPrice(bestHotelEntity.getHotelPrice());
            crazyHotelResponseDto.setHotelRatings(bestHotelEntity.getHotelRatings());
            crazyHotelResponseDto.setRoomAmenities(bestHotelEntity.getRoomAmenities());
            crazyHotelResponseDtoList.add(crazyHotelResponseDto);
        }
        return crazyHotelResponseDtoList;

    }
    public CrazyHotelResponseDto createHotel(PostRequestDto postRequestDto)throws  Exception{
        CrazyHotelEntity crazyHotelEntity=new CrazyHotelEntity();
        if(postRequestDto.getHotelRatings().length()<1 || postRequestDto.getHotelRatings().length()>5){
            throw new InvalidRateException("Rating is invalid");
        }
        crazyHotelEntity.setHotelName(postRequestDto.getHotelName());
        crazyHotelEntity.setCity(postRequestDto.getCity());
        crazyHotelEntity.setHotelRatings(postRequestDto.getHotelRatings());
        crazyHotelEntity.setHotelPrice(postRequestDto.getHotelPrice());
        crazyHotelEntity.setRoomAmenities(postRequestDto.getRoomAmenities());
        crazyHotelEntity.setNumberOfAdults(postRequestDto.getNumberOfAdults());
        crazyHotelEntity.setFromDate(postRequestDto.getFromDate());
        crazyHotelEntity.setToDate(postRequestDto.getToDate());


        crazyHotelRepo.save(crazyHotelEntity);

        CrazyHotelResponseDto crazyHotelResponseDto=new CrazyHotelResponseDto();
       crazyHotelResponseDto.setHotelName(crazyHotelEntity.getHotelName());
        crazyHotelResponseDto.setHotelRatings(crazyHotelEntity.getHotelRatings());
        crazyHotelResponseDto.setHotelPrice(crazyHotelEntity.getHotelPrice());
        crazyHotelResponseDto.setRoomAmenities(crazyHotelEntity.getRoomAmenities());

        return crazyHotelResponseDto;

    }
    public String editHotel(CrazyHotelUpdateDto crazyHotelUpdateDto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("hotelName").is(crazyHotelUpdateDto.getHotelName()));
        Update update = new Update();
        update.set("hotelPrice", crazyHotelUpdateDto.getHotelPrice());
        CrazyHotelEntity bestHotelRef = mongoTemplate.findAndModify(query, update, CrazyHotelEntity.class);
        if (bestHotelRef == null) {
            throw new ElementNotFoundException("The hotel is not existing");
        }
        return "success";
    }
    public String editAllHotel(CrazyHotelUpdateDto crazyHotelUpdateDto){
        Query query=new Query();
        query.addCriteria(Criteria.where("hotelName").is(crazyHotelUpdateDto.getHotelName()));
        Update update=new Update();
        update.set("city",crazyHotelUpdateDto.getCity());
        update.set("fromDate",crazyHotelUpdateDto.getFromDate());
        update.set("toDate",crazyHotelUpdateDto.getToDate());
        update.set("hotelRatings",crazyHotelUpdateDto.getHotelRatings());
        CrazyHotelEntity bestHotelEntity=mongoTemplate.findAndModify(query,update,CrazyHotelEntity.class);
        if (bestHotelEntity==null){
            throw new ElementNotFoundException("The fields are not existing");
        }
        return "success";
    }
    public DeleteResult deleteHotel(CrazyHotelUpdateDto crazyHotelUpdateDto) {
        Query query=new Query();
        query.addCriteria(Criteria.where("hotelName").is(crazyHotelUpdateDto.getHotelName()));
        DeleteResult crazyHotelEntity=mongoTemplate.remove(query,CrazyHotelEntity.class);
        if (crazyHotelEntity==null){
            throw new ElementNotFoundException("Element not found");
        }
        return crazyHotelEntity;
    }

}
