package com.greatlearning.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.greatlearning.emr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);
    List<Employee> findAllByOrderByFirstNameAsc();
    List<Employee> findAllByOrderByFirstNameDesc();
}
