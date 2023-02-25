package com.cydeo.config;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppConfigData {

    @Value("${username}")
    private String userName;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;

}
