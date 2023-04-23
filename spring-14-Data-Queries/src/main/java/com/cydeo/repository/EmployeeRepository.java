package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByEmail(String email);

    List<Employee> findByFirstNameAndLastNameOrEmail(String fistName, String lastName, String email);

    List<Employee> findByFirstNameIsNot(String firstName);

    List<Employee> findByLastNameStartingWith(String lastName);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email='aditchfield92@sogou.com'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='aditchfield92@sogou.com'")
    Integer retrieveEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.salary<>?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGraterThan(int salary);

    @Query("SELECT e.lastName FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<String> retrieveEmployeeLastNameSalaryBetween(int startSalary, int endSalary);

    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    @Query(value = "SELECT details FROM employees WHERE salary = ?1",nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);

}
