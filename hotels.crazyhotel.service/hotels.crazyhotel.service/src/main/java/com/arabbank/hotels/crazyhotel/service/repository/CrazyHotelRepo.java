package com.arabbank.hotels.crazyhotel.service.repository;

import com.arabbank.hotels.crazyhotel.service.model.entity.CrazyHotelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrazyHotelRepo extends MongoRepository<CrazyHotelEntity,String> {
}
