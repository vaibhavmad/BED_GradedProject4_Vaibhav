package com.greatlearning.emr.service;

import java.util.List;

import com.greatlearning.emr.entity.Employee;

public interface EmployeeService {
  Employee save(Employee employee);
  List<Employee> findAll();
  Employee findById(int id);
  void deleteById(int id);
  List<Employee> findByFirstName(String firstName);
  List<Employee> sortByFirstName(String order);
}


