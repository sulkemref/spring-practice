package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Component
@ToString
public class Dimensions {

    private int width;
    private int height;
    private int depth;

    public Dimensions() {
        this.width = 10;
        this.height =50;
        this.depth = 90;
    }

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }

}
