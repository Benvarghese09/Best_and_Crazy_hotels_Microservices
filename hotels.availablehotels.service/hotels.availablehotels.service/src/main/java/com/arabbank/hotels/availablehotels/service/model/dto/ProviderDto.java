package com.arabbank.hotels.availablehotels.service.model.dto;

import com.arabbank.hotels.availablehotels.service.model.enums.Provider;
import lombok.Data;

import java.util.List;

@Data
public class ProviderDto {
    private Provider provider;
    private List<AvailableHotelResponseDto> response;

}
