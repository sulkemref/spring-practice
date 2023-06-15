package com.cydeo.client;


import com.cydeo.dto.country.CountryDTO;
import com.cydeo.dto.weather.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://restcountries.com/v3.1/",name = "REST-COUNTRIES-CLIENT")
public interface RestCountriesApiClient {

//    https://restcountries.com/v3.1/name/germany

    @GetMapping("/name/{country}")
    List<CountryDTO> getCountryInformation(@PathVariable("country") String country);

}
