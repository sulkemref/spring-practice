package com.cydeo.streotype_annotation.casefactory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
public abstract class Case {

    private String model;
    private String manufacturer;
    private String powerSupply;
    @Autowired
    private Dimensions dimensions;

    public Case(String model, String manufacturer, String powerSupply) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
    }




    public abstract void pressPowerButton();

}
