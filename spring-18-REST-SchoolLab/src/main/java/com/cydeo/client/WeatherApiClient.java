package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com",name = "WEATHER-CLIENT")
public interface WeatherApiClient {

//    http://api.weatherstack.com/current?access_key=9a1a5ededfe85a2b84538ac2920df4bb&query=Chicago

    @GetMapping("/current")
    Object getCurrentWeather(@RequestParam(value = "access_key") String accessKey,
                             @RequestParam(value = "query") String city);
}
