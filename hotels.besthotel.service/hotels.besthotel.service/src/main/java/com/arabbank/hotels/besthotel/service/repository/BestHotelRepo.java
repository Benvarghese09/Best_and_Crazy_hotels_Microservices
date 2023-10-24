package com.arabbank.hotels.besthotel.service.repository;

import com.arabbank.hotels.besthotel.service.model.dto.BestHotelRequestDto;
import com.arabbank.hotels.besthotel.service.model.entity.BestHotelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface BestHotelRepo extends MongoRepository<BestHotelEntity,String> {

}
