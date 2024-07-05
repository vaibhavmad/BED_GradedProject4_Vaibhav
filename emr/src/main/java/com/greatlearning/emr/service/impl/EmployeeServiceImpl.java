package com.greatlearning.emr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.emr.entity.Employee;
import com.greatlearning.emr.repository.EmployeeRepository;
import com.greatlearning.emr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> sortByFirstName(String order) {
        if (order.equalsIgnoreCase("asc")) {
            return employeeRepository.findAllByOrderByFirstNameAsc();
        } else {
            return employeeRepository.findAllByOrderByFirstNameDesc();
        }
    }
}
