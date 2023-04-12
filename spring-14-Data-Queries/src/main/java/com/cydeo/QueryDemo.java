package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("--------------REGIONS---------------");
        System.out.println("findByCountry: "+ regionRepository.findByCountry("Canada"));
        System.out.println("-------------");
        System.out.println("findByCountryContaining: "+regionRepository.findByCountryContaining("United"));
        System.out.println("-------------");
        System.out.println("findByCountryContainingOrderByRegionDesc: "+regionRepository.findByCountryContainingOrderByRegionDesc("United"));
        System.out.println("-------------");
        System.out.println("findTop2ByCountry: "+regionRepository.findTop2ByCountry("United States"));
        System.out.println("--------------DEPARTMENTS---------------");
        System.out.println("findByDepartment: "+departmentRepository.findByDepartment("Furniture"));
        System.out.println("-------------");
        System.out.println("getByDivision: "+departmentRepository.getByDivision("Health"));
        System.out.println("-------------");
        System.out.println("findByDivisionEndsWith: "+departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("-------------");
        System.out.println("getDistinctTop3ByDivisionContaining: "+departmentRepository.getDistinctTop3ByDivisionContaining("Hea"));
        System.out.println("--------------EMPLOYEES---------------");
        System.out.println(employeeRepository.findByEmail("acurwood6@1und1.de"));
        System.out.println("-------------");
        System.out.println(employeeRepository.retrieveEmployeeDetail());
    }
}
