package com.arabbank.hotels.availablehotels.service.config;

import kotlin.text.UStringsKt;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("config.app.info")
@Data

public class ApplicationConfig {
    private String bestHotelUrl;
    private String crazyHotelUrl;

}
