package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {
    @Bean
    public Monitor monitorSony() {
        return new SonyMonitor("25 inch Beast","Acer",25);
    }
    @Bean
    public Case caseDell(){
        return new DellCase("Z-10","Dell","200W");
    }
    @Bean
    public Motherboard motherboardAsus(){
        return new AsusMotherboard("X-200","Asus",4,6,"v2.44");
    }
}
