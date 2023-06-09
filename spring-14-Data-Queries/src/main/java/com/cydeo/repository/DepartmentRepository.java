package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    List<Department> findByDepartment(String department);

    List<Department> getByDivision(String division);
    List<Department> findByDivisionIs(String division);//alt
    List<Department> findByDivisionEquals(String division);//alt

    List<Department> findByDivisionEndsWith(String division);
    List<Department> getDistinctTop3ByDivisionContaining(String division);

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> retrieveDepartmentDivision(List<String> division);

}
