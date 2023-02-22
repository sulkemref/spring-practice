package com.cydeo.stereotype_annotation.monitorfactory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AcerMonitor extends Monitor{

    public AcerMonitor() {
        super("23 inch beast","Sony",23);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Acer");
    }
}
